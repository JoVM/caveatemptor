package com.amudhan.caveatemptor.web.mapper;

import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.web.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User userDtoToUser(UserDto user);

    UserDto userToUserDto(User user);
}
