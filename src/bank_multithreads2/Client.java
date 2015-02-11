package bank_multithreads2;

import java.util.concurrent.atomic.AtomicInteger;

public class Client {
	private AtomicInteger accountstate;
	
	public Client(int sum) {
		
		accountstate = new AtomicInteger(sum);
		
	}
	
	public void addmoney(int sum){
		
		accountstate.addAndGet(sum);
		
	}
	
public void takemoney(int sum){
		
		accountstate.addAndGet(-sum);
		
	}
	
public int getaccountstate(){
	
	return accountstate.get();
	
}


}
