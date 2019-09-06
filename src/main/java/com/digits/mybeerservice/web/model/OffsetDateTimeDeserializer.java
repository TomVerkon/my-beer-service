package com.digits.mybeerservice.web.model;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class OffsetDateTimeDeserializer extends StdDeserializer<OffsetDateTime> {

    protected OffsetDateTimeDeserializer() {
	super(OffsetDateTime.class);
    }

    @Override
    public OffsetDateTime deserialize(JsonParser parser, DeserializationContext ctxt)
	    throws IOException, JsonProcessingException {
	return OffsetDateTime.parse(parser.readValueAs(String.class), DateTimeFormatter.ISO_DATE_TIME);
    }

}
