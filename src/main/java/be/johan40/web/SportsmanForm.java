package be.johan40.web;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

class SportsmanForm {

	@NotBlank
	private String firstname;
	@NotBlank
	private String lastname;
	// @NotNull
	// @Past
	private Date birthday;
	@NotNull
	@Max(300)
	@Min(0)
	@Digits(integer = 3, fraction = 1)
	private double weightinkg;
	@NotNull
	@Max(3)
	@Min(0)
	@Digits(integer = 1, fraction = 2)
	private double lengthinmeters;
//	@Max(300)
//	@Min(0)
//	@Digits(integer = 1, fraction = 0)
//	private short maxHearbeats;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public double getWeightinkg() {
		return weightinkg;
	}

	public void setWeightinkg(double weightinkg) {
		this.weightinkg = weightinkg;
	}

	public double getLengthinmeters() {
		return lengthinmeters;
	}

	public void setLengthinmeters(double lengthinmeters) {
		this.lengthinmeters = lengthinmeters;
	}

//	public short getMaxHearbeats() {
//		return maxHearbeats;
//	}
//
//	public void setMaxHearbeats(short maxHearbeats) {
//		this.maxHearbeats = maxHearbeats;
//	}
}
