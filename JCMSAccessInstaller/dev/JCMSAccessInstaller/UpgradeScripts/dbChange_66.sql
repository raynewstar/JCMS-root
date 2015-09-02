﻿#***
#Copyright (c) 2015 The Jackson Laboratory
#
#This is free software: you can redistribute it and/or modify it 
#under the terms of the GNU General Public License as published by  
#the Free Software Foundation, either version 3 of the License, or  
#(at your option) any later version.
# 
#This software is distributed in the hope that it will be useful,  
#but WITHOUT ANY WARRANTY; without even the implied warranty of 
#MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU 
#General Public License for more details.
#
#You should have received a copy of the GNU General Public License 
#along with this software.  If not, see <http://www.gnu.org/licenses/>.
#***

DELIMITER $$

DROP PROCEDURE IF EXISTS upgrade_database_65_to_66 $$
CREATE PROCEDURE upgrade_database_65_to_66()
BEGIN

-- add a columns safely
IF NOT EXISTS( (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE()
        AND COLUMN_NAME='isActive' AND TABLE_NAME='Room') ) THEN
    ALTER TABLE Room
        ADD COLUMN isActive TINYINT NOT NULL DEFAULT -1 AFTER version,
        ADD COLUMN createdBy VARCHAR(45) NULL AFTER version,
        ADD COLUMN dateCreated DATETIME NULL AFTER createdBy,
        ADD COLUMN modifiedBy VARCHAR(45) NULL AFTER dateCreated,
        ADD COLUMN dateModified DATETIME NULL AFTER modifiedBy;
END IF;

IF NOT EXISTS( (SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE()
        AND COLUMN_NAME='createdBy' AND TABLE_NAME='HealthLevelHistory') ) THEN
    ALTER TABLE HealthLevelHistory
        ADD COLUMN createdBy VARCHAR(45) NULL AFTER version,
        ADD COLUMN dateCreated DATETIME NULL AFTER createdBy,
        ADD COLUMN modifiedBy VARCHAR(45) NULL AFTER dateCreated,
        ADD COLUMN dateModified DATETIME NULL AFTER modifiedBy;
END IF;

ALTER TABLE HealthLevelHistory MODIFY COLUMN _healthLevelHistory_key INT(11) NOT NULL AUTO_INCREMENT;
UPDATE dbInfo SET dbVers = 66, versDate = now(), databaseReleaseNum = 66 ;

END $$

CALL upgrade_database_65_to_66() $$
DROP PROCEDURE IF EXISTS upgrade_database_65_to_66 $$

DELIMITER ;


