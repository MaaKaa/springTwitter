package pl.marzenakaa.app.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.marzenakaa.app.Tweet.Tweet;
import pl.marzenakaa.repository.TweetRepository;
import pl.marzenakaa.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    //LOG-IN: TO DO (now it's only a form)
    //WZÓR: https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("user", new User());
        return "login-form";
    }

    @PostMapping("/login/{id}")
    public String processLoginForm(@PathVariable Long id, @ModelAttribute User user){
        userRepository.save(user);
        return "home-logged";
    }

    //LOGGED USER'S ACTIONS:
    @GetMapping("/logged/{id}")
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

    @PostMapping("/logged/{id}")
    public String processAddUserTweetForm(@PathVariable String id, @ModelAttribute("userTweet") @Valid Tweet tweet, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect: ";
        }
        tweetRepository.save(tweet);
        return "redirect: ";
    }

    /*@GetMapping("/logged/{id}/edit/{id}")
    public String showEditTweetForm(@PathVariable Long id, Model model) {
        Tweet tweet = tweetRepository.findOne(id);
        model.addAttribute("tweet", tweet);
        return "home-logged";
    }

    @PostMapping("/logged/{id}/edit/{id}")
    public String processEditTweetForm(@ModelAttribute("tweet") @Valid Tweet tweet, BindingResult result) {
        if (result.hasErrors()) {
            return "home-logged";
        }
        tweetRepository.save(tweet);
        return "redirect: ";
    }

    @GetMapping("/logged/{id}/delete/{id}")
    public String processDeleteTweet(@PathVariable Long id) {
        tweetRepository.delete(id);
        return "redirect: ";
    }*/
}
