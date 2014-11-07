package grm;

public class Rownanie {
	private int[]	stale;
	private int		countN;
	private String	rownanie	= "";
	
	public Rownanie(int... stale) {
		this.stale = stale;
		this.countN = this.stale.length;
		char z = 'z';
		char firstChar = (char) (z - countN);
		for (int i = 0; i < countN; i++) {
			String stala = "" + stale[i];
			String charVar = "" + ((char) (firstChar + i + 1));
			rownanie = rownanie.concat(stala);
			String stringVar = "" + charVar;
			if (i < (countN - 2)) {
				if (!stringVar.equals("1")) {
					rownanie = rownanie.concat(stringVar);
				}
				rownanie = rownanie.concat(" + ");
			} else if (i == countN - 2) {
				rownanie = rownanie.concat(stringVar);
				rownanie = rownanie.concat(" = ");
			} else {
				rownanie = rownanie.concat(";");
			}
		}
	}
	
	public int[] getRownanieAsArray() {
		return stale;
	}
	
	public int[] getRownanieAsArrayLOnly() {
		int length = this.stale.length - 1;
		int[] rown = new int[length];
		for (int i = 0; i < stale.length - 1; i++) {
			rown[i] = this.stale[i];
		}
		return rown;
	}
	
	public String getRownanie() {
		return this.rownanie;
	}
}
