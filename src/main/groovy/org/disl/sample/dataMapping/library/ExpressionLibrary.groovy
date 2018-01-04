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
package org.disl.sample.dataMapping.library

import org.disl.util.test.AbstractDislTestCase
import org.junit.Test;

class ExpressionLibrary extends AbstractDislTestCase {

	static final String NOT_AVAILABLE="'XNA'"
	
	@Test
	void testNvlXNA() {
		assertExpressionEquals(NOT_AVAILABLE,nvlXNA(null))
		assertExpressionEquals("'value'",nvlXNA("'value'"))
	}
	
	static String nvlXNA(def value) {
		"nvl($value,$NOT_AVAILABLE)"
	}
	
	@Test
	void testDecodeSex() {
		assertExpressionEquals("'Male'",decodeSex("'M'"))
		assertExpressionEquals("'Female'",decodeSex("'F'"))
		assertExpressionEquals(NOT_AVAILABLE,decodeSex("'X'"))
	}
	
	static String decodeSex(def sexFlag) {
		"""\
TRIM(CASE WHEN $sexFlag='M' THEN
		'Male'
WHEN $sexFlag='F' THEN
		'Female'
ELSE
		$NOT_AVAILABLE
END)
"""
	}
	

	
}
