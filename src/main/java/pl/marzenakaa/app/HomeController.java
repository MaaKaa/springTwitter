package pl.marzenakaa.app;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.marzenakaa.app.Tweet.Tweet;
import pl.marzenakaa.app.User.User;
import pl.marzenakaa.repository.TweetRepository;
import pl.marzenakaa.repository.UserRepository;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String showHomepage(Model model){
        List<Tweet> latestTweets = tweetRepository.findAllLatest();
        Hibernate.initialize(latestTweets);
        model.addAttribute("latestTweets", latestTweets);
        return "home";
    }

    @GetMapping("/user/{id}")
    public String showUsersProfile(@PathVariable String id, Model model){
        User user = userRepository.findOne(Long.parseLong(id));
        model.addAttribute("user", user);
        List<Tweet> usersTweets = tweetRepository.findByUserId(Long.parseLong(id));
        Hibernate.initialize(usersTweets);
        model.addAttribute("usersTweets", usersTweets);
        return "user-profile";
    }
}
