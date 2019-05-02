package pl.marzenakaa.app.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.marzenakaa.repository.TweetRepository;
import pl.marzenakaa.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    //REGISTRATION: TO BE FINISHED, WHEN THE LOG-IN WILL BE READY (now it only saves the user's details in the DB)
    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "register-form";
    }

    @PostMapping("/register")
    public String processRegisterForm(@ModelAttribute ("user") @Valid User user, BindingResult result){
        if (result.hasErrors()) {
            return "register-form";
        }
        userRepository.save(user);
        return "redirect: login";
    }



}
