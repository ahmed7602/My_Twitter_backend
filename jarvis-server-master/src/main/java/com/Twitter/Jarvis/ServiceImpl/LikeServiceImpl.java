package com.Twitter.Jarvis.ServiceImpl;

import com.Twitter.Jarvis.Exception.TwitException;
import com.Twitter.Jarvis.Exception.UserException;
import com.Twitter.Jarvis.Model.LikeConfigurationModel;
import com.Twitter.Jarvis.Model.TwitConfigurationModel;
import com.Twitter.Jarvis.Model.UserConfigurationModel;
import com.Twitter.Jarvis.Repository.LikeRepository;
import com.Twitter.Jarvis.Repository.TwitRepository;
import com.Twitter.Jarvis.Service.LikeService;
import com.Twitter.Jarvis.Service.TwitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private TwitRepository twitRepository;

    @Autowired
    private TwitService twitService;

    @Override
    public LikeConfigurationModel likeTwit(Long twitId, UserConfigurationModel user) throws UserException, TwitException {
        LikeConfigurationModel isLikeExit = likeRepository.isLikeExist(user.getId(), twitId);

        if(isLikeExit!=null){
            likeRepository.deleteById(isLikeExit.getId());
            return isLikeExit;
        }

        TwitConfigurationModel twit = twitService.findById(twitId);

        LikeConfigurationModel like = new LikeConfigurationModel();
        like.setTwit(twit);
        like.setUser(user);

        LikeConfigurationModel savedLike = likeRepository.save(like);

        twit.getLikes().add(savedLike);
        twitRepository.save(twit);

        return savedLike;
    }

    @Override
    public List<LikeConfigurationModel> getAllLikes(Long twitId) throws TwitException {

        TwitConfigurationModel twit = twitService.findById(twitId);

        List<LikeConfigurationModel> likes = likeRepository.findByTwitId(twitId);

        return likes;
    }
}
