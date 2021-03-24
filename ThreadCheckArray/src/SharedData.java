import java.util.ArrayList;

/**
 * Class SharedData defines all the required field for the program
 * @author matti
 */
public class SharedData 
{
	//private int [] array;
	private ArrayList<Integer> array;
	private boolean [] winArray;
	private boolean flag;
	private final int b;
	
	/**
	 * The constructor sets parameter array and b that are defined by user
	 * @param array Integer ArrayList that includes user input
	 * @param b The number that needs to be found
	 */
	public SharedData(ArrayList<Integer> array, int b) {
		
		this.array = array;
		this.b = b;
	}

	/**
	 * @return boolean[] A boolean array that shows the combination that was calculated
	 */
	public boolean[] getWinArray() 
	{
		return winArray;
	}

	/**
	 * Sets winArray
	 * @param winArray 
	 */
	public void setWinArray(boolean [] winArray) 
	{
		this.winArray = winArray;
	}

	/**
	 * Gets winArray
	 * @return ArrayList
	 */
	public ArrayList<Integer> getArray() 
	{
		return array;
	}

	/**
	 * Returns b
	 * @return int
	 */
	public int getB() 
	{
		return b;
	}

	/**
	 * Gets the flag value
	 * @return boolean
	 */
	public boolean getFlag() 
	{
		return flag;
	}

	/**
	 * Sets flag value
	 * @param flag
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
