package com.iot.iothingsboard.server.common.data.id;

import java.io.Serializable;

public interface HasId <I extends HasUUID> extends Serializable {
    I getId();
}
