//package com.Twitter.Jarvis.Dto.Mapper;
//
//import com.Twitter.Jarvis.Dto.UserDto;
//import com.Twitter.Jarvis.Model.UserConfigurationModel;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class UserDtoMapper {
//
//    public static UserDto toUserDto(UserConfigurationModel user){
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setEmail(user.getEmail());
//        userDto.setFullName(user.getFullName());
//        userDto.setImage(user.getImage());
//        userDto.setBackGroundImage(user.getBackGroundImage());
//        userDto.setBio(user.getBio());
//        userDto.setBirthDate(user.getDateOfBirth());
//        userDto.setLogin_with_google(user.isLogin_with_google());
//        userDto.setLocation(user.getLocation());
//        userDto.setFollowers(user.getFollowers().stream()
//                .map(follower -> new UserDto(follower.getId(), follower.getFullName()))
//                .collect(Collectors.toList()));
//        userDto.setFollowing(user.getFollowings().stream()
//                .map(following -> new UserDto(following.getId(), following.getFullName()))
//                .collect(Collectors.toList()));
//        return userDto;
//    }
//
//    public static List<UserDto> toUserDtos(List<UserConfigurationModel> users){
//        return users.stream()
//                .map(UserDtoMapper::toUserDto)
//                .collect(Collectors.toList());
//    }
//}


package com.Twitter.Jarvis.Dto.Mapper;

import com.Twitter.Jarvis.Dto.UserDto;
import com.Twitter.Jarvis.Model.UserConfigurationModel;

import java.util.ArrayList;
import java.util.List;

public class UserDtoMapper {

    public static UserDto toUserDto(UserConfigurationModel user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFullName(user.getFullName());
        userDto.setImage(user.getImage());
        userDto.setBackGroundImage(user.getBackGroundImage());
        userDto.setBio(user.getBio());
        userDto.setBirthDate(user.getDateOfBirth());
        userDto.setFollowers(toUserDtos(user.getFollowers()));
        userDto.setFollowing(toUserDtos(user.getFollowings()));
        userDto.setLogin_with_google(user.isLogin_with_google());
        userDto.setLocation(user.getLocation());
//        userDto.setVerified(false);
        return userDto;
    }

    public static List<UserDto> toUserDtos(List<UserConfigurationModel> followers){
        List<UserDto> userDtos = new ArrayList<>();

        for(UserConfigurationModel user:followers){
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setEmail(user.getEmail());
            userDto.setFullName(user.getFullName());
            userDto.setImage(user.getImage());
            userDtos.add(userDto);
        }


        return userDtos;
    }
}
