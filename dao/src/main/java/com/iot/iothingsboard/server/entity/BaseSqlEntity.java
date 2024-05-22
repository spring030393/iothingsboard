package com.iot.iothingsboard.server.entity;

import com.iot.iothingsboard.server.common.data.id.CustomerId;
import com.iot.iothingsboard.server.common.data.id.EntityId;
import com.iot.iothingsboard.server.common.data.id.TenantId;
import com.iot.iothingsboard.server.common.data.id.UUIDBased;
import com.iot.iothingsboard.server.model.ModelConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
public abstract class BaseSqlEntity<D> implements BaseEntity<D>{
    @Id
    @Column(name= ModelConstants.ID_PROPERTY,columnDefinition = "uuid")
    protected UUID id;
    @Column(name=ModelConstants.CREATED_TIME_PROPERTY, updatable = false)
    protected long createdTime;

    @Override
    public UUID getUuid(){return id;}
    @Override
    public void setUuid(UUID id){this.id = id;}

    @Override
    public long getCreatedTime(){return createdTime;}
    @Override
    public void setCreatedTime(long createdTime){
        if(createdTime >0){
            this.createdTime = createdTime;
        }
    }

    protected static UUID getUuid(UUIDBased uuidBased){
        if(uuidBased !=null){
            return uuidBased.getId();
        }
        else{
            return null;
        }
    }

    protected static UUID getTenantUuid(TenantId tenantId){
        if(tenantId !=null){
            return tenantId.getId();
        }
        else{
            return EntityId.NULL_UUID;
        }
    }

    protected static UUID getCustomerUuid(CustomerId customerId){
        if(customerId !=null){
            return customerId.getId();
        }
        else{
            return EntityId.NULL_UUID;
        }
    }
}
