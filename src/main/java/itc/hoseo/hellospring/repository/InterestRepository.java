package itc.hoseo.hellospring.repository;

import java.sql.Connection;
import java.util.List;

import itc.hoseo.hellospring.domain.Interest;

public interface InterestRepository {
	public void save(Interest interest);

	public List<Interest> findById(String id);
}
