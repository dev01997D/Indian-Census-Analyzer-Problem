/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.blz.censusanalyzer.tester;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.blz.censusanalyzer.controller.CensusAnalyser;
import com.blz.censusanalyzer.controller.CensusAnalyserException;

public class CensusAnalyserTest {
	private static String CORRECT_CSV_FILE_PATH = "E:\\Eclipse-Workspace-java-developer\\CensusAnalyzerAssignment\\src\\test\\resources\\IndianStateCensusData.csv";
	private static String WRONG_CSV_FILE_PATH = "E:\\Eclipse-Workspace-java-developer\\CensusAnalyzerAssignment\\src\\IndianStateCensusData.csv";

	@Test
	public void givenIndianCensusCSVFile_ShouldReturnCorrectNumberOfRecordTest() {
		CensusAnalyser censusAnalyzerObj = new CensusAnalyser();
		int numOfEntries;
		try {
			numOfEntries = censusAnalyzerObj.loadIndiaCensusData(CORRECT_CSV_FILE_PATH);
			Assert.assertEquals(29, numOfEntries);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenWrongIndianCensusCSVFile_ShouldReturnCustomExceptionTest() {
		try {
			CensusAnalyser censusAnalyzerObj = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none(); // Allow us to verify the Exception thrown
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyzerObj.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenWrongType_IndianCensusCSVFile_ShouldReturnCustomExceptionTest() {
		try {
			CensusAnalyser censusAnalyzerObj = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none(); // Allow us to verify the Exception thrown
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyzerObj.loadIndiaCensusData(CORRECT_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
}
