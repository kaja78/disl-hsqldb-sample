/*
 * Copyright 2015-2018 Karel H�bl <karel.huebl@gmail.com>.
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

import org.disl.meta.ColumnMapping
import org.disl.sample.dataMapping.common.Subquery
import org.disl.sample.dataModel.source.DEPARTMENT
import org.disl.sample.dataModel.source.EMPLOYEE

class DepartmentSubquery extends Subquery {

	DEPARTMENT dep
	EMPLOYEE emp
	
	ColumnMapping DEPARTMENT_ID=e dep.ID
	ColumnMapping DEPARTMENT_NAME=e dep.NAME
	ColumnMapping AVG_SALARY=a "AVG($emp.SALARY)"
	
	
	void initMapping() {
		from dep
		innerJoin emp on "$dep.ID=$emp.DEPARTMENT_ID"
	}
}
