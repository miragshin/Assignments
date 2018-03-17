public class GSMCallHistoryTest {
	private static GSM testPhone = new GSM(
			"Test phone model",
			"Test manufacturer",
			100,
			"Test owner"
	);

	public static void run() {

		testPhone.add(new Calls(1, 2, 3, 4, 5, 6));
		testPhone.add(new Calls(2, 3, 4, 5, 6, 7));
		testPhone.add(new Calls(3, 4, 5, 6, 7, 8));
		displayCalls();
		removeLongestCall();
		System.out.println(testPhone.getCall().totalPrice());
		testPhone.getCall().clear();
		System.out.println(testPhone.getCall().toString());
	}

	private static void displayCalls() {
		for (Calls call : testPhone.getCallsArrayList()) {
			System.out.println(call.toString());
		}
	}

	private static Calls removeLongestCall() {
		int max = 0;
		Calls maxCall = new Calls();	// Because IDE wouldn't compile
		for (Calls call : testPhone.getCallsArrayList()) {
			if (call.getDuration() >= max) {
				max = call.getDuration();
				maxCall = call;

			}
		}
		testPhone.remove(maxCall);
		return maxCall;				// Returning the removed value for just in case

	}
}
