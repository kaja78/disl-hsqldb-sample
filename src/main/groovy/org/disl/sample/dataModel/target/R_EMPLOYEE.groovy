/*
 * Copyright 2015-2018 Karel Hübl <karel.huebl@gmail.com>.
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
package org.disl.sample.dataModel.target

import org.disl.meta.Description
import org.disl.sample.dataModel.common.TargetTable;
import org.disl.sample.dataModel.domains.Amount
import org.disl.sample.dataModel.domains.Id
import org.disl.sample.dataModel.domains.Name

@Description('Employee target denormalized table.')
class R_EMPLOYEE extends TargetTable {
	@Description('Employee id.')	
	Id EMP_ID
	
	@Description('Employee name.')
	Name EMP_NAME
	
	@Description('Employee gender.')
	Name GENDER
	
	@Description('Department name.')
	Name DEPT_NAME
	
	@Description('Office location.')
	Name LOCATION
	
	@Description('Employee salary')
	Amount SALARY
	
	@Description('Department average salary.')
	Amount DEPT_AVG_SALARY
	
	@Description('Department average salary of female employees.')
	Amount FEMALE_AVG_SALARY
	
	
}
