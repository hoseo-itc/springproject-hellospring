package itc.hoseo.hellospring.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import itc.hoseo.hellospring.domain.Interest;
import itc.hoseo.hellospring.repository.InterestRepository;

@Repository
public class H2InterestRepository implements InterestRepository{
	
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void save(Interest interest) {
		template.update("insert into interest values(?,?)", 
				interest.getId(), interest.getName());
	}
	
	@Override
	public List<Interest> findById(String id){
		return template.query("select * from interest where id = ?"
				,new BeanPropertyRowMapper<Interest>(Interest.class)
				,id);
	}

}
