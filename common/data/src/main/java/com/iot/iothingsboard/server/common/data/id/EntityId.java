package com.iot.iothingsboard.server.common.data.id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.iot.iothingsboard.server.common.data.EntityType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.UUID;

@JsonSerialize
@JsonDeserialize(using = EntityIdDeserializer.class)
@Schema
public interface EntityId extends HasUUID, Serializable {
    UUID NULL_UUID = UUID.fromString("13814000-1dd2-11b2-8080-808080808080");

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,example = "DEVICE")
    EntityType getEntityType();
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,description = "ID of the entity, time-based UUID v1", example="784f394c-42b6-435a-983c-b7beff2784f9")
    UUID getId();
    @JsonIgnore
    default boolean isNullUid(){return NULL_UUID.equals(getId());}
}