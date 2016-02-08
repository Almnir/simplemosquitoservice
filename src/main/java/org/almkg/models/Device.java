package org.almkg.models;

import java.time.Instant;

/**
 * Created by yarnykh on 26.01.2016.
 */
public class Device {

    public static final String TABLE_NAME = "devices";

    public static final String ID_FIELD = "device_id";
    public static final String PASSWORD_FIELD = "passwd";
    public static final String DEVICE_DATE_FIELD = "device_date";
    public static final String UPDATE_DATE_FIELD = "update_date";
    public static final String DEVICE_MODE_FIELD = "device_mode";
    public static final String TIMER_1_START_FIELD = "timer1start";
    public static final String TIMER_1_STOP_FIELD = "timer1stop";
    public static final String TIMER_2_START_FIELD = "timer2start";
    public static final String TIMER_2_STOP_FIELD = "timer2stop";
    public static final String FLOW_RATE_FIELD = "flowrate";
    public static final String FLOW_ENABLED_FIELD = "flow_enabled";
    public static final String PREDICTION_FIELD = "prediction";
    public static final String GAS_AVAILABILITY_FIELD = "gas_available";
    public static final String VOLUME_FIELD = "volume";
    public static final String REDUCER_TYPE_FIELD = "reducer_type";
    public static final String LIGHT_ENABLED_FIELD = "light_enabled";

    private long deviceId;
    private String password;
    private Instant deviceDate;
    private Instant updateDate;
    private String deviceMode;
    private Instant timer1start;
    private Instant timer1stop;
    private Instant timer2start;
    private Instant timer2stop;
    private Integer flowRate;
    private Boolean flowControlEnabled;
    private Integer prediction;
    private Boolean gasAvailability;
    private Integer volume;
    private Integer reducerType;
    private Boolean lightEnabled;

    public Device(DeviceBuilder builder) {
        this.deviceId = builder.deviceId;
        this.password = builder.password;
        this.deviceDate = builder.deviceDate;
        this.updateDate = builder.updateDate;
        this.deviceMode = builder.deviceMode;
        this.timer1start = builder.timer1start;
        this.timer1stop = builder.timer1stop;
        this.timer2start = builder.timer2start;
        this.timer2stop = builder.timer2stop;
        this.flowRate = builder.flowRate;
        this.flowControlEnabled = builder.flowControlEnabled;
        this.prediction = builder.prediction;
        this.gasAvailability = builder.gasAvailability;
        this.volume = builder.volume;
        this.reducerType = builder.reducerType;
        this.lightEnabled = builder.lightEnabled;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Instant getDeviceDate() {
        return deviceDate;
    }
    public void setDeviceDate(Instant deviceDate) {
        this.deviceDate = deviceDate;
    }
    public Instant getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }
    public String getDeviceMode() {
        return deviceMode;
    }
    public void setDeviceMode(String deviceMode) {
        this.deviceMode = deviceMode;
    }
    public Instant getTimer1start() {
        return timer1start;
    }
    public void setTimer1start(Instant timer1start) {
        this.timer1start = timer1start;
    }
    public Instant getTimer1stop() {
        return timer1stop;
    }
    public void setTimer1stop(Instant timer1stop) {
        this.timer1stop = timer1stop;
    }
    public Instant getTimer2start() {
        return timer2start;
    }
    public void setTimer2start(Instant timer2start) {
        this.timer2start = timer2start;
    }
    public Instant getTimer2stop() {
        return timer2stop;
    }
    public void setTimer2stop(Instant timer2stop) {
        this.timer2stop = timer2stop;
    }
    public Integer getFlowRate() {
        return flowRate;
    }
    public void setFlowRate(Integer flowRate) {
        this.flowRate = flowRate;
    }
    public Boolean getFlowControlEnabled() {
        return flowControlEnabled;
    }
    public void setFlowControlEnabled(Boolean flowControlEnabled) {
        this.flowControlEnabled = flowControlEnabled;
    }
    public Integer getPrediction() {
        return prediction;
    }
    public void setPrediction(Integer prediction) {
        this.prediction = prediction;
    }
    public Boolean getGasAvailability() {
        return gasAvailability;
    }
    public void setGasAvailability(Boolean gasAvailability) {
        this.gasAvailability = gasAvailability;
    }
    public Integer getVolume() {
        return volume;
    }
    public void setVolume(Integer volume) {
        this.volume = volume;
    }
    public Integer getReducerType() {
        return reducerType;
    }
    public void setReducerType(Integer reducerType) {
        this.reducerType = reducerType;
    }
    public Boolean getLightEnabled() {
        return lightEnabled;
    }
    public void setLightEnabled(Boolean lightEnabled) {
        this.lightEnabled = lightEnabled;
    }

    public static class DeviceBuilder {
        private long deviceId;
        private String password;
        private Instant deviceDate;
        private Instant updateDate;
        private String deviceMode;
        private Instant timer1start;
        private Instant timer1stop;
        private Instant timer2start;
        private Instant timer2stop;
        private Integer flowRate;
        private Boolean flowControlEnabled;
        private Integer prediction;
        private Boolean gasAvailability;
        private Integer volume;
        private Integer reducerType;
        private Boolean lightEnabled;

        public DeviceBuilder(long deviceId) {
            this.deviceId = deviceId;
        }

        public DeviceBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public DeviceBuilder setDeviceDate(Instant deviceDate) {
            this.deviceDate = deviceDate;
            return this;
        }

        public DeviceBuilder setUpdateDate(Instant updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public DeviceBuilder setDeviceMode(String deviceMode) {
            this.deviceMode = deviceMode;
            return this;
        }

        public DeviceBuilder setTimer1start(Instant timer1start) {
            this.timer1start = timer1start;
            return this;
        }

        public DeviceBuilder setTimer1stop(Instant timer1stop) {
            this.timer1stop = timer1stop;
            return this;
        }

        public DeviceBuilder setTimer2start(Instant timer2start) {
            this.timer2start = timer2start;
            return this;
        }

        public DeviceBuilder setTimer2stop(Instant timer2stop) {
            this.timer2stop = timer2stop;
            return this;
        }

        public DeviceBuilder setFlowRate(Integer flowRate) {
            this.flowRate = flowRate;
            return this;
        }

        public DeviceBuilder setFlowControlEnabled(Boolean flowControlEnabled) {
            this.flowControlEnabled = flowControlEnabled;
            return this;
        }

        public DeviceBuilder setPrediction(Integer prediction) {
            this.prediction = prediction;
            return this;
        }

        public DeviceBuilder setGasAvailability(Boolean gasAvailability) {
            this.gasAvailability = gasAvailability;
            return this;
        }

        public DeviceBuilder setVolume(Integer volume) {
            this.volume = volume;
            return this;
        }

        public DeviceBuilder setReducerType(Integer reducerType) {
            this.reducerType = reducerType;
            return this;
        }

        public DeviceBuilder setLightEnabled(Boolean lightEnabled) {
            this.lightEnabled = lightEnabled;
            return this;
        }

        public Device build() {
            return new Device(this);
        }
    }
}
