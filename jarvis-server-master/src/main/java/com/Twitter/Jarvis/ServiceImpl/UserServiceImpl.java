package com.Twitter.Jarvis.ServiceImpl;

import com.Twitter.Jarvis.Config.JwtProvider;
import com.Twitter.Jarvis.Exception.UserException;
import com.Twitter.Jarvis.Model.UserConfigurationModel;
import com.Twitter.Jarvis.Repository.UserRepository;
import com.Twitter.Jarvis.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtProvider;
    @Override
    public UserConfigurationModel findUserById(Long userId) throws UserException {
        UserConfigurationModel user = userRepository.findById(userId).orElseThrow(()-> new UserException("user not found with id "+userId));
        return user;
    }

    @Override
    public UserConfigurationModel findUserProfileByJwt(String jwt) throws UserException {
       try {
           String email = jwtProvider.getEmailFromToken(jwt);
           UserConfigurationModel user = userRepository.findByEmail(email);

           if(user == null){
               throw new UserException("User not found with email " + email);
           }
           return user;
       } catch (Exception e){
           System.out.println(e);
       }
       return null;
    }

    @Override
    public UserConfigurationModel updateUser(Long userId, UserConfigurationModel req) throws UserException {
        UserConfigurationModel user = findUserById(userId);

        if(req.getFullName()!=null){
            user.setFullName(req.getFullName());
        }

        if(req.getImage()!=null){
            user.setImage(req.getImage());
        }

        if(req.getBackGroundImage()!=null){
            user.setBackGroundImage(req.getBackGroundImage());
        }

        if(req.getDateOfBirth()!=null){
            user.setDateOfBirth(req.getDateOfBirth());
        }

        if(req.getLocation()!=null){
            user.setLocation(req.getLocation());
        }

        if(req.getBio()!=null){
            user.setBio(req.getBio());
        }

        if(req.getWebsite()!=null){
            user.setWebsite(req.getWebsite());
        }

        return userRepository.save(user);
    }

    @Override
    public UserConfigurationModel followUser(Long userId, UserConfigurationModel user) throws UserException {
        UserConfigurationModel followToUser = findUserById(userId);

        if(user.getFollowings().contains(followToUser) && followToUser.getFollowers().contains(user)){
            user.getFollowings().remove(followToUser);
            followToUser.getFollowers().remove(user);
        }
        else{
            user.getFollowings().add(followToUser);
            followToUser.getFollowers().add(user);
        }

        userRepository.save(followToUser);
        userRepository.save(user);
        return followToUser;
    }

    @Override
    public List<UserConfigurationModel> searchUser(String query) {
        return userRepository.searchUser(query);
    }
}
