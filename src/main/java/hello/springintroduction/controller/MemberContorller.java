package hello.springintroduction.controller;

import hello.springintroduction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberContorller {

    MemberService memberService;

    @Autowired // DI의존주입
    public MemberContorller(MemberService memberService){
        this.memberService = memberService;
    }
}
