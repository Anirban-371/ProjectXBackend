package com.projectX.AdminService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectX.Admin.AdminAssets;

@Service
public interface AdminService {

	boolean addAdminAssets(AdminAssets adminAssets);

	List<AdminAssets> getAdminAssets();

	List<AdminAssets> getSpecificAdminAssets(String assetType);
	
	Boolean deleteAsset(String assetId);

	List<AdminAssets> getAsset(String zoneId, String string);

}
