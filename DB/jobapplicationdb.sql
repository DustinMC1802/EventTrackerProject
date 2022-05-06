-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jobapplicationsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jobapplicationsdb` ;

-- -----------------------------------------------------
-- Schema jobapplicationsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jobapplicationsdb` DEFAULT CHARACTER SET utf8 ;
USE `jobapplicationsdb` ;

-- -----------------------------------------------------
-- Table `job_application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `job_application` ;

CREATE TABLE IF NOT EXISTS `job_application` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `company` VARCHAR(45) NULL,
  `posting_date` DATE NULL,
  `date_applied` DATE NULL,
  `offer` TINYINT NULL,
  `url` TEXT NULL,
  `job_number` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS applicant@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'applicant'@'localhost' IDENTIFIED BY 'applicant';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'applicant'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `job_application`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobapplicationsdb`;
INSERT INTO `job_application` (`id`, `title`, `city`, `state`, `company`, `posting_date`, `date_applied`, `offer`, `url`, `job_number`) VALUES (1, 'software developer 1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `job_application` (`id`, `title`, `city`, `state`, `company`, `posting_date`, `date_applied`, `offer`, `url`, `job_number`) VALUES (2, 'Software Engineer I (NST)', 'Redmond', 'WA', 'Ninentdo of America', NULL, NULL, NULL, 'https://careers.nintendo.com/job-openings/listing/210000005E.html?src=CWS-10000', '210000005E');
INSERT INTO `job_application` (`id`, `title`, `city`, `state`, `company`, `posting_date`, `date_applied`, `offer`, `url`, `job_number`) VALUES (3, 'Full Stack Java Developer', 'Fort Knox', 'KY', 'SAIC', '2022-03-16', NULL, NULL, 'https://jobs.saic.com/jobs/9051640-full-stack-java-developer', '2204326');
INSERT INTO `job_application` (`id`, `title`, `city`, `state`, `company`, `posting_date`, `date_applied`, `offer`, `url`, `job_number`) VALUES (4, 'Full Stack Java Developer (REMOTE)\n', 'Fort Knox', 'KY', 'AGIL3TECH (AGIL3 TECHNOLOGY SOLUTIONS)', NULL, NULL, NULL, 'https://www.smartrecruiters.com/Agil3TechAgil3TechnologySolution/743999822561758-full-stack-java-developer-remote-', NULL);
INSERT INTO `job_application` (`id`, `title`, `city`, `state`, `company`, `posting_date`, `date_applied`, `offer`, `url`, `job_number`) VALUES (5, 'Full Stack Developer', 'Boston', 'MA', 'MassMutual', NULL, NULL, NULL, 'https://careers.massmutual.com/job/15072725/full-stack-developer-boston-ma/', 'R11194\n\n\n');

COMMIT;

