package com.projectX.AdminController;

import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectX.Admin.AdminAssets;
import com.projectX.AdminService.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping(method= RequestMethod.POST, value="/saveassets")
	public @ResponseBody Boolean saveAssets(@RequestBody AdminAssets adminAssets) {
		System.out.println("Inside save Assets::"+ adminAssets);
		boolean status= adminService.addAdminAssets(adminAssets);
		return status;
	}
	
	@RequestMapping(method= RequestMethod.GET, value="/getassets")
	public @ResponseBody List<AdminAssets> getAssets(){
		System.out.println("Inside get Assets::");
		return adminService.getAdminAssets();
	}
	
	@RequestMapping(method= RequestMethod.POST, value="/deleteasset")
	public @ResponseBody Boolean deleteAsset(@RequestParam("assetID") String assetID){
		System.out.println("Inside delete Assets::"+ assetID);
		return adminService.deleteAsset(assetID);
	}
	
	@RequiresPermissions(value= {"READ","UPDATE"},logical = Logical.AND)
	@RequestMapping(method= RequestMethod.GET, value="/getbanner")
	public @ResponseBody AdminAssets getBanner(@RequestParam("zoneId") String zoneId){
		System.out.println("Inside getBanner::"+ zoneId);
		AdminAssets adminAssets =new AdminAssets();
		adminAssets = null != adminService.getAsset(zoneId, "banner") && 
				adminService.getAsset(zoneId, "banner").size() > 0 ? 
				adminService.getAsset(zoneId, "banner").get(0): null;
		return adminAssets;
	}
	@RequestMapping(method= RequestMethod.GET, value="/getpromotion")
	public @ResponseBody List<AdminAssets>  getPromotion(@RequestParam("zoneId") String zoneId){
		System.out.println("Inside getpromotion::"+ zoneId);
		return adminService.getAsset(zoneId, "promotion");
	}
	@RequestMapping(method= RequestMethod.GET, value="/getcorousel")
	public @ResponseBody List<AdminAssets>  getCorousel(@RequestParam("zoneId") String zoneId){
		System.out.println("Inside getCorousel::"+ zoneId);
		return adminService.getAsset(zoneId, "corousel");
	}
}
