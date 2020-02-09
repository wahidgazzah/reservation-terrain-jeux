package com.demo.reservation.utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.demo.reservation.dto.JoueurDTO;
import com.demo.reservation.dto.ReservationDTO;
import com.demo.reservation.entity.JoueurEntity;
import com.demo.reservation.entity.ReservationEntity;

/**
 * Joueur Utility
 * @author wahid
 *
 */
public class JoueurUtility {

	/**
	 * JoueurEntity to JoueurDTO mapper
	 * @param entity JoueurEntity
	 * @return JoueurDTO
	 */
	public static JoueurDTO toDTO(JoueurEntity entity) {
		JoueurDTO dto = new JoueurDTO();
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setPhoneNumber(entity.getPhoneNumber());
		if(entity.getReservationsList() != null) {
//			Set<ReservationDTO> reservations = new HashSet<>();
			for(ReservationEntity reservationEntity : entity.getReservationsList()) {
//				reservations.add(ReservationUtility.toDTO(reservationEntity));
//				dto.getReservationsList().add(ReservationUtility.toDTO(reservationEntity));
			}
//			dto.setReservationsList(ReservationUtility.toDTO(entity.getReservationsList()));
		}
		return dto;
	}

	/**
	 * JoueurDTO to JoueurEntity mapper
	 * @param dto JoueurDTO
	 * @return JoueurEntity
	 */
	public static JoueurEntity toEntity(JoueurDTO dto) {
		JoueurEntity entity = new JoueurEntity();
		entity.setId(dto.getId());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setPhoneNumber(dto.getPhoneNumber());
		if(dto.getReservationsList() != null) {
			Set<ReservationEntity> reservations = new HashSet<>();
			for(ReservationDTO reservationDTO : dto.getReservationsList()) {
				reservations.add(ReservationUtility.toEntity(reservationDTO));
			}
			entity.setReservationsList(reservations);
		}
		return entity;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public static List<JoueurDTO> toDTO(List<JoueurEntity> list) {
		
		List<JoueurDTO> result = new ArrayList<>();
		for(JoueurEntity entity : list) {
			result.add(toDTO(entity));
		}
		return result;
	}
	
}
