public class Display {
	private double size;			// Given in inches
	private long colorAmount;

	public double getSize() {
		return this.size;
	}

	public double getColorAmount() {
		return this.colorAmount;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public void setColorAmount(long colorAmount) {
		this.colorAmount = colorAmount;
	}

	public Display(double size, long colorAmount) {
		this.size = size;
		this.colorAmount = colorAmount;
	}

	public Display(double size) {    // Because size matters
		this.size = size;
	}

	public Display(Display display) {
		this.size = display.size;
		this.colorAmount = display.colorAmount;
	}
}