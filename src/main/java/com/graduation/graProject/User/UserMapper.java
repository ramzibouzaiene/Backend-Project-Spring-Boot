package com.graduation.graProject.User;

import com.graduation.graProject.User.DTO.RegisterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    RegisterDTO mapToUserDto(UserEntity user);
    UserEntity mapToUser(RegisterDTO userDto);
}
