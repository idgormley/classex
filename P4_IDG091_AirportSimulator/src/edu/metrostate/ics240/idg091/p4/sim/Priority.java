package edu.metrostate.ics240.idg091.p4.sim;

import java.time.LocalTime;
import java.util.Comparator;

import edu.metrostate.ics240.p4.sim.Event;
import edu.metrostate.ics240.p4.sim.Event.EventType;

	public final class Priority implements Comparator<Flight> {

		public int compare(Flight o1, Flight o2) {
			
			EventType e1=o1.getEvent();
			EventType e2=o2.getEvent();
			LocalTime st1=o1.getScheduledTime();
			LocalTime st2=o2.getScheduledTime();
			LocalTime at1=o1.getActualTime();
			LocalTime at2=o2.getActualTime();

			if( e1==Event.EventType.ARRIVAL&&e2==Event.EventType.DEPARTURE)
				return 5;
			if( st1.isBefore(st2))
				return 4;
			if( at1.isBefore(at2))
				return 3;
			if( at1.isBefore(st2))
				return 2;
			if( st1.isBefore(at2))
				return 1;
			if(at1==at2)
				return 0;
			if(st1==st2)
				return 0;
			if( e1==Event.EventType.DEPARTURE&&e2==Event.EventType.DEPARTURE)
				return 0;
			if( e1==Event.EventType.ARRIVAL&&e2==Event.EventType.ARRIVAL)
				return 0;
			if( st1.isAfter(at2))
				return -1;
			if( at1.isAfter(st2))
				return -2;
			if( at1.isAfter(at2))
				return -3;
			if( st1.isAfter(st2))
				return -4;
			if( e1==Event.EventType.DEPARTURE&&e2==Event.EventType.ARRIVAL)
				return -5;
			else
				return 0;
		}

}
