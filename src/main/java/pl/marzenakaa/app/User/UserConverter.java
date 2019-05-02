package pl.marzenakaa.app.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.marzenakaa.app.Tweet.Tweet;
import pl.marzenakaa.repository.UserRepository;

public class UserConverter implements Converter<String, User> {
    @Autowired
    UserRepository userRepository;

    @Override
    public User convert(String s) {
        return userRepository.findOne(Long.parseLong(s));
    }
}
