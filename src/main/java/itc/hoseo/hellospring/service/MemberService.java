package itc.hoseo.hellospring.service;

import itc.hoseo.hellospring.domain.Interest;
import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.InterestRepository;
import itc.hoseo.hellospring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final InterestRepository interestRepository;


    @Transactional
    public void join(Member member, Interest... interests){
        memberRepository.save(member);

        if(interests.length == 0){
            throw new RuntimeException("한개 이상의 관심분야를 선택하여주세요.");
        }

        for(Interest interest : interests){
            interestRepository.save(interest);
        }
    }

}
