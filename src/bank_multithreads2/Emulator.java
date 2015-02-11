package bank_multithreads2;

import java.util.ArrayList;

public class Emulator {
	
	final static int clientnumber=100;
	final static int emulatornumber=100;
	Bank bank;
	
	
	ArrayList<EmuThread> threadlist = new ArrayList<EmuThread>();
	
public Emulator() {
	bank=new Bank();
	bank.addclients(clientnumber);
}


	public int emulate() {
	

		int before=bank.bankrevision();
		
for (int i=0; i<emulatornumber; i++){
	threadlist.add(new EmuThread(i, clientnumber, bank));
		}
		
for ( EmuThread et :threadlist){
	et.start();
}

try {
	for ( EmuThread et :threadlist){
		et.join();
	}
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

int last=bank.bankrevision();


		
		int difference=before-last;
		return difference;
	}
	
	
	

}
