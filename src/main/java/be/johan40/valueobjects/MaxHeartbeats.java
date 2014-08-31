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

}
