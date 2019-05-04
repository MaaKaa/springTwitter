package pl.marzenakaa.app.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.marzenakaa.app.Tweet.Tweet;
import pl.marzenakaa.repository.TweetRepository;
import pl.marzenakaa.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/logged")
public class LoggedController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping("/{id}")
    public String showUserHomepage(@PathVariable String id, Model model){
        User user = userRepository.findOne(Long.parseLong(id));
        model.addAttribute("user", user);
        Tweet userTweet = new Tweet();
        userTweet.setUser(user);
        model.addAttribute("userTweet", userTweet);
        List<Tweet> tweetsByUser = tweetRepository.findByUserId(Long.parseLong(id));
        model.addAttribute("tweetsByUser", tweetsByUser);
        return "home-logged";
    }

    @PostMapping("/{id}")
    public String processAddUserTweetForm(@PathVariable String id, @ModelAttribute("userTweet") @Valid Tweet tweet, BindingResult result) {
        if (result.hasErrors()) {
            return "/{id}";
        }
        tweetRepository.save(tweet);
        return "redirect: ";
    }

    @GetMapping("/{id}/edit/{tweetId}")
    public String showEditTweetForm(@PathVariable Long id, @PathVariable Long tweetId, Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        Tweet userTweet = tweetRepository.findOne(tweetId);
        userTweet.setUser(user);
        model.addAttribute("userTweet", userTweet);
        List<Tweet> tweetsByUser = tweetRepository.findByUserId(id);
        model.addAttribute("tweetsByUser", tweetsByUser);
        return "home-logged";
    }

    @PostMapping("/{id}/edit/{tweetId}")
    public String processEditTweetForm(@ModelAttribute("userTweet") @Valid Tweet userTweet, BindingResult result) {
        if (result.hasErrors()) {
            return "/{id}/edit/{tweetId}";
        }
        tweetRepository.save(userTweet);
        return "redirect: /logged/{id}";
    }

    @GetMapping("/{id}/delete/{tweetId}")
    public String processDeleteTweet(@PathVariable Long tweetId) {
        tweetRepository.delete(tweetId);
        return "redirect: /logged/{id}";
    }
}
