package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import model.Properties;

/**
 * Serialization and deserialization of simple .ini files, containing only
 * sections (enclosed in square brackets) and property key-value pairs,
 * separated by an equals sign.
 * 
 * @author Wim Ombelets
 * @version 20131124-01 - initial commit
 *
 */
public class SimpleIniFile {

	//data members
	
	private Path pathToIniFile;
	
	public Path getPathToIniFile() {
		return pathToIniFile;
	}

	private void setPathToIniFile(String pathToIniFile) {
		if(pathToIniFile == null || pathToIniFile.isEmpty() || !pathToIniFile.endsWith(".ini"))
			throw new IllegalArgumentException("Path to .ini file cannot be null or empty.");
		else {
			try {
				Path p = Paths.get(pathToIniFile);
				this.pathToIniFile = p;
			} catch (InvalidPathException ipe) {
				throw ipe;
			}
		}
	}

	public static Properties deserialize(String pathToIniFile) {
		
		Path p;
		Properties deserializedProperties = null;
		
		try {
			p = Paths.get(pathToIniFile);
			
			if(p == null)
				return null;
			
			Map<String, String> props = readProperties(p);
			
			
			for(Map.Entry<String, String> entry : props.entrySet()) {
				//entries found, initialize return object
				deserializedProperties = new Properties();
				//key refers to a complex class field
				if(entry.getKey().contains(".")) {
					if(entry.getKey().startsWith("dbproperties")) {
						
					}
				}
				//key refers to a primitive field
				else {
					
				}
			}
			
		} catch (InvalidPathException e) {
			e.printStackTrace();
		}	
		
		return deserializedProperties;
	}
	
	public static Map<String, String> readSection(String sectionName) {

		if(sectionName == null || sectionName.isEmpty())
			return null;
		
		Map<String, String> result = null;
		
		BufferedReader reader = null;
		
		try {
			File file = new File(new FileReader())
		}
	}
	
	private static Map<String, String> readProperties(Path pathToIniFile) {
		
		//check if there is a valid .ini file at given pathToIniFile
		if(Files.notExists(pathToIniFile))
			return null;
		
		Map<String, String> iniProps = new HashMap<String, String>();
		BufferedReader reader = null;
		
		try {
			File file = new File(pathToIniFile.toString());
			reader = new BufferedReader(new FileReader(file));
			String line;
			String sectionName = "";
			
			//as long as there are lines to read
			while((line = reader.readLine()) != null) {
				//line is a section
				if(line.startsWith("[") && line.endsWith("]")) {
					sectionName = line.substring(1, line.length() - 1);
				}
				//line is a key-value pair
				else {
					String key = sectionName + line.split("=")[0];
					String value = line.split("=")[1];
					iniProps.put(sectionName + key, value);
				}
			}
			
			reader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return iniProps;		
	}
	
}
