package com.demo.reservation.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.reservation.dto.ReservationRequestDTO;
import com.demo.reservation.service.IYahooWeatherService;

@Service
public class YahooWeatherServiceImpl implements IYahooWeatherService{
	
	//woeid paris
	private final static String woeid = "FRXX0077";

	private static final Logger logger = LoggerFactory.getLogger(YahooWeatherServiceImpl.class);

	@Override
	public boolean checkPrevisionPluie(ReservationRequestDTO request) {
		// TODO call a Yahoo Weather service
		return false;
	}
}
