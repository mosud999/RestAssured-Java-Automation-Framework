package configuration;

/*
 * Method overloading has three rules to follow:
	Method overloading means multiple methods with same name in a same class;
	1) By changing the number of the parameter;
    2) By changing the type of the parameter;
    3) By changing the order of the parameter;*/

public class MethodOverloadingConcept {

	public static void main(String[] args) {
		ChangingNumber changingNumber = new ChangingNumber();
		System.out.println(changingNumber.m(2, 2));
		System.out.println(changingNumber.m(2, 2, 2));

		ChangingType changingType = new ChangingType();
		System.out.println(changingType.m(1, 2));
		System.out.println(changingType.m(14, 12, 14));
		
		ChangingOrder changingOrder = new ChangingOrder();
		changingOrder.m("Jimmy", 28);
		changingOrder.m(20, "Rebecca");
	}
}

// By changing the number of the parameter;
class ChangingNumber {
	public int m(int a, int b) {
		int sum = a + b;
		return sum;
	}

	public int m(int a, int b, int c) {
		int sum = a + b + c;
		return sum;
	}
}

// By changing the type of parameter;
class ChangingType {
	public int m(int a, int b) {
		int sum = a + b;
		return sum;
	}

	public double m(double a, double b, double c) {
		double sum = a + b;
		return sum;
	}
}

// By Changing the order of parameter;
class ChangingOrder {
	public void m(String name, int age) {
		System.out.println(name + "is " + age + "years old");
	}

	public void m(int age, String name) {
		System.out.println(name + "is " + age + "years old");
	}

}