package be.johan40.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class LengthInMeters implements Serializable {

	private static final long serialVersionUID = 1L;

	@Embedded
	private StartDateEndDate startDateEndDate;
	private double lengthInMeters;
	
	protected LengthInMeters() {
	}

	public LengthInMeters(StartDateEndDate startDateEndDate,
			double lengthInMeters) {
		this.startDateEndDate = startDateEndDate;
		this.lengthInMeters = lengthInMeters;
	}

	public StartDateEndDate getStartDateEndDate() {
		return startDateEndDate;
	}

	public void setStartDateEndDate(StartDateEndDate startDateEndDate) {
		this.startDateEndDate = startDateEndDate;
	}

	public double getLengthInMeters() {
		return lengthInMeters;
	}

	public void setLengthInMeters(double lengthInMeters) {
		this.lengthInMeters = lengthInMeters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lengthInMeters);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (!(obj instanceof LengthInMeters)) {
			return false;
		}
		LengthInMeters other = (LengthInMeters) obj;
		if (Double.doubleToLongBits(lengthInMeters) != Double
				.doubleToLongBits(other.lengthInMeters)) {
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
		return "LengthInMeters [startDateEndDate=" + startDateEndDate
				+ ", lengthInMeters=" + lengthInMeters + "]";
	}

}
