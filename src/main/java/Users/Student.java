package Users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int stdId;
	@Column(name="student_Name")
	private String stdName;
	private String email;
	private String password;
	private String contact;
	private String city;
	private String address;
	private int marks;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int stdId, String stdName, String email, String password, String contact, String city,
			String address, int marks) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.city = city;
		this.address = address;
		this.marks = marks;
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
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
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", email=" + email + ", password=" + password
				+ ", contact=" + contact + ", city=" + city + ", address=" + address + ", marks=" + marks + "]";
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
}
