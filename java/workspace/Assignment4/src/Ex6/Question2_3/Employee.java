package Ex6.Question2_3;

public class Employee extends User {

	@Override
	public void calculatePay() {
		System.out.println("Calculate Pay: " + getSalaryRatio() * 420);
	}

}
