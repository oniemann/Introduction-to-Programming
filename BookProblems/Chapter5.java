import java.util.*;
import java.io.*;

class ArraySum2 {
	public static void main(String[] args) {
		int[] data1 = {22, 15, 16, 6, 12, 14};
		int[] data2 = {13, 76, 88, 109, 222, 666};

		System.out.println("sum of data1: " + sum(data1));
	}

	static int sum(int[] a) {
		int sum = 0;
		for (int d: a)
			sum += d;

		return sum;
	}
}