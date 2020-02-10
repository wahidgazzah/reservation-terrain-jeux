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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((idsJoueurs == null) ? 0 : idsJoueurs.hashCode());
		result = prime * result + ((terrainType == null) ? 0 : terrainType.hashCode());
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
		ReservationRequestDTO other = (ReservationRequestDTO) obj;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (idsJoueurs == null) {
			if (other.idsJoueurs != null)
				return false;
		} else if (!idsJoueurs.equals(other.idsJoueurs))
			return false;
		if (terrainType != other.terrainType)
			return false;
		return true;
	}
	
	
    
}
