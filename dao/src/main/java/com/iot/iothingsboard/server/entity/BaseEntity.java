package com.iot.iothingsboard.server.entity;

import java.util.UUID;

public interface BaseEntity<D> extends ToData<D>{
    UUID getUuid();
    void setUuid(UUID id);
    long getCreatedTime();
    void setCreatedTime(long createdTime);
}
