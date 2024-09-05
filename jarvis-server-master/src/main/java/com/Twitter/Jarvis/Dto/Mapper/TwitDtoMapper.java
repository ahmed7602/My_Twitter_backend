//package com.Twitter.Jarvis.Dto.Mapper;
//
//import com.Twitter.Jarvis.Dto.TwitDto;
//import com.Twitter.Jarvis.Dto.UserDto;
//import com.Twitter.Jarvis.Model.TwitConfigurationModel;
//import com.Twitter.Jarvis.Model.UserConfigurationModel;
//import com.Twitter.Jarvis.Utils.TwitUtil;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class TwitDtoMapper {
//
//    public static TwitDto toTwitDto(TwitConfigurationModel twit, UserConfigurationModel reqUser){
//
//        UserDto user = UserDtoMapper.toUserDto(twit.getUser());
//
//        boolean isLiked = TwitUtil.isLIkedByReqUser(reqUser, twit);
//        boolean isRetwited = TwitUtil.isRetwitedByReqUser(reqUser, twit);
//
//        List<Long> retwitUserId = twit.getRetwitUser().stream()
//                .map(UserConfigurationModel::getId)
//                .collect(Collectors.toList());
//
//        TwitDto twitDto = new TwitDto();
//        twitDto.setId(twit.getId());
//        twitDto.setContent(twit.getContent());
//        twitDto.setImage(twit.getImage());
//        twitDto.setCreatedAt(twit.getCreatedAt());
//        twitDto.setTotalLikes(twit.getLikes().size());
//        twitDto.setTotalReplies(twit.getReplyTwits().size());
//        twitDto.setTotalRetweets(twit.getRetwitUser().size());
//        twitDto.setUser(user);
//        twitDto.setLiked(isLiked);
//        twitDto.setRetwit(isRetwited);
//        twitDto.setRetwitUserId(retwitUserId);
//        twitDto.setReplyTwit(twit.getReplyTwits().stream()
//                .map(reply -> new TwitDto(reply.getId(), reply.getContent(), reply.getUser().getId()))
//                .collect(Collectors.toList()));
//        twitDto.setVideo(twit.getVideo());
//        return twitDto;
//    }
//
//    public static List<TwitDto> toTwitDtos(List<TwitConfigurationModel> twits, UserConfigurationModel reqUser){
//        return twits.stream()
//                .map(twit -> toTwitDto(twit, reqUser))
//                .collect(Collectors.toList());
//    }
//
//    public static TwitDto toReplyTwitDto(TwitConfigurationModel twit, UserConfigurationModel reqUser){
//        return toTwitDto(twit, reqUser);
//    }
//}



package com.Twitter.Jarvis.Dto.Mapper;

import com.Twitter.Jarvis.Dto.TwitDto;
import com.Twitter.Jarvis.Dto.UserDto;
import com.Twitter.Jarvis.Model.TwitConfigurationModel;
import com.Twitter.Jarvis.Model.UserConfigurationModel;
import com.Twitter.Jarvis.Utils.TwitUtil;

import java.util.ArrayList;
import java.util.List;

public class TwitDtoMapper {

    public static TwitDto toTwitDto(TwitConfigurationModel twit, UserConfigurationModel reqUser){

        UserDto user = UserDtoMapper.toUserDto(twit.getUser());

        boolean isLiked = TwitUtil.isLIkedByReqUser(reqUser, twit);

        boolean isRetwited = TwitUtil.isRetwitedByReqUser(reqUser, twit);

        List<Long> retwitUserId = new ArrayList<>();

        for(UserConfigurationModel user1: twit.getRetwitUser()){
            retwitUserId.add(user.getId());
        }

        TwitDto twitDto = new TwitDto();
        twitDto.setId(twit.getId());
        twitDto.setContent(twit.getContent());
        twitDto.setImage(twit.getImage());
        twitDto.setCreatedAt(twit.getCreatedAt());
        twitDto.setTotalLikes(twit.getLikes().size());
        twitDto.setTotalReplies(twit.getReplyTwits().size());
        twitDto.setTotalRetweets(twit.getRetwitUser().size());
        twitDto.setUser(user);
        twitDto.setLiked(isLiked);
        twitDto.setRetwit(isRetwited);
        twitDto.setRetwitUserId(retwitUserId);
        twitDto.setReplyTwit(toTwitDtos(twit.getReplyTwits(), reqUser));
        twitDto.setVideo(twit.getVideo());
        return twitDto;
    }

    public static List<TwitDto> toTwitDtos(List<TwitConfigurationModel> twits, UserConfigurationModel reqUser){
        List<TwitDto> twitDtos = new ArrayList<>();

        for(TwitConfigurationModel twit:twits){
            TwitDto twitDto = toReplyTwitDto(twit, reqUser);
            twitDtos.add(twitDto);
        }

        return twitDtos;
    }

    public static TwitDto toReplyTwitDto(TwitConfigurationModel twit, UserConfigurationModel reqUser){
        UserDto user = UserDtoMapper.toUserDto(twit.getUser());

        boolean isLiked = TwitUtil.isLIkedByReqUser(reqUser, twit);

        boolean isRetwited = TwitUtil.isLIkedByReqUser(reqUser, twit);

        List<Long> retwitUserId = new ArrayList<>();

        for(UserConfigurationModel user1: twit.getRetwitUser()){
            retwitUserId.add(user.getId());
        }

        TwitDto twitDto = new TwitDto();
        twitDto.setId(twit.getId());
        twitDto.setContent(twit.getContent());
        twitDto.setImage(twit.getImage());
        twitDto.setCreatedAt(twit.getCreatedAt());
        twitDto.setTotalLikes(twit.getLikes().size());
        twitDto.setTotalReplies(twit.getReplyTwits().size());
        twitDto.setTotalRetweets(twit.getRetwitUser().size());
        twitDto.setUser(user);
        twitDto.setLiked(isLiked);
        twitDto.setRetwit(isRetwited);
        twitDto.setRetwitUserId(retwitUserId);
        twitDto.setReplyTwit(null);
//        twitDto.setReplyTwit(toTwitDtos(twit.getReplyTwits(), reqUser));
        return twitDto;
    }
}
