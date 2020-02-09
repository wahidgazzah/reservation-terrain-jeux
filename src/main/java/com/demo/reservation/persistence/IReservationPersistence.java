package com.demo.reservation.persistence;

import java.util.List;

import com.demo.reservation.dto.ReservationDTO;
import com.demo.reservation.dto.ReservationRequestDTO;
import com.demo.reservation.entity.ReservationEntity;

/**
 * Reservation persistence Interface
 * @author wahid
 *
 */
public interface IReservationPersistence {

	Long create(ReservationDTO dto);

	List<ReservationDTO> getAll();
	
	List<ReservationEntity> checkDisponibilite (ReservationRequestDTO request);
}
