package itc.hoseo.hellospring.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {
    @NotBlank
    private String id;
    @NotBlank
    private String password;
}
