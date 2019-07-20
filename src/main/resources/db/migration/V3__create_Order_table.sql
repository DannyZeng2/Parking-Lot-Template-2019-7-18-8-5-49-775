create table PARKING_LOT_ORDER (
    id varchar PRIMARY KEY,
    parkingLotName varchar,
    CarNum varchar,
    startTime date,
    endTime date,
    state int,
    PARKING_LOT_ID varchar
);