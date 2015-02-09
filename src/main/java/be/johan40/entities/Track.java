package be.johan40.entities;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import be.johan40.enums.Activity;
import be.johan40.enums.Status;

@Entity
@Table(name = "track")
public class Track implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Activity activity;
	private double kilometer;
	private String description;
	@Access(AccessType.FIELD)
	private String remark;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Status status;

	public Track() {
	}
	
	//TODO builder pattern(?)
	public Track(String name, Activity activity, double kilometer,
			String description, Status status) {
		this.name = name;
		this.activity = activity;
		this.kilometer = kilometer;
		this.description = description;		
		this.status = status;
	}
	
	public Track(String name, Activity activity, double kilometer,
			String description, String remark, Status status) {
		this.name = name;
		this.activity = activity;
		this.kilometer = kilometer;
		this.description = description;
		this.remark = remark;
		this.status = status;
	}

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

	public Optional<String> getRemark() {
		return Optional.of(remark);
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

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activity == null) ? 0 : activity.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(kilometer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Track)) {
			return false;
		}
		Track other = (Track) obj;
		if (activity != other.activity) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (Double.doubleToLongBits(kilometer) != Double
				.doubleToLongBits(other.kilometer)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (remark == null) {
			if (other.remark != null) {
				return false;
			}
		} else if (!remark.equals(other.remark)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Track [id=").append(id).append(", name=").append(name)
				.append(", activity=").append(activity).append(", kilometer=")
				.append(kilometer).append(", description=").append(description)
				.append(", remark=").append(remark).append(", status=")
				.append(status).append("]");
		return builder.toString();
	}

}
