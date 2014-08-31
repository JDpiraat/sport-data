package be.johan40.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class WeightInKg implements Serializable {

	private static final long serialVersionUID = 1L;

	@Embedded
	private StartDateEndDate startDateEndDate;
	private double weightInKilogram;

	protected WeightInKg() {
	}

	public WeightInKg(StartDateEndDate startDateEndDate, double weightInKilogram) {
		this.startDateEndDate = startDateEndDate;
		this.weightInKilogram = weightInKilogram;
	}

	public StartDateEndDate getStartDateEndDate() {
		return startDateEndDate;
	}

	public void setStartDateEndDate(StartDateEndDate startDateEndDate) {
		this.startDateEndDate = startDateEndDate;
	}

	public double getWeightInKilogram() {
		return weightInKilogram;
	}

	public void setWeightInKilogram(double weightInKilogram) {
		this.weightInKilogram = weightInKilogram;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((startDateEndDate == null) ? 0 : startDateEndDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weightInKilogram);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof WeightInKg)) {
			return false;
		}
		WeightInKg other = (WeightInKg) obj;
		if (startDateEndDate == null) {
			if (other.startDateEndDate != null) {
				return false;
			}
		} else if (!startDateEndDate.equals(other.startDateEndDate)) {
			return false;
		}
		if (Double.doubleToLongBits(weightInKilogram) != Double
				.doubleToLongBits(other.weightInKilogram)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "WeightInKg [startDateEndDate=" + startDateEndDate
				+ ", weightInKilogram=" + weightInKilogram + "]";
	}

}
