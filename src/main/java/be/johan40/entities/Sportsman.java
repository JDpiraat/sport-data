package be.johan40.entities;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

public class Sportsman implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String firstName;
	private String lastName;
	private GregorianCalendar birthDay;
	private double kilogram;
	private double lengthInMeters;
	private short maxHeartbeats;
	private boolean autoMaxHeartbeats;
	private List<Track> tracks;

}
