package itc.hoseo.hellospring;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BeanValidationTests {

	@Autowired
	private MemberService memberService;

	@Test
	void memberValidation() {

		final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		final Member member = Member.builder()
				.id("")
				.password("123")
				.name(null)
				.build();

		final Set<ConstraintViolation<Member>> constraintViolations = validator.validate(member);

		assertEquals(3, constraintViolations.size());
		assertEquals("공백일 수 없습니다",constraintViolations.iterator().next().getMessage());
	}

	@Test
	void memberValidationWithService() {

		final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

		final Member member = Member.builder()
				.id("kimdogo")
				.password("123")
				.name("doge")
				.build();

		assertThrows(ConstraintViolationException.class,() ->{
			memberService.join(member);
		});
	}

}
