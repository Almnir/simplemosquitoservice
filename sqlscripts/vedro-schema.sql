
CREATE TABLE Device
(
	deviceDate           DATE NULL,
	deviceTime           TIME NULL,
	updatedTimestamp     TIMESTAMP NULL,
	deviceMode           INTEGER NULL,
	timer1Start          TIME NULL,
	timer1Stop           TIME NULL,
	timer2Start          TIME NULL,
	timer2Stop           TIME NULL,
	flowRateMode         INTEGER NULL,
	flowControlEnabled   BIT NULL,
	gasAvailabilityPrediction INTEGER NULL,
	gasAvailability      BIT NULL,
	gasCylinderVolume    INTEGER NULL,
	reducerType          INTEGER NULL,
	lightEnabled         BIT NULL,
	password             VARCHAR(32) NULL,
	DeviceID             BIGINT NOT NULL,
	workingTime          INTEGER NULL,
	version              VARCHAR(20) NULL,
	heaterTemperature    FLOAT NULL,
	motorTemperature     FLOAT NULL,
	temperature          FLOAT NULL,
	timeUpdatedTimestamp TIMESTAMP NULL,
	salt                 VARCHAR(32) NULL
);

ALTER TABLE Device
ADD PRIMARY KEY (DeviceID);

CREATE TABLE DeviceError
(
	errorDate            DATE NOT NULL,
	errorTime            TIME NOT NULL,
	errorType            TINYINT NOT NULL,
	DeviceID             BIGINT NOT NULL
);

ALTER TABLE DeviceError
ADD PRIMARY KEY (errorDate,errorTime,errorType,DeviceID);

CREATE TABLE DeviceGetData
(
	deviceDate           DATE NULL,
	deviceTime           TIME NULL,
	updatedTimestamp     TIMESTAMP NULL,
	deviceMode           INTEGER NULL,
	timer1Start          TIME NULL,
	timer1Stop           TIME NULL,
	timer2Start          TIME NULL,
	timer2Stop           TIME NULL,
	flowRateMode         INTEGER NULL,
	flowControlEnabled   BIT NULL,
	gasAvailabilityPrediction INTEGER NULL,
	gasAvailability      BIT NULL,
	gasVolume            INTEGER NULL,
	reducerType          INTEGER NULL,
	lightEnabled         BIT NULL,
	password             VARCHAR(32) NULL,
	workingTime          INTEGER NULL,
	version              VARCHAR(20) NULL,
	heaterTemperature    FLOAT NULL,
	motorTemperature     FLOAT NULL,
	temperature          FLOAT NULL,
	DeviceID             BIGINT NOT NULL,
	dataTimestamp        TIMESTAMP NOT NULL
);

ALTER TABLE DeviceGetData
ADD PRIMARY KEY (dataTimestamp,DeviceID);

CREATE TABLE DeviceGroup
(
	DeviceGroupID        INTEGER NOT NULL,
	DeviceGroupName      VARCHAR(48) NOT NULL,
	UserID               INTEGER NOT NULL
);

ALTER TABLE DeviceGroup
ADD PRIMARY KEY (DeviceGroupID);

CREATE TABLE DeviceSetCommand
(
	DeviceID             BIGINT NOT NULL,
	CommandStartTime     TIMESTAMP NOT NULL,
	commandFinishTime    TIMESTAMP NULL,
	deviceTime           TIME NULL,
	deviceMode           INTEGER NULL,
	timer1start          TIME NULL,
	timer1stop           TIME NULL,
	timer2start          TIME NULL,
	timer2stop           TIME NULL,
	flowRateMode         INTEGER NULL,
	flowControlEnabled   INTEGER NULL,
	lightEnabled         INTEGER NULL,
	systemShutdown       INTEGER NULL
);

ALTER TABLE DeviceSetCommand
ADD PRIMARY KEY (CommandStartTime,DeviceID);

CREATE TABLE User
(
	UserID               INTEGER NOT NULL,
	login                VARCHAR(48) NOT NULL,
	password             VARCHAR(64) NOT NULL,
	Name                 VARCHAR(20) NOT NULL,
	RoleID               INTEGER NOT NULL,
	salt                 VARCHAR(64) NULL
);

ALTER TABLE User
ADD PRIMARY KEY (UserID);

CREATE UNIQUE INDEX XAK1User ON User
(
	login
);

CREATE TABLE UserDevice
(
	DeviceGroupID        INTEGER NOT NULL,
	DeviceID             BIGINT NOT NULL
);

ALTER TABLE UserDevice
ADD PRIMARY KEY (DeviceID);

CREATE TABLE UserRole
(
	RoleID               INTEGER NOT NULL,
	role                 VARCHAR(32) NULL
);

ALTER TABLE UserRole
ADD PRIMARY KEY (RoleID);

ALTER TABLE DeviceError
ADD CONSTRAINT R_13 FOREIGN KEY (DeviceID) REFERENCES Device (DeviceID);

ALTER TABLE DeviceGetData
ADD CONSTRAINT R_15 FOREIGN KEY (DeviceID) REFERENCES Device (DeviceID);

ALTER TABLE DeviceGroup
ADD CONSTRAINT R_6 FOREIGN KEY (UserID) REFERENCES User (UserID);

ALTER TABLE DeviceSetCommand
ADD CONSTRAINT R_12 FOREIGN KEY (DeviceID) REFERENCES Device (DeviceID);

ALTER TABLE User
ADD CONSTRAINT R_14 FOREIGN KEY (RoleID) REFERENCES UserRole (RoleID);

ALTER TABLE UserDevice
ADD CONSTRAINT R_8 FOREIGN KEY (DeviceGroupID) REFERENCES DeviceGroup (DeviceGroupID);

ALTER TABLE UserDevice
ADD CONSTRAINT R_11 FOREIGN KEY (DeviceID) REFERENCES Device (DeviceID);
