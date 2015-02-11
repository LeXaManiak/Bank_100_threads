package bank_multithreads2;

public class EmuThread extends Thread{
	int clientcounter=0;
	int threadnumber=0;
	Bank bank;
	
	public EmuThread(int threadnumber,int clientcounter,Bank bank) {
		this.clientcounter=clientcounter;
		this.threadnumber=threadnumber;
		this.bank=bank;
		
	}

	
	public void run () {
		for (int i=0; i<10000; i++){
		int producerId = (int) (clientcounter * Math.random());
		int consumerId = (int) (clientcounter * Math.random());
		int sum = (int) (100 * Math.random());
		
		boolean suxess=bank.transfer(consumerId, producerId, sum);
		System.out.println(threadnumber+"\t"+suxess);
		}
		
	}
	
	
	
}
