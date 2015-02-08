package be.johan40.dao.util;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalTimeToTimeConverter implements AttributeConverter<LocalTime, Time> {

	@Override
	public Time convertToDatabaseColumn(LocalTime localTime) {		
		return Time.valueOf(localTime);
	}

	@Override
	public LocalTime convertToEntityAttribute(Time time) {		
		return time.toLocalTime();
	}

}
