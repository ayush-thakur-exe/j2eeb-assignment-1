create database evidence;

use evidence;

create table evidences(
	evidenceID int primary key auto_increment,
    description varchar(500),
    sourceOfficerDepartment varchar(500),
    dateOfAcquisition varchar(50),
    custodyStatus varchar(50),
    lastCustodianName varchar(200),
    encryptionStatus boolean
);

-- Playground
insert into evidences(description, sourceOfficerDepartment, dateOfAcquisition, custodyStatus, lastCustodianName, encryptionStatus) 
values("testing table", "mr. test debug", "2025-10-22", "IN_CUSTODY", "Mr. Debug Console", TRUE);
select * from evidences;