package eatda.clone.service;

import eatda.clone.exception.user.UserNotFoundException;
import eatda.clone.model.User;
import eatda.clone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public User create(final User userEntity){
        if(userEntity == null || userEntity.getEmail() == null){
            throw new RuntimeException("Invalid arguments");
        }

        final String email = userEntity.getEmail();
        if(userRepository.existsByEmail(email)){
            log.warn("email already exists {}", email);
            throw new UserNotFoundException();
        }

        return userRepository.save(userEntity);
    }

    public User getByCredentials(final String email, final String password, final BCryptPasswordEncoder encoder){
        final User originalUser = userRepository.findByEmail(email);

        if(originalUser!=null && encoder.matches(password,originalUser.getPassword())) {
            return originalUser;
        }
        return null;
    }
}
