package grm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Rown {
	private static Map<Integer, Rownanie>	rownania	= new HashMap<Integer, Rownanie>();
	private static int						n;
	private static Scanner					input;
	private static int[][]					macierz, macierzW;
	private static int						W;
	private static int						Wx;
	private static int						Wy;
	private static int						x;
	private static int						y;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Podaj ilosc rownan: ");
		n = input.nextInt();
		setupRownania();
		showRownania();
		createMatrix();
		wyliczWyznaczniki();
		showWyznaczniki();
		calculateXY();
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}
	
	private static void setupRownania() {
		for (int i = 1; i <= n; i++) {
			System.out.println("\nPodaj a" + i);
			int da = input.nextInt();
			System.out.println("Podaj b" + i);
			int db = input.nextInt();
			System.out.println("Podaj c" + i);
			int dc = input.nextInt();
			rownania.put(i, new Rownanie(da, db, dc));
		}
	}
	
	private static void createMatrix() {
		int[][] macierzT1 = new int[n][3];
		int[][] macierzT2 = new int[n][2];
		for (int i = 0; i < n; i++) {
			macierzT1[i] = rownania.get(i + 1).getRownanieAsArray();
		}
		for (int i = 0; i < n; i++) {
			macierzT2[i] = rownania.get(i + 1).getRownanieAsArrayLOnly();
		}
		macierz = macierzT1;
		macierzW = macierzT2;
	}
	
	private static void showRownania() {
		for (Entry<Integer, Rownanie> entry : rownania.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue().getR());
		}
	}
	
	private static void wyliczWyznaczniki() {
		Wyznacznik wyznacznik = new Wyznacznik(macierz, n);
		W = wyznacznik.wyznaczWyznacznik(macierzW, n);
		int[][] macierzWT = macierzW;
		for (int i = 0; i < n; i++) {
			macierzWT[i][0] = macierz[i][2];
		}
		Wx = wyznacznik.wyznaczWyznacznik(macierzWT, n);
		macierzWT = macierzW;
		for (int i = 0; i < n; i++) {
			macierzWT[i][1] = macierz[i][2];
		}
		Wy = wyznacznik.wyznaczWyznacznik(macierzWT, n);
	}
	
	private static void showWyznaczniki() {
		System.out.println("W = " + W);
		System.out.println("Wx = " + Wx);
		System.out.println("Wy = " + Wy);
	}
	
	private static void calculateXY() {
		x = Wx / W;
		y = Wy / W;
	}
}
