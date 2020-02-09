package com.demo.reservation.service;

import java.util.List;

import com.demo.reservation.dto.ReservationDTO;
import com.demo.reservation.dto.ReservationRequestDTO;
import com.demo.reservation.dto.ReservationResponseDTO;

/**
 * Reservation Service
 * @author wahid
 *
 */
public interface IReservationService {
	
	ReservationResponseDTO reservation(ReservationRequestDTO dto);

	List<ReservationDTO> getAll();

}
