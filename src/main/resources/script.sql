CREATE DATABASE IF NOT EXISTS mydbtest;

USE mydbtest;

CREATE TABLE IF NOT EXISTS library (
                                     `id` INT NOT NULL AUTO_INCREMENT,
                                     `title` VARCHAR(100) NOT NULL,
                                     `author` VARCHAR(100) NOT NULL,
                                     PRIMARY KEY (`id`));



CREATE TABLE IF NOT EXISTS users (
                                     `id` INT NOT NULL AUTO_INCREMENT,
                                     `name` VARCHAR(100) NOT NULL,
                                     `surname` VARCHAR(100) NOT NULL,
                                     PRIMARY KEY (`id`));