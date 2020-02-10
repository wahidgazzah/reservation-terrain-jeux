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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prix == null) ? 0 : prix.hashCode());
		result = prime * result + ((reservationTerrainState == null) ? 0 : reservationTerrainState.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationResponseDTO other = (ReservationResponseDTO) obj;
		if (prix == null) {
			if (other.prix != null)
				return false;
		} else if (!prix.equals(other.prix))
			return false;
		if (reservationTerrainState != other.reservationTerrainState)
			return false;
		return true;
	}
	
	
	
}
