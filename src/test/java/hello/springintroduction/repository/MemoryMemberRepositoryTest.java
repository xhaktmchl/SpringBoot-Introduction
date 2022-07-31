package hello.springintroduction.repository;

import hello.springintroduction.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*; // static import를 통해 코드 최소화

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    // 테스트 단위 끝날 때 마다 DB초기화
    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    public void save(){
        //given
        Member member = new Member();
        member.setName("name1");

        //when
        memoryMemberRepository.save(member);

        //then
        Member result1 = memoryMemberRepository.findByName("name1").get();
        assertThat(member).isEqualTo(result1); // 같은지 테스트: junit 이 아닌 assertj 라이브러리 것 사용
    }

    @Test
    public void findByName(){
        //given
        Member member1 = new Member();
        member1.setName("name1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("name2");
        memoryMemberRepository.save(member2);

        //when
        Member result1 = memoryMemberRepository.findByName("name1").get();

        //then
        assertThat(result1).isEqualTo(member1); // 같은지 테스트: junit 이 아닌 assertj 라이브러리 것 사용
    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        //when
        List<Member> result1 = memoryMemberRepository.findAll();

        //then
        assertThat(result1.size()).isEqualTo(2);
    }
}
