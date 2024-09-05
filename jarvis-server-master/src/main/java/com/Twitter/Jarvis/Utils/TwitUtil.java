package com.Twitter.Jarvis.Utils;

import com.Twitter.Jarvis.Model.LikeConfigurationModel;
import com.Twitter.Jarvis.Model.TwitConfigurationModel;
import com.Twitter.Jarvis.Model.UserConfigurationModel;

public class TwitUtil {
    public final static boolean isLIkedByReqUser(UserConfigurationModel reqUser, TwitConfigurationModel twit){
        for(LikeConfigurationModel like : twit.getLikes()){
            if(like.getUser().getId().equals(reqUser.getId()))
                return true;
        }

        return false;
    }


    public final static boolean isRetwitedByReqUser(UserConfigurationModel reqUser, TwitConfigurationModel twit){

        for(UserConfigurationModel user: twit.getRetwitUser()) {

            if (user.getId().equals(reqUser.getId()))
                return true;
        }

        return false;

    }
}
