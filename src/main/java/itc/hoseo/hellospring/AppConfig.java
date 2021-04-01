package itc.hoseo.hellospring;

import itc.hoseo.hellospring.repository.ItemRepository;
import itc.hoseo.hellospring.repository.impl.HashMapItemRepository;

public class AppConfig {

	public ItemRepository itemRepository() {
		return HashMapItemRepository.getInstance();
	}
	
	//public 
}
