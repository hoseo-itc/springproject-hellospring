package itc.hoseo.hellospring.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Member {
	private Integer id;
	private String name;
	private Integer age;
	
	public Member() {}
	
	public Member(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Member(Integer id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
}
