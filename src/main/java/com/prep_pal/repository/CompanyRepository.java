package com.prep_pal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prep_pal.model.Company;


public interface CompanyRepository extends MongoRepository<Company, String> {
    
}
