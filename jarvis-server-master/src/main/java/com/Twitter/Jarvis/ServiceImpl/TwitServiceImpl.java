package com.Twitter.Jarvis.ServiceImpl;

import com.Twitter.Jarvis.Exception.TwitException;
import com.Twitter.Jarvis.Exception.UserException;
import com.Twitter.Jarvis.Model.TwitConfigurationModel;
import com.Twitter.Jarvis.Model.UserConfigurationModel;
import com.Twitter.Jarvis.Repository.TwitRepository;
import com.Twitter.Jarvis.Request.TwitReplyRequest;
import com.Twitter.Jarvis.Service.TwitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class TwitServiceImpl implements TwitService {
   @Autowired
    private TwitRepository twitRepository;

    @Override
    public TwitConfigurationModel createTwit(TwitConfigurationModel req, UserConfigurationModel user) throws UserException {
        try {
            TwitConfigurationModel twit = new TwitConfigurationModel();
            twit.setContent(req.getContent());
            twit.setCreatedAt(LocalDateTime.now());
            twit.setImage(req.getImage());
            twit.setUser(user);
            twit.setReply(false);
            twit.setTwit(true);
            twit.setVideo(req.getVideo());
            return twitRepository.save(twit);
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<TwitConfigurationModel> findAllTwit() {
        return twitRepository.findAllByIsTwitTrueOrderByCreatedAtDesc();
    }

    @Override
    public TwitConfigurationModel reTwit(Long twitId, UserConfigurationModel user) throws UserException, TwitException {
        TwitConfigurationModel twit = findById(twitId);
        if(twit.getRetwitUser().contains(user)){
            twit.getRetwitUser().remove(user);
        }
        else{
            twit.getRetwitUser().add(user);
        }
        return twitRepository.save(twit);
    }

    @Override
    public TwitConfigurationModel findById(Long twitId) throws TwitException {
        TwitConfigurationModel twit = twitRepository.findById(twitId)
                .orElseThrow(()-> new TwitException("Twit not found with id "+ twitId));
        return twit;
    }

    @Override
    public void deleteTwitById(Long twitId, Long userId) throws TwitException, UserException {
        TwitConfigurationModel twit = findById(twitId);

        if(!userId.equals(twit.getUser().getId())){
            throw new UserException("You can't delete another user's twit");
        }

        twitRepository.deleteById(twit.getId());
    }


    @Override
    public TwitConfigurationModel removeFromRetwit(Long twitId, UserConfigurationModel user) throws TwitException, UserException {
        return null;
    }

    @Override
    public TwitConfigurationModel CreatedReply(TwitReplyRequest req, UserConfigurationModel user) throws TwitException {

        TwitConfigurationModel replyFor = findById(req.getTwitId());

        TwitConfigurationModel reTwit = new TwitConfigurationModel();
        reTwit.setContent(req.getContent());
        reTwit.setCreatedAt(LocalDateTime.now());
        reTwit.setImage(req.getImage());
        reTwit.setUser(user);
        reTwit.setReply(true);
        reTwit.setTwit(false);
        reTwit.setReplyFor(replyFor);

        TwitConfigurationModel savedReply = twitRepository.save(reTwit);

        reTwit.getReplyTwits().add(savedReply);
        twitRepository.save(replyFor);
        return replyFor;
    }

    @Override
    public List<TwitConfigurationModel> getUserTwit(UserConfigurationModel user) {

        return twitRepository.findByRetwitUserContainsOrUser_IdAndIsTwitTrueOrderByCreatedAtDesc(user, user.getId());

    }

    @Override
    public List<TwitConfigurationModel> findByLikesContainsUser(UserConfigurationModel user) {

        return twitRepository.findByLikesUser_id(user.getId());
    }
}
