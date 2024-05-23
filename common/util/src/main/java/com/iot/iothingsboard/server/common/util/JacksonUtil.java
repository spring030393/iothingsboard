package com.iot.iothingsboard.server.common.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.*;

import java.io.IOException;

public class JacksonUtil {
    public static final ObjectMapper OBJECT_MAPPER = JsonMapper.builder()
            .addModule(new Jdk8Module())
            .build();

    public static final ObjectMapper PRETTY_SORTED_JSON_MAPPER= JsonMapper.builder()
            .addModule(new Jdk8Module())
            .enable(SerializationFeature.INDENT_OUTPUT)
            .configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true)
            .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
            .build();

    public static final ObjectMapper ALLOW_UNQUOTED_FIELD_NAMES_MAPPER = JsonMapper.builder()
            .addModule(new Jdk8Module())
            .configure(JsonWriteFeature.QUOTE_FIELD_NAMES.mappedFeature(),false)
            .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,true)
            .build();

    public static final ObjectMapper IGNORE_UNKNOWN_PROPERTIES_JSON_MAPPER=JsonMapper.builder()
            .addModule(new Jdk8Module())
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
            .build();


    public static <T> T convertValue(Object fromValue, Class<T> toValueType){
        try{
            return fromValue !=null ?OBJECT_MAPPER.convertValue(fromValue, toValueType): null;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("The given object value cannot be converted to "+ toValueType + ": " + fromValue,e);
        }
    }

    public static<T> T convertValue(Object fromValue, TypeReference<T> toValueTypeRef){
        try{
            return fromValue !=null ? OBJECT_MAPPER.convertValue(fromValue, toValueTypeRef):null;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("The given object value cannot be converted to "+ toValueTypeRef + ": " + fromValue,e);
        }
    }

    public static String toPrettyString(Object value){
        try{
            return value !=null?PRETTY_SORTED_JSON_MAPPER.writeValueAsString(value):null;
        }catch (JsonProcessingException e){
            throw new IllegalArgumentException("The given Json object value cannot be transformed to a String: "+ value, e);
        }
    }

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
