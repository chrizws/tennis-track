package com.xyz.tennistrack.customSerializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.*;

public class EmptyStringAsDoubleDeserializer extends JsonDeserializer<Double> {

    @Override
    public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
       String value = jsonParser.getText();
       if (value == null || value.isEmpty())
           return 0.0;

         return Double.parseDouble(value);
    }
}
