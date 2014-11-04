package grm;

public class Wyznacznik { // FIXME int na double zmienic
	private int	macierz[][], m[][];
	private int	N;
	
	public Wyznacznik(int macierz[][], int N) {
		this.macierz = macierz;
		this.N = N;
	}
	
	public int wyznaczWyznacznik(int macierz[][], int N) {
		int wyznacznik;
		if (N == 1) {
			wyznacznik = macierz[0][0];
		} else if (N == 2) {
			wyznacznik = macierz[0][0] * macierz[1][1] - macierz[1][0] * macierz[0][1];
		} else {
			wyznacznik = 0;
			for (int i = 0; i < N; i++) {
				m = stworzWewnMacierz(macierz, N, i);
				wyznacznik += Math.pow(-1.0, 1.0 + i + 1.0) * macierz[0][i]
						* wyznaczWyznacznik(m, N - 1);
			}
		}
		return wyznacznik;
	}
	
	private int[][] stworzWewnMacierz(int macierzT[][], int N, int j1) {
		m = new int[N - 1][];
		for (int k = 0; k < (N - 1); k++) {
			m[k] = new int[N - 1];
		}
		for (int i = 1; i < N; i++) {
			int j2 = 0;
			for (int j = 0; j < N; j++) {
				if (j == j1)
					continue;
				m[i - 1][j2] = macierzT[i][j];
				j2++;
			}
		}
		return m;
	}
}
