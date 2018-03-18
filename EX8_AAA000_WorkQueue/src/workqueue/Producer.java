package workqueue;

public class Producer extends Worker implements Runnable {
	private static final int DELAY_FACTOR = 8;
	private WorkQueue queue;
	public Producer(WorkQueue queue) {
		workerID = String.format("Producer_%02d", workerCounter++);
		this.queue = queue;
	}
	
	public WorkOrder submitWorkOrder(WorkQueue queue){
		WorkOrder wo = new WorkOrder();
		queue.submit(wo, this);
		return wo;
	}

	@Override
	public void run() {
		int delay = (1 + RAND.nextInt(DELAY_FACTOR)) ;
		WorkOrder wo = null;
		while(true){
			System.out.printf("%s submitting work order\n", workerID);
			wo = submitWorkOrder(queue);
			System.out.println(wo.toString());
			System.out.printf("%s taking a break...\n", workerID);
			delay(delay);
		}
	}
	
}
