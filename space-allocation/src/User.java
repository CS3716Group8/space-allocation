/*
 *	Defines A User. Not yet Implemented.
 *	@author Dylan Kennedy
*/
public class User {
	private String userName;
	private int userNum;
	
	public User(String name, int num)
	{
		userName = name;
		userNum = num;
		
	}
	
	public String getName()
	{
		return userName;
	}
	
	public int getNum()
	{
		return userNum;
	}
	
	public void setName(String n)
	{
		userName = n;
	}
	public void setNum(int num)
	{
		userNum = num;
	}
}
