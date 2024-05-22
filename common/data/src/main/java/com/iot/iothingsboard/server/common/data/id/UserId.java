package com.iot.iothingsboard.server.common.data.id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iot.iothingsboard.server.common.data.EntityType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;

@Schema
public class UserId extends UUIDBased implements EntityId{
    @JsonCreator
    public UserId(@JsonProperty("id") UUID id){
        super(id);
    }

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,description = "string",example = "USER",allowableValues = "USER")
    @Override
    public EntityType getEntityType() {
        return EntityType.USER;
    }
}
