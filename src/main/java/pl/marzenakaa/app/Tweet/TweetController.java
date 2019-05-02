package pl.marzenakaa.app.Tweet;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.marzenakaa.repository.TweetRepository;
import pl.marzenakaa.repository.UserRepository;

import javax.validation.Valid;
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

    /*@GetMapping("/add")
    public String showAddTweetForm(Model model){
        model.addAttribute("tweet", new Tweet());
        return "add-tweet-form";
    }

    @PostMapping("/add")
    public String processAddTweetForm(@ModelAttribute("tweet") @Valid Tweet tweet, BindingResult result){
        if (result.hasErrors()) {
            return "add-tweet-form";
        }
        tweetRepository.save(tweet);
        return "redirect:all";
    }

    @GetMapping("/edit/{id}")
    public String showEditTweetForm(@PathVariable Long id, Model model) {
        Tweet tweet = tweetRepository.findOne(id);
        model.addAttribute("tweet", tweet);
        return "redirect:all";
    }

    @PostMapping("/edit/{id}")
    public String processEditTweetForm(@ModelAttribute("tweet") @Valid Tweet tweet, BindingResult result) {
        if (result.hasErrors()) {
            return "add-tweet-form";
        }
        tweetRepository.save(tweet);
        return "redirect:all";
    }

    @GetMapping("/delete/{id}")
    public String processDeleteTweet(@PathVariable Long id) {
        tweetRepository.delete(id);
        return "redirect:all";
    }*/


}
