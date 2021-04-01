package itc.hoseo.hellospring.repository.impl;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
@Primary
public class H2MemberRepository implements MemberRepository {

    @Autowired
    private DataSource ds;

    @Override
    public Member save(Member member) {
        //TODO :: 회원 저장 기능
        return null;
    }

    @Override
    public List<Member> findAll() {
        //TODO :: 회원 목록 기능
        return null;
    }

    @Override
    public Member findById(String id) {
        //TODO :: ID를 기반으로 회원 검색
        return null;
    }

    @Override
    public void clear() {
        //TODO :: 회원 전체 초기화
    }
}
