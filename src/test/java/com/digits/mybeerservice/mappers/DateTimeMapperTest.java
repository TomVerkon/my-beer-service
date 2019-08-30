package com.digits.mybeerservice.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateTimeMapperTest {

    @BeforeEach
    void setUp() throws Exception {
    }
    
    @Test
    void testDateTimeMapper() {
	Timestamp tsIn = Timestamp.from(Instant.now());
	DateTimeMapper dtMapper = new DateTimeMapper();
	OffsetDateTime odt = dtMapper.timestampToOffsetDateTime(tsIn);
	System.out.println(odt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
	Timestamp tsOut = dtMapper.offsetDateTimeToTimestamp(odt);
	System.out.println("tsIn: " + tsIn.toInstant().toString() + " tsOut: " + tsOut.toInstant().toString());
	assertEquals(0, tsIn.toInstant().compareTo(tsOut.toInstant()));
    }

}
