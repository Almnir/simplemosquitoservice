package org.almkg.models;

/**
 * Created by yarnykh on 26.01.2016.
 */
public class DeviceGroup {

    public static final String TABLE_NAME = "devicegroup";

    public static final String ID_FIELD = "devicegroup_id";
    public static final String DEVICE_GROUPNAME_FIELD = "groupname";
    public static final String USER_FIELD = "user_id";

    private int deviceGroupId;

    private String deviceGroupName;

    private int userId;

    public DeviceGroup(int deviceGroupId, String deviceGroupName, int userId) {
        this.deviceGroupId = deviceGroupId;
        this.deviceGroupName = deviceGroupName;
        this.userId = userId;
    }

    public String getDeviceGroupName() {
        return deviceGroupName;
    }

    public void setDeviceGroupName(String deviceGroupName) {
        this.deviceGroupName = deviceGroupName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
