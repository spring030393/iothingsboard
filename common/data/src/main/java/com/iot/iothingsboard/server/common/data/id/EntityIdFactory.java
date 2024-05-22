package com.iot.iothingsboard.server.common.data.id;

import com.iot.iothingsboard.server.common.data.EntityType;
import java.util.UUID;

public class EntityIdFactory {

    public static EntityId getByTypeAndUuid(String entityType, String id) {
        return getByTypeAndUuid(EntityType.valueOf(entityType),UUID.fromString(id) );
    }

    public static EntityId getByTypeAndUuid(String entityType,UUID uuid){
        return getByTypeAndUuid(EntityType.valueOf(entityType),uuid);
    }

    public static EntityId getByTypeAndUuid(EntityType type,UUID uuid){
        switch(type){
            case USER:
                return new UserId(uuid);
        }
        throw new IllegalArgumentException("EntityType "+ type + " is not supported!");
    }
}
