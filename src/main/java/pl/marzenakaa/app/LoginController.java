package pl.marzenakaa.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.marzenakaa.app.User.User;
import pl.marzenakaa.repository.TweetRepository;
import pl.marzenakaa.repository.UserRepository;

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

}
