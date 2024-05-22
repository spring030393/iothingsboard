package com.iot.iothingsboard.server.util.mapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.iot.iothingsboard.server.common.util.JacksonUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class JsonConverter implements AttributeConverter<JsonNode,String> {
    @Override
    public String convertToDatabaseColumn(JsonNode jsonNode) {
        return JacksonUtil.toString(jsonNode);
    }
    @Override
    public JsonNode convertToEntityAttribute(String s) {
        return JacksonUtil.toJsonNode(s);
    }
}
