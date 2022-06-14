package fr.m2i.crm.model;

import fr.m2i.crm.state.CustomerState;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city", length = 100)
	private String city;
	
	@Column(name = "company_name", length = 100)
	private String companyName;
	
	@Column(name = "country", length = 100)
	private String country;
	
	@Column(name = "email", length = 100)
	private String email;
	
	@Column(name="first_name", length = 100)
	private String firstName;
	
	@Column(name="last_name", length = 100)
	private String lastName;
	
	@Column(name = "phone", length = 20)
	private String phone;
	
	@Column(name = "zip_code" ,length = 12)
	private String zipCode;
	
	@Column(name="state")
	@ColumnDefault("0")
	@Enumerated(EnumType.ORDINAL)
	private CustomerState state;
	
	
	
	public Customer() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public CustomerState getState() {
		return state;
	}
	
	public void setState(CustomerState state) {
		this.state = state;
	}
	
	public void setNotNullData (Customer newCostumer) {
		if (newCostumer.address != null) {
			this.setAddress(newCostumer.getAddress());
		}
		if (newCostumer.city != null) {
			this.setCity(newCostumer.getCity());
		}
		if (newCostumer.companyName != null) {
			this.setCompanyName(newCostumer.getCompanyName());
		}
		if (newCostumer.country != null) {
			this.setCountry(newCostumer.getCountry());
		}
		if (newCostumer.email != null) {
			this.setEmail(newCostumer.getEmail());
		}
		if (newCostumer.firstName != null) {
			this.setFirstName(newCostumer.getFirstName());
		}
		if (newCostumer.lastName != null) {
			this.setLastName(newCostumer.getLastName());
		}
		if (newCostumer.phone != null) {
			this.setPhone(newCostumer.getPhone());
		}
		if (newCostumer.zipCode != null) {
			this.setZipCode(newCostumer.getZipCode());
		}
		if (newCostumer.state != null) {
			this.setState(newCostumer.getState());
		}
	}
}
