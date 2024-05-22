package com.iot.iothingsboard.server.common.data.id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.UUID;

public abstract class IdBased<I extends UUIDBased> implements HasId<I> {
    protected I id;

    public IdBased(){super();}

    public IdBased(I id){
        super();
        this.id = id;
    }
    @JsonSetter
    public void setId(I id){
        this.id = id;
    }

    public I getId(){
        return this.id;
    }

    @JsonIgnore
    public UUID getuidId(){
        if(id !=null){
            return id.getId();
        }
        return null;
    }


}
