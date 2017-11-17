package me.aruna.week6challange.Controllers;

import me.aruna.week6challange.UserData;
import me.aruna.week6challange.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

public class HomeController {

    @Autowired
    private UserService userService;


    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegistrationPages(Model model){
        model.addAttribute("userData", new UserData());
        return "registration";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String processRegistrationPages(@Valid @ModelAttribute("userData") UserData userData, BindingResult result, Model model){
        model.addAttribute("userData", userData);
        System.out.println(result.toString());
        if(result.hasErrors()){
            return "registration";
        }
        else{
            userService.saveUser(userData);
            model.addAttribute("message", "User Account Successfully Created");
        }
        return "register";
    }
    @RequestMapping("/")
    public String showMainPage(Principal p) {

        return "login";
    }

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    @RequestMapping("/deposit")
    public String showPageOne(Model model)
    {
        model.addAttribute("title","Deposit");
        model.addAttribute("deposit");
        return "deposit";
    }


//    @GetMapping("/register")
//    public String showRegistrationPage(Model model)
//    {
//        model.addAttribute("userData",new UserData());
//        return "register";
//    }

    //    @PostMapping("/register")
//    public String processRegistrationPage(@Valid @ModelAttribute("userData") UserData userData,
//                                          BindingResult bindingresult, Model model)
//    {
//        model.addAttribute("userData", userData);
//        System.out.println(bindingresult);
//        if(bindingresult.hasErrors()){
//            return "registration";
//        }
//        else{
//            userService.saveUser(userData);
//            model.addAttribute("message", "User Account Successfully Created");
//        }
//        return "index";
//    }
    @RequestMapping("/withdraw")
    public String showWithdraw(Model model)
    {
        model.addAttribute("title","withdraw");
        model.addAttribute("withdraw");
        return "withdraw";
    }

    @RequestMapping("/transaction")
    public String showTransaction(Model model)
    {
        model.addAttribute("title","transaction");
        model.addAttribute("transaction");
        return "transaction";
    }


}
