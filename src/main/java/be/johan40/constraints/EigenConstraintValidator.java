package be.johan40.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EigenConstraintValidator implements
		ConstraintValidator<EigenConstraint, Integer> {

	@Override
	public void initialize(EigenConstraint entity) {
	}

	@Override
	public boolean isValid(Integer entity, ConstraintValidatorContext context) {
		// TODO wat controle 
		// ff checken maar ik dacht dat hier bv null oke is als input (of zelfs moet zijn), daarvoor heb je namelijk de @notNull
		return true;

	}

}
