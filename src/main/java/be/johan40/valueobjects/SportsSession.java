package be.johan40.valueobjects;

import java.io.Serializable;
import java.sql.Time;
import java.util.GregorianCalendar;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import be.johan40.entities.Track;

@Embeddable
public class SportsSession implements Serializable {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar date;
	private Time time;
	private short heartbeatsPerMinute;
	private short maxHeartbeatsPerMinute;
	private short kilocalories;
	private String remark;
	private Track track;
	// maybe in a later version when the functionality of comparing track results between multiple users is implemented
	// private Sportsman sportsman;

}
