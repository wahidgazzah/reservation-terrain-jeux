package com.demo.reservation.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.demo.reservation.dto.TerrainType;
import com.demo.reservation.utilities.IConstante;

/**
 * Reservation Entity
 * @author wahid
 *
 */
@Entity
@Table(name = IConstante.TABLE_RESERVATION)
public class ReservationEntity implements Serializable{
	
	private static final long serialVersionUID = 5037461844972995493L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RESERVATION_ID")
	private Long id;
	
	@ManyToMany(mappedBy="reservationsList")
	private Set<JoueurEntity> joueursList = new HashSet<>();
    
	@Column(name = "DATE_RESERVATION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateReservation;
    
	@Column(name = "DATE_DEBUT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebut;
	
	@Column(name = "DATE_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;
	
	@Column(name = "FACTURE")
	private Double facture;
	
	@Enumerated(EnumType.STRING)
    private TerrainType terrainType;

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

	public Set<JoueurEntity> getJoueursList() {
		return joueursList;
	}

	public void setJoueursList(Set<JoueurEntity> joueursList) {
		this.joueursList = joueursList;
	}
	
}
