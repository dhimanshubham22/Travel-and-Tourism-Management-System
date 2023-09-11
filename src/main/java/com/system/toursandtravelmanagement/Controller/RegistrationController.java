package com.system.toursandtravelmanagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.toursandtravelmanagement.DTO.UserRegisteredDTO;
import com.system.toursandtravelmanagement.service.DefaultUserService;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

	 private DefaultUserService userService;

	    public RegistrationController(DefaultUserService userService) {
	        super();
	        this.userService = userService;
	    }

	    @ModelAttribute("user")
	    public UserRegisteredDTO userRegistrationDto() {
	        return new UserRegisteredDTO();
	    }

	    @GetMapping
	    public String showRegistrationForm() {
	        return "register";
	    }

@PostMapping
public String registerUserAccount(@ModelAttribute("user") UserRegisteredDTO registrationDto, BindingResult result) {
    if (result.hasErrors()) {
        // Validation failed; return to the registration form with error messages
        return "register";
    }
    userService.save(registrationDto);
    return "redirect:/login";
}
}