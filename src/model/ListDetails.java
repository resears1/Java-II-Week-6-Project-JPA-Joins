package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="CREATION_DATE")
	private LocalDate creationDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="DISTRICT_ID")
	private District district;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(name="pets_on_list", joinColumns={ @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID")}, inverseJoinColumns= { @JoinColumn(name="PET_ID", referencedColumnName="ID", unique=true)})
	private List<ListPet> listOfPets;
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, LocalDate creationDate, District district, List<ListPet> listOfPets) {
		super();
		this.id = id;
		this.listName = listName;
		this.creationDate = creationDate;
		this.district = district;
		this.listOfPets = listOfPets;
	}
	
	public ListDetails(String listName, LocalDate creationDate, District district, List<ListPet> listOfPets) {
		super();
		this.listName = listName;
		this.creationDate = creationDate;
		this.district = district;
		this.listOfPets = listOfPets;
	}
	
	public ListDetails(String listName, LocalDate creationDate, District district) {
		super();
		this.listName = listName;
		this.creationDate = creationDate;
		this.district = district;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public List<ListPet> getListOfPets() {
		return listOfPets;
	}
	public void setListOfPets(List<ListPet> listOfPets) {
		this.listOfPets = listOfPets;
	}
	
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", creationDate=" + creationDate + ", district="
				+ district + ", listOfPets=" + listOfPets + "]";
	}
}
