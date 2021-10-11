package de.teclead.springbootapp.service;

import de.teclead.springbootapp.dto.CreateUserRequestDto;
import de.teclead.springbootapp.dto.UpdateUserRequestDto;
import de.teclead.springbootapp.dto.UserDto;
import de.teclead.springbootapp.entity.User;
import de.teclead.springbootapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userEntities = userRepository.findAll();

        return createUserDtosFromEntities(userEntities);
    }

    private List<UserDto> createUserDtosFromEntities(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = modelMapper.map(user, UserDto.class);
            userDtos.add(userDto);
        });

        return userDtos;
    }

    @Override
    public List<UserDto> getUsersByFirstName(String name) {
        List<User> userEntities = userRepository.findByFirstNameIgnoreCase(name);

        return createUserDtosFromEntities(userEntities);
    }

    @Override
    public UserDto updateUser(UpdateUserRequestDto requestDto) {
        User userEntity = userRepository.findById(requestDto.getId());
        userEntity.setEmail(requestDto.getEmail());
        userEntity.setFirstName(requestDto.getFirstName());
        userEntity.setLastName(requestDto.getLastName());
        User updatedUser = userRepository.save(userEntity);
        return createUserDtoFromEntity(updatedUser);
    }

    @Override
    public UserDto createUser(CreateUserRequestDto requestDto) {
        User userEntity = modelMapper.map(requestDto, User.class);
        userEntity.setId(UUID.randomUUID());
        User savedUserEntity = userRepository.save(userEntity);

        return createUserDtoFromEntity(savedUserEntity);
    }

    @Override
    @Transactional
    public void deleteUser(String id) {
        User user = userRepository.findById(UUID.fromString(id));
        userRepository.delete(user);
    }

    @Override
    public UserDto getUserById(String id) {
        User userEntity = userRepository.findById(UUID.fromString(id));

        return createUserDtoFromEntity(userEntity);
    }

    private UserDto createUserDtoFromEntity(User userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }
}
