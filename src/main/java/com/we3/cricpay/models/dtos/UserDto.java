package com.we3.cricpay.models.dtos;

import com.we3.cricpay.models.enums.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto {
    @NotEmpty()
    private String name;

    @Max(20)
    @NotEmpty()
    private String username;

    @Email()
    @NotEmpty()
    private String email;

    @Max(10)
    @NotEmpty()
    private Integer phone;

    @NotEmpty()
    private UserStatus status;
}
