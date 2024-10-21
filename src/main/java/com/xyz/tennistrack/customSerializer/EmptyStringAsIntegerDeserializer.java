package com.xyz.tennistrack.customSerializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class EmptyStringAsIntegerDeserializer extends JsonDeserializer<Integer> {



    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String value = jsonParser.getText();
        if (value == null || value.isEmpty())
            return 0;

        return Integer.parseInt(value);
    }
}
