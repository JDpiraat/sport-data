package be.johan40.valueobjects;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class StartDateEndDate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Calendar startDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar endDate;
	private boolean current;

	protected StartDateEndDate() {
	}

	public StartDateEndDate(Calendar startDate) {
		this.startDate = startDate;
		current = true;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	protected void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
		current = false;
	}

	public boolean isCurrent() {
		return current;
	}

	protected void setCurrent(boolean current) {
		this.current = current;
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
				.append(", current=").append(current).append("]");
		return builder.toString();
	}

}
