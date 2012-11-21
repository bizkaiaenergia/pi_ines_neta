




import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Format;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class pi_to_ines_neta {

	public static String ultimo_bucle_generado;
	
	
	public static String hora_actual;
	
	public static String minutos_actual;
	
	public static String dia_actual;
	
	public static String año_actual;
	
	public static String mes_actual;
	public static String mes_actual_us;
	
public static String hora_actual_mas_una;
	
	
	public static String dia_actual_mas_una;
	
	public static String año_actual_mas_una;
	
	public static String mes_actual_mas_una;
	public static String mes_actual_us_mas_una;
	
	public static String texto2="";
	public static String todo;
	
	
	 public static String hora_anterior;
	 
	public static String minutos_hora_anterior;
	
	public static String dia_hora_anterior;
	
	public static String año_hora_anterior;
	
	public static String mes_hora_anterior;
	public static String mes_corto_hora_anterior;
	public static String año_hora_anterior_largo;
	public static Date end_of_month;
	public static Date begining_of_month;
	public static boolean mescompleto;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Exportación de potencia neta de PI a INES");
		//Cogemos fecha y hora actuales.
		Integer	generar_ahora= 0;
		Integer bucle = 1;
		 ultimo_bucle_generado = "200101010000";
		propiedades Archivopropiedades1 = new propiedades();
		String hora_generacion = Archivopropiedades1.hora_generacion();
		
		while (bucle == 1){	
			
			System.out.println("Se generará el ficheros en el primer día de cada mes");
			System.out.println("Con los datos del mes anterior");
			System.out.println("A las 13:00 horas");
			
			do {
			//Espera un tiempo 
				try {
				Thread.sleep(10000);
				
				Date fecha = new Date();
				
				Format formatter = new SimpleDateFormat("HH");
				 hora_actual= formatter.format(fecha);
				formatter = new SimpleDateFormat("mm");
				 minutos_actual= formatter.format(fecha);
				formatter = new SimpleDateFormat("dd");
				 dia_actual= formatter.format(fecha);
				formatter = new SimpleDateFormat("yy");
				 año_actual= formatter.format(fecha);
				formatter = new SimpleDateFormat("MMM",new Locale("us_US"));
				 mes_actual_us= formatter.format(fecha);
				 formatter = new SimpleDateFormat("MM");
				 mes_actual= formatter.format(fecha);
				 
				 /*
				GregorianCalendar cal_fecha = new GregorianCalendar ();
				cal_fecha.setTime(fecha);
				cal_fecha.add(Calendar.HOUR_OF_DAY,-1);
				Date Fecha_menos_una_hora = cal_fecha.getTime();
				
				formatter = new SimpleDateFormat("HH");
				 hora_anterior= formatter.format(Fecha_menos_una_hora);
				formatter = new SimpleDateFormat("mm");
				 minutos_hora_anterior= formatter.format(Fecha_menos_una_hora);
				formatter = new SimpleDateFormat("dd");
				 dia_hora_anterior= formatter.format(Fecha_menos_una_hora);
				formatter = new SimpleDateFormat("yy");
				 año_hora_anterior= formatter.format(Fecha_menos_una_hora);
				 formatter = new SimpleDateFormat("yyyy");
				 año_hora_anterior_largo= formatter.format(Fecha_menos_una_hora);
				 
				 
				 
				formatter = new SimpleDateFormat("MMM",new Locale("us_US"));
				 mes_hora_anterior= formatter.format(Fecha_menos_una_hora);
				 formatter = new SimpleDateFormat("MM");
				 mes_corto_hora_anterior= formatter.format(Fecha_menos_una_hora);
				 */
				 
				 ///// CAMBIOS PARA POTENCIA NETA UNA VEZ AL MES !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				 //String nuevo_bucle_a_generar = año_actual + mes_actual + dia_actual + hora_actual + minutos_actual;
				 String bucle_actual = año_actual + mes_actual + dia_actual + hora_actual + minutos_actual;
				 //String nuevo_bucle_a_generar = año_actual + mes_actual + "01" + hora_generacion;
				 String nuevo_bucle_a_generar = año_actual + mes_actual + "09" + hora_generacion;
				 //importante admiración delante de ultimo_bucle_generado ....
			
				 if ( bucle_actual.equals(nuevo_bucle_a_generar) && !ultimo_bucle_generado.equals(nuevo_bucle_a_generar) ){
					 generar_ahora = 1;
			 	ultimo_bucle_generado = bucle_actual;
				 }else{
					 generar_ahora = 0;
					 ///////////////////////////////PARA TESTS 
					 generar_ahora = 1;
					 /////////////////////////////PARA TESTS 
				 }
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					
			}while(generar_ahora != 1);
				
			
				propiedades Archivopropiedades = new propiedades();
				String temp_outFile = Archivopropiedades.temp_outFile();
				String outFile = Archivopropiedades.outFile();
				System.out.println(temp_outFile);
				System.out.println(outFile);
				
				Calendar calendar = GregorianCalendar.getInstance();
			    calendar.setTime(new Date());
			    
			    calendar.set(Calendar.DAY_OF_MONTH,
		                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		        calendar.set(Calendar.HOUR_OF_DAY, 0);
			    calendar.set(Calendar.MINUTE, 0);
			    calendar.set(Calendar.SECOND, 0);
			    calendar.set(Calendar.MILLISECOND, 0);
		        end_of_month = calendar.getTime();
			    
			    
			    
			    calendar.add(Calendar.DAY_OF_MONTH,-10);
				
			    calendar.set(Calendar.DAY_OF_MONTH,
		                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			    calendar.set(Calendar.HOUR_OF_DAY, 0);
			    calendar.set(Calendar.MINUTE, 0);
			    calendar.set(Calendar.SECOND, 0);
			    calendar.set(Calendar.MILLISECOND, 0);
		        begining_of_month = calendar.getTime();
				
		        /*
		        calendar.set(Calendar.DAY_OF_MONTH,
		                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		        calendar.set(Calendar.HOUR_OF_DAY, 0);
			    calendar.set(Calendar.MINUTE, 0);
			    calendar.set(Calendar.SECOND, 0);
			    calendar.set(Calendar.MILLISECOND, 0);
		        end_of_month = calendar.getTime();
		        */
		    	calendar.setTime(begining_of_month);
		    	mescompleto=false;
		        do{
		        	
		        		        	
		        
		        	Date calendar_date = calendar.getTime();
		        	Format formatter = new SimpleDateFormat("HH");
					hora_actual= formatter.format(calendar_date);
					formatter = new SimpleDateFormat("dd");
					dia_actual= formatter.format(calendar_date);
					formatter = new SimpleDateFormat("yyyy");
					año_actual= formatter.format(calendar_date);
					formatter = new SimpleDateFormat("MMM",new Locale("us_US"));
					mes_actual_us= formatter.format(calendar_date);
					calendar.add(Calendar.HOUR_OF_DAY,1);
					 calendar_date = calendar.getTime();
					 formatter = new SimpleDateFormat("HH");
					hora_actual_mas_una= formatter.format(calendar_date);
					formatter = new SimpleDateFormat("dd");
					dia_actual_mas_una= formatter.format(calendar_date);
					formatter = new SimpleDateFormat("yyyy");
					año_actual_mas_una= formatter.format(calendar_date);
					formatter = new SimpleDateFormat("MMM",new Locale("us_US"));
					mes_actual_us_mas_una= formatter.format(calendar_date);
		        	
		        	
		        	String texto1 = "@echo off\r\n@table piarc\r\n@mode list\r\n@istru tag, starttime, endtime, count\r\n@ostru tag, value, time, status\r\n@ostru ...\r\n";	
		        	 texto2 = texto2 + "10CJA00DE100.XQ20," + dia_actual +"-" + mes_actual_us + "-" + año_actual + " " + hora_actual+ ":00:00, "+ dia_actual_mas_una +"-" + mes_actual_us_mas_una + "-" + año_actual_mas_una + " " + hora_actual_mas_una+ ":00:00 " + ",1\r\n10CJA00DE100.XQ20I," + dia_actual +"-" + mes_actual_us + "-" + año_actual + " " + hora_actual+ ":00:00, "+ dia_actual_mas_una +"-" + mes_actual_us_mas_una + "-" + año_actual_mas_una + " " + hora_actual_mas_una+ ":00:00 " + ",1\r\n";
		        	 String texto3 = "@endsection\r\n";
		        	  todo = texto1+texto2+texto3;
		        	 
		        	 if (calendar_date.after(end_of_month)) {
		        		 mescompleto=true;
		        		 System.out.println(todo);
		        	 }
		        	 
		        	 
		        }while(mescompleto==false);
		        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		        
				try {
				File f = new File("0INEStag.txt");
				FileWriter fw;
				fw = new FileWriter(f);
				fw.write(todo);
				fw.close();
				Runtime rt = Runtime.getRuntime();
				Process pr1;
				String archivo_salida = temp_outFile + "AmorebietaPotNetaPlantData_" + año_actual + mes_actual  + "_INES.dat";
				String rt_exec = "cmd /c D://PI//adm//piconfig < 0INEStag.txt > " + archivo_salida;
				pr1 = rt.exec(rt_exec);
				
				System.out.println(rt_exec);
				BufferedReader input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
				String line=null;
				while((line=input.readLine()) != null) {
			        System.out.println(line); 
			        int exitVal;
			        exitVal = pr1.waitFor();
			        System.out.println("Exited with error code "+exitVal); 
				}			
				
				File file = new File(archivo_salida);
				System.out.println("Se va a mover el archivo " + archivo_salida);
				File dir = new File(outFile);
				boolean success = file.renameTo(new File(dir, file.getName()));
				System.out.println("A la dirección " + outFile);
				
				if (!success) {
				   System.out.println("No se ha podido mover el fichero");
				}else{
					   System.out.println("Fichero " + "AmorebietaCMSPlantData_" + año_hora_anterior + mes_corto_hora_anterior + dia_hora_anterior + hora_anterior + "_ZIV.dat"+ " movido con exito");
				}
				
				
				
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
					
				
		
			 
			 
			 
			 
			 
			 
		}
		
	}

}
