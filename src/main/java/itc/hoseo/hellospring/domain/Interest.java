package itc.hoseo.hellospring.domain;

import lombok.Data;

@Data
public class Interest {
	private String id; //해당 회원의  ID
	private String name; //관심분야의 이름
	
	public Interest() {}
	
	public Interest(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	
}
