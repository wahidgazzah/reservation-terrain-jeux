package com.demo.reservation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.reservation.dto.ReservationDTO;
import com.demo.reservation.dto.ReservationRequestDTO;
import com.demo.reservation.dto.ReservationResponseDTO;
import com.demo.reservation.dto.weather.WeatherDTO;
import com.demo.reservation.service.IReservationService;
import com.demo.reservation.service.IYahooWeatherService;

import io.swagger.annotations.Api;

/**
 * Reservation Rest Controller
 * @author wahid
 *
 */
@RestController
@RequestMapping("/reservation")
@Api(value = "ReservationController")
public class ReservationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private IReservationService reservationService;
	
	@Autowired
	private IYahooWeatherService yahooWeatherService;

	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	public ReservationResponseDTO reservation(@RequestBody ReservationRequestDTO dto) {
		
		logger.info("Delegating request to Service layer.");
		
		return reservationService.reservation(dto);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<ReservationDTO> getAll() {
		  
		logger.info("Delegating request id to service layer.");
		
		return reservationService.getAll();
	}
	
	@RequestMapping(value = "/weather", method = RequestMethod.GET, produces = "application/json")
	public WeatherDTO findWeather() {
		
		return yahooWeatherService.findWeather();
	}
}
