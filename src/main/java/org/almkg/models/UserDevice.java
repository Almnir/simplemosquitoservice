package org.almkg.models;

import java.util.List;

/**
 * Created by yarnykh on 26.01.2016.
 * Таблица связей, оставлена для информативности и констант
 */
public class UserDevice {

    public static final String TABLE_NAME = "userdevice";

    public static final String ID_FIELD = "user_id";
    public static final String DEVICES_FIELD = "devices";
    public static final String DEVICE_GROUP_FIELD = "device_group";

    private int userId;

    private List<Device> devices;

    private DeviceGroup deviceGroup;

    public UserDevice(int userId, List<Device> devices, DeviceGroup deviceGroup) {
        this.userId = userId;
        this.devices = devices;
        this.deviceGroup = deviceGroup;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public DeviceGroup getDeviceGroup() {
        return deviceGroup;
    }

    public void setDeviceGroup(DeviceGroup deviceGroup) {
        this.deviceGroup = deviceGroup;
    }
}
