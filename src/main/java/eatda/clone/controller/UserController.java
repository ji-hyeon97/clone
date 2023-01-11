package eatda.clone.controller;

import eatda.clone.config.security.jwt.TokenProvider;
import eatda.clone.dto.ResponseDTO;
import eatda.clone.dto.UserDTO;
import eatda.clone.exception.user.UserNotFoundException;
import eatda.clone.model.Role;
import eatda.clone.model.User;
import eatda.clone.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TokenProvider tokenProvider;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping(value = "/signup")
    @ApiOperation(value = "회원가입", notes = "UserDTO 객체로 받아 유저를 등록합니다.")
    public ResponseDTO<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            User user = User.builder()
                    .email(userDTO.getEmail())
                    .username(userDTO.getUsername())
                    .password(encoder.encode(userDTO.getPassword()))
                    .role(Role.USER)
                    .build();

            User registerUser = userService.create(user);
            UserDTO responseUserDTO = UserDTO.builder()
                    .email(registerUser.getEmail())
                    .username(registerUser.getUsername())
                    .role(userDTO.getRole())
                    .id(registerUser.getId())
                    .build();

            return new ResponseDTO<>(HttpStatus.OK.value(), responseUserDTO);
        } catch (IllegalArgumentException e) {
            return new ResponseDTO<>(500, e.getMessage());
        }
    }

    @PostMapping("/signin")
    @ApiOperation(value = "로그인", notes = "UserDTO 객체로 email과 password를 받아 로그인을 진행하고, token을 리턴합니다.")
    public ResponseDTO<?> authenticate(@RequestBody UserDTO userDTO) {
        User user = userService.getByCredentials(userDTO.getEmail(), userDTO.getPassword(), encoder);

        if (user != null) {
            final String token = tokenProvider.create(user);
            final UserDTO responseUserDTO = UserDTO.builder()
                    .token(token)
                    .email(user.getEmail())
                    .username(user.getUsername())
                    .role(user.getRole())
                    .id(user.getId())
                    .build();
            return new ResponseDTO<>(HttpStatus.OK.value(), responseUserDTO);
        } else {
            throw new UserNotFoundException();
        }
    }
}
