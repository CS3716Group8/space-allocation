package scheduling;

import java.util.UUID;

public class TimeSlot {
	private String timeDuration;
	private boolean isReserved;
	private String id;
	
	public TimeSlot(String timeDuration, boolean isReserved)
	{
		this.timeDuration = timeDuration;
		this.isReserved = isReserved;
		this.id = UUID.randomUUID().toString();
	}
	
	public TimeSlot(String timeDuration, boolean isReserved, String i)
	{
		this.timeDuration = timeDuration;
		this.isReserved = isReserved;
		this.id = i;
	}
	
	public String getId() { return id; }
	
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
		return timeDuration + " " +
				String.valueOf(isReserved) + " " + id + " ";
	}
}
