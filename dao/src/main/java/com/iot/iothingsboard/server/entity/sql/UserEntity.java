package com.iot.iothingsboard.server.entity.sql;

import com.fasterxml.jackson.databind.JsonNode;
import com.iot.iothingsboard.server.common.data.User;
import com.iot.iothingsboard.server.entity.BaseSqlEntity;
import com.iot.iothingsboard.server.model.ModelConstants;
import com.iot.iothingsboard.server.util.mapping.JsonConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name= ModelConstants.USER_PG_HIBERNATE_TABLE_NAME)
public class UserEntity extends BaseSqlEntity<User> {
    @Column(name = ModelConstants.USER_TENANT_ID_PROPERTY)
    private UUID tenantId;
    @Column(name=ModelConstants.USER_CUSTOMER_ID_PROPERTY)
    private UUID customerId;
    @Column(name=ModelConstants.USER_EMAIL_PROPERTY, unique = true)
    private String email;
    @Column(name=ModelConstants.USER_FIRST_NAME_PROPERTY)
    private String firstName;
    @Column(name=ModelConstants.USER_LAST_NAME_PROPERTY)
    private String lastName;
    @Column(name=ModelConstants.PHONE_PROPERTY)
    private String phone;
    @Convert(converter= JsonConverter.class)
    @Column(name=ModelConstants.USER_ADDITIONAL_INFO_PROPERTY)
    private JsonNode additionalInfo;

    @Override
    public UUID getUuid() {
        return null;
    }

    @Override
    public void setUuid(UUID id) {

    }

    @Override
    public long getCreatedTime() {
        return 0;
    }

    @Override
    public void setCreatedTime(long createdTime) {

    }

    @Override
    public User toData() {
        return null;
    }
}
