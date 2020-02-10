package com.demo.reservation.service;

import org.springframework.transaction.annotation.Transactional;

import com.demo.reservation.dto.ReservationRequestDTO;

public interface IYahooWeatherService {

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	boolean checkPrevisionPluie(ReservationRequestDTO request);
}
