package com.prep_pal.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prep_pal.model.Company;
import com.prep_pal.repository.CompanyRepository;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @PostMapping("/add")
    public String addCompany(@RequestBody ArrayList<String> companies) {

        for(String companyName: companies){
            companyRepository.save(new Company(null, companyName));
        }
        return "Companies added successfully";
        
    }
    

}
