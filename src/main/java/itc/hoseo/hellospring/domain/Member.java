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
}
