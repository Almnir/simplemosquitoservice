package org.almkg.models;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by yarnykh on 26.01.2016.
 */
public class Device {

    public static final String TABLE_NAME = "Device";

    public static final String ID_FIELD = "DeviceID";
    public static final String PASSWORD_FIELD = "password";
    public static final String PASSWORD_SALT_FIELD = "salt";
    public static final String DEVICE_DATE_FIELD = "deviceDate";    //Системная дата утр-ва
    public static final String DEVICE_TIME_FIELD = "deviceTime";    //Системное время утр-ва
    public static final String UPDATE_TIME_TIMESTAMP_FIELD = "timeUpdatedTimestamp";    //метка времени получения системного времени утройства
    public static final String UPDATE_DATA_TIMESTAMP_FIELD = "updatedTimestamp";    //метка времени получения пакета данных
    public static final String DEVICE_MODE_FIELD = "deviceMode";    //Режим работы (по таймеру/ручной)
    public static final String TIMER_1_START_FIELD = "timer1start";
    public static final String TIMER_1_STOP_FIELD = "timer1stop";
    public static final String TIMER_2_START_FIELD = "timer2start";
    public static final String TIMER_2_STOP_FIELD = "timer2stop";
    public static final String FLOW_RATE_MODE_FIELD = "flowRateMode";        //режим расхода газа (50%,100%,200%)
    public static final String FLOW_CONTROL_ENABLED_FIELD = "flowControlEnabled";    //включен/выключен контоль расхода газа
    public static final String GAS_AVAILABILITY_PREDICTION_FIELD = "gasAvailabilityPrediction"; //на сколько хватит газа в баллоне
    public static final String GAS_AVAILABILITY_FIELD = "gasAvailability";  //Газ в баллоне есть/нет
    public static final String GAS_CYLINDER_VOLUME_FIELD = "gasCylinderVolume"; //Объём газового баллона
    public static final String REDUCER_TYPE_FIELD = "reducerType";  //Тип редуктора (резерв, пока не используется)
    public static final String LIGHT_ENABLE_FIELD = "lightEnabled"; //Подсветка включена/выключена
    public static final String WORKING_TIME_FIELD = "workingTime";  // Время работы системы (uptime)
    public static final String VERSION_FIELD = "version";   // Версия прошивки
    public static final String HEATER_TEMPERATURE_FIELD = "heaterTemperature";  // Температура нагревателя
    public static final String MOTOR_TEMPERATURE_FIELD = "motorTemperature";    // Температура двигателя
    public static final String TEMPERATURE_FIELD = "temperature";   // Температура окружающей среды


    private long deviceId;
    private String password;
    private String salt;
    private Instant deviceDate; //Системная дата утр-ва
    private Instant deviceTime; //Системное время утр-ва
    private Instant updatedTimestamp;   //метка времеи последего пакета с данными
    private Instant timeUpdatedTimestamp;   //метка времени пекета с системным временем устройства
    private String deviceMode;
    private Instant timer1start;
    private Instant timer1stop;
    private Instant timer2start;
    private Instant timer2stop;
    private Integer flowRateMode;
    private Boolean flowControlEnabled;
    private Integer gasAvailabilityPrediction;
    private Boolean gasAvailability;
    private Integer gasCylinderVolume;
    private Integer reducerType;
    private Boolean lightEnabled;
    private Integer workingTime;
    private String version;
    private float heaterTemperature;
    private float motorTemperature;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Device{");
        sb.append("deviceId=").append(deviceId);
        sb.append(", password='").append(password).append('\'');
        sb.append(", salt='").append(salt).append('\'');
        sb.append(", deviceDate=").append(deviceDate);
        sb.append(", deviceTime=").append(deviceTime);
        sb.append(", updatedTimestamp=").append(updatedTimestamp);
        sb.append(", timeUpdatedTimestamp=").append(timeUpdatedTimestamp);
        sb.append(", deviceMode='").append(deviceMode).append('\'');
        sb.append(", timer1start=").append(timer1start);
        sb.append(", timer1stop=").append(timer1stop);
        sb.append(", timer2start=").append(timer2start);
        sb.append(", timer2stop=").append(timer2stop);
        sb.append(", flowRateMode=").append(flowRateMode);
        sb.append(", flowControlEnabled=").append(flowControlEnabled);
        sb.append(", gasAvailabilityPrediction=").append(gasAvailabilityPrediction);
        sb.append(", gasAvailability=").append(gasAvailability);
        sb.append(", gasCylinderVolume=").append(gasCylinderVolume);
        sb.append(", reducerType=").append(reducerType);
        sb.append(", lightEnabled=").append(lightEnabled);
        sb.append(", workingTime=").append(workingTime);
        sb.append(", version='").append(version).append('\'');
        sb.append(", heaterTemperature=").append(heaterTemperature);
        sb.append(", motorTemperature=").append(motorTemperature);
        sb.append(", temperature=").append(temperature);
        sb.append('}');
        return sb.toString();
    }

    private float temperature;

    public Device(DeviceBuilder builder) {
        this.deviceId = builder.deviceId;
        this.password = builder.password;
        this.salt = builder.salt;
        this.deviceDate = builder.deviceDate;
        this.deviceTime = builder.deviceTime;
        this.updatedTimestamp = builder.updatedTimestamp;
        this.timeUpdatedTimestamp = builder.timeUpdatedTimestamp;
        this.deviceMode = builder.deviceMode;
        this.timer1start = builder.timer1start;
        this.timer1stop = builder.timer1stop;
        this.timer2start = builder.timer2start;
        this.timer2stop = builder.timer2stop;
        this.flowRateMode = builder.flowRateMode;
        this.flowControlEnabled = builder.flowControlEnabled;
        this.gasAvailabilityPrediction = builder.gasAvailabilityPrediction;
        this.gasAvailability = builder.gasAvailability;
        this.gasCylinderVolume = builder.gasCylinderVolume;
        this.reducerType = builder.reducerType;
        this.lightEnabled = builder.lightEnabled;
        this.workingTime = builder.workingTime;
        this.version = builder.version;
        this.heaterTemperature = builder.heaterTemperature;
        this.motorTemperature =builder.motorTemperature;
        this.temperature = builder.temperature;
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
    public Instant getDeviceTime() { return deviceTime; }
    public void setDeviceTime(Instant deviceTime) { this.deviceTime = deviceTime; }
    public Instant getUpdatedTimestamp() {
        return updatedTimestamp;
    }
    public void setUpdatedTimestamp(Instant updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }
    public void setTimeUpdatedTimestamp(Instant timeUpdatedTimestamp) {
        this.timeUpdatedTimestamp = timeUpdatedTimestamp;
    }
    public Instant getTimeUpdatedTimestamp() {        return timeUpdatedTimestamp;    }
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
    public Integer getFlowRateMode() {
        return flowRateMode;
    }
    public void setFlowRateMode(Integer flowRateMode) {
        this.flowRateMode = flowRateMode;
    }
    public Boolean getFlowControlEnabled() {
        return flowControlEnabled;
    }
    public void setFlowControlEnabled(Boolean flowControlEnabled) {
        this.flowControlEnabled = flowControlEnabled;
    }
    public Integer getGasAvailabilityPrediction() {
        return gasAvailabilityPrediction;
    }
    public void setGasAvailabilityPrediction(Integer gasAvailabilityPrediction) {
        this.gasAvailabilityPrediction = gasAvailabilityPrediction;
    }
    public Boolean getGasAvailability() {
        return gasAvailability;
    }
    public void setGasAvailability(Boolean gasAvailability) {
        this.gasAvailability = gasAvailability;
    }
    public Integer getGasCylinderVolume() {
        return gasCylinderVolume;
    }
    public void setGasCylinderVolume(Integer volume) {
        this.gasCylinderVolume = volume;
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
    public Integer getWorkingTime() {        return workingTime;    }
    public void setWorkingTime(Integer workingTime) {        this.workingTime = workingTime;    }
    public String getVersion() {        return version;    }
    public void setVersion(String version) {        this.version = version;    }
    public float getHeaterTemperature() {        return heaterTemperature;    }
    public void setHeaterTemperature(float heaterTemperature) {  this.heaterTemperature = heaterTemperature;}
    public float getMotorTemperature() {        return motorTemperature;    }
    public void setMotorTemperature(float motorTemperature) {        this.motorTemperature = motorTemperature;    }
    public float getTemperature() {        return temperature;    }
    public void setTemperature(float temperature) {        this.temperature = temperature;    }
    public String getSalt() { return this.salt; }
    public void setSalt(String salty) { this.salt = salty; }

    private String getDate(Instant instant) {
        Timestamp ts = Timestamp.from(instant);
        Date dt = Date.valueOf(ts.toLocalDateTime().toLocalDate());
        return dt.toString();
    }

    private String getTime(Instant instant) {
        Timestamp ts = Timestamp.from(instant);
        Time time = Time.valueOf(ts.toLocalDateTime().toLocalTime());
        return time.toString();
    }

    public String toSQLString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append("timer2start").append(",");
        sb.append("deviceId").append(",");
        sb.append("password").append(",");
        sb.append("salt").append(",");
        sb.append("deviceDate").append(",");
        sb.append("deviceTime").append(",");
        sb.append("updatedTimestamp").append(",");
        sb.append("timeUpdatedTimestamp").append(",");
        sb.append("deviceMode").append(",");
        sb.append("timer1start").append(",");
        sb.append("timer1stop").append(",");
        sb.append("timer2stop").append(",");
        sb.append("flowRateMode").append(",");
        sb.append("flowControlEnabled").append(",");
        sb.append("gasAvailabilityPrediction").append(",");
        sb.append("gasAvailability").append(",");
        sb.append("gasCylinderVolume").append(",");
        sb.append("reducerType").append(",");
        sb.append("lightEnabled").append(",");
        sb.append("workingTime").append(",");
        sb.append("version").append(",");
        sb.append("heaterTemperature").append(",");
        sb.append("motorTemperature").append(",");
        sb.append("temperature");
        sb.append(")");
        sb.append(" VALUES (");
        sb.append(String.format("'%s',", getTime(timer2start)));
        sb.append(deviceId).append(",");
        sb.append("'").append(password).append("',");
        sb.append("'").append(salt).append("',");
        sb.append(String.format("'%s',", getDate(deviceDate)));
        sb.append(String.format("'%s',", getTime(deviceTime)));
        sb.append("CURRENT_TIMESTAMP").append(",");
        sb.append("CURRENT_TIMESTAMP").append(",");
        sb.append("'").append(deviceMode).append("',");
        sb.append(String.format("'%s',", getTime(timer1start)));
        sb.append(String.format("'%s',", getTime(timer1stop)));
        sb.append(String.format("'%s',", getTime(timer2stop)));
        sb.append(flowRateMode).append(",");
        sb.append(flowControlEnabled).append(",");
        sb.append(gasAvailabilityPrediction).append(",");
        sb.append(gasAvailability).append(",");
        sb.append(gasCylinderVolume).append(",");
        sb.append(reducerType).append(",");
        sb.append(lightEnabled).append(",");
        sb.append(workingTime).append(",");
        sb.append("'").append(version).append("',");
        sb.append(heaterTemperature).append(",");
        sb.append(motorTemperature).append(",");
        sb.append(temperature);
        sb.append(")");
        return sb.toString();
    }

    public static class DeviceBuilder {
        private long deviceId;
        private String password;
        private String salt;
        private Instant deviceDate;    //Системная дата утр-ва
        private Instant deviceTime;    //Системное время утр-ва
        private Instant updatedTimestamp;   //метка времеи последего пакета с данными
        private Instant timeUpdatedTimestamp;   //метка времени пекета с системным временем устройства
        private String deviceMode;
        private Instant timer1start;
        private Instant timer1stop;
        private Instant timer2start;
        private Instant timer2stop;
        private Integer flowRateMode;
        private Boolean flowControlEnabled;
        private Integer gasAvailabilityPrediction;
        private Boolean gasAvailability;
        private Integer gasCylinderVolume;
        private Integer reducerType;
        private Boolean lightEnabled;
        private Integer workingTime;
        private String version;
        private float heaterTemperature;
        private float motorTemperature;
        private float temperature;

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

        public DeviceBuilder setDeviceTime(Instant deviceTime) {
            this.deviceTime = deviceTime;
            return this;
        }

        public DeviceBuilder setUpdatedTimestamp(Instant updatedTimestamp) {
            this.updatedTimestamp = updatedTimestamp;
            return this;
        }

        public DeviceBuilder setTimeUpdatedTimestamp(Instant timeUpdatedTimestamp) {
            this.timeUpdatedTimestamp = timeUpdatedTimestamp;
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

        public DeviceBuilder setFlowRateMode(Integer flowRateMode) {
            this.flowRateMode = flowRateMode;
            return this;
        }

        public DeviceBuilder setFlowControlEnabled(Boolean flowControlEnabled) {
            this.flowControlEnabled = flowControlEnabled;
            return this;
        }

        public DeviceBuilder setGasAvailabilityPrediction(Integer gasAvailabilityPrediction) {
            this.gasAvailabilityPrediction = gasAvailabilityPrediction;
            return this;
        }

        public DeviceBuilder setGasAvailability(Boolean gasAvailability) {
            this.gasAvailability = gasAvailability;
            return this;
        }

        public DeviceBuilder setGasCylinderVolume(Integer gasCylinderVolume) {
            this.gasCylinderVolume = gasCylinderVolume;
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

        public DeviceBuilder setTemperature(float temperature) {
            this.temperature = temperature;
            return this;
        }

        public DeviceBuilder setMotorTemperature(float motorTemperature) {
            this.motorTemperature = motorTemperature;
            return this;
        }

        public DeviceBuilder setHeaterTemperature(float heaterTemperature) {
            this.heaterTemperature = heaterTemperature;
            return this;
        }

        public DeviceBuilder setVersion(String version) {
            this.version = version;
            return this;
        }

        public DeviceBuilder setWorkingTime(Integer workingTime) {
            this.workingTime = workingTime;
            return this;
        }

        public DeviceBuilder setSalt(String salty) {
            this.salt = salty;
            return this;
        }

        public Device build() {
            return new Device(this);
        }

    }
}
