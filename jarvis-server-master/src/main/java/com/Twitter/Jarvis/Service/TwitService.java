package com.Twitter.Jarvis.Service;

import com.Twitter.Jarvis.Exception.TwitException;
import com.Twitter.Jarvis.Exception.UserException;
import com.Twitter.Jarvis.Model.TwitConfigurationModel;
import com.Twitter.Jarvis.Model.UserConfigurationModel;
import com.Twitter.Jarvis.Request.TwitReplyRequest;

import java.util.List;

public interface TwitService {

    public TwitConfigurationModel createTwit(TwitConfigurationModel req, UserConfigurationModel user) throws UserException;
    public List<TwitConfigurationModel> findAllTwit();
    public TwitConfigurationModel reTwit(Long twitId, UserConfigurationModel user) throws UserException, TwitException;

    public TwitConfigurationModel findById(Long twitId) throws TwitException;
    public void deleteTwitById(Long twitId, Long userId) throws TwitException, UserException;

    public TwitConfigurationModel removeFromRetwit(Long twitId, UserConfigurationModel user) throws TwitException, UserException;

    public TwitConfigurationModel CreatedReply(TwitReplyRequest req, UserConfigurationModel user) throws TwitException;

    public List<TwitConfigurationModel> getUserTwit(UserConfigurationModel user);
    public List<TwitConfigurationModel> findByLikesContainsUser(UserConfigurationModel user);

}
