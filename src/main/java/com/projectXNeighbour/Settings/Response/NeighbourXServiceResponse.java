package com.projectXNeighbour.Settings.Response;
import java.util.List;

import com.projectXNeighbour.Settings.Services;

public class NeighbourXServiceResponse {
	
	List<Services> serviceList;

	public List<Services> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<Services> serviceList) {
		this.serviceList = serviceList;
	}

	@Override
	public String toString() {
		return "NeighbourXServiceResponse [serviceList=" + serviceList + "]";
	}
	
	
	
}
