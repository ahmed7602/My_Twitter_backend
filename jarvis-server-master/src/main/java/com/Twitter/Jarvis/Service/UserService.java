package com.Twitter.Jarvis.Service;

import com.Twitter.Jarvis.Exception.UserException;
import com.Twitter.Jarvis.Model.UserConfigurationModel;

import java.util.List;

public interface UserService {

    public UserConfigurationModel findUserById(Long userId) throws UserException;
    public UserConfigurationModel findUserProfileByJwt(String jwt) throws UserException;
    public UserConfigurationModel updateUser(Long userId, UserConfigurationModel user) throws UserException;

    public UserConfigurationModel followUser(Long userId, UserConfigurationModel user) throws UserException;

    public List<UserConfigurationModel> searchUser(String query);
}
