package com.aaa.bbb;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

	public List<POJO> xmlParser() {

		List<POJO> xmls = new ArrayList<POJO>();

		try {
			//podanie nazwy pliku i tworzenie documentbuildera do parsowania
			File inputFile = new File("Sklep.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			
			//normalizacja formatowania
			doc.getDocumentElement().normalize();

			//lista elementow z tagiem produkt
			NodeList nList = doc.getElementsByTagName("produkt");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					//tworzenie obiektu typu POJO w celu przypisania odczytanych wartosci
					POJO xml = new POJO();
					
					//rzutowanie wezla na element zeby uzyc metod do odczytu
					Element eElement = (Element) nNode;
					
					//przypisanie typu i klucza
					xml.setType(eElement.getAttribute("typ"));
					xml.setKey(eElement.getAttribute("klucz"));
					
					//przypisanie id
					xml.setIdentifier((eElement.getElementsByTagName("identyfikator").item(0).getTextContent()));
					
					//lista elementów z tagiem parametry
					NodeList parametersList = eElement.getElementsByTagName("parametry");

					for (int count = 0; count < parametersList.getLength(); count++) {

						Node node1 = parametersList.item(count);


							Element parameter = (Element) node1;

								//bezposrednie przypisanie tytulu - nigdy nie null
								xml.getSimpleAttributes()
										.setTitle(parameter.getElementsByTagName("tytuł").item(count).getTextContent());
								
								//przypisanie pozostałych parametrów z uzyciem funkcji getTagValue - sprawdza czy nie null
								String wykonawca = getTagValue("wykonawca", parameter);
								if (wykonawca != null) {

									xml.getSimpleAttributes().setWykonawca(getTagValue("wykonawca", parameter));
								}

								String gatunek = getTagValue("gatunek", parameter);
								if (gatunek != null) {

									xml.getSimpleAttributes().setGatunek(getTagValue("gatunek", parameter));
								}
								String cena = getTagValue("cena", parameter);
								if (cena != null) {

									xml.getSimpleAttributes().setCena(getTagValue("cena", parameter));
								}
								String podtytuł = getTagValue("podtytuł", parameter);
								if (podtytuł != null) {

									xml.getSimpleAttributes().setPodtytul(getTagValue("podtytuł", parameter));
								}
						//dodanie zasetowanego POJO do listy 
						xmls.add(xml);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return xmls;
	}
   
 
   //zwracanie atrybutu szukanego po tagu jesli niezerowy (zapezpieczenie przed nullpointerexception)
   private static String getTagValue(String tag, Element eElement) {
	   if (eElement.getElementsByTagName(tag).item(0)!=null) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    return nValue.getNodeValue();
	   } return null;
	}
}