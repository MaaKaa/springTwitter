package pl.marzenakaa.app.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.marzenakaa.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "register-form";
    }

    //Dodać widok z komunikatem o tym, że użytkownik został poprawnie zapisany do bazy:
    @PostMapping("/register")
    public String processRegisterForm(@ModelAttribute ("user") @Valid User user, BindingResult result){
        if (result.hasErrors()) {
            return "register-form";
        }
        userRepository.save(user);
        return "register-form";
    }

    //Logowanie: do zrobienia.
    //WZÓR: https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("user", new User());
        return "login-form";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute User user){
        userRepository.save(user);
        return "Użytkownik zapisany!";
    }
}
