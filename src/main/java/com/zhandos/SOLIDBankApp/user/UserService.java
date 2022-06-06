package com.zhandos.SOLIDBankApp.user;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class UserService {
    private ModelMapper modelMapper;
    private UserRepository userRepository;

    public int createUser(UserRequest userRequest) {
        User user = User.builder().username(userRequest.getUsername()).
                password(userRequest.getPassword()).build();
        User createdUser = userRepository.save(user);
        return createdUser.getUserID();
    }

    public void deleteUser(int id) {
        userRepository.findById((long) id).orElseThrow(() -> new UserNotFound(id));
        userRepository.deleteById((long) id);
    }

    public User updateUser(UserRequest userRequest, int id) {
        userRepository.findById((long) id).orElseThrow(() -> new UserNotFound(id));
        User user = User.builder().username(userRequest.getUsername())
                .password(userRequest.getPassword()).userID(id).build();
        return userRepository.save(user);
    }

    public List<UserResponse> getUsers() {
        List<UserResponse> UserResponses = Streamable.of(userRepository.findAll())
                .stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
        return UserResponses;
    }

    public UserResponse getUserById(int id) {
        User user = userRepository.findById((long) id).orElseThrow(() -> new UserNotFound(id));
        return modelMapper.map(user, UserResponse.class);
    }
}

