package com.demo.reservation.dto;

import java.util.Set;

/**
 * Joueur DTO
 * @author wahid
 *
 */
public class JoueurDTO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Set<ReservationDTO> reservationsList;
	
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
	public Set<ReservationDTO> getReservationsList() {
		return reservationsList;
	}
	public void setReservationsList(Set<ReservationDTO> reservationsList) {
		this.reservationsList = reservationsList;
	}

	
}
