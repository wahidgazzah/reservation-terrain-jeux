package com.demo.reservation.dto;

public class ReservationResponseDTO {

	private ReservationTerrainState reservationTerrainState;
	private Double prix;
	
	public ReservationTerrainState getReservationTerrainState() {
		return reservationTerrainState;
	}
	public void setReservationTerrainState(ReservationTerrainState reservationTerrainState) {
		this.reservationTerrainState = reservationTerrainState;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	
}
