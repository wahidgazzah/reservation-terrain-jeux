package com.demo.reservation.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.reservation.dto.weather.WeatherDTO;
import com.demo.reservation.service.IYahooWeatherService;

@Service
public class YahooWeatherServiceImpl implements IYahooWeatherService{
	
	//woeid paris
	private final static String woeid = "FRXX0077";

	private static final Logger logger = LoggerFactory.getLogger(YahooWeatherServiceImpl.class);
	
	public WeatherDTO findWeather() {
		logger.info("retrieve current data from Yahoo Weather Service");
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("https://weather-ydn-yql.media.yahoo.com/forecastrss?w=" + woeid + "&u=c", WeatherDTO.class);
	}
}
