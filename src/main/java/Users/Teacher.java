package Users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {

	@Id
	private int tId;
	@Column(name="teacher_Name")
	private String tName;
	private String email;
	private String password;
	private String contact;
	private String city;
	private String address;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int tId, String tName, String email, String password, String contact, String city, String address) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.city = city;
		this.address = address;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Teacher [tId=" + tId + ", tName=" + tName + ", email=" + email + ", password=" + password + ", contact="
				+ contact + ", city=" + city + ", address=" + address + "]";
	}
}
