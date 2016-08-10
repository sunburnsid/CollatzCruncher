import java.util.*;

public class BigWhole {

	private static HashMap<Long, Long> theTree;
	private static long best;
	private static long upperLimit = 100000000;
	private static long k;
	//private static HashMap<Long, Long> theTree2;
	//private static long lowerLimit = 5000000;
	

	public static void main(String[] args) {

		theTree = new HashMap<Long, Long>();
		theTree.put((long) 1, (long) 0);
		best = 1;

		for (k = 1; k < upperLimit; k++) {
			decryptify(k);
		}

	}

	private static void decryptify(long num) {

		if (!theTree.containsKey(num)) {
			long cuckoo = makepath(num);
			if (cuckoo > best) {
				best = cuckoo;
				System.out.println("The best is " + num + " at " + best);
			}
		}
	}

	private static long makepath(long check) {
			if (theTree.containsKey(check)) {
				return theTree.get(check);
			}

			if (check % 2 == 0) {
				long sum = 1 + makepath(check / 2);
				if (check <= k){ theTree.put(check, sum); }
				return sum;
			} else {
				long sum = 1 + makepath(3 * check + 1);
				if (check <= k){ theTree.put(check, sum); }
				return sum;
			}
	}
}
