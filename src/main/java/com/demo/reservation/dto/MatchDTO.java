package com.demo.reservation.dto;

import java.util.Date;
import java.util.Set;

public class MatchDTO {

	private Long id;
	private Date dateDebut;
	private Date dateFin;
	private Double facture;
    private Long terrainId;
	private Set<ReservationDTO> reservationsList;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Long getTerrainId() {
		return terrainId;
	}
	public void setTerrainId(Long terrainId) {
		this.terrainId = terrainId;
	}
	public Set<ReservationDTO> getReservationsList() {
		return reservationsList;
	}
	public void setReservationsList(Set<ReservationDTO> reservationsList) {
		this.reservationsList = reservationsList;
	}
	public Double getFacture() {
		return facture;
	}
	public void setFacture(Double facture) {
		this.facture = facture;
	}
	
}
