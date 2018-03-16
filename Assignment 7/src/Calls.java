import java.util.ArrayList;
import java.util.Calendar;

public class Calls {
	private static boolean isInstantiated = false;
	private String date;
	private String dialledNumber;
	private int startSecond;
	private int startMinute;
	private int startHour;
	private int endSecond;
	private int endMinute;
	private int endHour;
	private int duration;
	private static final double PRICE = 0.37;
	private ArrayList<Calls> CallHistory = new ArrayList<>();

	public int getDuration() {    // Not sure if this works
		return this.duration;
	}

	@Override
	public String toString() {
		if (!isInstantiated) return null;
		String startHour = String.format("%02d", this.startHour);
		String startMinute = String.format("%02d", this.startMinute);
		String startSecond = String.format("%02d", this.startSecond);
		String endHour = String.format("%02d", this.endHour);
		String endMinute = String.format("%02d", this.endMinute);
		String endSecond = String.format("%02d", this.endSecond);
		return "Called " + dialledNumber + " on " + date + " (" +
				startHour + ":" + startMinute + ":" + startSecond + " - " +
				endHour + ":" + endMinute + ":" + endSecond + ")";
	}

	public void add(Calls call) {
		CallHistory.add(call);
	}

	public void remove(Calls call) {
		CallHistory.remove(call);
	}

	public void clear() {
		CallHistory.clear();
	}

	public ArrayList<Calls> getCallHistory() {
		return CallHistory;
	}

	public double totalPrice() {
		double sum = 0;
		for (Calls call : CallHistory) {
			sum += call.getDuration() * PRICE;
		}
		return sum;
	}

	public Calls(int startSecond, int startMinute, int startHour,
				 int endSecond, int endMinute, int endHour) {
		this.startSecond = startSecond;
		this.startMinute = startMinute;
		this.startHour = startHour;
		this.endSecond = endSecond;
		this.endMinute = endMinute;
		this.endHour = endHour;
		int startSeconds = (startSecond + startMinute * 60 + startHour * 3600);
		int endSeconds = (endSecond + endMinute * 60 + endHour * 3600);
		this.duration = endSeconds - startSeconds;
		Calls.isInstantiated = true;
	}

	public Calls() {}


}