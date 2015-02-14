package be.johan40.valueobjects;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import be.johan40.entities.Track;

@Embeddable
@Access(AccessType.FIELD)
public class SportsSession implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private LocalDate date;
	@Column(nullable = false)
	private LocalTime time;
	private short heartbeatsPerMinute;
	private short maxHeartbeatsPerMinute;
	private short kilocalories;
	private String remark;

	// @ManyToOne
	// @JoinColumn(name = "trackId")
	// private Track track;

	protected SportsSession() {
	}

	public SportsSession(LocalDate date, LocalTime time, Track track) {
		this.date = date;
		this.time = time;
		// this.track = track;
	}

	public SportsSession(LocalDate date, LocalTime time,
			short heartbeatsPerMinute, short maxHeartbeatsPerMinute,
			short kilocalories, String remark, Track track) {
		this.date = date;
		this.time = time;
		this.heartbeatsPerMinute = heartbeatsPerMinute;
		this.maxHeartbeatsPerMinute = maxHeartbeatsPerMinute;
		this.kilocalories = kilocalories;
		this.remark = remark;
		// this.track = track;
	}

	public LocalDate getDate() {
		return date;
	}

	protected void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	protected void setTime(LocalTime time) {
		this.time = time;
	}

	public Optional<Short> getHeartbeatsPerMinute() {
		return Optional.of(heartbeatsPerMinute);
	}

	public void setHeartbeatsPerMinute(short heartbeatsPerMinute) {
		this.heartbeatsPerMinute = heartbeatsPerMinute;
	}

	public Optional<Short> getMaxHeartbeatsPerMinute() {
		return Optional.of(maxHeartbeatsPerMinute);
	}

	public void setMaxHeartbeatsPerMinute(short maxHeartbeatsPerMinute) {
		this.maxHeartbeatsPerMinute = maxHeartbeatsPerMinute;
	}

	public Optional<Short> getKilocalories() {
		return Optional.of(kilocalories);
	}

	public void setKilocalories(short kilocalories) {
		this.kilocalories = kilocalories;
	}

	public Optional<String> getRemark() {
		return Optional.of(remark);
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	// public Track getTrack() {
	// return track;
	// }
	//
	// protected void setTrack(Track track) {
	// this.track = track;
	// }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		// result = prime * result + ((track == null) ? 0 : track.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SportsSession)) {
			return false;
		}
		SportsSession other = (SportsSession) obj;
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (time == null) {
			if (other.time != null) {
				return false;
			}
		} else if (!time.equals(other.time)) {
			return false;
		}
		// if (track == null) {
		// if (other.track != null) {
		// return false;
		// }
		// } else if (!track.equals(other.track)) {
		// return false;
		// }
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		DateFormat dateFormatDate = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat dateFormatTime = new SimpleDateFormat("HH:mm:ss");
		builder.append("SportsSession [date=")
				.append(dateFormatDate.format(date)).append(", time=")
				.append(dateFormatTime.format(time))
				.append(", heartbeatsPerMinute=").append(heartbeatsPerMinute)
				.append(", maxHeartbeatsPerMinute=")
				.append(maxHeartbeatsPerMinute).append(", kilocalories=")
				.append(kilocalories).append(", remark=").append(remark)
		// .append(", track=").append(track).append("]")
		;
		return builder.toString();
	}

}
