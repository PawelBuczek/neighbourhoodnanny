package pl.sdacademy.neighbourhoodnanny.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.neighbourhoodnanny.babysitter.Babysitter;
import pl.sdacademy.neighbourhoodnanny.babysitter.BabysitterRepository;
import pl.sdacademy.neighbourhoodnanny.users.User;
import pl.sdacademy.neighbourhoodnanny.users.UserRepository;

import javax.mail.MessagingException;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/mailer")
public class MailApi {
    BabysitterRepository babysitterRepository;
    UserRepository userRepository;
    private final MailService mailService;

    @Autowired
    public MailApi(MailService mailService, BabysitterRepository babysitterRepository, UserRepository userRepository) {
        this.mailService = mailService;
        this.babysitterRepository=babysitterRepository;
        this.userRepository=userRepository;
    }

    @GetMapping("/RemindPassword/{email}")
    public String sendMail(@PathVariable String email) throws MessagingException {
        TokenGenerator tokenGenerator = new TokenGenerator();
        String token = tokenGenerator.generate();
        Babysitter babysitter = babysitterRepository.findByEmail(email).orElse(null);
        assert babysitter != null;
        User user = babysitter.getUser();
        assert user != null;
        user.setPassword(token);
        userRepository.save(user);

        mailService.sendMail(babysitter.getEmail(),
                "Przypomnienie hasla dla: " + user.getUsername(),
                "<b>Twoja rola to: </b>" + user.getRole()  +"<br><b>Twoj kod zmiany hasła to: </b>" + user.getPassword(), true);
        return "wysłano";
    }
    @PostMapping("/RemindPassword")
    public PasswordTokenDTO resetPassword(@RequestBody PasswordTokenDTO passwordTokenDTO) {
        User user = userRepository.findByPassword(passwordTokenDTO.getToken()).orElse(null);
        assert user != null;
        user.setPassword(passwordTokenDTO.getPassword());
        userRepository.save(user);
        return passwordTokenDTO;
    }

}
