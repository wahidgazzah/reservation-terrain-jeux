package com.demo.reservation.dto.weather;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ItemDTO {

	@XmlElement(name = "forecast", namespace = "http://xml.weather.yahoo.com/ns/rss/1.0")
	private List<ForecastDTO> forecasts;

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ForecastDTO> getForecasts() {
		return forecasts;
	}

	public void setForecasts(List<ForecastDTO> forecasts) {
		this.forecasts = forecasts;
	}
}
