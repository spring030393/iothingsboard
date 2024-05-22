package com.iot.iothingsboard.server.common.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot.iothingsboard.server.common.data.id.IdBased;
import com.iot.iothingsboard.server.common.data.id.UUIDBased;

import java.io.Serializable;

public abstract class BaseData<I extends UUIDBased> extends IdBased<I> implements Serializable {
    protected long createdTime;
    public static final ObjectMapper mapper= new ObjectMapper();

    public BaseData(){super();}

    public BaseData(I id){
        super(id);
    }

    public BaseData(BaseData<I> data){
        super(data.getId());
        this.createdTime = data.getCreatedTime();
    }

    public long getCreatedTime(){return createdTime;}

    public void setCreatedTime( long createdTime){
        this.createdTime = createdTime;
    }
}