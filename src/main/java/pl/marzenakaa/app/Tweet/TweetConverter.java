package pl.marzenakaa.app.Tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.marzenakaa.repository.TweetRepository;

public class TweetConverter implements Converter<String, Tweet> {
    @Autowired
    TweetRepository tweetRepository;

    @Override
    public Tweet convert(String s) {
        return tweetRepository.findOne(Long.parseLong(s));
    }
}
