package com.demo.reservation.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.demo.reservation.utilities.IConstante;

/**
 * Joueur Entity
 * @author wahid
 *
 */
@Entity
@Table(name = IConstante.TABLE_JOUEUR)
public class JoueurEntity implements Serializable{
	
	private static final long serialVersionUID = -5782419191028551221L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "JOUEUR_ID")
	private Long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@ManyToMany
	@JoinTable(name = "JOUEUR_RESERVATION",
		joinColumns = { @JoinColumn(name = "JOUEUR_ID") },
		inverseJoinColumns = { @JoinColumn(name = "RESERVATION_ID") })
	private Set<ReservationEntity> reservationsList = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<ReservationEntity> getReservationsList() {
		return reservationsList;
	}

	public void setReservationsList(Set<ReservationEntity> reservationsList) {
		this.reservationsList = reservationsList;
	}
	
	
}
