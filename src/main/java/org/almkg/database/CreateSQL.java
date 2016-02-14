package org.almkg.database;

/**
 * Created by alm on 13.02.2016.
 */
public class CreateSQL {
    public static final String createDevice =
            "CREATE TABLE Device\n" +
                    "(\n" +
                    "\tdeviceDate           DATE NULL,\n" +
                    "\tdeviceTime           TIME NULL,\n" +
                    "\tupdatedTimestamp     TIMESTAMP NULL,\n" +
                    "\tdeviceMode           INTEGER NULL,\n" +
                    "\ttimer1Start          TIME NULL,\n" +
                    "\ttimer1Stop           TIME NULL,\n" +
                    "\ttimer2Start          TIME NULL,\n" +
                    "\ttimer2Stop           TIME NULL,\n" +
                    "\tflowRateMode         INTEGER NULL,\n" +
                    "\tflowControlEnabled   BIT NULL,\n" +
                    "\tgasAvailabilityPrediction INTEGER NULL,\n" +
                    "\tgasAvailability      BIT NULL,\n" +
                    "\tgasCylinderVolume    INTEGER NULL,\n" +
                    "\treducerType          INTEGER NULL,\n" +
                    "\tlightEnabled         BIT NULL,\n" +
                    "\tpassword             VARCHAR(32) NULL,\n" +
                    "\tDeviceID             BIGINT NOT NULL,\n" +
                    "\tworkingTime          INTEGER NULL,\n" +
                    "\tversion              VARCHAR(20) NULL,\n" +
                    "\theaterTemperature    FLOAT NULL,\n" +
                    "\tmotorTemperature     FLOAT NULL,\n" +
                    "\ttemperature          FLOAT NULL,\n" +
                    "\ttimeUpdatedTimestamp TIMESTAMP NULL,\n" +
                    "\tsalt                 VARCHAR(32) NULL,\n" +
                    "\tPRIMARY KEY          (DeviceID)\n" +
                    ");\n";
    public static final String createDeviceGroup =
            "CREATE TABLE DeviceGroup\n" +
                    "(\n" +
                    "\tDeviceGroupID        INTEGER NOT NULL,\n" +
                    "\tDeviceGroupName      VARCHAR(48) NOT NULL,\n" +
                    "\tUserID               INTEGER NOT NULL,\n" +
                    "\tPRIMARY KEY          (DeviceGroupID)\n" +
                    ");";
    public static final String createDeviceSetCommand =
            "CREATE TABLE DeviceSetCommand\n" +
                    "(\n" +
                    "\tDeviceID             BIGINT NOT NULL,\n" +
                    "\tCommandStartTime     TIMESTAMP NOT NULL,\n" +
                    "\tcommandFinishTime    TIMESTAMP NULL,\n" +
                    "\tdeviceTime           TIME NULL,\n" +
                    "\tdeviceMode           INTEGER NULL,\n" +
                    "\ttimer1start          TIME NULL,\n" +
                    "\ttimer1stop           TIME NULL,\n" +
                    "\ttimer2start          TIME NULL,\n" +
                    "\ttimer2stop           TIME NULL,\n" +
                    "\tflowRateMode         INTEGER NULL,\n" +
                    "\tflowControlEnabled   INTEGER NULL,\n" +
                    "\tlightEnabled         INTEGER NULL,\n" +
                    "\tsystemShutdown       INTEGER NULL,\n" +
                    "\tPRIMARY KEY          (CommandStartTime, DeviceID)\n" +
                    ");";
    public static final String createUser =
            "CREATE TABLE User\n" +
                    "(\n" +
                    "\tUserID               INTEGER NOT NULL,\n" +
                    "\tlogin                VARCHAR(48) NOT NULL,\n" +
                    "\tpassword             VARCHAR(64) NOT NULL,\n" +
                    "\tName                 VARCHAR(20) NOT NULL,\n" +
                    "\tRoleID               INTEGER NOT NULL,\n" +
                    "\tsalt                 VARCHAR(64) NULL,\n" +
                    "\tPRIMARY KEY          (UserID)\n" +
                    ");";
    public static final String createUserDevice =
            "CREATE TABLE UserDevice\n" +
                    "(\n" +
                    "\tDeviceGroupID        INTEGER NOT NULL,\n" +
                    "\tDeviceID             BIGINT NOT NULL,\n" +
                    "\tPRIMARY KEY          (DeviceID)\n" +
                    ");";
    public static final String createUserRole =
            "CREATE TABLE UserRole\n" +
                    "(\n" +
                    "\tRoleID               INTEGER NOT NULL,\n" +
                    "\trole                 VARCHAR(32) NULL,\n" +
                    "\tPRIMARY KEY          (RoleID)\n" +
                    ");";
}
