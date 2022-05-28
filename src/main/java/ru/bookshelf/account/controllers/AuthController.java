package ru.bookshelf.account.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bookshelf.account.mappers.UserMapper;
import ru.bookshelf.account.requests.UserRequest;
import ru.bookshelf.account.services.RegistrationService;
import ru.bookshelf.account.util.UserValidator;

import javax.validation.Valid;

/**
 * @author Raphael Kalimullin <raphaelkalimullin@gmail.com>
 */
@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;
    private final UserValidator userValidator;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") UserRequest userRequest) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid UserRequest userRequest, BindingResult bindingResult) {
        userValidator.validate(userRequest, bindingResult);

        if (bindingResult.hasErrors())
            return "/auth/registration";

        registrationService.register(UserMapper.toModel(userRequest));

        return "redirect:/auth/login";
    }
}
