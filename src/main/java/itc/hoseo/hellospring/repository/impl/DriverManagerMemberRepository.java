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
		// TODO :: DB에 회원 저장
		throw new IllegalStateException("구현되지 않은 기능입니다.");
	}

	public List<Member> findAll() {
		// TODO :: DB에서 회원 전체 목록 조회
		throw new IllegalStateException("구현되지 않은 기능입니다.");
	}

	public Member findById(Integer id) {
		// TODO :: DB에서 특정 ID 회원 조회
		throw new IllegalStateException("구현되지 않은 기능입니다.");
	}

	public void clear() {
		// TODO :: Member 테이블 전체 레코드 삭제
		throw new IllegalStateException("구현되지 않은 기능입니다.");
	}

}
