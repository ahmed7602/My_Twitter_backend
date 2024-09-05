package com.Twitter.Jarvis.Controller;

import com.Twitter.Jarvis.Dto.Mapper.TwitDtoMapper;
import com.Twitter.Jarvis.Dto.TwitDto;
import com.Twitter.Jarvis.Exception.TwitException;
import com.Twitter.Jarvis.Exception.UserException;
import com.Twitter.Jarvis.Model.TwitConfigurationModel;
import com.Twitter.Jarvis.Model.UserConfigurationModel;
import com.Twitter.Jarvis.Request.TwitReplyRequest;
import com.Twitter.Jarvis.Response.ApiResponse;
import com.Twitter.Jarvis.Service.TwitService;
import com.Twitter.Jarvis.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Executable;
import java.util.List;

@RestController
@RequestMapping("/api/twits")
public class TwitController {

    @Autowired
    private TwitService twitService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<TwitDto> createTwit(@RequestBody TwitConfigurationModel req, @RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        try {
            UserConfigurationModel user = userService.findUserProfileByJwt(jwt);

            TwitConfigurationModel twit = twitService.createTwit(req,user);

            TwitDto twitDto = TwitDtoMapper.toTwitDto(twit, user);

            return new ResponseEntity<>(twitDto, HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(new TwitDto(), HttpStatus.CONFLICT);

    }

    @PostMapping("/reply")
    public ResponseEntity<TwitDto> replyTwit(@RequestBody TwitReplyRequest req, @RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        try {
            UserConfigurationModel user = userService.findUserProfileByJwt(jwt);

            TwitConfigurationModel twit = twitService.CreatedReply(req,user);

            TwitDto twitDto = TwitDtoMapper.toTwitDto(twit, user);

            return new ResponseEntity<>(twitDto, HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(new TwitDto(), HttpStatus.CONFLICT);
    }

    @PutMapping("/{twitId}/retwit")
    public ResponseEntity<TwitDto> retwit(@PathVariable Long twitId, @RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        UserConfigurationModel user = userService.findUserProfileByJwt(jwt);

        TwitConfigurationModel twit = twitService.reTwit(twitId, user);

        TwitDto twitDto = TwitDtoMapper.toTwitDto(twit, user);

        return new ResponseEntity<>(twitDto, HttpStatus.OK);
    }

    @GetMapping("/{twitId}")
    public ResponseEntity<TwitDto> findTwitById(@PathVariable Long twitId, @RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        try{
            UserConfigurationModel user = userService.findUserProfileByJwt(jwt);

            TwitConfigurationModel twit = twitService.findById(twitId);

            TwitDto twitDto = TwitDtoMapper.toTwitDto(twit, user);

            return new ResponseEntity<>(twitDto, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(new TwitDto(), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{twitId}")
    public ResponseEntity<ApiResponse> deleteTwit(@PathVariable Long twitId, @RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        UserConfigurationModel user = userService.findUserProfileByJwt(jwt);

        twitService.deleteTwitById(twitId, user.getId());

        ApiResponse res = new ApiResponse();
        res.setStatus(true);
        res.setMessage("Twit deleted successfully");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TwitDto>> getAllTwits(@RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        UserConfigurationModel user = userService.findUserProfileByJwt(jwt);

        List<TwitConfigurationModel> twit = twitService.findAllTwit();

        List<TwitDto> twitDto = TwitDtoMapper.toTwitDtos(twit, user);

        return new ResponseEntity<>(twitDto, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TwitDto>> getUserAllTwits(@PathVariable Long userId, @RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        UserConfigurationModel user = userService.findUserProfileByJwt(jwt);

        List<TwitConfigurationModel> twits = twitService.getUserTwit(user);

        List<TwitDto> twitDto = TwitDtoMapper.toTwitDtos(twits, user);

        return new ResponseEntity<>(twitDto, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/likes")
    public ResponseEntity<List<TwitDto>> findTwitByLikesContainersUser(@PathVariable Long userId, @RequestHeader("Authorization") String jwt) throws UserException, TwitException{
        UserConfigurationModel user = userService.findUserProfileByJwt(jwt);

        List<TwitConfigurationModel> twits = twitService.findByLikesContainsUser(user);

        List<TwitDto> twitDto = TwitDtoMapper.toTwitDtos(twits, user);

        return new ResponseEntity<>(twitDto, HttpStatus.OK);
    }

}

