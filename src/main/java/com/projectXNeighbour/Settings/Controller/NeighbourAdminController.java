package com.projectXNeighbour.Settings.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectXNeighbour.Settings.Service.NeighbourAdminService;
import com.projectXNeighbour.Settings.Services;
import com.projectXNeighbour.Settings.Request.NeighbourXServiceRequest;
import com.projectXNeighbour.Settings.Response.NeighbourXServiceResponse;

@RestController
public class NeighbourAdminController {
	
	@Autowired
	NeighbourAdminService  adminService;
	
	@RequestMapping(method= RequestMethod.POST, value="/saveservice")
	public @ResponseBody Boolean saveService(@RequestBody NeighbourXServiceRequest serviceObj) {
		System.out.println("Inside saveService ::"+ serviceObj);
		return adminService.saveService(serviceObj);
	}
	@RequestMapping(method= RequestMethod.GET, value="/getservice")
	public @ResponseBody NeighbourXServiceResponse getService() {
		System.out.println("Inside getService ::");
		return adminService.getService();
	}
	@RequestMapping(method= RequestMethod.POST, value="/getsearchservice")
	public @ResponseBody NeighbourXServiceResponse getSearchService(@RequestParam("serviceName") String serviceName) {
		System.out.println("Inside getSearchService ::"+serviceName);
		return adminService.getSearchService(serviceName);
	}
}
