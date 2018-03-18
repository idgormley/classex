package workqueue;

import java.util.Random;

public class Worker  {
	private static final long SEED = 20170607001L;
	protected static final Random RAND = new Random();
	
	protected static int workerCounter = 0;
	protected String workerID;

	public Worker() {
		super();
	}

	public void getWorkOrder(WorkQueue queue) {
		WorkOrder wo = queue.getWork(this);
		if (wo != null) {
			System.out.printf("%s working on %d", workerID, wo.getId());
		}
	}
	/**
	 * @return the producerID
	 */
	public String getID() {
		return workerID;
	}

	static protected void delay(int timeInSecs) {
		try {
			Thread.sleep(timeInSecs * 1_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}