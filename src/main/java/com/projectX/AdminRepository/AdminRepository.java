package com.projectX.AdminRepository;

import java.util.List;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.projectX.Admin.AdminAssets;

public interface AdminRepository extends MongoRepository<AdminAssets, String>,QuerydslPredicateExecutor<AdminAssets> {
	
	@Query(value = "{category : ?0 }") //, fields = "{productOwnerId : 1, productName : 1 }"
	List<AdminAssets> findSpecificAdminAssets(String assetType);
	
	@DeleteQuery(value="{id : ?0}")
	public void deleteById(String Id);
	
	
	@Query(value = "{zoneId : ?0 , category :?1 , active : ?2 }")
	List<AdminAssets> getAssetByZone(String zoneId, String category, int activeStatus);
	
}
