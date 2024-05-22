package com.iot.iothingsboard.server.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.*;

import java.io.IOException;

public class JacksonUtil {
    public static final ObjectMapper OBJECT_MAPPER = JsonMapper.builder()
            .addModule(new Jdk8Module())
            .build();

    public static String toString(Object value){
        try{
            return value !=null? OBJECT_MAPPER.writeValueAsString(value):null;
        }catch(JsonProcessingException e){
            throw new IllegalArgumentException("The given Json object value cannot be transformed to a String: "+ value,e);
        }
    }

    public static JsonNode toJsonNode(String value){
        return toJsonNode(value, OBJECT_MAPPER);
    }

    private static JsonNode toJsonNode(String value, ObjectMapper mapper){
        if(value == null || value.isEmpty()){
            return null;
        }
        try{
            return mapper.readTree(value);
        }catch (IOException e){
            throw new IllegalArgumentException(e);
        }
    }
}
