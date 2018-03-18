package workqueue;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

public class WorkQueue {

	private Queue<WorkOrder> workQueue;
	
	public WorkQueue(){
		workQueue = new LinkedList<>();
	}
	
	public void submit(WorkOrder wo, Worker producer) {
		wo.setSubmittedBy(producer.getID());
		wo.setSubmitTime(LocalDateTime.now());
		System.out.printf("%d submitted by %s\n", wo.getId(), producer.getID());
		workQueue.add(wo);
	}
	
	public WorkOrder getWork(Worker consumer) {
		WorkOrder wo = workQueue.poll();
		if (wo != null) {
			wo.setCompletedBy(consumer.getID());
			wo.setCompleteTime(LocalDateTime.now());
			System.out.printf("%d retrieved by %s\n", wo.getId(), consumer.getID());

		}
		return wo;
	}

	public int size() {
		return workQueue.size();
	}
}
