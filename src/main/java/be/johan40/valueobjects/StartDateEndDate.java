package be.johan40.valueobjects;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Embeddable;

@Embeddable
public class StartDateEndDate implements Serializable {

	private static final long serialVersionUID = 1L;

	private GregorianCalendar endDate;
	private GregorianCalendar startDate;

}
