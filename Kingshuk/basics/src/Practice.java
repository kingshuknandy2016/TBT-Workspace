
public class Practice {
	{
		System.out.println("instance block");
	}
	static {
		System.out.println("static block");
	}
	Practice() {
		System.out.println("default constructor");
	}
	public static void main(String[] args) {
		System.out.println("main method");
		Practice p = new Practice();
	}

}
