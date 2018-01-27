package org.hksoft.arrayWalker;

import java.util.Random;

public class ArrayWalkerTest {

	private static Random rnd = new Random();

	public static void main(String[] args) {
		Integer[][] array = new Integer[4][5];
		System.out.println("\n");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = rnd.nextInt(300);
				System.out.print(String.format("%03d", array[i][j]) + "  ");
			}
			System.out.println("\n");
		}
		System.out.println();
		ArrayWalker<Integer> arrayWalker = new ArrayWalker<Integer>(array);
		arrayWalker.goTo(13);
		System.out.println(arrayWalker.getValue());
		arrayWalker.right();
		System.out.println(arrayWalker.getValue());
	}
}
