package com.Twitter.Jarvis.Dto.Mapper;

import com.Twitter.Jarvis.Dto.LikeDto;
import com.Twitter.Jarvis.Dto.TwitDto;
import com.Twitter.Jarvis.Dto.UserDto;
import com.Twitter.Jarvis.Model.LikeConfigurationModel;
import com.Twitter.Jarvis.Model.UserConfigurationModel;

import java.util.ArrayList;
import java.util.List;

public class LikeDtoMapper {

    public static LikeDto toLikeDto(LikeConfigurationModel like, UserConfigurationModel reqUser){
        UserDto user = UserDtoMapper.toUserDto(like.getUser());
        TwitDto twit = TwitDtoMapper.toTwitDto(like.getTwit(), reqUser);

        LikeDto likeDto = new LikeDto();
        likeDto.setId(like.getId());
        likeDto.setTwit(twit);
        likeDto.setUser(user);

        return likeDto;
    }

    public static List<LikeDto> toLikeDtos(List<LikeConfigurationModel> likes, UserConfigurationModel reqUser){
        List<LikeDto> likeDtos = new ArrayList<>();

        for(LikeConfigurationModel like : likes){
            likeDtos.add(toLikeDto(like, reqUser));
        }

        return likeDtos;
    }
}


//package com.Twitter.Jarvis.Dto.Mapper;
//
//import com.Twitter.Jarvis.Dto.LikeDto;
//import com.Twitter.Jarvis.Dto.TwitDto;
//import com.Twitter.Jarvis.Dto.UserDto;
//import com.Twitter.Jarvis.Model.LikeConfigurationModel;
//import com.Twitter.Jarvis.Model.UserConfigurationModel;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class LikeDtoMapper {
//
//    public static LikeDto toLikeDto(LikeConfigurationModel like, UserConfigurationModel reqUser){
//        UserDto user = UserDtoMapper.toUserDto(like.getUser());
//        UserDto reqUserDto = UserDtoMapper.toUserDto(reqUser);
//        TwitDto twit = TwitDtoMapper.toTwitDto(like.getTwit(), reqUser);
//
//        LikeDto likeDto = new LikeDto();
//        likeDto.setId(like.getId());
//        likeDto.setTwit(twit);
//        likeDto.setUser(user);
//
//        return likeDto;
//    }
//
//    public static List<LikeDto> toLikeDtos(List<LikeConfigurationModel> likes, UserConfigurationModel reqUser){
//        List<LikeDto> likeDtos = new ArrayList<>();
//
//        for(LikeConfigurationModel like:likes){
//            UserDto user = UserDtoMapper.toUserDto(reqUser);
//            TwitDto twit = TwitDtoMapper.toTwitDto(like.getTwit(), reqUser);
//
//            LikeDto likeDto = new LikeDto();
//            likeDto.setId(like.getId());
//            likeDto.setTwit(twit);
//            likeDto.setUser(user);
//            likeDtos.add(likeDto);
//        }
//
//        return likeDtos;
//    }
//}
