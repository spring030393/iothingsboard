package com.iot.iothingsboard.server.common.data.id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iot.iothingsboard.server.common.data.EntityType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;
@Schema
public class CustomerId extends UUIDBased implements  EntityId{
    @JsonCreator
    public CustomerId(@JsonProperty("id") UUID id){
        super(id);
    }

    @Override
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "string",  example = "CUSTOMER", allowableValues = "CUSTOMER")
    public EntityType getEntityType(){
        return EntityType.CUSTOMER;
    }
}
