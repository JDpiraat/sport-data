package be.johan40.entities;

import java.io.Serializable;
import java.util.List;

import be.johan40.enums.Activiteit;
import be.johan40.enums.Status;

public class Track implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private Activiteit activity;
	private double kilometer;
	private String description;
	private String remark;
	private Status status;
	private List<Sportsman> sportmen;

}
