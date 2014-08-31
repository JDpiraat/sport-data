package be.johan40.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import be.johan40.entities.Track;

@Embeddable
public class SportsmanTrack implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "trackId")
	private Track track;
	private boolean trackOwner;

}
