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
package org.disl.sample.dataMapping.common

import org.disl.meta.Mapping
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

abstract class Subquery extends Mapping{

	@Before
	public void initTest() {
		init()
		
	}
	
	@Test
	public void testValidate() {
		validate()
	}
	
	@After
	public void copySqlQueryToClipboard() {
		super.copySqlQueryToClipboard()
	}

}
