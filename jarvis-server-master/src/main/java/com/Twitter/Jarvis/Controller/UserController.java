package com.Twitter.Jarvis.Controller;

import com.Twitter.Jarvis.Dto.Mapper.UserDtoMapper;
import com.Twitter.Jarvis.Dto.UserDto;
import com.Twitter.Jarvis.Exception.UserException;
import com.Twitter.Jarvis.Model.UserConfigurationModel;
import com.Twitter.Jarvis.Service.UserService;
import com.Twitter.Jarvis.Utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getUserProfile(@RequestHeader("Authorization") String jwt) throws UserException{
        try {
            UserConfigurationModel user = userService.findUserProfileByJwt(jwt);
            UserDto userDto = UserDtoMapper.toUserDto(user);
            userDto.setReq_user(true);

            return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<UserDto>(new UserDto(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId, @RequestHeader("Authorization") String jwt) throws UserException{
        try {
            UserConfigurationModel reqUser = userService.findUserProfileByJwt(jwt);
            UserConfigurationModel user = userService.findUserById(userId);
            UserDto userDto = UserDtoMapper.toUserDto(user);
            userDto.setReq_user(UserUtil.isReqUser(reqUser, user));
            userDto.setFollowed(UserUtil.isFollowedByReqUser(reqUser, user));

            return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<UserDto>(new UserDto(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserDto>> searchUser(@RequestParam String query, @RequestHeader("Authorization") String jwt) throws UserException{
        UserConfigurationModel reqUser = userService.findUserProfileByJwt(jwt);
        List<UserConfigurationModel> users = userService.searchUser(query);
        List<UserDto> userDtos = UserDtoMapper.toUserDtos(users);
//        userDto.setReq_user(UserUtil.isReqUser(reqUser, user));
//        userDto.setFollowed(UserUtil.isFollowedByReqUser(reqUser, user));

        return new ResponseEntity<List<UserDto>>(userDtos, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserConfigurationModel req, @RequestHeader("Authorization") String jwt) throws UserException{
        UserConfigurationModel reqUser = userService.findUserProfileByJwt(jwt);
        UserConfigurationModel user = userService.updateUser(reqUser.getId(), req);
        UserDto userDto = UserDtoMapper.toUserDto(user);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping("/{userid}/follow")
    public ResponseEntity<UserDto> followUser(@PathVariable Long userid, @RequestHeader("Authorization") String jwt) throws UserException{
        UserConfigurationModel reqUser = userService.findUserProfileByJwt(jwt);
        UserConfigurationModel user = userService.followUser(userid, reqUser);

        UserDto userDto = UserDtoMapper.toUserDto(user);
        userDto.setFollowed(UserUtil.isFollowedByReqUser(reqUser,user));

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}

