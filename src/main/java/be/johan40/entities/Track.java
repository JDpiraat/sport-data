package be.johan40.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import be.johan40.enums.Activity;
import be.johan40.enums.Status;
import be.johan40.valueobjects.SportsmanTrack;

@Entity
@Table(name = "track")
public class Track implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Activity activity;
	private double kilometer;
	private String description;
	private String remark;
	@Enumerated(EnumType.STRING)
	private Status status;
//	@ElementCollection
//	@CollectionTable(name = "sportsmantrack", joinColumns = @JoinColumn(name = "trackId"))
//	@OrderBy("sportsman.lastName desc")
//	private Set<SportsmanTrack> sportsmanTracks;

}
