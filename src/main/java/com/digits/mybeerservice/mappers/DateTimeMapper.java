package com.digits.mybeerservice.mappers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Component;

@Component
public class DateTimeMapper {

    public Timestamp offsetDateTimeToTimestamp(OffsetDateTime offsetDateTime) {
	if (null != offsetDateTime) {
	    return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
	} else {
	    return null;
	}
    }

    public OffsetDateTime timestampToOffsetDateTime(Timestamp ts) {
	if (null != ts) {
	    LocalDateTime ldt = ts.toLocalDateTime();
	    return OffsetDateTime.of(ldt.getYear(), ldt.getMonthValue(), ldt.getDayOfMonth(), ldt.getHour(),
		    ldt.getMinute(), ldt.getSecond(), ldt.getNano(), ZoneOffset.UTC);
	} else {
	    return null;
	}
    }
}