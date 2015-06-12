package com.wolf.restws.dto;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TransMap {
	private Map<String, User> map;

	public Map<String, User> getMap() {
		return map;
	}

	public void setMap(Map<String, User> map) {
		this.map = map;
	}

}
