package bank_multithreads2;







import java.util.HashMap;

public class Bank {
	
	
	int clientcounter = 0;
	static HashMap<Integer, Client> clients;
	
	int totalsumm=0;
	
	
	public Bank() {		
		clients = new HashMap<Integer, Client>();
	}
	
	void addclients(int clientsnumber){
		
		for (int i = 0; i < clientsnumber; i++) {
			
			bankaddclient(1000);
			
		}
		
	}
	
	
	public boolean transfer(int consumerID, int producerID, int sum) {
		
		Client consumer=clients.get(consumerID);
		Client producer=clients.get(producerID);
		
		if (producer==null || consumer==null || producer.getaccountstate()<sum) return false;
		
		producer.takemoney(sum);
		consumer.addmoney(sum);
		
		
		
		return true;
		
		
	}
	
	
	public void bankaddclient(int accountstate) {

		Client cl = new Client( accountstate);
		totalsumm+=accountstate;
		clients.put(clientcounter, cl);
		
		clientcounter++;
	}
	
	
	public int bankrevision() {
	int sum=0;
	for (int i = 0; i < clientcounter; i++) {
		Client cl=clients.get(i);
		i+=cl.getaccountstate();
		
	}
	return sum;
	
	}

}
