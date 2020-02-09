package com.demo.reservation.dto;

import java.util.ArrayList;
import java.util.Date;

public class ReservationRequestDTO {

    private ArrayList<Long> idsJoueurs;
    private Date dateDebut;
    private Date dateFin;
    private TerrainType terrainType;
    
	public ArrayList<Long> getIdsJoueurs() {
		return idsJoueurs;
	}
	public void setIdsJoueurs(ArrayList<Long> idsJoueurs) {
		this.idsJoueurs = idsJoueurs;
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
	public TerrainType getTerrainType() {
		return terrainType;
	}
	public void setTerrainType(TerrainType terrainType) {
		this.terrainType = terrainType;
	}
    
}
