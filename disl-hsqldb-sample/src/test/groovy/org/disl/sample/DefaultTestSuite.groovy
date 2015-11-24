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
package org.disl.sample

import junit.framework.JUnit4TestAdapter
import junit.framework.TestSuite

import org.disl.meta.Mapping
import org.disl.meta.MetaFactory
import org.disl.meta.Table
import org.disl.sample.dataMapping.common.AbstractJob;
import org.disl.sample.dataMapping.library.ExpressionLibrary
import org.disl.workflow.ClassFinder
import org.junit.runner.RunWith
import org.junit.runners.AllTests

@RunWith(AllTests.class)
class DefaultTestSuite {

	public static TestSuite suite() {
		createTestSuite();
	}

	public static createTestSuite() {
		def testClasses=[]		
		ClassFinder cf=ClassFinder.createClassFinder(ExpressionLibrary)
		testClasses.addAll cf.findNonAbstractTypes('org.disl.sample.dataMapping', Mapping)
		testClasses.addAll cf.findNonAbstractTypes('org.disl.sample.dataModel', Table)
		testClasses.addAll cf.findNonAbstractTypes('org.disl.sample', AbstractJob)
		testClasses.add ExpressionLibrary
		
		TestSuite suite = new TestSuite();
		testClasses.each {suite.addTest(new JUnit4TestAdapter(it))}
		return suite
	}
}