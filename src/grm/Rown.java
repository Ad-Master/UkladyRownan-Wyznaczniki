package grm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Rown {
	private static Map<Integer, Rownanie>	rownania	= new HashMap<Integer, Rownanie>();
	private static int						iloscNiewiadomych;
	private static Scanner					input;
	private static int[][]					macierz, macierzW;
	private static double					W, Wx, Wy, x, y;
	private static ArrayList<Integer>		elemRownList;
	private static Integer[]				elemRownPattern;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Obecnie dziala tylko dla 2");
		System.out
				.println("Podaj ilosc niewiadomych. Tyle rowniez musisz podac rownan: ");
		iloscNiewiadomych = input.nextInt();
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
		elemRownList = new ArrayList<Integer>();
		elemRownPattern = new Integer[iloscNiewiadomych];
		
		for (int i = 1; i <= iloscNiewiadomych; i++) {
			elemRownList.clear();
			int[] elemRownInt = setupRownanie(i);
			rownania.put(i, new Rownanie(elemRownInt));
		}
	}
	
	private static int[] setupRownanie(int i) {
		for (int j = 0; j <= iloscNiewiadomych; j++) {
			System.out.println("\nPodaj " + ((char) ('a' + j)) + i);
			elemRownList.add(input.nextInt());
		}
		Integer[] elemInteger = elemRownList.toArray(elemRownPattern);
		int[] elemRownInt = new int[elemInteger.length];
		for (int k = 0; k < elemInteger.length; k++) {
			elemRownInt[k] = elemInteger[k].intValue();
		}
		return elemRownInt;
	}
	
	private static void createMatrix() {
		int[][] macierzT1 = new int[iloscNiewiadomych][3];
		int[][] macierzT2 = new int[iloscNiewiadomych][2];
		for (int i = 0; i < iloscNiewiadomych; i++) {
			macierzT1[i] = rownania.get(i + 1).getRownanieAsArray();
		}
		for (int i = 0; i < iloscNiewiadomych; i++) {
			macierzT2[i] = rownania.get(i + 1).getRownanieAsArrayLOnly();
		}
		macierz = macierzT1;
		macierzW = macierzT2;
	}
	
	private static void showRownania() {
		for (Entry<Integer, Rownanie> entry : rownania.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue().getRownanie());
		}
	}
	
	private static void wyliczWyznaczniki() {
		Wyznacznik wyznacznik = new Wyznacznik(macierz, iloscNiewiadomych);
		W = wyznacznik.wyznaczWyznacznik(macierzW, iloscNiewiadomych);
		if (W == 0) { throw new ZeroException("Wyznacznik = 0"); }
		if (iloscNiewiadomych != 1) {
			int[][] macierzWT = macierzW.clone();
			for (int i = 0; i < iloscNiewiadomych; i++) {
				macierzWT[i][0] = macierz[i][2];
			}
			Wx = wyznacznik.wyznaczWyznacznik(macierzWT, iloscNiewiadomych);
			macierzWT = macierzW;
			for (int i = 0; i < iloscNiewiadomych; i++) {
				macierzWT[i][0] = macierz[i][0];
				macierzWT[i][1] = macierz[i][2];
			}
			Wy = wyznacznik.wyznaczWyznacznik(macierzWT, iloscNiewiadomych);
		} else {
			Wy = macierz[0][1];
		}
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
