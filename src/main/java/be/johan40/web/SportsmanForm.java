package be.johan40.web;

import java.util.Calendar;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

class SportsmanForm {

	@NotBlank
	private String firstname;
	@NotBlank
	private String lastname;
	@NotBlank
	@Past
	private Calendar birthday;
	@NotBlank
	private short weightinkg;
	@NotBlank
	@Max(3)
	@Min(0)
	@Digits(integer = 1, fraction = 2)
	private double lengthinmeters;

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

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public short getWeightinkg() {
		return weightinkg;
	}

	public void setWeightinkg(short weightinkg) {
		this.weightinkg = weightinkg;
	}

	public double getLengthinmeters() {
		return lengthinmeters;
	}

	public void setLengthinmeters(double lengthinmeters) {
		this.lengthinmeters = lengthinmeters;
	}

}
