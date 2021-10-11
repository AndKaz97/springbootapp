package de.teclead.springbootapp.service;

import de.teclead.springbootapp.dto.CreateUserRequestDto;
import de.teclead.springbootapp.dto.UpdateUserRequestDto;
import de.teclead.springbootapp.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    List<UserDto> getUsersByFirstName(String name);
    UserDto updateUser(UpdateUserRequestDto requestDto);
    UserDto createUser(CreateUserRequestDto requestDto);
    void deleteUser(String id);

    UserDto getUserById(String id);

}
