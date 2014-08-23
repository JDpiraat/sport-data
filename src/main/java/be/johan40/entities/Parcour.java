package be.johan40.entities;

import java.io.Serializable;

import be.johan40.enums.Activiteit;
import be.johan40.enums.Status;

public class Parcour implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String naam;
	private Activiteit activiteit;	
	private double kilometer;
	private String beschrijving;
	private String opmerking;
	private Status status;
	
}
