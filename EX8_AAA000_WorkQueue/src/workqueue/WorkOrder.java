package workqueue;

import java.time.LocalDateTime;

public class WorkOrder {
	private static int workOrderCount = 0;
	private int id;
	private String submittedBy;
	private String completedBy;
	private String description;
	private LocalDateTime submitTime;
	private LocalDateTime completeTime;
	
	public WorkOrder (){
		synchronized (WorkOrder.class) {
			id = ++workOrderCount;
		}
	}
	/**
	 * @return the submittedBy
	 */
	public String getSubmittedBy() {
		return submittedBy;
	}
	/**
	 * @param submittedBy the submittedBy to set
	 */
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
	/**
	 * @return the completedBy
	 */
	public String getCompletedBy() {
		return completedBy;
	}
	/**
	 * @param completedBy the completedBy to set
	 */
	public void setCompletedBy(String completedBy) {
		this.completedBy = completedBy;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the submitTime
	 */
	public LocalDateTime getSubmitTime() {
		return submitTime;
	}
	/**
	 * @param submitTime the submitTime to set
	 */
	public void setSubmitTime(LocalDateTime submitTime) {
		this.submitTime = submitTime;
	}
	/**
	 * @return the completeTime
	 */
	public LocalDateTime getCompleteTime() {
		return completeTime;
	}
	/**
	 * @param completeTime the completeTime to set
	 */
	public void setCompleteTime(LocalDateTime completeTime) {
		this.completeTime = completeTime;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("WorkOrder_%02d\t%s\t%s\t%s\t%s",  id, submittedBy, submitTime ,  completedBy, completeTime );
	}

}
