-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema MisNotasDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `MisNotasDB` ;

-- -----------------------------------------------------
-- Schema MisNotasDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MisNotasDB` DEFAULT CHARACTER SET utf8 ;
USE `MisNotasDB` ;

-- -----------------------------------------------------
-- Table `MisNotasDB`.`Curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MisNotasDB`.`Curso` ;

CREATE TABLE IF NOT EXISTS `MisNotasDB`.`Curso` (
  `idCurso` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCurso`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
PACK_KEYS = DEFAULT;


-- -----------------------------------------------------
-- Table `MisNotasDB`.`EstructuraNotas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MisNotasDB`.`EstructuraNotas` ;

CREATE TABLE IF NOT EXISTS `MisNotasDB`.`EstructuraNotas` (
  `idEstructuraNotas` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Curso_idCurso` INT UNSIGNED NOT NULL,
  `periodoInicial` DATE NOT NULL,
  `periodoFinal` DATE NULL DEFAULT NULL,
  `creditos` TINYINT UNSIGNED NOT NULL,
  PRIMARY KEY (`idEstructuraNotas`),
  INDEX `fk_EstructuraNotas_Curso_idx` (`Curso_idCurso` ASC) VISIBLE,
  CONSTRAINT `fk_EstructuraNotas_Curso`
    FOREIGN KEY (`Curso_idCurso`)
    REFERENCES `MisNotasDB`.`Curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MisNotasDB`.`Carrera`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MisNotasDB`.`Carrera` ;

CREATE TABLE IF NOT EXISTS `MisNotasDB`.`Carrera` (
  `idCarrera` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCarrera`))
ENGINE = InnoDB
AUTO_INCREMENT = 0;


-- -----------------------------------------------------
-- Table `MisNotasDB`.`Malla`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MisNotasDB`.`Malla` ;

CREATE TABLE IF NOT EXISTS `MisNotasDB`.`Malla` (
  `idMalla` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Carrera_idCarrera` INT UNSIGNED NOT NULL,
  `periodoInicial` DATE NOT NULL,
  `periodoFinal` DATE NULL DEFAULT NULL,
  `creditosElectivos` TINYINT UNSIGNED NOT NULL,
  `creditosObligatorios` TINYINT UNSIGNED NOT NULL,
  PRIMARY KEY (`idMalla`),
  INDEX `fk_Malla_Carerra1_idx` (`Carrera_idCarrera` ASC) VISIBLE,
  CONSTRAINT `fk_Malla_Carerra1`
    FOREIGN KEY (`Carrera_idCarrera`)
    REFERENCES `MisNotasDB`.`Carrera` (`idCarrera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0;


-- -----------------------------------------------------
-- Table `MisNotasDB`.`Malla_has_Curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MisNotasDB`.`Malla_has_Curso` ;

CREATE TABLE IF NOT EXISTS `MisNotasDB`.`Malla_has_Curso` (
  `Malla_idMalla` INT UNSIGNED NOT NULL,
  `Curso_idCurso` INT UNSIGNED NOT NULL,
  `ciclo` TINYINT UNSIGNED NOT NULL,
  `tipo` BIT(1) NOT NULL,
  PRIMARY KEY (`Malla_idMalla`, `Curso_idCurso`),
  INDEX `fk_Malla_has_Curso_Curso1_idx` (`Curso_idCurso` ASC) VISIBLE,
  INDEX `fk_Malla_has_Curso_Malla1_idx` (`Malla_idMalla` ASC) VISIBLE,
  CONSTRAINT `fk_Malla_has_Curso_Malla1`
    FOREIGN KEY (`Malla_idMalla`)
    REFERENCES `MisNotasDB`.`Malla` (`idMalla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Malla_has_Curso_Curso1`
    FOREIGN KEY (`Curso_idCurso`)
    REFERENCES `MisNotasDB`.`Curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0;


-- -----------------------------------------------------
-- Table `MisNotasDB`.`FilasEstructuras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MisNotasDB`.`FilasEstructuras` ;

CREATE TABLE IF NOT EXISTS `MisNotasDB`.`FilasEstructuras` (
  `orden` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `EstructuraNotas_idEstructuraNotas` INT UNSIGNED NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `peso` DECIMAL(4,2) NOT NULL,
  `FilasEstructuras_orden` TINYINT UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`orden`, `EstructuraNotas_idEstructuraNotas`),
  INDEX `fk_FilasEstructuras_EstructuraNotas1_idx` (`EstructuraNotas_idEstructuraNotas` ASC) VISIBLE,
  INDEX `fk_FilasEstructuras_FilasEstructuras1_idx` (`FilasEstructuras_orden` ASC) VISIBLE,
  CONSTRAINT `fk_FilasEstructuras_EstructuraNotas1`
    FOREIGN KEY (`EstructuraNotas_idEstructuraNotas`)
    REFERENCES `MisNotasDB`.`EstructuraNotas` (`idEstructuraNotas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FilasEstructuras_FilasEstructuras1`
    FOREIGN KEY (`FilasEstructuras_orden`)
    REFERENCES `MisNotasDB`.`FilasEstructuras` (`orden`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0;

USE `MisNotasDB` ;

-- -----------------------------------------------------
-- Placeholder table for view `MisNotasDB`.`mallaActual`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MisNotasDB`.`mallaActual` (`nombre` INT, `ciclo` INT, `tipo` INT);

-- -----------------------------------------------------
-- View `MisNotasDB`.`mallaActual`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MisNotasDB`.`mallaActual`;
DROP VIEW IF EXISTS `MisNotasDB`.`mallaActual` ;
USE `MisNotasDB`;
CREATE  OR REPLACE VIEW `mallaActual` AS SELECT cur.nombre, m_cur.ciclo, m_cur.tipo FROM Curso cur, Malla_has_Curso m_cur, Malla m, Carrera c WHERE c.idCarrera = 1 AND c.idCarrera = m.Carrera_idCarrera AND m.periodoFinal IS NULL AND m.idMalla = m_cur.Malla_idMalla AND cur.idCurso = m_cur.Curso_idCurso;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `MisNotasDB`.`Curso`
-- -----------------------------------------------------
START TRANSACTION;
USE `MisNotasDB`;
INSERT INTO `MisNotasDB`.`Curso` (`idCurso`, `nombre`) VALUES (0, 'DESARROLLO HUMANO');
INSERT INTO `MisNotasDB`.`Curso` (`idCurso`, `nombre`) VALUES (0, 'NIVELACIÓN EN FÍSICA');
INSERT INTO `MisNotasDB`.`Curso` (`idCurso`, `nombre`) VALUES (0, 'NIVELACIÓN EN INGLÉS');
INSERT INTO `MisNotasDB`.`Curso` (`idCurso`, `nombre`) VALUES (0, 'NIVELACIÓN EN LENGUAJE');
INSERT INTO `MisNotasDB`.`Curso` (`idCurso`, `nombre`) VALUES (0, 'NIVELACIÓN EN MATEMÁTICA A');
INSERT INTO `MisNotasDB`.`Curso` (`idCurso`, `nombre`) VALUES (0, 'ENGLISH I');
INSERT INTO `MisNotasDB`.`Curso` (`idCurso`, `nombre`) VALUES (0, 'ESTRUCTURAS DISCRETAS');
INSERT INTO `MisNotasDB`.`Curso` (`idCurso`, `nombre`) VALUES (0, 'FUNDAMENTOS DE CÁLCULO');
INSERT INTO `MisNotasDB`.`Curso` (`idCurso`, `nombre`) VALUES (0, 'FUNDAMENTOS DE SISTEMAS DE INFORMACIÓN');
INSERT INTO `MisNotasDB`.`Curso` (`idCurso`, `nombre`) VALUES (0, 'LENGUAJE I');

COMMIT;


-- -----------------------------------------------------
-- Data for table `MisNotasDB`.`EstructuraNotas`
-- -----------------------------------------------------
START TRANSACTION;
USE `MisNotasDB`;
INSERT INTO `MisNotasDB`.`EstructuraNotas` (`idEstructuraNotas`, `Curso_idCurso`, `periodoInicial`, `periodoFinal`, `creditos`) VALUES (0, 1, '2017-08-01', NULL, 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `MisNotasDB`.`Carrera`
-- -----------------------------------------------------
START TRANSACTION;
USE `MisNotasDB`;
INSERT INTO `MisNotasDB`.`Carrera` (`idCarrera`, `nombre`) VALUES (0, 'INGENIERÍA INFORMÁTICA Y DE SISTEMAS');

COMMIT;


-- -----------------------------------------------------
-- Data for table `MisNotasDB`.`Malla`
-- -----------------------------------------------------
START TRANSACTION;
USE `MisNotasDB`;
INSERT INTO `MisNotasDB`.`Malla` (`idMalla`, `Carrera_idCarrera`, `periodoInicial`, `periodoFinal`, `creditosElectivos`, `creditosObligatorios`) VALUES (0, 1, '2019-03-01', NULL, 16, 184);

COMMIT;


-- -----------------------------------------------------
-- Data for table `MisNotasDB`.`Malla_has_Curso`
-- -----------------------------------------------------
START TRANSACTION;
USE `MisNotasDB`;
INSERT INTO `MisNotasDB`.`Malla_has_Curso` (`Malla_idMalla`, `Curso_idCurso`, `ciclo`, `tipo`) VALUES (1, 1, 0, 1);
INSERT INTO `MisNotasDB`.`Malla_has_Curso` (`Malla_idMalla`, `Curso_idCurso`, `ciclo`, `tipo`) VALUES (1, 2, 0, 1);
INSERT INTO `MisNotasDB`.`Malla_has_Curso` (`Malla_idMalla`, `Curso_idCurso`, `ciclo`, `tipo`) VALUES (1, 3, 0, 1);
INSERT INTO `MisNotasDB`.`Malla_has_Curso` (`Malla_idMalla`, `Curso_idCurso`, `ciclo`, `tipo`) VALUES (1, 4, 0, 1);
INSERT INTO `MisNotasDB`.`Malla_has_Curso` (`Malla_idMalla`, `Curso_idCurso`, `ciclo`, `tipo`) VALUES (1, 5, 0, 1);
INSERT INTO `MisNotasDB`.`Malla_has_Curso` (`Malla_idMalla`, `Curso_idCurso`, `ciclo`, `tipo`) VALUES (1, 6, 1, 1);
INSERT INTO `MisNotasDB`.`Malla_has_Curso` (`Malla_idMalla`, `Curso_idCurso`, `ciclo`, `tipo`) VALUES (1, 7, 1, 1);
INSERT INTO `MisNotasDB`.`Malla_has_Curso` (`Malla_idMalla`, `Curso_idCurso`, `ciclo`, `tipo`) VALUES (1, 8, 1, 1);
INSERT INTO `MisNotasDB`.`Malla_has_Curso` (`Malla_idMalla`, `Curso_idCurso`, `ciclo`, `tipo`) VALUES (1, 9, 1, 1);
INSERT INTO `MisNotasDB`.`Malla_has_Curso` (`Malla_idMalla`, `Curso_idCurso`, `ciclo`, `tipo`) VALUES (1, 10, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `MisNotasDB`.`FilasEstructuras`
-- -----------------------------------------------------
START TRANSACTION;
USE `MisNotasDB`;
INSERT INTO `MisNotasDB`.`FilasEstructuras` (`orden`, `EstructuraNotas_idEstructuraNotas`, `nombre`, `peso`, `FilasEstructuras_orden`) VALUES (0, 1, 'Evaluación Permanente', 60, NULL);
INSERT INTO `MisNotasDB`.`FilasEstructuras` (`orden`, `EstructuraNotas_idEstructuraNotas`, `nombre`, `peso`, `FilasEstructuras_orden`) VALUES (0, 1, 'Prom. Participación Clase', 20, 1);
INSERT INTO `MisNotasDB`.`FilasEstructuras` (`orden`, `EstructuraNotas_idEstructuraNotas`, `nombre`, `peso`, `FilasEstructuras_orden`) VALUES (0, 1, 'Participación 1', 50, 2);
INSERT INTO `MisNotasDB`.`FilasEstructuras` (`orden`, `EstructuraNotas_idEstructuraNotas`, `nombre`, `peso`, `FilasEstructuras_orden`) VALUES (0, 1, 'Participación 2', 50, 2);
INSERT INTO `MisNotasDB`.`FilasEstructuras` (`orden`, `EstructuraNotas_idEstructuraNotas`, `nombre`, `peso`, `FilasEstructuras_orden`) VALUES (0, 1, 'Prom. Proyectos', 30, 1);
INSERT INTO `MisNotasDB`.`FilasEstructuras` (`orden`, `EstructuraNotas_idEstructuraNotas`, `nombre`, `peso`, `FilasEstructuras_orden`) VALUES (0, 1, 'Proyecto 1', 40, 5);
INSERT INTO `MisNotasDB`.`FilasEstructuras` (`orden`, `EstructuraNotas_idEstructuraNotas`, `nombre`, `peso`, `FilasEstructuras_orden`) VALUES (0, 1, 'Proyecto 2', 60, 5);
INSERT INTO `MisNotasDB`.`FilasEstructuras` (`orden`, `EstructuraNotas_idEstructuraNotas`, `nombre`, `peso`, `FilasEstructuras_orden`) VALUES (0, 1, 'Promedio de Trabajos', 50, 1);
INSERT INTO `MisNotasDB`.`FilasEstructuras` (`orden`, `EstructuraNotas_idEstructuraNotas`, `nombre`, `peso`, `FilasEstructuras_orden`) VALUES (0, 1, 'Sustentación', 35, 6);
INSERT INTO `MisNotasDB`.`FilasEstructuras` (`orden`, `EstructuraNotas_idEstructuraNotas`, `nombre`, `peso`, `FilasEstructuras_orden`) VALUES (0, 1, 'Trabajo 1', 10, 8);
INSERT INTO `MisNotasDB`.`FilasEstructuras` (`orden`, `EstructuraNotas_idEstructuraNotas`, `nombre`, `peso`, `FilasEstructuras_orden`) VALUES (0, 1, 'Trabajo 2', 20, 8);
INSERT INTO `MisNotasDB`.`FilasEstructuras` (`orden`, `EstructuraNotas_idEstructuraNotas`, `nombre`, `peso`, `FilasEstructuras_orden`) VALUES (0, 1, 'Trabajo Final', 35, 8);
INSERT INTO `MisNotasDB`.`FilasEstructuras` (`orden`, `EstructuraNotas_idEstructuraNotas`, `nombre`, `peso`, `FilasEstructuras_orden`) VALUES (0, 1, 'Examen Parcial', 20, NULL);
INSERT INTO `MisNotasDB`.`FilasEstructuras` (`orden`, `EstructuraNotas_idEstructuraNotas`, `nombre`, `peso`, `FilasEstructuras_orden`) VALUES (0, 1, 'Examen Final', 20, NULL);

COMMIT;

