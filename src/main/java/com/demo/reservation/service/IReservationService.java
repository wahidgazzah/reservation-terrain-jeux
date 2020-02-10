package com.demo.reservation.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.demo.reservation.dto.ReservationDTO;
import com.demo.reservation.dto.ReservationRequestDTO;
import com.demo.reservation.dto.ReservationResponseDTO;

/**
 * Reservation Service
 * @author wahid
 *
 */

public interface IReservationService {
	
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	ReservationResponseDTO reservation(ReservationRequestDTO dto);

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	List<ReservationDTO> getAll();

}
