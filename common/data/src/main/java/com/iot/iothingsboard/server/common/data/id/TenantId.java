package com.iot.iothingsboard.server.common.data.id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iot.iothingsboard.server.common.data.EntityType;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.util.ConcurrentReferenceHashMap;

import java.util.UUID;

public final class TenantId extends UUIDBased implements EntityId  {

    @JsonIgnore
    static final ConcurrentReferenceHashMap<UUID,TenantId>tenants = new ConcurrentReferenceHashMap<>(16, ConcurrentReferenceHashMap.ReferenceType.SOFT);
    @JsonIgnore
    public static final TenantId SYS_TENANT_ID=TenantId.fromUUID(EntityId.NULL_UUID);

    @JsonCreator
    public static TenantId fromUUID(@JsonProperty("id") UUID id){
        return tenants.computeIfAbsent(id,TenantId::new);
    }

    public TenantId(UUID id){
        super(id);
    }

    @JsonIgnore
    public boolean isSysTenantId(){
        return this.equals(SYS_TENANT_ID);
    }

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,description = "string", example="TENANT",allowableValues = "TENANT")
    @Override
    public EntityType getEntityType(){
        return EntityType.TENANT;
    }
}
