package com.projectXNeighbour.Settings.AdminRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.projectXNeighbour.Settings.Services;

public interface NeighbourAdminRepository extends MongoRepository<Services, String>,QuerydslPredicateExecutor<Services>  {

}
