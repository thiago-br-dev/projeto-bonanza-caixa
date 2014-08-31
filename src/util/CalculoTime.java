package util;

import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.TimeZone;  
  
public class CalculoTime {  
    public static void main(String[] args) {  
        System.out.println(subtraiHora("03:10:01","02:00:00"));  
          
    }  
      
    public static String subtraiHora(String hora, String hora2) {    
          SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");    
          formatter.setTimeZone(TimeZone.getTimeZone("GMT"));    
        
          long min_1 = getMinutos(hora, formatter);    
          long min_2 = getMinutos(hora2, formatter);
          
          long result = (min_1 - min_2) *  1000;
          System.out.println(result);
          Date data = new Date(result);    
          return formatter.format(data);    
       }    
        
       private static long getMinutos(String hora, SimpleDateFormat formatter) {    
          Date data;    
          try {    
             data = formatter.parse(hora);    
          } catch (ParseException e) {    
             return 0;    
          }    
          long minutos = data.getTime() / 1000;  
          System.out.println("minutos "+minutos);
          return minutos;    
       }  
  
}  