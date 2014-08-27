package be.johan40.entities;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import be.johan40.valueobjects.LengthInMeters;
import be.johan40.valueobjects.MaxHeartbeats;
import be.johan40.valueobjects.SportsSession;
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
	private GregorianCalendar birthday;
	@ElementCollection
	@CollectionTable(name = "weight", joinColumns = @JoinColumn(name = "id"))
	@OrderBy("weightInKg.startDateEndDate.startDate desc")
	private WeightInKg weightInKg;
	@ElementCollection
	@CollectionTable(name = "length", joinColumns = @JoinColumn(name = "id"))
	@OrderBy("lengthInMeters.startDateEndDate.startDate desc")
	private LengthInMeters lengthInMeters;
	@ElementCollection
	@CollectionTable(name = "maxheartbeats", joinColumns = @JoinColumn(name = "id"))
	@OrderBy("maxHeartbeats.startDateEndDate.startDate desc")
	private MaxHeartbeats maxHeartbeats;
	private boolean autoMaxHeartbeats;
	private List<Track> tracks;
	private List<SportsSession> sportsSessions;

}

// TODO reminder: @SafeHtml bij velden die beschermd moeten worden tegen xss
// (cross-site scripting)