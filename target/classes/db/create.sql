CREATE DATABASE wildlife_tracker IF NOT EXISTS;
CREATE TABLE IF NOT EXISTS sightings(
    name VARCHAR
    location VARCHAR
    count INTEGER
    reportedby VARCHAR
    reportedat TIMESTAMP
)