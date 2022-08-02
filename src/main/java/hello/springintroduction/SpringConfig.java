//package hello.springintroduction;
//
//import hello.springintroduction.repository.MemberRepository;
//import hello.springintroduction.repository.MemoryMemberRepository;
//import hello.springintroduction.service.MemberService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration // 스프링 ioc 컨테이너에 직접 bean등록
//public class SpringConfig {
//
//    @Bean // bean직접 등록
//    public MemberService memberService(){
//        return new MemberService(memberRepository()); // 의존주입 직접해줌
//    }
//
//    @Bean // bean직접 등록
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
//}
