#***
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
UPDATE `ControlledVocabulary` SET `displayName`='Storage Manager' WHERE `tableName`='Location';
UPDATE `dbInfo` SET `dbVers`='107', `webReleaseNum`='2.10.0', versDate=now(), releaseDate='2013-10-09 00:00:00'  WHERE `_dbinfo_key`='1';
