package eatda.clone.dto;

import eatda.clone.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String token;
    private String id;
    private String email;
    private String username;
    private String password;
    private Role role = Role.USER;
}
