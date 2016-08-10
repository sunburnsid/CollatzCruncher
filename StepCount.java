/** Calculates the distance of num from the 1*/
public class StepCount{
	
	public static long num = 138367; //Change this number
	
	public static void main(String[] args){
		System.out.println("No of steps: " + makepath(num));
	}
	private static long makepath(long check) {
		System.out.println("No: "+ check);
		if (check == 1) return 0;
		
		if (check % 2 == 0) {
			long sum = 1 + makepath(check / 2);
			return sum;
		} else {
			long sum = 1 + makepath(3 * check + 1);
			return sum;
		}
	}
}
