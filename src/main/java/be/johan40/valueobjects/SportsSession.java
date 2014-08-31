package be.johan40.valueobjects;

import java.io.Serializable;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
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
	@Column(nullable = false)
	private Calendar date;
	@Column(nullable = false)
	private Time time;
	private short heartbeatsPerMinute;
	private short maxHeartbeatsPerMinute;
	private short kilocalories;
	private String remark;
	@ManyToOne
	@JoinColumn(name = "trackId")
	@Column(nullable = false)
	private Track track;

	protected SportsSession() {
	}

	public SportsSession(Calendar date, Time time, Track track) {
		this.date = date;
		this.time = time;
		this.track = track;
	}

	public SportsSession(Calendar date, Time time, short heartbeatsPerMinute,
			short maxHeartbeatsPerMinute, short kilocalories, String remark,
			Track track) {
		this.date = date;
		this.time = time;
		this.heartbeatsPerMinute = heartbeatsPerMinute;
		this.maxHeartbeatsPerMinute = maxHeartbeatsPerMinute;
		this.kilocalories = kilocalories;
		this.remark = remark;
		this.track = track;
	}

	public Calendar getDate() {
		return date;
	}

	protected void setDate(Calendar date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	protected void setTime(Time time) {
		this.time = time;
	}

	public short getHeartbeatsPerMinute() {
		return heartbeatsPerMinute;
	}

	public void setHeartbeatsPerMinute(short heartbeatsPerMinute) {
		this.heartbeatsPerMinute = heartbeatsPerMinute;
	}

	public short getMaxHeartbeatsPerMinute() {
		return maxHeartbeatsPerMinute;
	}

	public void setMaxHeartbeatsPerMinute(short maxHeartbeatsPerMinute) {
		this.maxHeartbeatsPerMinute = maxHeartbeatsPerMinute;
	}

	public short getKilocalories() {
		return kilocalories;
	}

	public void setKilocalories(short kilocalories) {
		this.kilocalories = kilocalories;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Track getTrack() {
		return track;
	}

	protected void setTrack(Track track) {
		this.track = track;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((track == null) ? 0 : track.hashCode());
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
		if (track == null) {
			if (other.track != null) {
				return false;
			}
		} else if (!track.equals(other.track)) {
			return false;
		}
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
				.append(", track=").append(track).append("]");
		return builder.toString();
	}

}
