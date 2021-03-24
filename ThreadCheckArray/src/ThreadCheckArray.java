import java.util.ArrayList;

/**
 * Class ThreadCheckArray
 * Defines the run method for the threads from TestThreadCheckArray
 * Performs the calculations required for reaching our required results
 */
public class ThreadCheckArray implements Runnable 
{
	private boolean flag;
	private boolean [] winArray;
	SharedData sd;
	private ArrayList<Integer> array;
	//int[] array;
	int b;
	
	/**
	 * Constructor
	 * Has synchronized on sd so that only one thread can access this information at a time
	 * @param sd
	 */
	public ThreadCheckArray(SharedData sd) 
	{
		this.sd = sd;	
		synchronized (sd) 
		{
			array = sd.getArray();
			b = sd.getB();
		}		
		//winArray = new boolean[array.length];
		winArray = new boolean[array.size()];
	}
	
	/**
	 * A recursive function
	 * Checks the array from the end to the beginning
	 * Stop condition is when array size is equal to 1 
	 * @param n
	 * @param b
	 */
	void rec(int n, int b)
	{
		synchronized (sd) 
		{
			if (sd.getFlag())
				return;
		}	
		if (n == 1)
		{
			//if(b == 0 || b == array[n-1])
			if(b == 0 || b == array.get(n-1))
			{
				flag = true;
				synchronized (sd) 
				{
					sd.setFlag(true);
				}			
			}
			//if (b == array[n-1])
			if (b == array.get(n-1))
				winArray[n-1] = true;
			return;
		}
		
		//rec(n-1, b - array[n-1]);
		rec(n-1, b - array.get(n-1));
		if (flag)
			winArray[n-1] = true;
		synchronized (sd) 
		{
			if (sd.getFlag())
				return;
		}	
		rec(n-1, b);
	}

	/**
	 *A run function for the threads that are run from the main method 
	 */
	public void run() {
		//if (array.length != 1)
		if (array.size() != 1)
			if (Thread.currentThread().getName().equals("thread1"))
				//rec(array.length-1, b - array[array.length - 1]);
				rec(array.size()-1, b - array.get(array.size() - 1));
			else 
				//rec(array.length-1, b);
				rec(array.size()-1, b);
		//if (array.length == 1)
		if (array.size() == 1)
			//if (b == array[0] && !flag)
			if (b == array.get(0) && !flag)
			{
				winArray[0] = true;
				flag = true;
				synchronized (sd) 
				{
					sd.setFlag(true);
				}
			}
		if (flag)
		{
			if (Thread.currentThread().getName().equals("thread1"))
				//winArray[array.length - 1] = true;
				winArray[array.size() - 1] = true;
			synchronized (sd) 
			{
				sd.setWinArray(winArray);
			}	
		}
	}
}
