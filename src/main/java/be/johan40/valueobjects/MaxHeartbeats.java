package be.johan40.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class MaxHeartbeats implements Serializable {

	private static final long serialVersionUID = 1L;

	@Embedded
	private StartDateEndDate startDateEndDate;
	private short maxHeartbeats;

	protected MaxHeartbeats() {
	}

	public MaxHeartbeats(StartDateEndDate startDateEndDate, short maxHeartbeats) {
		this.startDateEndDate = startDateEndDate;
		this.maxHeartbeats = maxHeartbeats;
	}

	public StartDateEndDate getStartDateEndDate() {
		return startDateEndDate;
	}

	public void setStartDateEndDate(StartDateEndDate startDateEndDate) {
		this.startDateEndDate = startDateEndDate;
	}

	public short getMaxHeartbeats() {
		return maxHeartbeats;
	}

	public void setMaxHeartbeats(short maxHeartbeats) {
		this.maxHeartbeats = maxHeartbeats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maxHeartbeats;
		result = prime
				* result
				+ ((startDateEndDate == null) ? 0 : startDateEndDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MaxHeartbeats)) {
			return false;
		}
		MaxHeartbeats other = (MaxHeartbeats) obj;
		if (maxHeartbeats != other.maxHeartbeats) {
			return false;
		}
		if (startDateEndDate == null) {
			if (other.startDateEndDate != null) {
				return false;
			}
		} else if (!startDateEndDate.equals(other.startDateEndDate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "MaxHeartbeats [startDateEndDate=" + startDateEndDate
				+ ", maxHeartbeats=" + maxHeartbeats + "]";
	}

}
