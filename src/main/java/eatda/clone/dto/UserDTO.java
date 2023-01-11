package eatda.clone.dto;

import eatda.clone.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String token;
    private String id;

    @Email @NotBlank
    private String email;

    @NotBlank
    private String username;
    private String password;
    private Role role = Role.USER;
}
