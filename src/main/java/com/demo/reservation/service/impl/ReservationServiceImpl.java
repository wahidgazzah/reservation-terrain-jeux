package com.demo.reservation.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.reservation.domain.IReservationDomain;
import com.demo.reservation.dto.ReservationDTO;
import com.demo.reservation.dto.ReservationRequestDTO;
import com.demo.reservation.dto.ReservationResponseDTO;
import com.demo.reservation.service.IReservationService;

/**
 * Implementation of {@link IReservationService}
 * @author wahid
 *
 */
@Service
public class ReservationServiceImpl implements IReservationService{

	private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	private IReservationDomain reservationDomain;
	
	@Override
	public ReservationResponseDTO reservation(ReservationRequestDTO dto) {
		
		logger.info("Delegating request to Domain layer.");
		
		return reservationDomain.reservation(dto);
	}

	@Override
	public List<ReservationDTO> getAll() {
		
		logger.info("Delegating request to Domain layer.");
		
		return reservationDomain.getAll();
	}
}
