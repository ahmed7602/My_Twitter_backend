package com.Twitter.Jarvis.Utils;

import com.Twitter.Jarvis.Model.UserConfigurationModel;
import org.springframework.security.core.userdetails.User;

public class UserUtil {

    public static final boolean isReqUser(UserConfigurationModel reqUser, UserConfigurationModel user){
        return reqUser.getId().equals(user.getId());
    }

    public static final boolean isFollowedByReqUser(UserConfigurationModel reqUser, UserConfigurationModel user){
        return reqUser.getFollowings().contains(user);
    }
}
