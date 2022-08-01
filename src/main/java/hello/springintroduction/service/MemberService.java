package hello.springintroduction.service;


import hello.springintroduction.domain.Member;
import hello.springintroduction.repository.MemberRepository;
import hello.springintroduction.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository(); //TODO: 인터페이스를 객체로 받아? 왜?

    //회원가입
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    //같은 이름 중복 검사
    private void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체회원 조회
    private List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //회원 id로 단일조회
    private Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
