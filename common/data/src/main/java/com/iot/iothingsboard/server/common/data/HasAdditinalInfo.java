package com.iot.iothingsboard.server.common.data;

import com.fasterxml.jackson.databind.JsonNode;

public interface HasAdditinalInfo {
    JsonNode getAdditionalInfo();
}
