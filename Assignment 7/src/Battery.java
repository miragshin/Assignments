public class Battery {

	/* Battery parameters */
	private String model;
	private double idleHours;
	private double talkHours;

	/* Battery constructor */
	public Battery(String model, double idleHours, double talkHours) {
		this.model = model;
		this.idleHours = idleHours;
		this.talkHours = talkHours;
	}

	// Idle hours are more important because who makes phone calls in 2018
	public Battery(String model, double idleHours) {
		this.model = model;
		this.idleHours = idleHours;
	}

	public Battery(String model) {
		this.model = model;
	}

	public Battery(Battery battery) {
		this.model = battery.model;
		this.idleHours = battery.idleHours;
		this.talkHours = battery.talkHours;
	}

	/* Battery getter and setters */
	public String getModel() {
		return this.model;
	}

	public double getIdleHours() {
		return this.idleHours;
	}

	public double getTalkHours() {
		return this.talkHours;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setIdleHours(double idleHours) {
		this.idleHours = idleHours;
	}

	public void setTalkHours(double talkHours) {
		this.talkHours = talkHours;
	}
}