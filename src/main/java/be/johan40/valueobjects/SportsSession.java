package be.johan40.valueobjects;

import java.io.Serializable;
import java.sql.Time;
import java.util.Calendar;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import be.johan40.entities.Track;

@Embeddable
public class SportsSession implements Serializable {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;
	private Time time;
	private short heartbeatsPerMinute;
	private short maxHeartbeatsPerMinute;
	private short kilocalories;
	private String remark;
	@ManyToOne
	@JoinColumn(name = "trackId")
	private Track track;

}
