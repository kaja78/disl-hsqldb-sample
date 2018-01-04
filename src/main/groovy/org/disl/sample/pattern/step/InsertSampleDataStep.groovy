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
package org.disl.sample.pattern.step

import org.disl.pattern.ExecuteSQLScriptTableStep
import org.disl.sample.dataModel.common.SourceTable;

class InsertSampleDataStep extends ExecuteSQLScriptTableStep {
	
	SourceTable getTable() {
		(SourceTable)super.getTable()
	}
	
	String getCode() {
		getTable().sampleData.collect({getInsertStatement(it)}).join('\n')
	}
	
	String getInsertStatement(Map row) {
		"INSERT INTO ${table.fullName} (${row.keySet().join(',')}) VALUES (${row.values().join(',')});"		
	}

}
