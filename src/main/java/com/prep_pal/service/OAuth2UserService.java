package com.prep_pal.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.prep_pal.repository.UserRepository;
import com.prep_pal.model.User;
import java.util.Optional;

@Service 
public class OAuth2UserService extends DefaultOAuth2UserService {

    @Autowired 
    private UserRepository userRepository;

    @Override 
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        
        // Fetch the profile data from Google using the standard OAuth flow
        OAuth2User oAuth2User = super.loadUser(userRequest);

        // Extract the user information from the OAuth2User object
        String userId = oAuth2User.getAttribute("sub");
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String pictureUrl = oAuth2User.getAttribute("picture");

        // Check if the user already exists in MongoDb, otherwise save them
        Optional<User> existingUser = userRepository.findByUserId(userId);

        if(existingUser.isEmpty()){
            User newUser = new User(null, userId, email, name, pictureUrl);
            userRepository.save(newUser);
        }

        return oAuth2User;

    }


}
