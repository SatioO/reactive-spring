package com.we3.cricpay.models.mappers;

import com.we3.cricpay.models.dtos.UserDto;
import com.we3.cricpay.models.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<User, UserDto> {
    User toEntity(UserDto dto);

    UserDto toDto(User entity);
}
