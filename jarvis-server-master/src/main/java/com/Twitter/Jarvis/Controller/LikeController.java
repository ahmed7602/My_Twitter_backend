package com.Twitter.Jarvis.Controller;

import com.Twitter.Jarvis.Dto.LikeDto;
import com.Twitter.Jarvis.Dto.Mapper.LikeDtoMapper;
import com.Twitter.Jarvis.Exception.TwitException;
import com.Twitter.Jarvis.Exception.UserException;
import com.Twitter.Jarvis.Model.LikeConfigurationModel;
import com.Twitter.Jarvis.Model.UserConfigurationModel;
import com.Twitter.Jarvis.Service.LikeService;
import com.Twitter.Jarvis.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LikeController {
    @Autowired
    private UserService userService;
    @Autowired
    private LikeService likeService;


    @PostMapping("/{twitId}/likes")
    public ResponseEntity<LikeDto> likeTwit(@PathVariable Long twitId, @RequestHeader("Authorization") String jwt) throws UserException, TwitException {
        UserConfigurationModel user = userService.findUserProfileByJwt(jwt);
        LikeConfigurationModel like = likeService.likeTwit(twitId, user);

        LikeDto likeDto = LikeDtoMapper.toLikeDto(like, user);

        return new ResponseEntity<LikeDto>(likeDto, HttpStatus.CREATED);
    }

    @PostMapping("twit/{twitId}")
    public ResponseEntity<List<LikeDto>> getAllLikes(@PathVariable Long twitId, @RequestHeader("Authorization") String jwt) throws UserException, TwitException {
        UserConfigurationModel user = userService.findUserProfileByJwt(jwt);
        List<LikeConfigurationModel> likes = likeService.getAllLikes(twitId);

        List<LikeDto> likeDto = LikeDtoMapper.toLikeDtos(likes, user);

        return new ResponseEntity<List<LikeDto>>(likeDto, HttpStatus.CREATED);
    }
}
