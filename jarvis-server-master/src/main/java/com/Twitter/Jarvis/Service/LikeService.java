package com.Twitter.Jarvis.Service;

import com.Twitter.Jarvis.Exception.TwitException;
import com.Twitter.Jarvis.Exception.UserException;
import com.Twitter.Jarvis.Model.LikeConfigurationModel;
import com.Twitter.Jarvis.Model.UserConfigurationModel;

import java.util.List;

public interface LikeService {

    public LikeConfigurationModel likeTwit(Long twitId, UserConfigurationModel user) throws UserException, TwitException;

    public List<LikeConfigurationModel> getAllLikes(Long twitId) throws TwitException;

}
