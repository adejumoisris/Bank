package com.idris.bank.service;

import com.idris.bank.dto.request.UserDTO;
import com.idris.bank.model.Users;

public interface UserService {

    public Users registerUser(UserDTO userDTO);
}
