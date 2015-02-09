package be.johan40.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import be.johan40.valueobjects.LengthInMeters;
import be.johan40.valueobjects.MaxHeartbeats;
import be.johan40.valueobjects.SportsSession;
import be.johan40.valueobjects.SportsmanTrack;
import be.johan40.valueobjects.StartDateEndDate;
import be.johan40.valueobjects.WeightInKg;

@Entity
@Table(name = "sportsman")
public class Sportsman implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false, length = 50)
	private String firstName;
	@Column(nullable = false, length = 50)
	private String lastName;
	@Column(nullable = false)
	@Past
	private LocalDate birthday;
	@ElementCollection
	@CollectionTable(name = "weight", joinColumns = @JoinColumn(name = "sportsmanId"))
	@OrderBy("startDateEndDate.startDate desc")
	private Set<WeightInKg> weightInKg = new HashSet<>();
	@ElementCollection
	@CollectionTable(name = "length", joinColumns = @JoinColumn(name = "sportsmanId"))
	@OrderBy("startDateEndDate.startDate desc")
	private Set<LengthInMeters> lengthInMeters = new HashSet<>();;
	@ElementCollection
	@CollectionTable(name = "maxheartbeats", joinColumns = @JoinColumn(name = "sportsmanId"))
	@OrderBy("startDateEndDate.startDate desc")
	private Set<MaxHeartbeats> maxHeartbeats = new HashSet<>();;
	private boolean autoMaxHeartbeats;
	@ElementCollection
	@CollectionTable(name = "sportsmantrack", joinColumns = @JoinColumn(name = "sportsmanId"))
	@OrderBy("track.name desc")
	@Access(AccessType.FIELD)
	private Set<SportsmanTrack> sportsmanTracks = new HashSet<>();;
	@ElementCollection
	@CollectionTable(name = "sportssession", joinColumns = @JoinColumn(name = "sportsmanId"))
	@OrderBy("date desc")
	@Access(AccessType.FIELD)
	private Set<SportsSession> sportsSessions = new HashSet<>();

	protected Sportsman() {
	}

	/**
	 * maxHeartbeats set to default value (220-age), auto updated
	 */
	public Sportsman(String firstName, String lastName, LocalDate birthday,
			WeightInKg weightInKg, LengthInMeters lengthInMeters) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		addWeightInKg(weightInKg);
		addLengthInMeters(lengthInMeters);
		LocalDate toDay = LocalDate.now();
		addMaxHeartbeats(new MaxHeartbeats(new StartDateEndDate(toDay),
				(short) (220 - (toDay.getYear() - 1900) - birthday.getYear())));
		autoMaxHeartbeats = true;
	}

	/**
	 * @param maxHeartbeats
	 *            maximum heart rate, use constructor without this parameter if
	 *            you have no idea what this is (now user set, no default value
	 *            anymore and not auto updated)
	 * 
	 */
	public Sportsman(String firstName, String lastName, LocalDate birthday,
			WeightInKg weightInKg, LengthInMeters lengthInMeters,
			short maxHeartbeats) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		addWeightInKg(weightInKg);
		addLengthInMeters(lengthInMeters);
		addMaxHeartbeats(new MaxHeartbeats(
				new StartDateEndDate(LocalDate.now()), maxHeartbeats));
		autoMaxHeartbeats = false;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Set<WeightInKg> getWeightInKg() {
		return Collections.unmodifiableSet(weightInKg);
	}

	protected void setWeightInKg(Set<WeightInKg> weightInKg) {
		this.weightInKg = weightInKg;
	}

	public void addWeightInKg(WeightInKg weightInKg) {
		this.weightInKg.add(weightInKg);
	}

	public Set<LengthInMeters> getLengthInMeters() {
		return Collections.unmodifiableSet(lengthInMeters);
	}

	protected void setLengthInMeters(Set<LengthInMeters> lengthInMeters) {
		this.lengthInMeters = lengthInMeters;
	}

	public void addLengthInMeters(LengthInMeters lengthInMeters) {
		this.lengthInMeters.add(lengthInMeters);
	}

	public Set<MaxHeartbeats> getMaxHeartbeats() {
		return Collections.unmodifiableSet(maxHeartbeats);
	}

	protected void setMaxHeartbeats(Set<MaxHeartbeats> maxHeartbeats) {
		this.maxHeartbeats = maxHeartbeats;
	}

	public void addMaxHeartbeats(MaxHeartbeats maxHeartbeats) {
		this.maxHeartbeats.add(maxHeartbeats);
	}

	public boolean isAutoMaxHeartbeats() {
		return autoMaxHeartbeats;
	}

	public void setAutoMaxHeartbeats(boolean autoMaxHeartbeats) {
		this.autoMaxHeartbeats = autoMaxHeartbeats;
	}

	public Optional<Set<SportsmanTrack>> getSportsmanTracks() {
		return Optional.of(Collections.unmodifiableSet(sportsmanTracks));
	}

	protected void setSportsmanTracks(Set<SportsmanTrack> sportsmanTracks) {
		this.sportsmanTracks = sportsmanTracks;
	}

	public void addSportsmanTrack(SportsmanTrack sportsmanTrack) {
		sportsmanTracks.add(sportsmanTrack);
	}

	public Optional<Set<SportsSession>> getSportsSessions() {
		return Optional.of(Collections.unmodifiableSet(sportsSessions));
	}

	protected void setSportsSessions(Set<SportsSession> sportsSessions) {
		this.sportsSessions = sportsSessions;
	}

	public void addSportsSession(SportsSession sportsSession) {
		sportsSessions.add(sportsSession);
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Sportsman)) {
			return false;
		}
		Sportsman other = (Sportsman) obj;
		if (birthday == null) {
			if (other.birthday != null) {
				return false;
			}
		} else if (!birthday.equals(other.birthday)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return "Sportsman [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthday="
				+ dateFormat.format(birthday) + "]";
	}

}

// TODO reminder: @SafeHtml bij velden die beschermd moeten worden tegen xss
// (cross-site scripting)