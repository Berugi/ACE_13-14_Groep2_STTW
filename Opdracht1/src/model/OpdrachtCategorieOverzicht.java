package model;

import java.util.HashMap;

import model.baseclasses.Opdracht;
import model.enums.OpdrachtCategorie;
/**
 * 
 * @author Sander Van der Borght
 * 
 * @version 20131229-01 - initial commit
 * @version 20140104-01 - added missing import
 */
public class OpdrachtCategorieOverzicht {

	private HashMap<OpdrachtCategorie,Integer> map;
	
	public static void printCategories(OpdrachtCatalogus _catalogus){
		OpdrachtCatalogus catalogus = _catalogus;
	
		HashMap<OpdrachtCategorie,Integer> map = new HashMap<OpdrachtCategorie,Integer>();
		for(OpdrachtCategorie cat:OpdrachtCategorie.values()){
			map.put(cat, 0);
		}
		
		for(int i =0;i< catalogus.size();i++){
			if(catalogus.change(i) != null){
				Opdracht opdracht = catalogus.change(i);
				map.put(opdracht.getOpdrachtCategorie(), map.get(opdracht.getOpdrachtCategorie()) + 1);
			}
		}
		
		print(map);
	}
	private static boolean print(HashMap<OpdrachtCategorie,Integer> map){
		
		for(OpdrachtCategorie cat:OpdrachtCategorie.values()){
			System.out.println(cat+" "+map.get(cat));
		}
		
		return true;
	}
}
