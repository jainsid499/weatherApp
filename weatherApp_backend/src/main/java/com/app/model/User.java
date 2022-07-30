package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="userregister")
public class User {
	
	private String  name;
	@Id
	private String   userId;
	private String   email;
	private String  phone;
	private String  password;
	private String  cpassword;
	private String  gender;

	@ManyToMany
	private List<city>  cities;

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", userId='" + userId + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", password='" + password + '\'' +
				", cpassword='" + cpassword + '\'' +
				", gender='" + gender + '\'' +
				", cities=" + cities +
				'}';
	}
}
