package com.we3.cricpay.models.entities;

import com.we3.cricpay.models.enums.UserStatus;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Accessors(chain = true)
@Table("te_users")
public class User {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private Integer phoneExt;
    private Integer phone;
    private UserStatus status;
}
