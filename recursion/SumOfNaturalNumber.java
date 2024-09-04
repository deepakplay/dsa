package recursion;

public class SumOfNaturalNumber {
	public static void main(String[] args) {
		System.out.println(sonR(851));
		System.out.println(sonF(851));
		System.out.println(sonIter(851));

	}

	private static int sonR(int num) {
		if (num <= 0)
			return 0;

		return sonR(num - 1) + num;
	}

	private static int sonF(int num) {
		return num * (num + 1) / 2;
	}

	private static int sonIter(int num) {
		int total = 0;
		for (int i = 0; i <= num; i++)
			total += i;
		return total;
	}
}