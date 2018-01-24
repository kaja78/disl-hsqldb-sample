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
package org.disl.sample.dataMapping.library

import org.disl.util.test.AbstractDislTestCase
import org.junit.Test;

class ExpressionLibrary extends AbstractDislTestCase {

	static final String NOT_AVAILABLE="'XNA'"
	static final String FEMALE_CODE="'F'"
	static final String MALE_CODE="'M'"
	
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
TRIM(CASE WHEN $sexFlag=$MALE_CODE THEN
		'Male'
WHEN $sexFlag=$FEMALE_CODE THEN
		'Female'
ELSE
		$NOT_AVAILABLE
END)
"""
	}

	@Test
	void testAmountForFemale() {
		assertExpressionEquals('10000',amountForFemale("'F'", 10000))
		assertExpressionEquals(null,amountForFemale("'M'", 10000))
	}
	
	static String amountForFemale(def sexFlag,def amount) {
		"""\
CASE WHEN $sexFlag=$FEMALE_CODE THEN
		$amount
END
"""
	}
	
	@Test
	void testFemaleAvg() {
		def testData=[
			[GENDER:"'M'",AMOUNT:20000],
			[GENDER:"'F'",AMOUNT:25000],
			[GENDER:"'F'",AMOUNT:21000]]
		assertExpressionEquals( '23000',  femaleAvg('GENDER','AMOUNT'), testData)
	}
	
	static String femaleAvg(def sexFlag, def amount) {
		"AVG(${amountForFemale(sexFlag,amount)})"
	}
	
}
