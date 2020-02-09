package com.demo.reservation.domain;

import java.util.List;

import com.demo.reservation.dto.ReservationDTO;
import com.demo.reservation.dto.ReservationRequestDTO;
import com.demo.reservation.dto.ReservationResponseDTO;

/**
 * Reservation Domain
 * @author wahid
 *
 */
public interface IReservationDomain {

	ReservationResponseDTO reservation(ReservationRequestDTO dto);

	List<ReservationDTO> getAll();

}
