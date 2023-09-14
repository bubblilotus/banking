use bank;

CREATE TABLE `users`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `enabled` INT NOT NULL,
    PRIMARY KEY(`id`));
CREATE TABLE `authorities`(
     `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `authority` VARCHAR(45) NOT NULL,
    PRIMARY KEY(`id`));
INSERT INTO `users` VALUES (NULL, 'happy', '12345', '1');
INSERT INTO `authorities` VALUES (NULL, 'happy', 'write');

use bank;
drop table `customer`;
CREATE TABLE `customer`(
                           `id` INT NOT NULL AUTO_INCREMENT,
                           `email` VARCHAR(45) NOT NULL,
                           `pwd` VARCHAR(45) NOT NULL,
                           `role` VARCHAR(45) NOT NULL,
                           PRIMARY KEY(`id`));
insert into `customer` (`email`, `pwd`, `role`) values ('janedoe@email.com', '54321', 'admin');
