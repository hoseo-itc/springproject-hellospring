package itc.hoseo.hellospring.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;

@Repository
@Primary
public class H2MemberRepository implements MemberRepository {

    @Autowired
    private DataSource ds;
    
    @Autowired
    private JdbcTemplate template;

    @Override
    public Member save(Member member) {
    	final String SQL = "INSERT INTO MEMBER(id, name, password, age) values(?,?,?,?)";
    	
    	Connection con = DataSourceUtils.getConnection(ds);
    	try(PreparedStatement pstmt = con.prepareStatement(SQL)){
    		pstmt.setString(1, member.getId());
    		pstmt.setString(2, member.getName());
    		pstmt.setString(3, member.getPassword());
    		pstmt.setInt(4, member.getAge() == null ? 0 : member.getAge());
    		pstmt.executeUpdate(); 		
    	}catch(SQLException sqlE) {
    		throw new RuntimeException("회원 저장중 오류가 발생하였습니다.", sqlE);
    	}
    	
    	DataSourceUtils.releaseConnection(con, ds);
    	
        return member;
    }

    @Override
    public List<Member> findAll() {
    	final String SQL = "SELECT * FROM MEMBER";
    	List<Member> rslt = new ArrayList<Member>();
    	try(Connection con = ds.getConnection();
    			PreparedStatement pstmt = con.prepareStatement(SQL);
    			ResultSet rs = pstmt.executeQuery()){
    		
    		while(rs.next()) {
    			rslt.add(new Member(rs.getInt("seq"),
    					rs.getString("id"),
    					rs.getString("name"),
    					rs.getString("password"),
    					rs.getInt("age")
    					));
    		}
    	}catch(SQLException sqlE) {
    		throw new RuntimeException("회원 목록 조회중 오류가 발생하였습니다.", sqlE);
    	}
        return rslt;
    }

    @Override
    public Member findById(String id) {
    	return template.queryForObject("select * from member where id = ?", 
    			new BeanPropertyRowMapper<Member>(Member.class), id);
    }

    @Override
    public void clear() {
        template.execute("trunacte table member");
    }
}
