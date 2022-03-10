package com.brigelabz.bookstoreapp.service.UserService;

import com.brigelabz.bookstoreapp.dto.UserDTO;
import com.brigelabz.bookstoreapp.entity.User;
import com.brigelabz.bookstoreapp.exceptions.BookstoreException;
import com.brigelabz.bookstoreapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).stream().filter(userData -> userData.getId()==userId).findFirst().orElseThrow(()->new BookstoreException("User not found, enter the valid User ID"));
    }

    @Override
    public User addUser(UserDTO userDTO) {
//        User userData = modelMapper.map(userDTO, User.class);
//        log.info("User data : ",userData);
//        return userRepository.save(userData);
        String userEncodePassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(userEncodePassword);
        User userData = modelMapper.map(userDTO, User.class);
        log.info("User data : ",userData);
        return userRepository.save(userData);


    }

    @Override
    public User updateUser(Long userId, UserDTO userDTO) {
        return null;
    }

    @Override
    public String deleteUser(Long userId) {
        userRepository.deleteById(userId);
        log.info("User data successfully deleted by ID -> ",userId);
        return "User data successfully deleted by ID -> " + userId;
    }

}