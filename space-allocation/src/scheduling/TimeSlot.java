package scheduling;

public class TimeSlot {
	private String timeDuration;
	private boolean isReserved;
	
	public TimeSlot(String timeDuration, boolean isReserved)
	{
		this.timeDuration = timeDuration;
		this.isReserved = isReserved;
	}
	
	public String getTimeDuration()
	{
		return timeDuration;
	}
	
	public boolean getIsReserved()
	{
		return isReserved;
	}
	
	public void setTimeDuration(String timeDuration)
	{
		this.timeDuration = timeDuration;
	}
	
	public void setIsReserved(boolean isReserved)
	{
		this.isReserved = isReserved;
	}
	
	public String toString(){
		return timeDuration + "\n" +
				String.valueOf(isReserved) + "\n";
	}
}
