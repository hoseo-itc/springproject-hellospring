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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;

@Repository
@Primary
public class H2MemberRepository implements MemberRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public Member save(Member member) {
    	template.update("insert into member(id,name,password,age) values(?,?,?,?)",
    			member.getId(), member.getName(), member.getPassword(), member.getAge());
    	return findById(member.getId());
    }

    @Override
    public List<Member> findAll() {
    	return template.query("select * from member",
    			new BeanPropertyRowMapper<Member>(Member.class));
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
