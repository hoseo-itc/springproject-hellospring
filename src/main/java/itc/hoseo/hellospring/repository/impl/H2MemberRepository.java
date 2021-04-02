package itc.hoseo.hellospring.repository.impl;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class H2MemberRepository implements MemberRepository {

    @Autowired
    private DataSource ds;

    @Override
    public Member save(Member member) {

        final String SQL = "INSERT INTO MEMBER(id, name, password, age) values(?,?,?,?)";

        try (Connection con = DataSourceUtils.getConnection(ds);
             PreparedStatement pstmt = con.prepareStatement(SQL)) {
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getPassword());
            pstmt.setInt(4, member.getAge() == null ? 0 : member.getAge());

            pstmt.executeUpdate();

        } catch (SQLException sqlE) {
            throw new RuntimeException("회원 저장중 에외 발생", sqlE);
        }

        return member;
    }

    @Override
    public List<Member> findAll() {
        List<Member> rslt = new ArrayList<>();
        final String SQL = "SELECT * FROM MEMBER";

        try (Connection con = DataSourceUtils.getConnection(ds);
             PreparedStatement pstmt = con.prepareStatement(SQL);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                rslt.add(new Member(rs.getInt("seq"), rs.getString("id"), rs.getString("name"), rs.getString("password"), rs.getInt("age")));
            }
        } catch (SQLException sqlE) {
            throw new RuntimeException("회원 저장중 에외 발생", sqlE);
        }
        return rslt;
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
