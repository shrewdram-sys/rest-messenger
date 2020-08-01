package src.main.java.com.demo.food.delivery.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="deliveryinfo")
public class DeliveryInfo {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="deliveryid")
	private int deliveryid;
	
	@Column(name="userid")
	private String userid;
	
	@Column(name="firstname")
    private String firstname;
	
	@Column(name="lastname")
    private String lastname;
	
	@Column(name="phonenumber")
    private String phonenumber;
	
	@OneToMany(targetEntity=Address.class, cascade=CascadeType.ALL)
	@JoinColumn(name="add_fk", referencedColumnName="deliveryid")
	private List<Address> address;
	
	public DeliveryInfo() {

	}

	public DeliveryInfo(int deliveryid, String userid, String firstname, String lastname, String phonenumber,
			List<Address> address) {
		this.deliveryid = deliveryid;
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
		this.address = address;
	}

	public int getDeliveryid() {
		return deliveryid;
	}

	public void setDeliveryid(int deliveryid) {
		this.deliveryid = deliveryid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "DeliveryInfo [deliveryid=" + deliveryid + ", userid=" + userid + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", phonenumber=" + phonenumber + ", address=" + address + "]";
	}

}