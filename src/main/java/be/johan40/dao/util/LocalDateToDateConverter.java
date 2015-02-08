package be.johan40.dao.util;



import java.time.LocalDate;
import java.sql.Date;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateToDateConverter implements
		AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate localDate) {
		return null == localDate ? null : Date.valueOf(localDate);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date date) {
		return null == date ? null : date.toLocalDate();
	}

}
