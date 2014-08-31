package be.johan40.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import be.johan40.valueobjects.LengthInMeters;
import be.johan40.valueobjects.MaxHeartbeats;
import be.johan40.valueobjects.SportsSession;
import be.johan40.valueobjects.SportsmanTrack;
import be.johan40.valueobjects.WeightInKg;

@Entity
@Table(name = "sportsman")
public class Sportsman implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Calendar birthday;
	@ElementCollection
	@CollectionTable(name = "weight", joinColumns = @JoinColumn(name = "sportsmanId"))
	@OrderBy("startDateEndDate.startDate desc")
	private Set<WeightInKg> weightInKg;
	@ElementCollection
	@CollectionTable(name = "length", joinColumns = @JoinColumn(name = "sportsmanId"))
	@OrderBy("startDateEndDate.startDate desc")
	private Set<LengthInMeters> lengthInMeters;
	@ElementCollection
	@CollectionTable(name = "maxheartbeats", joinColumns = @JoinColumn(name = "sportsmanId"))
	@OrderBy("startDateEndDate.startDate desc")
	private Set<MaxHeartbeats> maxHeartbeats;
	private boolean autoMaxHeartbeats;
	@ElementCollection
	@CollectionTable(name = "sportsmantrack", joinColumns = @JoinColumn(name = "sportsmanId"))
	@OrderBy("name desc")
	private Set<SportsmanTrack> tracks;
	@ElementCollection
	@CollectionTable(name = "sportssession", joinColumns = @JoinColumn(name = "sportsmanId"))
	@OrderBy("date desc")
	private Set<SportsSession> sportsSessions;

}

// TODO reminder: @SafeHtml bij velden die beschermd moeten worden tegen xss
// (cross-site scripting)