package com.demo.reservation.dto.weather;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rss")
public class WeatherDTO {

	private ChannelDTO channel;

	public ChannelDTO getChannel() {
		return channel;
	}

	public void setChannel(ChannelDTO channel) {
		this.channel = channel;
	}
	
}
