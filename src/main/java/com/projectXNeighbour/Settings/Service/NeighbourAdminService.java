package com.projectXNeighbour.Settings.Service;


import com.projectXNeighbour.Settings.Request.NeighbourXServiceRequest;
import com.projectXNeighbour.Settings.Response.NeighbourXServiceResponse;

public interface NeighbourAdminService {
	public Boolean saveService(NeighbourXServiceRequest service);
	public NeighbourXServiceResponse getService();
	public NeighbourXServiceResponse getSearchService(String serviceName);
	
}
