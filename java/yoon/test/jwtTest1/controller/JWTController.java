package yoon.test.jwtTest1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yoon.test.jwtTest1.service.JWTService;

@Controller
public class JWTController {

    @Autowired
    private JWTService jwtService;

    @PostMapping("/build")
    public String build(
            @RequestParam("id")String id,
            @RequestParam("password")String password,
            @RequestParam("name")String name,
            Model model
    ){

        if (id.equals("") || password.equals("") || name.equals("")) {
            model.addAttribute("message", "빈칸없이 입력하세요");
            return"main";
        }

        String jwt = jwtService.build(id, password, name);
        /*String[] jwtArr = jwt.split(".");*/
        model.addAttribute("jwt", jwt);
        /*model.addAttribute("header", jwtArr[0]);
        model.addAttribute("payload", jwtArr[1]);
        model.addAttribute("signature", jwtArr[2]);*/
        return "main";
    }

}
