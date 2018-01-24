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
package org.disl.sample.scripts


import org.disl.meta.Mapping
import org.disl.meta.Table
import org.disl.sample.dataModel.target.R_EMPLOYEE

@BaseScript(org.disl.workflow.DislScript)
import groovy.transform.BaseScript

def objects=[]
sqlDepUserAccountId='7297560a-3528-4b89-9f4a-e279968e2227'
sqlDepCustomSqlSetName='disl-hsqldb-saple (rest API)'

objects.addAll createAll(R_EMPLOYEE,'org.disl.sample', Table)
objects.addAll createAll(R_EMPLOYEE,'org.disl.sample', Mapping)

sqlDepPublish(sqlDepUserAccountId,sqlDepCustomSqlSetName,objects)





