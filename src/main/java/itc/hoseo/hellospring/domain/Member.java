package itc.hoseo.hellospring.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class Member {
	private Integer seq;

	@NotBlank
	@Length(max = 64)
	private String id;

	@NotBlank
	private String name;

	@NotBlank
	@Length(min = 9, max = 24)
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
