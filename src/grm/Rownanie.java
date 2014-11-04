package grm;

public class Rownanie {
	private int		a, b, c;
	private String	r;
	
	public Rownanie(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.r = a + "x + " + b + "y" + " = " + c;
	}
	
	public int[] getRownanieAsArray() {
		int[] rown = {a, b, c};
		return rown;
	}
	
	public int[] getRownanieAsArrayLOnly() {
		int[] rown = {a, b};
		return rown;
	}
	
	public String getR() {
		return this.r;
	}
	
	public int getA() {
		return this.a;
	}
	
	public int getB() {
		return this.b;
	}
	
	public int getC() {
		return this.c;
	}
	
}
