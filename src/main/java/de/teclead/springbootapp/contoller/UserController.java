package de.teclead.springbootapp.contoller;

import de.teclead.springbootapp.dto.CreateUserRequestDto;
import de.teclead.springbootapp.dto.UpdateUserRequestDto;
import de.teclead.springbootapp.dto.UserDto;
import de.teclead.springbootapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserDto>> getAllUserByFirstname(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(userService.getUsersByFirstName(name));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody CreateUserRequestDto requestDto) {
        return ResponseEntity.ok().body(userService.createUser(requestDto));
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UpdateUserRequestDto requestDto) {
        return ResponseEntity.ok().body(userService.updateUser(requestDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);

        return ResponseEntity.ok().build();
    }
}
