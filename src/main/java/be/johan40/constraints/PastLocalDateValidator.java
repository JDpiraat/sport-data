package be.johan40.constraints;

import java.time.LocalDate;
import java.time.temporal.Temporal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PastLocalDateValidator implements ConstraintValidator<PastLocalDate, Temporal> {

	@Override
	public void initialize(PastLocalDate pastLocalDate) {		
	}

	@Override
	public boolean isValid(Temporal temporal, ConstraintValidatorContext constraintValidatorContext) {
		if (temporal == null) {
			return true;
		}
		LocalDate localDate = LocalDate.from(temporal);
		if (localDate.isBefore(LocalDate.now())) {
			return true;
		}
		return false;
	}

}
