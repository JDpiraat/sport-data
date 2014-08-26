package be.johan40.entities;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.transaction.annotation.Transactional;

import be.johan40.valueobjects.LengthInMeters;
import be.johan40.valueobjects.MaxHeartbeats;
import be.johan40.valueobjects.SportsSession;
import be.johan40.valueobjects.WeightInKg;

@Entity(name = "sportsman")
@Transactional(readOnly = true)
public class Sportsman implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private GregorianCalendar birthday;

	private WeightInKg weightInKg;
	private LengthInMeters lengthInMeters;
	private MaxHeartbeats maxHeartbeats;
	private boolean autoMaxHeartbeats;
	private List<Track> tracks;
	private List<SportsSession> sportsSessions;

}

// TODO reminder: @SafeHtml bij velden die beschermd moeten worden tegen xss
// (cross-site scripting)