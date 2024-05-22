package com.iot.iothingsboard.server.common.data;

import lombok.Getter;

public enum EntityType {
    TENANT(1),
    CUSTOMER(2),
    USER(3,"tb_user");

    @Getter
    private final int protoNumber;
    @Getter
    private final String tableName;

    private final String normalName = org.springframework.util.StringUtils.capitalize(StringUtils.removeStart(name(),"TB_").toLowerCase()
            .replaceAll("_"," "));

    EntityType(int protoNumber) {
        this.protoNumber = protoNumber;
        this.tableName = name().toLowerCase();
    }

    EntityType(int protoNumber, String tableName) {
        this.protoNumber = protoNumber;
        this.tableName = tableName;
    }
}
