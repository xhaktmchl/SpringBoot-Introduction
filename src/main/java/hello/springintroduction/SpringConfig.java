package hello.springintroduction;

import hello.springintroduction.repository.JdbcMemberRepository;
import hello.springintroduction.repository.JdbcTemplateMemberRepository;
import hello.springintroduction.repository.MemberRepository;
import hello.springintroduction.repository.MemoryMemberRepository;
import hello.springintroduction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration // 스프링 ioc 컨테이너에 직접 bean등록
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean // bean직접 등록
    public MemberService memberService(){
        return new MemberService(memberRepository()); // 의존주입 직접해줌
    }

    @Bean // bean직접 등록
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
