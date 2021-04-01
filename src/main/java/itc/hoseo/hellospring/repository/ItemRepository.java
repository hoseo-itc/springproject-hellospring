package itc.hoseo.hellospring.repository;

import java.util.List;

import itc.hoseo.hellospring.domain.Item;
import itc.hoseo.hellospring.domain.Member;

public interface ItemRepository {
	public Item save(Item member);
	
	public List<Item> findAll();
	
	public Item findById(Integer id);
	
	public void clear();
}
