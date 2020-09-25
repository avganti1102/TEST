package Ex6.Question2_3;

public class Waiter extends User {

	@Override
	public void calculatePay() {
		System.out.println("Calculate Pay: " + getSalaryRatio() * 220);
		
	}
	

}
