package scheduling;

public class Location {
	private String name;
	private String roomNo;
	
	public Location(String name, String roomNo)
	{
		this.name = name;
		this.roomNo = roomNo;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getRoomNo()
	{
		return roomNo;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setRoomNo(String roomNo)
	{
		this.roomNo = roomNo;
	}
	
	public String toString(){
		return name + " " +
				roomNo + " ";
	}
}
