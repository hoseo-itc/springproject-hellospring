package itc.hoseo.hellospring.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class Member {
	private Integer id;
	private String name;
	private Integer age;
	
	public Member() {}
	
	public Member(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}



	public Member(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
}
