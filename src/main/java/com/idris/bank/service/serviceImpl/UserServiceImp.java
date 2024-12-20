package com.idris.bank.service.serviceImpl;

import com.idris.bank.constants.ApiKeyGenerator;
import com.idris.bank.dto.request.UserDTO;
import com.idris.bank.enums.UserTypes;
import com.idris.bank.model.BusinessUser;
import com.idris.bank.model.Users;
import com.idris.bank.repository.UserRepository;
import com.idris.bank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users registerUser(UserDTO userDTO) {

//         check if user is already registered
        Optional<Users> existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()){
            throw new RuntimeException("User already registered with the same email");
        }

//        Validate User Type
        if (UserTypes.BUSINESS.equals(userDTO.getUserTypes()) && UserTypes.PERSONAL.equals(userDTO.getUserTypes())){
            throw new RuntimeException("Invalid user type. Must be BUSINESS or PERSONAL ");
        }

//         Else create new user
        Users user = new Users();
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setUserTypes(userDTO.getUserTypes());

//        Bussiness-specific logic
        if (UserTypes.BUSINESS.equals(userDTO.getUserTypes())){
//            set bussiness-specifice details
            BusinessUser businessUser = new BusinessUser();
            businessUser.setBusinessName(userDTO.getBusinessName());
            businessUser.setBusinessAddress(userDTO.getBusinessAddress());
            user.setEligibleForCommission(userDTO.isEligibleForCommission());

//            Generate Api Request
            if (userDTO.isApiIntegrationRequested()){
                user.setApiKey(ApiKeyGenerator.generateApiKey());
            }
        }

        return userRepository.save(user);
    }
}
