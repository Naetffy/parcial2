package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "email", nullable=false, unique=true)
    private String email;

    @Column(name = "password", nullable=false)
    private String password;
	@Column(name = "roles", nullable=false)
	private List<UserRole> userRoles;

    public User(String email, String password, List<UserRole> userRoles) {
		this.email = email;
		this.password = password;
		this.userRoles = userRoles;
	}

	public User() {
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

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}