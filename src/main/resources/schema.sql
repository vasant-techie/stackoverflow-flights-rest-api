CREATE SCHEMA IF NOT EXISTS flightdb;

CREATE TABLE IF NOT EXISTS flightdb.flights (
  flightid INT NOT NULL AUTO_INCREMENT,
  originairport VARCHAR(45) NOT NULL,
  destinationairport VARCHAR(45) NOT NULL,
  PRIMARY KEY (flightid));
