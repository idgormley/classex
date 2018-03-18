package edu.metrostate.ics240.idg091.p4.sim;

import java.time.LocalTime;
import edu.metrostate.ics240.p4.sim.Event;

abstract class Flight implements Event {

	private EventType event;
	private String id;
	private LocalTime actualTime;
	private LocalTime scheduledTime;

	@Override
	public LocalTime getActualTime() {
		return actualTime;
	}
	public void setActualTime(LocalTime time) {
		 this.actualTime=time;
	}
	@Override
	public EventType getEvent() {
		return event;
	}
	public void setEvent(EventType eventType) {
		this.event=eventType;
	}
	@Override
	public String getIdent() {
		return id;
	}
	public void setIdent(String string) {
		 this.id=string;
	}
	@Override
	public LocalTime getScheduledTime() {
		return scheduledTime;
	}
	public void setScheduledTime(LocalTime time) {
		 this.scheduledTime=time;
	}
}