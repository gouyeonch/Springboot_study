package com.example.myfisrtproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") //url 연결 요정
    public  String niceToMeetYou(Model model){
        model.addAttribute("username", "gouyeon");
        return "greetings"; //templates/greeting.mustache -> 브라우저로 전송
    }
}

//1 컨트롤러로 선언
//2 반환값 설정
//3 getmapping을 통해 연결시켜주면됨
