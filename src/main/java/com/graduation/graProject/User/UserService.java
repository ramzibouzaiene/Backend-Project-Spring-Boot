package com.graduation.graProject.User;

import com.graduation.graProject.Trainings.TrainingEntity;
import com.graduation.graProject.User.DTO.RegisterDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public UserEntity getById(Long id){
        return userRepository.findById(id).get();
    }

    public UserEntity createUser(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity updateUser(UserEntity user, Long id){
        if(userRepository.existsById(id)){
            user.setId(id);
            userRepository.save(user);
        }
        return null;
    }

    public boolean deleteUser(Long id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
