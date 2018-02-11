 package com.websystique.springmvc.model;

//Repository user data
import java.math.BigInteger;
import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER")
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private Integer id_user;

	
	
	@NotEmpty
	@Column(name="firstname", nullable=false)
	private String firstname;

	@NotEmpty
	@Column(name="lastname", nullable=false)
	private String lastname;

	@NotEmpty
	@Column(name="email", unique=true,nullable=false)
	private String email;
	
	@NotEmpty
	@Column(name="birth_day", nullable=false)
	private String birth_day;
	
	@NotEmpty
	@Column(name="city", nullable=false)
	private String city;
	
	@NotEmpty
	@Column(name="pw", nullable=false)
	private String pw;

	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(name="photo", nullable=false)
	private byte[] photo;
	
	@Column(name="exponent_public")
	private String exponent_public;
	
	@Column(name="modulus_public")
	private String modulus_public;
	

	@Column(name="iv")
	private String iv;
	
	@Column(name="salt")
	private String salt;
	

	public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv=iv;
	} 
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name="private_key")
	private String private_key;
	
	
	public String getExponent_public() {
		return exponent_public;
	}

	public void setExponent_public(String exponent_public) {
		this.exponent_public = exponent_public;
	}

	public String getModulus_public() {
		return modulus_public;
	}

	public void setModulus_public(String modulus_public) {
		this.modulus_public = modulus_public;
	}

	public String getPrivate_key() {
		return private_key;
	}

	public void setPrivate_key(String private_key) {
		this.private_key = private_key;
	}

	public User(){}
	
	public Integer getId() {
		return id_user;
	}

	public void setId(Integer id) {
		this.id_user = id;
	}

	

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirth_day(String bd){
		this.birth_day=bd;
	}
	
	public String getBirth_day(){
		return birth_day;
	}
	
	public void setCity(String city){
		this.city=city;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setPw(String pw){
		this.pw=pw;
	}
	
	public String getPw(){
		return pw;
	}
	
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo=photo;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_user == null) ? 0 : id_user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id_user == null) {
			if (other.id_user != null)
				return false;
		} else if (!id_user.equals(other.id_user))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", birth_day=" + birth_day + ", city=" + city + ", pw=" + pw + ", photo=" + Arrays.toString(photo)
				+ ", exponent_public=" + exponent_public + ", modulus_public=" + modulus_public + ", private_key="
				+ private_key + "]";
	}

	
	
	
}
