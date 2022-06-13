package fr.m2i.crm.model;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String address;
	
	@Column(length = 100, nullable = false)
	private String city;
	
	@Column(name = "company_name", length = 100, nullable = false)
	private String companyName;
	
	@Column(length = 100, nullable = false)
	private String country;
	
	@Column(length = 100, nullable = false)
	private String email;
	
	@Column(name="first_name", length = 100, nullable = false)
	private String firstName;
	
	@Column(name="last_name", length = 100, nullable = false)
	private String lastName;
	
	@Column(length = 20, nullable = false)
	private String phone;
	
	@Column(name = "zip_code" ,length = 12, nullable = false)
	private String zipCode;
	
	
	
	public Customer() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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
}
