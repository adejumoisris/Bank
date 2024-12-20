package com.idris.bank.controller;

import com.idris.bank.dto.request.UserDTO;
import com.idris.bank.model.Users;
import com.idris.bank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUsers(@RequestBody UserDTO userDTO){
        try {
            Users registerUser  = userService.registerUser(userDTO);
            return  ResponseEntity.ok("User Register Successfully! API Key "
                    + (registerUser.getApiKey() == null ? registerUser.getApiKey():"Not Requested"));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
