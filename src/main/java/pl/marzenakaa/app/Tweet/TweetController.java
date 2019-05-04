package pl.marzenakaa.app.Tweet;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.marzenakaa.repository.TweetRepository;
import pl.marzenakaa.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public String showTweetsList(Model model){
        List<Tweet> tweets = tweetRepository.findAll();
        Hibernate.initialize(tweets);
        model.addAttribute("tweets", tweets);
        return "tweets-list";
    }
}
