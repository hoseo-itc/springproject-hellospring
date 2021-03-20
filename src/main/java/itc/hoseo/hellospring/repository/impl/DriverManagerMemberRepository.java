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
 * 
 * CREATE TABLE IF NOT EXISTS member ( id int auto_increment, name varchar(255)
 * not null, age int not null, primary key(id) );
 * 
 * 
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

		final String INSERT_SQL = "INSERT INTO MEMBER (NAME, AGE) VALUES(?,?)";

		try (Connection con = DriverManager.getConnection(JDBC_URL, USER_NAME, "");
				PreparedStatement pstmt = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, member.getName());
			pstmt.setInt(2, member.getAge());

			pstmt.executeUpdate();

			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				rs.next();
				member.setId(rs.getInt(1));
			}

		} catch (SQLException sqlE) {
			throw new RuntimeException("회원 가입중 오류가 발생했습니다.", sqlE);
		}

		return member;
	}

	public List<Member> findAll() {
		final String SQL = "SELECT * FROM MEMBER";
		List<Member> result = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(JDBC_URL, USER_NAME, "");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(SQL)) {

			while (rs.next()) {
				// id, name ,age
				result.add(new Member(rs.getInt("id"), rs.getString("name"), rs.getInt("age")));
			}
		} catch (SQLException sqlE) {
			throw new RuntimeException("회원 가입중 오류가 발생했습니다.", sqlE);
		}

		return result;
	}

	public Member findById(Integer id) {
		// TODO :: DB에서 특정 ID 회원 조회
		throw new IllegalStateException("구현되지 않은 기능입니다.");
	}

	public void clear() {
		final String SQL = "TRUNCATE TABLE MEMBER";

		try (Connection con = DriverManager.getConnection(JDBC_URL, USER_NAME, "");
				Statement stmt = con.createStatement();) {
			stmt.executeUpdate(SQL);
		} catch (SQLException sqlE) {
			throw new RuntimeException("회원 가입중 오류가 발생했습니다.", sqlE);
		}
	}

//	@Override
//	public List<Member> findByName(String name) {
//		final String INSERT_SQL = "SELECT * FROM MEMBER WHERE NAME LIKE CONCAT('%', ?, '%')";
//		List<Member> result = new ArrayList<>();
//
//		try (Connection con = DriverManager.getConnection(JDBC_URL, USER_NAME, "");
//				PreparedStatement pstmt = con.prepareStatement(INSERT_SQL)) {
//			pstmt.setString(1, name);
//
//			try (ResultSet rs = pstmt.executeQuery()) {
//				while (rs.next()) {
//					result.add(new Member(rs.getInt("id"), rs.getString("name"), rs.getInt("age")));
//				}
//			}
//
//		} catch (SQLException sqlE) {
//			throw new RuntimeException("회원 가입중 오류가 발생했습니다.", sqlE);
//		}
//
//		return result;
//	}

}
