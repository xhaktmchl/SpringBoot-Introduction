package hello.springintroduction.controller;

import hello.springintroduction.domain.Member;
import hello.springintroduction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberContorller {

    MemberService memberService;

    @Autowired // DI의존주입
    public MemberContorller(MemberService memberService){
        this.memberService = memberService;
        System.out.println("memberService : " + memberService.getClass()); // 멤버서비스가 AOP프록시 객체인지 확인
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    // 회원가입
    @PostMapping("members/new")
    public String create(MemberForm form){

        //멤버 객체 변환
        Member member = new Member();
        member.setName(form.getName());
        //멤버 생성 요청
        memberService.join(member);
        //리디렉션 페이지
        return "redirect:/";
    }

    /*회원 전체조회*/
    @GetMapping("/members")
    public String list(Model model){ // Model 객체는 컨트롤러의 메소드를 객체로 받는다.
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members); // addAttribute: Model 객체의 내장 메소드로 addAttribute() 웹 화면으로 전송
        // 키:"members" 으로 넘겨줌
        return "members/memberList"; // String 형으로 반환해서 템플릿에서members/memberList주소 웹 화면 파일 찾음
    }
}
