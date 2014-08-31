package be.johan40.valueobjects;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class StartDateEndDate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
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

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

}
