DROP TABLE IF EXISTS `gates`;
CREATE TABLE IF NOT EXISTS `gates` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `in_use` TINYINT NOT NULL DEFAULT 0,
    `available_from` TIME DEFAULT '00:00:00',
    `available_to` TIME DEFAULT '23:59:59',
    PRIMARY KEY (`id`));

DROP TABLE IF EXISTS `gate_assignments`;
CREATE TABLE IF NOT EXISTS `gate_assignments` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `flight_number` VARCHAR(45) NOT NULL,
    `gate_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_gate_assignments_gates1`
        FOREIGN KEY (`gate_id`)
        REFERENCES `gates` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);
