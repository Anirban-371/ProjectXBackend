package com.projectX.Admin.Request;

import com.projectX.Admin.AdminAssets;

public class AdminRequest {
	AdminAssets admin;

	public AdminAssets getAdmin() {
		return admin;
	}
	public void setAdmin(AdminAssets admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "AdminRequest [admin=" + admin + "]";
	}	
}
