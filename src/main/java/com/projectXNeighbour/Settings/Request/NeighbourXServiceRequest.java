package com.projectXNeighbour.Settings.Request;

import com.projectXNeighbour.Settings.Services;

public class NeighbourXServiceRequest {
	Services services;

	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "NeighbourXServiceRequest [services=" + services + "]";
	}
	
	
	

}
