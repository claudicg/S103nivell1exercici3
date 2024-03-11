package n1exercici3.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ReaderUtils {
	
	public static void llegirArxius(String path, String fileName, Map<String, String> mapa) {
			
		BufferedReader br = null;
			
		try {
			File file = new File(path + fileName);

		    br = new BufferedReader(new FileReader(file)); 

		    String linea;

		    while ((linea = br.readLine()) != null) {
		        
		    	guardarLinea(linea, mapa);
		    
		    }
		        
		}catch(FileNotFoundException e) {
		    System.out.println("Fichero no encontrado.");	
		}catch(IOException e) {
		    System.out.println("Error de E/S.");
		}catch(Exception e) {
		    System.out.println("Error general." + e);
		}finally {
		    try {
		    	br.close();
			} catch (IOException e) {
				System.out.println("Error al intentar cerrar el buffer.");
			}
		}
	}
	
	private static void guardarLinea(String linea, Map<String, String> mapa) {

	    String[] partes = linea.split(" ");        
	    String clave = partes[0].trim();
	    String valor = partes[1].trim();
	            	
	    mapa.put(clave, valor);  
	}
}
