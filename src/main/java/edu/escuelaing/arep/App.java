package edu.escuelaing.arep;

import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase app que inicia los servidores spark
 * @author Alexander Torres
 *
 */
public class App 
{ 
	
	/**
	 * Inicializa el servidor web de spark, publica y recibe los mensajes
	 * @param args ejecucion
	 */
    public static void main( String[] args )
    {
    	port(getPort());
        get("/convertidor", (req, res) -> { 
        	 String contenido
        	 = "<!DOCTYPE html>"
                     + "<html>"
                     + "<h:head>"
                     + "<style>"
                     + "body {background-color: LightSteelBlue;}"
                     + "h1   {color: blue;}"
                     + "p    {color: White;}"
                     + "</style>"
                     + "</h:head>"
                     + "<body>"
                     + "<div class=\"center\">"
                     + "<h1><p align=\"center\" style=\"font-size:40px;\">Calculadora</p></h1>"
                     + "<h3> <p align=\"center\">James Alexander Torres</p></h3>"
                     + "<center><img src=\"https://media.tenor.com/images/de2a9b7bb8147c9c93a0d4e474550fbe/tenor.gif\" alt=\"programing\" align=\"middle\" style=\"width:120px;height:100px;\"></img></center>"
                     + "</div>"
                     + "<h3> <p align=\"center\"></p></h3>"
                     + "<h3 style=\"	color:black;text-align:center\">Convertir de Fahrenheit a Celsius</h3>"
                     + "<br>"
                     + "<form action=\"/final\">"
                     + "<center><input align=\"middle\" id=\"datos\" placeholder=\"Ingrese los valores\" name=\"numero\" value=\"\" /></center>"
                     + "<br>"
                     + "<center><input align=\"middle\" type=\"submit\" align=\"center\" style=\"background-color: #3CBC8D\" update=\"calculadora_form\" onclick=\"\"></input></center>"
                     + "</form>"
                     + "<br><br>"   
                     + "<img src=\"https://concepto.de/wp-content/uploads/2018/08/Estadistica-inferencial-min-e1533841684477.jpg\" alt=\"Trulli\" width=\"49%\" height=\"170\"></img>"
                     + "<img src=\"https://developingthebusiness.com/wp-content/uploads/2018/05/Estadisticas-de-ventas.jpg\" alt=\"Trulli\" width=\"50%\" height=\"170\"></img>"
                     + "</body>"
                     + "</html>";
        	return contenido;});
    
        get("/resultado", (req, res) -> { 
        	 int valor= Integer.parseInt(String.valueOf(req));
             String resultado="";
             try {
                 URL url = new URL("https://kxjw75scsb.execute-api.us-east-1.amazonaws.com/alpha"+ "?value=" + valor);
                 String temp;
                 BufferedReader reader = new BufferedReader(
                         new InputStreamReader(url.openStream()));
                 while ((temp = reader.readLine()) != null) {
                	 resultado = resultado + temp;
                 }
             } catch (MalformedURLException ex ) {
                 Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
                 Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
             }
             return resultado;      
        });
    	}
        
        /**
         * retorna el puerto en uso
         * @return el puerto usado 
         */
        static int getPort() {
            if (System.getenv("PORT") != null) {
                return Integer.parseInt(System.getenv("PORT"));
            }
            return 6001;
        }

    }