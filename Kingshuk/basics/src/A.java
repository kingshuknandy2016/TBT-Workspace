
public class A {
	static int i = 4;
	A(){
		System.out.println("aa");
	}
	void run() {
		System.out.println("A");
	}
}

class Ba extends A {
	Ba(){
		System.out.println("bb");
	}
	static int k = 5;
	void run() {
		//super.run();
		System.out.println("B");
	}
}

class C extends Ba {
	
	C(){
		System.out.println("cc");
	}
	static int j=46;
	void run() {
		//super.run();
		int m;
		m=j+k+i;
		System.out.println(m);
		System.out.println("C");
	}
}
