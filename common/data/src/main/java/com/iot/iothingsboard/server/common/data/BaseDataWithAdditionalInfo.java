package com.iot.iothingsboard.server.common.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.iot.iothingsboard.server.common.data.id.UUIDBased;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BaseDataWithAdditionalInfo<I extends UUIDBased> extends BaseData<I> implements  HasAdditinalInfo{

    private transient JsonNode addtionalInfo;
    @JsonIgnore
    private byte[] additionalInfoBytes;

    public BaseDataWithAdditionalInfo(){super();}

    public BaseDataWithAdditionalInfo(I id){
        super(id);
    }
    public BaseDataWithAdditionalInfo(BaseDataWithAdditionalInfo<I> baseData){
        super(baseData);

    }

    public void setAdditionalInfo(JsonNode addInfo){
        setJson(addInfo,json->this.addtionalInfo = json,bytes->this.additionalInfoBytes= bytes);
    }

    public static void setJson(JsonNode json, Consumer<JsonNode> jsonConsumer, Consumer<byte[]> byteConsumer){
        jsonConsumer.accept(json);
        try{
            byteConsumer.accept(mapper.writeValueAsBytes(json));
        }catch (JsonProcessingException e){}
    }

    public static JsonNode getJson(Supplier<JsonNode> jsonData, Supplier<byte[]> binaryData){
        JsonNode json =  jsonData.get();
        if(json !=null){
            return json;
        }
        else{
            byte[] data = binaryData.get();
            if(data !=null){
                try{
                    return mapper.readTree(new ByteArrayInputStream(data));
                }catch (IOException e){
                    return null;
                }
            }else{
                return null;
            }
        }
    }

    @Override
    public JsonNode getAdditionalInfo() {
        return getJson(()-> addtionalInfo, ()-> additionalInfoBytes);
    }
}
