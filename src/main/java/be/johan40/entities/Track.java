package be.johan40.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.transaction.annotation.Transactional;

import be.johan40.enums.Activiteit;
import be.johan40.enums.Status;

@Entity(name = "track")
@Transactional(readOnly = true)
public class Track implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private Activiteit activity;
	private double kilometer;
	private String description;
	private String remark;
	private Status status;
	private List<Sportsman> sportmen;

}
