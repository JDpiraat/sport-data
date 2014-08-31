package be.johan40.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import be.johan40.entities.Track;

@Embeddable
public class SportsmanTrack implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "trackId")
	private Track track;
	private boolean trackOwner;

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

	public Track getTrack() {
		return track;
	}

	protected void setTrack(Track track) {
		this.track = track;
	}

	public boolean isTrackOwner() {
		return trackOwner;
	}

	protected void setTrackOwner(boolean trackOwner) {
		this.trackOwner = trackOwner;
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
