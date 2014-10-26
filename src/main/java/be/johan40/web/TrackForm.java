package be.johan40.web;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import be.johan40.enums.Activity;
import be.johan40.enums.Status;

class TrackForm {	

	@NotBlank
	private String name;
	private Activity activity;
	@NotNull
	@Max(1000)
	@Min(0)
	@Digits(integer = 3, fraction = 1)
	private double kilometer;
	@NotBlank
	private String description;
	private String remark;
	private Status status;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public double getKilometer() {
		return kilometer;
	}

	public void setKilometer(double kilometer) {
		this.kilometer = kilometer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}