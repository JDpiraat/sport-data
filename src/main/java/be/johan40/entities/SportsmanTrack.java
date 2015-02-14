package be.johan40.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import be.johan40.valueobjects.SportsSession;

@Entity
@Table(name = "sportsmantrack")
public class SportsmanTrack implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "trackId")
	private Track track;

	@ManyToOne
	@JoinColumn(name = "sportsmanId")
	private Sportsman sportsman;

	private boolean trackOwner;

	@ElementCollection
	@CollectionTable(name = "sportssession", joinColumns = @JoinColumn(name = "sportsmantrackId"))
	@OrderBy("date desc")
	@Access(AccessType.FIELD)
	private Set<SportsSession> sportsSessions = new HashSet<>();

	protected SportsmanTrack() {
	}

	public SportsmanTrack(Track track) {
		this.track = track;
		trackOwner = true;
	}

	private SportsmanTrack(Track track, boolean trackOwner) {
		this.track = track;
		this.trackOwner = trackOwner;
	}

	public void copySportsmanTrack() {
		new SportsmanTrack(track, false);

	}

	public void copyAndOwnSportsmanTrack() {
		new SportsmanTrack(new Track(track), false);

	}

	public Track getTrack() {
		return track;
	}

	protected void setTrack(Track track) {
		this.track = track;
	}

	public Sportsman getSportsman() {
		return sportsman;
	}

	public void setSportsman(Sportsman sportsman) {
		this.sportsman = sportsman;
	}

	public boolean isTrackOwner() {
		return trackOwner;
	}

	protected void setTrackOwner(boolean trackOwner) {
		this.trackOwner = trackOwner;
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
		result = prime * result + ((track == null) ? 0 : track.hashCode());
		result = prime * result + (trackOwner ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SportsmanTrack)) {
			return false;
		}
		SportsmanTrack other = (SportsmanTrack) obj;
		if (track == null) {
			if (other.track != null) {
				return false;
			}
		} else if (!track.equals(other.track)) {
			return false;
		}
		if (trackOwner != other.trackOwner) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SportsmanTrack [track=" + track + ", trackOwner=" + trackOwner
				+ "]";
	}

}
