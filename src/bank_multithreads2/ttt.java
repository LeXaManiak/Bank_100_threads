package bank_multithreads2;

public class ttt {

	

	public static void main(String[] args) {
	
		Emulator e=new Emulator();
		
		int t=e.emulate();
		
		System.out.println("Difference="+t);

	}

}
