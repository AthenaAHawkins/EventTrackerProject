-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fitnessdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `fitnessdb` ;

-- -----------------------------------------------------
-- Schema fitnessdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fitnessdb` DEFAULT CHARACTER SET utf8 ;
USE `fitnessdb` ;

-- -----------------------------------------------------
-- Table `Macros`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Macros` ;

CREATE TABLE IF NOT EXISTS `Macros` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `food` VARCHAR(45) NULL,
  `protein` DOUBLE NULL,
  `fat` DOUBLE NULL,
  `carbohydrates` DOUBLE NULL,
  `calories` DOUBLE NULL,
  `serving_size` VARCHAR(45) NULL,
  `number_of_servings` INT NOT NULL,
  `meal` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS fitnessuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'fitnessuser'@'localhost' IDENTIFIED BY 'fitnessuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'fitnessuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Macros`
-- -----------------------------------------------------
START TRANSACTION;
USE `fitnessdb`;
INSERT INTO `Macros` (`id`, `food`, `protein`, `fat`, `carbohydrates`, `calories`, `serving_size`, `number_of_servings`, `meal`) VALUES (1, 'chicken Breast', 33, 3, 0, 150, '5 oz', 1, 'dinner');
INSERT INTO `Macros` (`id`, `food`, `protein`, `fat`, `carbohydrates`, `calories`, `serving_size`, `number_of_servings`, `meal`) VALUES (2, 'shrimp', 20.4, 0.3, 0.2, 84, '3 oz', 1, 'dinner');
INSERT INTO `Macros` (`id`, `food`, `protein`, `fat`, `carbohydrates`, `calories`, `serving_size`, `number_of_servings`, `meal`) VALUES (3, 'peanuts', 7.3, 14, 4.6, 161, '1 oz', 1, NULL);

COMMIT;

