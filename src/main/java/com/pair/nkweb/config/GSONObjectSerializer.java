package com.pair.nkweb.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.gson.JsonObject;

import java.io.IOException;

public class GSONObjectSerializer extends SimpleSerializers {

    private static final long serialVersionUID = -8745250727467996655L;

    private class EmptySerializer extends StdSerializer<Object> {
        private static final long serialVersionUID = 5435498165882848947L;

        protected EmptySerializer(Class t) {
            super(t);
        }

        @Override
        public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeStartObject();
            gen.writeEndObject();

        }
    }

    @Override
    public JsonSerializer<?> findSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc) {

        if(type.isTypeOrSubTypeOf(JsonObject.class)) {
            return new EmptySerializer(type.getRawClass());
        }

        return super.findSerializer(config, type, beanDesc);
    }
}
