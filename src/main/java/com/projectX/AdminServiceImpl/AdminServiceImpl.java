package com.projectX.AdminServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.projectX.Admin.AdminAssets;
import com.projectX.AdminRepository.AdminRepository;
import com.projectX.AdminService.AdminService;

@EnableMongoRepositories(basePackageClasses = AdminRepository.class)
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public boolean addAdminAssets (AdminAssets adminAssets) {
		try {
			System.out.println(adminAssets);
			if(adminAssets.getId() == null)
				adminRepository.insert(adminAssets);
			else
				adminRepository.save(adminAssets);
			System.out.println("inserted data");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public List<AdminAssets> getAdminAssets() {
		try {
			List<AdminAssets> adminAssets =new ArrayList<>();
			adminRepository.findAll().forEach(adminAssets :: add);
			return adminAssets;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<AdminAssets> getSpecificAdminAssets(String assetType) {
		try {
			System.out.println("Inside get Owner Ids Impl::");
			List<AdminAssets> assetList = (List<AdminAssets>) this.adminRepository.findSpecificAdminAssets(assetType);
			System.out.println(assetList);		
			return assetList;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Boolean deleteAsset(String assetId) {
		try {
			//assetId = assetId.
			if(assetId != null) {
				System.out.println(assetId);
				this.adminRepository.deleteById(assetId);
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<AdminAssets> getAsset(String zoneId, String category) {
		List<AdminAssets> adminAssetsList =this.adminRepository.getAssetByZone(zoneId, category, 1);
		if(adminAssetsList.size()>0) {
			return adminAssetsList;
		}
		return null;
	}
	
}
