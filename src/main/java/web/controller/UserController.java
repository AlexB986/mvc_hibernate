package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public String addUser(@RequestParam("user") User user, ModelMap model) {
        userService.addUser(user);
        return "/WEB-INF/user.html";

    }

    @PostMapping("/id")
    public String updateUser(@RequestParam("id") Long id, User user, ModelMap model) {
        userService.updateUser(id, user);
        return "/WEB-INF/user.html";
    }

    @GetMapping("/read/id")
    public String readUser(@RequestParam("id") Long id, ModelMap model) {
        userService.findByIdUser(id);
        return "/WEB-INF/user.html";
    }

    @GetMapping("/read")
    public String readAllUser(ModelMap model) {
        userService.findAllUser();
        return "/WEB-INF/user.html";
    }

    @PostMapping("/delete/id")
    public String deleteUser(@RequestParam("id") Long id, ModelMap model) {
        userService.deleteUser(id);
        return "/WEB-INF/user.html";
    }

}

