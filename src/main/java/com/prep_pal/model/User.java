package com.prep_pal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Document(collection = "users")
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String userId;
    private String email;
    private String name;
    private String pictureUrl;
    
}
