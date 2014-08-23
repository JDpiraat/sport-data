package be.johan40.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.GregorianCalendar;

public class SportsSession implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private GregorianCalendar date;
	// TODO check if there's a better suitable class for an interval input via
	// frontend
	private GregorianCalendar time;
	private short heartbeatsPerMinute;
	private short maxHeartbeatsPerMinute;
	private short kilocalories;
	private String remark;
	private Track track;
	private Sportsman sportsman;
	
}
