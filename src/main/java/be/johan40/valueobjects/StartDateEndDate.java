package be.johan40.valueobjects;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class StartDateEndDate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar endDate;
	@Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar startDate;

}
