package com.iot.iothingsboard.server.common.data.id;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Kamal Mohan Singh Rana
 */

public abstract class UUIDBased implements HasUUID, Serializable {
    private static final long serialVersionUID = 1L;
    private final UUID id;

    public UUIDBased(){
        this(UUID.randomUUID());
    }

    public UUIDBased(UUID id) {
        super();
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
