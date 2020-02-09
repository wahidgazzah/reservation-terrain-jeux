package com.demo.reservation.utilities;

import java.util.ArrayList;
import java.util.List;

import com.demo.reservation.dto.JoueurDTO;
import com.demo.reservation.dto.ReservationDTO;
import com.demo.reservation.entity.JoueurEntity;
import com.demo.reservation.entity.ReservationEntity;

public class ReservationUtility {
	
	/**
	 * ReservationEntity to ReservationDTO mapper
	 * @param entity ReservationEntity
	 * @return ReservationDTO
	 */
	public static ReservationDTO toDTO(ReservationEntity entity) {
		ReservationDTO dto = new ReservationDTO();
		dto.setId(entity.getId());
		dto.setDateReservation(entity.getDateReservation());
		dto.setDateDebut(entity.getDateDebut());
		dto.setDateFin(entity.getDateFin());
		dto.setFacture(entity.getFacture());
		dto.setTerrainType(entity.getTerrainType());
		if(entity.getJoueursList() != null) {
			for(JoueurEntity element : entity.getJoueursList()) {
				dto.getJoueursList().add(JoueurUtility.toDTO(element));
			}
		}
		return dto;
	}

	/**
	 * ReservationDTO to ReservationEntity mapper
	 * @param ReservationDTO 
	 * @param FactureEntity
	 * @param MatchEntity
	 * @return ReservationEntity
	 */
	public static ReservationEntity toEntity(ReservationDTO dto) {
		ReservationEntity entity = new ReservationEntity();
		entity.setId(dto.getId());
		entity.setDateReservation(dto.getDateReservation());
		entity.setDateDebut(dto.getDateDebut());
		entity.setDateFin(dto.getDateFin());
		entity.setFacture(dto.getFacture());
		entity.setTerrainType(dto.getTerrainType());
		if(dto.getJoueursList() != null) {
			for(JoueurDTO element : dto.getJoueursList()) {
				entity.getJoueursList().add(JoueurUtility.toEntity(element));
			}
		}
		return entity;
	}

	/**
	 * mapper
	 * @param list
	 * @return
	 */
	public static List<ReservationDTO> toDTO(List<ReservationEntity> list) {
		
		List<ReservationDTO> result = new ArrayList<>();
		for(ReservationEntity entity : list) {
			result.add(toDTO(entity));
		}
		return result;
	}
}
