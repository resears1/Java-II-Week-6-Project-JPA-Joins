package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="district")
public class District {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DISTRICT_ID")
	private int id;
	@Column(name="DISTRICT_NAME")
	private String districtName;
	
	public District() {
		super();
	}
	
	public District(int id, String districtName) {
		super();
		this.id = id;
		this.districtName = districtName;
	}
	
	public District(String districtName) {
		super();
		this.districtName = districtName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	@Override
	public String toString() {
		return "District [id=" + id + ", districtName=" + districtName + "]";
	}
}
