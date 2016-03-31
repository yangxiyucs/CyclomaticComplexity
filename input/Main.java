package test;



public class Main {
	
	private A a = null;
	
	public void test1() {
		if (a == null) {
			System.out.println("1");
			a = new B();
		} else if (a instanceof B) {
			System.out.println("2");
			a = new C();
		} else if (a instanceof C) {
			System.out.println("3");
			a = new B();
		}
	}
	
	public static void test2(String[] args) {
		Main m = new Main();
		while (true) {
			m.test1();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static String nTo26Base(int n) {
		String res = "";
		
		
		char alf[] = new char[27];
		alf[0] = 'Z';
		
		for (int i=1;i < 27;i++) {
			alf [i] = (char) ('A' + (i-1)); 
		}
		
		int prev_m = -1, m = 0, d = 0;
		while (n >= 1) {
			m = n % 26;
			
			if (m == 0 && d == 0) {
				res = alf[m] + res;
			} else {
				
				if (prev_m == 0 && m != 0) {
					res = alf[m - 1] + res;
				} else {
					res = alf[m] + res;
				}
			}
			
			n = n / 26;
			
			prev_m = m;
			
			d++;
			System.out.println(n + " " + m + " " + res);
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(nTo26Base(677));
		//System.out.println(nTo26Base(677));
		//		System.out.println(nTo26Base(52));
		for (int i = 27; i < 34; i++) {
			//System.out.println(nTo26Base(i));
		}
	}
	
	
}

class A {}

class B extends A {}

class C extends A {}
