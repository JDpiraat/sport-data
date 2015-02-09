package be.johan40.valueobjects;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class StartDateEndDate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private LocalDate startDate;	
	@Access(AccessType.FIELD)
	private LocalDate endDate;	

	protected StartDateEndDate() {
	}

	/**
	 * creates the current timeslice until endDate is set
	 * 
	 * @param startDate 
	 */
	public StartDateEndDate(LocalDate startDate) {
		this.startDate = startDate;		
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	protected void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Optional<LocalDate> getEndDate() {
		return Optional.of(endDate);
	}

	/**
	 * makes this timeslice not the current one, if endDate is set 
	 * you should create a new timeslice to have a current timeslice
	 * 
	 * @param endDate
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}	

	/**
	 * 
	 * @return true if endDate is null (then this is the current timeslice)
	 */
	@Transient
	public boolean isCurrent() {
		return endDate == null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof StartDateEndDate)) {
			return false;
		}
		StartDateEndDate other = (StartDateEndDate) obj;
		if (startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!startDate.equals(other.startDate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		DateFormat dateFormatDateTime = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		builder.append("StartDateEndDate [startDate=")
				.append(dateFormatDateTime.format(startDate))
				.append(", endDate=")
				.append(dateFormatDateTime.format(endDate))
				.append("]");
		return builder.toString();
	}

}
