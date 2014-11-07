package grm;

public class ZeroException extends ArithmeticException {
	private String	message;
	
	public ZeroException(String message) {
		super(message);
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ZeroException [message=" + this.message + "]";
	}
}
