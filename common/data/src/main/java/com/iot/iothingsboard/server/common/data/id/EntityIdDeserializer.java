package com.iot.iothingsboard.server.common.data.id;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

public class EntityIdDeserializer extends JsonDeserializer<EntityId> {
    @Override
    public EntityId deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectCodec oc = jsonParser.getCodec();
        ObjectNode node = oc.readTree(jsonParser);
        if(node.has("entityType") && node.has("id")){
            return EntityIdFactory.getByTypeAndUuid(node.get("entityType").asText(),node.get("id").asText());
        }
        else{
            throw new IOException("Missing entityType or id!");
        }
    }
}
