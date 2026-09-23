package com.prep_pal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "company")
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Company {
    @Id
    private String id;
    private String name;
    
}
