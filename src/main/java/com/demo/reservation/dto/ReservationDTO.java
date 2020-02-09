package com.demo.reservation.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Reservation DTO
 * @author wahid
 *
 */
public class ReservationDTO {
	
	private Long id;
	private Date dateReservation;
	private Date dateDebut;
	private Date dateFin;
	private Double facture;
    private TerrainType terrainType;
    private Set<JoueurDTO> joueursList = new HashSet<>();
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
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
	public Double getFacture() {
		return facture;
	}
	public void setFacture(Double facture) {
		this.facture = facture;
	}
	public TerrainType getTerrainType() {
		return terrainType;
	}
	public void setTerrainType(TerrainType terrainType) {
		this.terrainType = terrainType;
	}
	public Set<JoueurDTO> getJoueursList() {
		return joueursList;
	}
	public void setJoueursList(Set<JoueurDTO> joueursList) {
		this.joueursList = joueursList;
	}
	
}
