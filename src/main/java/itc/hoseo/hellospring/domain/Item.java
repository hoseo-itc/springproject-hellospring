package itc.hoseo.hellospring.domain;

import lombok.Data;

@Data
public class Item {
	private Integer id;
	private String name;
	private int price;
	private int stockQuantity;
	
	public void addStock(int stock) {
		this.stockQuantity += stock;
	}
	
	public void removeStock(int stock) {
		if(this.stockQuantity - stock < 0) {
			throw new RuntimeException("재고 수량이 부족합니다.");
		}
		this.stockQuantity -= stock;
	}
}
