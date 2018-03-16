public class GSM {

	/* GSM parameters */
	private String model;
	private String manufacturer;
	private double price;
	private String owner;
	private Battery battery;
	private Display display;


	/* Static example class instance */
	static GSM IPhone4S = new GSM("iPhone 4S", "Apple Inc.", 139.95, "Someone Random");
	static Battery IBattery = new Battery(
			"Generic Non-removable Li-Po 1432 mAh battery (5.3 Wh)",
			200,
			14
	);
	static Display IDisplay = new Display(
			3.5,
			16000000
	);


	/* GSM getter an setters */
	public String getModel() {
		return this.model;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public double getPrice() {
		return this.price;
	}

	public String getOwner() {
		return this.owner;
	}

	public Battery getBattery() {
		return this.battery;
	}

	public Display getDisplay() {
		return this.display;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setBattery(String model, double idleHours, double talkHours) {
		this.battery = new Battery(model, idleHours, talkHours);
	}

	public void setBattery(String model, double idleHours) {
		this.battery = new Battery(model, idleHours);
	}

	public void setBattery(Battery battery) {
		this.battery = new Battery(battery);
	}

	public void setDisplay(double size, long colorAmount) {
		this.display = new Display(size, colorAmount);
	}

	public void setDisplay(double size) {
		this.display = new Display(size);
	}

	public void setDisplay(Display display) {
		this.display = new Display(display);
	}

	@Override
	public String toString() {
		return
				"\n------------\n" +
						"1. Model: " + this.model + '\n' +
						"2. Manufacturer: " + this.manufacturer + '\n' +
						"3. Price: " + this.price + '\n' +
						"5. Owner: " + this.owner + '\n' +
						"6. Battery model: " + battery.getModel() + '\n' +
						"7. Battery idle hours: " + battery.getIdleHours() + '\n' +
						"8. Battery talk hours: " + battery.getTalkHours() + '\n' +
						"9. Display size: " + display.getSize() + '\n' +
						"10. Display color amount: " + display.getColorAmount() + '\n' +
						"------------";
	}

	/* GSM constructors */
	public GSM(String model, String manufacturer) {
		this.model = model;
		this.manufacturer = manufacturer;
	}

	public GSM(String model, String manufacturer, double price, String owner) {
		this.model = model;
		this.manufacturer = manufacturer;
		this.price = price;
	}
}









