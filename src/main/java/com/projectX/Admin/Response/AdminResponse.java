package com.projectX.Admin.Response;

import java.util.List;

import com.projectX.Admin.AdminAssets;

public class AdminResponse {
	List<AdminAssets> admin;

	public List<AdminAssets> getAdmin() {
		return admin;
	}

	public void setAdmin(List<AdminAssets> admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminResponse [admin=");
		builder.append(admin);
		builder.append("]");
		return builder.toString();
	}	
}
