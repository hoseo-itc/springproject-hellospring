package itc.hoseo.hellospring.repository.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import itc.hoseo.hellospring.domain.Item;
import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.ItemRepository;
import itc.hoseo.hellospring.repository.MemberRepository;

public class HashMapItemRepository implements ItemRepository {

	private static HashMapItemRepository instance = new HashMapItemRepository();
	
	private HashMapItemRepository() {}
	
	public static HashMapItemRepository getInstance() {
		return instance;
	}
	
	private Map<Integer, Item> itemMap = new ConcurrentHashMap<>();
	
	public Item save(Item item) {
		final int id = item.getId() == null ? itemMap.size() + 1 : item.getId();
		item.setId(id);
		itemMap.put(id, item);
		
		return item;
	}
	
	
	public List<Item> findAll(){
		return itemMap.values().stream().collect(Collectors.toList());
	}
	
	public Item findById(Integer id){
		return itemMap.get(id);
	}
	
	public void clear() {
		itemMap.clear();
	}
	
}
