package org.almkg.models;

import java.time.Instant;

/**
 * Created by yarnykh on 26.01.2016.
 */
public class DeviceCommand {

    public static final String TABLE_NAME = "DeviceSetCommand";

//    public static final String ID_FIELD = "command_id";
    public static final String COMMAND_START_FIELD = "command_start";
    public static final String COMMAND_END_FIELD = "command_end";
    public static final String DEVICE_DATE_FIELD = "device_date";

//    private int commandId;

    private Instant commandStartTime;

    private Instant commandEndTime;

    private Instant deviceDate;

    public Instant getCommandStartTime() {
        return commandStartTime;
    }

    public void setCommandStartTime(Instant commandStartTime) {
        this.commandStartTime = commandStartTime;
    }

    public Instant getCommandEndTime() {
        return commandEndTime;
    }

    public void setCommandEndTime(Instant commandEndTime) {
        this.commandEndTime = commandEndTime;
    }

    public Instant getDeviceDate() {
        return deviceDate;
    }

    public void setDeviceDate(Instant deviceDate) {
        this.deviceDate = deviceDate;
    }

}
