package workqueue;

public class WorkerDemo {

	public final static int NUM_PRODUCERS = 1;
	public final static int NUM_CONSUMERS = 3;
	
	public static void main(String[] args) {

		WorkQueue queue = new WorkQueue();
		
		for (int i = 0; i < NUM_PRODUCERS; i++){
			new Thread(new Producer(queue)).start();
		}
		
		for (int i = 0; i < NUM_CONSUMERS; i++){
			new Thread(new Consumer(queue)).start();
		}
		
		while (true){
			System.out.printf("*** Queue Length: %d\n", queue.size() );
			
			delay(5);
			
		}
	}
	static protected void delay(int timeInSecs) {
		try {
			Thread.sleep(timeInSecs * 1_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
