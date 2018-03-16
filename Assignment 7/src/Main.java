public class Main {

    public static void main(String[] args) {
    	GSM phone1 = new GSM("Something", "Something else");
//    	GSM phone2 = new GSM("Sony", "Ericson Inc.");
//    	phone1.setBattery("Battery model", 123, 142);
//    	phone2.setBattery("Generic Battery something", 999, 999);
////    	phone1.getBattery().setModel("Some model");
//    	phone1.setDisplay(123);
//    	phone2.setDisplay(999);
////    	System.out.println(phone1.getBattery().getModel());
////    	phone1.setPrice(123);
////    	System.out.println(phone1.getPrice());
//    	System.out.println(phone1.toString());
//    	System.out.println(phone2.toString());
//    	System.out.println(phone1.toString());
		GSM.IPhone4S.setBattery(GSM.IBattery);
		GSM.IPhone4S.setDisplay(GSM.IDisplay);
//    	System.out.println(GSM.IPhone4S.getBattery().getModel());
//    	System.out.println(GSM.IPhone4S.getDisplay().getColorAmount());
//    	System.out.println(GSM.IPhone4S.toString());
    	GSMTest.printAllInstances();
    }
}