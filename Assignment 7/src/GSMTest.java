public class GSMTest {
	private static boolean isInitiated = false;
	public static GSM[] testInstance = new GSM[5];
	public GSMTest() {
		for (int i = 0; i < testInstance.length; i++){
			testInstance[i] = new GSM(
					"Generic name " + i,
					"Generic manufacturer " + i,
					i * 100,
					"Generic owner name " + i
			);
			testInstance[i].setBattery(
					"Generic model name " + i,
					i * 100,
					i * 100
			);
			testInstance[i].setDisplay(
					i * 100,
					i * 100
			);
		}
		isInitiated = true;
	}

	public static String testIPhone4S() {
		return GSM.IPhone4S.toString();
	}

	public static void printAllInstances() {
		if (!isInitiated) new GSMTest();
		for (int i = 0; i < GSMTest.testInstance.length; i++) {
			System.out.println(GSMTest.testInstance[i].toString());
		}
	}













}
