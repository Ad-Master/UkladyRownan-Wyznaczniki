package grm;

public class Wyznacznik {
	private int	macierz[][], macierzWewn[][];
	private int	N;
	
	public Wyznacznik(int macierz[][], int N) {
		this.macierz = macierz;
		this.N = N;
	}
	
	public double wyznaczWyznacznik(int macierz[][], int N) {
		int wyznacznik = 0;
		if (N == 1) {
			wyznacznik = macierz[0][0];
		} else if (N == 2) {
			wyznacznik = macierz[0][0] * macierz[1][1] - macierz[1][0] * macierz[0][1];
		} else if (N > 2) {
			for (int i = 0; i < N; i++) {
				macierzWewn = stworzWewnMacierz(macierz, N, i);
				wyznacznik += Math.pow(-1.0, 1.0 + i + 1.0) * macierz[0][i]
						* wyznaczWyznacznik(macierzWewn, N - 1);
			}
		}
		return wyznacznik;
	}
	
	private int[][] stworzWewnMacierz(int macierzT[][], int il_rown, int rownanie) {
		int unn = macierzT[0].length;
		macierzWewn = new int[il_rown - 1][];
		for (int k = 0; k < (il_rown - 1); k++) {
			macierzWewn[k] = new int[unn];
		}
		for (int i = 1; i < il_rown; i++) {
			for (int j = 0, j2 = 0; j < unn; j++) {
				if (j == rownanie)
					continue;
				macierzWewn[i - 1][j2] = macierzT[i][j];
				j2++;
			}
		}
		return macierzWewn;
	}
}
