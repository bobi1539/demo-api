
package com.domain.controllers;

import com.domain.dto.AppUserData;
import com.domain.dto.ResponseData;
import com.domain.models.entities.AppUser;
import com.domain.services.AppUserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AppUserController {
    
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseData<AppUser>> register(@RequestBody AppUserData userData){
        
        ResponseData<AppUser> responseData = new ResponseData<>();
        AppUser appUser = modelMapper.map(userData, AppUser.class);

        responseData.setStatus(true);
        responseData.setPayload(appUserService.registerAppUser(appUser));
        responseData.getMessages().add("User saved");
        return ResponseEntity.ok().body(responseData);
    }
}
