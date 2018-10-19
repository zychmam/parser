package com.aaa.bbb;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONWriter {

	public static void main(String[] args) throws IOException {
		
		//ostateczna lista obiektow POJO 
		List<POJO> total = new ArrayList<POJO>();
		
		//tworzenie obiektu ObjectMapper sluzacego do generowania pliku json
		ObjectMapper mapper = new ObjectMapper();
		
		//tworzenie obiektow klas CSV oraz XML Parser w celu wywolania ich wewnetrznych funkcji parsujacych
		CSVParser csvParse = new CSVParser();
		XMLParser xmlParse = new XMLParser();
		
		//dodanie zwracanych przez metody obiektow do ostatecznej listy
		total.addAll(csvParse.csvParser());
		total.addAll(xmlParse.xmlParser());

		FileOutputStream fileOutputStream = new FileOutputStream("Magazyn322.json");
		
		//inkluzja tylko niezerowych atrybutow
		mapper.setSerializationInclusion(Include.NON_NULL);
		
		//prettyprint - enable - formatowanie jsona
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		//końcowe wpisanie i zamkniecie streama
		mapper.writeValue(fileOutputStream, total);
		fileOutputStream.close();

	}
}
