CREATE DATABASE wildlife_tracker IF NOT EXISTS;
CREATE TABLE IF NOT EXISTS animals(
    id INTEGER
    name VARCHAR
    count INTEGER
    location VARCHAR
    reportedby VARCHAR
    reportedat TIMESTAMP
)