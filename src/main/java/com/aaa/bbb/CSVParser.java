package com.aaa.bbb;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVParser {

	public List<POJO> csvParser() throws IOException {
		
		
		// tworzenie obiektu csvreader i podanie nazwy pliku, ustawianie delimetera
		CSVReader reader = new CSVReader(new FileReader("store.csv"), ';')
				;
		//tworzenie listy obiektow typu POJO ktora zostanie pozniej zwrocona
		List<POJO> csvs = new ArrayList<POJO>();
		
		String[] record = null;

		//pominiecie headera
		reader.readNext();

		while ((record = reader.readNext()) != null) {
			//tworzenie obiektu POJO do ktorego wpisywane beda parametry odczytane z pliku csv
			POJO csv = new POJO();
			//setowanie poszczegolnych zmiennych
			csv.setKey(record[0]);
			csv.setIdentifier(record[1]);
			csv.setType(record[2]);
			csv.getSimpleAttributes().setAuthor(record[3]);
			csv.getSimpleAttributes().setTitle(record[4]);
			//dodanie obiektu z zasetowanymi parametrami do listy obiektow
			csvs.add(csv);

		}

		reader.close();
		return csvs;
	}
	

}
