package com.blz.censusanalyzer.controller;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyser {
	private static String CSV_FILE_PATH="E:\\Eclipse-Workspace-java-developer\\CensusAnalyzerAssignment\\src\\test\\resources\\IndianStateCensusData.csv";
	public int loadIndiaCensusData(String csvFilePath) {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			
			CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndiaCensusCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			
			CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			int numOfEntries = 0;
			while (censusCSVIterator.hasNext()) {
				numOfEntries++;
				censusCSVIterator.next();
			}
			return numOfEntries;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void main(String[] args) {
		CensusAnalyser censusAnalyzerObj=new CensusAnalyser();
		int numOfEntries=censusAnalyzerObj.loadIndiaCensusData(CSV_FILE_PATH);
		System.out.println(numOfEntries);
	}
}
