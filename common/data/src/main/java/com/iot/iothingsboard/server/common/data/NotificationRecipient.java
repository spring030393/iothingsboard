package com.iot.iothingsboard.server.common.data;

public interface NotificationRecipient {
    Object getId();
    String getTitle();
    default String getFirstName(){return null;}
    default String getLastName(){return null;}
    default String getEmail(){return null;}
}
