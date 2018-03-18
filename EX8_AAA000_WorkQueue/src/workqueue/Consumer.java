package workqueue;

public class Consumer extends Worker implements Runnable {
	private static final int MAX_DELAY_FACTOR = 10;
	private static final int MIN_DELAY_FACTOR = 5;
	private WorkQueue queue;
	
	public Consumer(WorkQueue queue) {
		workerID = String.format("Consumer_%02d", workerCounter++);
		this.queue = queue;
	}
	
	@Override
	public void run() {
		int delay = (MIN_DELAY_FACTOR + RAND.nextInt(MAX_DELAY_FACTOR)) ;
		WorkOrder wo = null;
		while(true){
			wo = queue.getWork(this);
			if (wo != null){
				System.out.println(wo.toString());
			}
			delay(delay);
		}
	}
}
