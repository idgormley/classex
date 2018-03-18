package edu.metrostate.ics240.idg091.p4.sim;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;
import edu.metrostate.ics240.p4.sim.Airport;
import edu.metrostate.ics240.p4.sim.Event;
import edu.metrostate.ics240.p4.sim.Event.EventType;

public class AirportSimulator extends Airport {
	protected PriorityQueue<Flight> airQueue;
	protected int runways;
	protected int arrRSV;
	protected int depRSV;
	protected LocalTime scheduledTime;
	protected EventType eventType;
	protected String flightId;
	protected Event[] flights;
	protected Flight plane;
	public int planecount;
	protected LocalTime simTime;
	private LocalTime actualTime;
	private LocalTime handledTime;

	/**
	 * Creates airport simulator with specified number of runways with default
	 * arrival and departure runway reserve times;
	 * 
	 * Precondition: numRunways >= 1;
	 * 
	 * @param numRunways
	 *            Number of runways at airport
	 */
	public AirportSimulator(int numRunways) {
		Comparator<Flight> Priority = new Priority();
		airQueue = new PriorityQueue<Flight>(11, Priority);
		runways = numRunways;
		arrRSV = ARR_RESERVE_TIME;
		depRSV = DEP_RESERVE_TIME;
	}

	/**
	 * Creates airport simulator with specified number of runways and arrival
	 * and departure runway reserve times (in minutes);
	 * 
	 * Precondition: numRunways >= 1, arrivalReserveTime >= 1,
	 * departureReserveTime >= 1;
	 * 
	 * @param numRunways
	 *            number of runways in airport
	 * @param arrivalReserveTime
	 *            reserved runway time (in minutes) for arrivals
	 * @param departureReserveTime
	 *            reserved runway time (in minutes) for departures
	 */
	public AirportSimulator(int numRunways, int arrivalReserveTime, int departureReserveTime) {
		if (numRunways >= 1 && arrivalReserveTime >= 1 && departureReserveTime >= 1) {
			Comparator<Flight> Priority = new Priority();
			airQueue = new PriorityQueue<Flight>(11, Priority);
			runways = numRunways;
			arrRSV = arrivalReserveTime;
			depRSV = departureReserveTime;
		}
	}

	/**
	 * Precondition: filename contains path to the events file; events file is
	 * pipe-delimited file containing the scheduled time, event type (ARRIVAL or
	 * DEPARTURE) and a Flight ID.
	 * 
	 * @param filename
	 *            path to the flight event file.
	 */
	public void processEventFile(String filename) {
		File file = new File("filename");
		try{
		Scanner events = new Scanner(file);
		simTime = LocalTime.MIN;
		while (events.hasNext()) {
			String sc = events.nextLine();
			String[] airPlane = sc.split("\\|", 3);
			process(airPlane);
		}
		events.close();
		run(airQueue);
		}
		catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}

	private void process(String[] airPlane) {
		scheduledTime = LocalTime.parse(airPlane[0]);
		plane.setScheduledTime(scheduledTime);
		if (airPlane[1].equals("ARRIVAL")) {
			eventType = EventType.ARRIVAL;
			plane.setEvent(eventType);
		} else if (airPlane[1].equals("DEPARTURE")) {
			eventType = EventType.DEPARTURE;
			plane.setEvent(eventType);
		}
		flightId = airPlane[2];
		plane.setIdent(flightId);
		planecount++;
		airQueue.add(plane);
	}

	private void startTime(Flight flight) {
		LocalTime time = flight.getScheduledTime();
		if (simTime.isBefore(time)) {
			simTime = time;
		}
	}
	private void nextTime(Flight flight) {
		LocalTime time = flight.getActualTime();
		if (simTime.isBefore(time)) {
			simTime = time;
		}
	}
	private void run(PriorityQueue<Flight> airQueue) {
		runway(airQueue);
	}

	private void runway(PriorityQueue<Flight> airQueue) {
		int i = 1;
		int j = 0;
		while (i <= runways) {
			while (j <= planecount) {
				Flight handled = airQueue.poll();
				startTime(handled);
				actualTime = convertTime(handled);
				handled.setActualTime(actualTime);
				flights[j] = handled;
				j++;
				nextTime(handled);
			}
			i++;
		}
	}

	private LocalTime convertTime(Flight flight) {
		LocalTime time = null;
		LocalTime st = flight.getScheduledTime();
		if (simTime == st)
			time = st;
		if (flight.getEvent() == Event.EventType.ARRIVAL)
			time = simTime.plusMinutes(arrRSV);
		else if (flight.getEvent() == Event.EventType.DEPARTURE)
			time = simTime.plusMinutes(depRSV);
		return time;
	}

	/**
	 * Returns an array of all processed flight arrivals and departures
	 * 
	 * @return array of all flights processed
	 */
	public Event[] getFlightsHandled() {
		return flights;
	}

}