


	import java.io.*;
import java.util.Properties;
public class propiedades {
	
	
	String archivo_properties="pi_to_ines.properties";
	
	
	String temp_outFile;
	String outFile;
	String hora_generacion;
	
	Properties prop  = new Properties();
	
	String temp_outFile(){
			try{
				prop.load(new FileInputStream(archivo_properties));
				temp_outFile = prop.getProperty("temp_outFile");
			}catch(IOException e){
			}
			return temp_outFile;
			}
	String outFile(){
		try{
			prop.load(new FileInputStream(archivo_properties));
			outFile = prop.getProperty("outFile");
		}catch(IOException e){
		}
		return outFile;
		}
	
	
	String hora_generacion(){
		try{
			prop.load(new FileInputStream(archivo_properties));
			hora_generacion = prop.getProperty("hora_generacion");
		}catch(IOException e){
		}
		return hora_generacion;
		}

}