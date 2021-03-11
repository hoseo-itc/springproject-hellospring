package itc.hoseo.hellospring.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;

/**
 * DriverManager를 이용하여 Member 를 저장하고 관리하는 클래스
 * 
 * 
 
 CREATE TABLE IF NOT EXISTS member (
 id int auto_increment,
 name varchar(255) not null,
 age int not null,
 primary key(id)
);


 * jdbcurl : jdbc:h2:tcp://localhost/~/hellospring username : sa
 * 
 * @author PJH
 *
 */
public class DriverManagerMemberRepository implements MemberRepository {

	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/hellospring";
	private final String USER_NAME = "sa";

	private static DriverManagerMemberRepository instance = new DriverManagerMemberRepository();

	private DriverManagerMemberRepository() {
	}

	public static DriverManagerMemberRepository getInstance() {
		return instance;
	}

	public Member save(Member member) {

		try (Connection con = DriverManager.getConnection(JDBC_URL, USER_NAME, "");
				PreparedStatement pstmt = con.prepareStatement("insert into member(name, age) values(?,?)",
						Statement.RETURN_GENERATED_KEYS);) {
			pstmt.setString(1, member.getName());
			pstmt.setInt(2, member.getAge());
			pstmt.executeUpdate();

			// 자동 생성된 PK를 가져옴
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				if (rs.next()) {
					member.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}

	public List<Member> findAll() {
		List<Member> rslt = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(JDBC_URL, USER_NAME, "");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from member")) {

			while (rs.next()) {
				Member m = new Member(rs.getInt(1), rs.getString(2), rs.getInt(3));
				rslt.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rslt;
	}

	public Member findById(Integer id) {
		Member findMember = null;
		try (Connection con = DriverManager.getConnection(JDBC_URL, USER_NAME, "");
				PreparedStatement pstmt = con.prepareStatement("select * from member where id = ?");) {
			pstmt.setInt(1, id);
			
			
			try(ResultSet rs = pstmt.executeQuery()){
				while (rs.next()) {
					findMember = new Member(rs.getInt(1), rs.getString(2), rs.getInt(3));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return findMember;
	}

	public void clear() {
		try (Connection con = DriverManager.getConnection(JDBC_URL, USER_NAME, "");
				PreparedStatement pstmt = con.prepareStatement("delete from member")) {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
