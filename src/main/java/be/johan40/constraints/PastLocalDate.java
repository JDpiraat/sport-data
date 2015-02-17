package be.johan40.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PastLocalDateValidator.class)
public @interface PastLocalDate {
	String message() default "{be.vdab.constraints.PastLocalDateConstraint}";
	Class<?>[] groups() default {}; 
	Class<? extends Payload>[] payload() default {};
}
