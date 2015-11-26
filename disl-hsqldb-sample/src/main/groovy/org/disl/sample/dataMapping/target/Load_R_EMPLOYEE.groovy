/*
 * Copyright 2015 Karel Hübl <karel.huebl@gmail.com>.
 *
 * This file is part of disl.
 *
 * Disl is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Disl is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Disl.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.disl.sample.dataMapping.target

import static org.disl.sample.dataMapping.library.ExpressionLibrary.*

import org.disl.meta.ColumnMapping
import org.disl.meta.MetaFactory
import org.disl.sample.dataMapping.common.LoadTargetTableMapping
import org.disl.sample.dataModel.source.EMPLOYEE
import org.disl.sample.dataModel.target.R_EMPLOYEE
import org.junit.Assert
import org.junit.Test

class Load_R_EMPLOYEE extends LoadTargetTableMapping {
	
	R_EMPLOYEE target
	
	EMPLOYEE emp
	DepartmentSubquery dept

	ColumnMapping EMP_ID=e emp.ID
	ColumnMapping EMP_NAME=e emp.NAME
	ColumnMapping GENDER=e decodeSex(emp.SEX)
	ColumnMapping DEPT_NAME=e dept.DEPARTMENT_NAME
	ColumnMapping LOCATION=e emp.LOCATION
	ColumnMapping SALARY=e emp.SALARY
	ColumnMapping DEPT_AVG_SALARY=e dept.AVG_SALARY	
		
	@Override
	public void initMapping() {
		from emp
		leftOuterJoin dept on "$dept.DEPARTMENT_ID=$emp.DEPARTMENT_ID"
	}
	
}
