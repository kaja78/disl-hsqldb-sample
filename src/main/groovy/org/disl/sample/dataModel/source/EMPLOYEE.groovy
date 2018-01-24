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
package org.disl.sample.dataModel.source

import org.disl.meta.Description
import org.disl.meta.ForeignKey
import org.disl.sample.dataModel.common.SourceTable
import org.disl.sample.dataModel.domains.Amount
import org.disl.sample.dataModel.domains.Id
import org.disl.sample.dataModel.domains.Name

@Description('Employee source table.')
class EMPLOYEE extends SourceTable {
	@Description('Employee Id.')
	Id ID

	@Description('Department id.')
	@ForeignKey(targetTable = DEPARTMENT)
	Id DEPARTMENT_ID

	@Description('Employee name.')
	Name NAME

	@Description('Employee name.')
	Name LOCATION

	@Description('Sex flag. F - female, M - male.')
	Name SEX

	@Description('Monthly salary.')
	Amount SALARY
	
	List<Map> sampleData=[
		[ID:'1',DEPARTMENT_ID:'1',NAME:"'John'",LOCATION:"'Prague'",SEX:"'M'",SALARY:'10000'],
		[ID:'2',DEPARTMENT_ID:'1',NAME:"'Jack'",LOCATION:"'Prague'",SEX:"'M'",SALARY:'11000'],
		[ID:'3',DEPARTMENT_ID:'2',NAME:"'Marry'",LOCATION:"'Prague'",SEX:"'F'",SALARY:'15000'],
		[ID:'4',DEPARTMENT_ID:'2',NAME:"'Jane'",LOCATION:"'Prague'",SEX:"'F'",SALARY:'14000'],
		[ID:'5',DEPARTMENT_ID:'2',NAME:"'Fred'",LOCATION:"'Prague'",SEX:"'M'",SALARY:'15000']
		]

}
