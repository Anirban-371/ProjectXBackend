package com.projectXNeighbour.Settings.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.projectXNeighbour.Settings.QServices;
import com.projectXNeighbour.Settings.Services;
import com.projectXNeighbour.Settings.AdminRepository.NeighbourAdminRepository;
import com.projectXNeighbour.Settings.Request.NeighbourXServiceRequest;
import com.projectXNeighbour.Settings.Response.NeighbourXServiceResponse;
import com.projectXNeighbour.Settings.Service.NeighbourAdminService;
import com.querydsl.core.types.dsl.BooleanExpression;

@EnableMongoRepositories(basePackageClasses = NeighbourAdminRepository.class)
@Service
public class NeighbourAdminServiceImpl implements NeighbourAdminService {

	@Autowired
	private NeighbourAdminRepository adminRepository;
	
	@Override
	public Boolean saveService(NeighbourXServiceRequest service) {
		try {
		adminRepository.save(service.getServices());
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public NeighbourXServiceResponse getService() {
		NeighbourXServiceResponse neighbourXServiceResponse = new NeighbourXServiceResponse();
		List<Services> serviceList = adminRepository.findAll() ;
		neighbourXServiceResponse.setServiceList(serviceList);
		return neighbourXServiceResponse;

	}

	@Override
	public NeighbourXServiceResponse getSearchService(String serviceName) {
		NeighbourXServiceResponse neighbourXServiceResponse = new NeighbourXServiceResponse();
		QServices qServices = new QServices("Services");
		BooleanExpression filterbyname = qServices.name.contains(serviceName);
		List<Services> serviceList = (List<Services>) this.adminRepository.findAll(filterbyname);
		neighbourXServiceResponse.setServiceList(serviceList);
		return neighbourXServiceResponse;
	}
	
}
