package edu.metrostate.ics240.idg091.p4.sim;

	import java.time.LocalDateTime;

import edu.metrostate.ics240.p4.sim.Event;
import edu.metrostate.ics240.p4.sim.Event.EventType;
	public class Runway {
		private String RunwayAssign;
		private LocalDateTime submitTime;
		private LocalDateTime completeTime;
		private EventType event;
		
		public Runway (){{
				
			}
		}
		

//		public void setRunway(runway runway){
//		if (runway().isEmpty){
//			return runway=RUNWAY_AVAIL;	
//		}else{
//			return runway=RUNWAY_ASSIGN
//		}
//		}
//		private Object runway() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//
//		public EventType getRunway(){
//			return runway
//		}
		/**
		 * @return the RunwayAssign
		 */
		public String getRunwayAssign() {
			return RunwayAssign;
		}
		/**
		 * @param RunwayAssign the RunwayAssign to set
		 */
		public void setRunwayAssign(String RunwayAssign) {
			this.RunwayAssign = RunwayAssign;
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
		public  EventType getEvent(){
			return event;
		}

		public void setEvent(EventType eventType){
			this.event=eventType;
		}
		/**
		 * @return the id
		 */
		public String getIdent() {
			return this.getIdent();
		}

	}


