package itc.hoseo.hellospring.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
public class Member {
	private Integer seq;
	private String id;
	private String name;
	private String password;
	private Integer age;
	
	public Member() {}
	
	public Member(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public Member(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Member(Integer seq, String id, String name, String password, Integer age) {
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
	
	
	
}
