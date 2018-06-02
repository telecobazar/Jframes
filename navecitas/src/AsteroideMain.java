import java.io.*;
import java.util.*;

public class AsteroideMain {
	  
	public static int nivel=1;
	public static int puntuacion;
	
	private static Iterator<Integer> i;

	/**
	 * salva cada puntuacion de cada jugador de la partida en un fichero
	 * @param nombref nombre que queremos dar al fichero
	 * @param jugadores set de jugadores que se van a almacenar
	 * @throws IOException excepcion de tipo entrada-salida
	 */
	private static void guardarJugadores(String nombref, Set<Jugador>jugadores) throws IOException {
		boolean r=false;
		DataOutputStream salida = null;
		try{
			salida = new DataOutputStream (new FileOutputStream(nombref));
			
			for(Jugador j: jugadores){
				salida.writeUTF(j.getNombre());
				Iterator<Integer> i;
 				i=j.getPuntuaciones().iterator();
 				int aux2;
 				aux2=j.getPuntuaciones().size();
 				salida.writeByte(aux2);
 				int aux;
 				aux = (int) i.next();
 					while(i.hasNext()){			
 						salida.writeInt(aux);
 					}
			}
				r=true;
			}catch(IOException e){e.getMessage();}
		finally{
				if(salida!=null)
					try{
						salida.close();
					}catch(IOException e){}
			}	
	}
	
	/**
	 * Carga los jugadores de un fichero
	 * @param f fichero que contiene los jugadores con sus puntuaciones
	 * @return devuelve un set con los jugadores
	 * @throws FileNotFoundException Si no encuentra el archivo saltara esta excepcion
	 * @throws IOException excepcion tipo io
	 */
	public static Set<Jugador> cargarJugadores(File f)throws FileNotFoundException, IOException{
		boolean eof=false;
		Set<Jugador> set = new HashSet<Jugador>();
		DataInputStream entrada = null;
		try{
			entrada = new DataInputStream(new FileInputStream (f));
			while(!eof){
				try{
					Jugador j = new Jugador(entrada.readUTF());
					for(int i=0;i<entrada.readByte();i++){
					j.getPuntuaciones().add(entrada.readInt());
					}
					set.add(j);
					}catch(EOFException s){eof=true;}
			}
		}catch(IOException e){e.getMessage();}
		finally{
			if(entrada!=null)
				try{
					entrada.close();
				}catch(IOException e){}
		}
		return set;
	}
		
public static void main (String[] args) throws InterruptedException  {
	
	
	
	File fichero = new File("fjugadores.txt");
	
	Set<Jugador> jugadores = new HashSet<Jugador>();
	

		 EscenarioAsteroides m = new EscenarioAsteroides(500,500);       // Creamos el escenario. 
	     Coordenada c1 = new Coordenada(0,250);     					 // Coordenadas para la nave 1 y bala
	     Coordenada c2 = new Coordenada(200,350);						 // Coordenadas para el asteroide 1 
	     Coordenada c3 = new Coordenada(500,100);						 // Coordenadas para el asteroide 2
	     Coordenada c4 = new Coordenada(150,100);						 // Coordenadas para la nave extraterrestre
	     Coordenada c5 = new Coordenada(375,147);						 // Coordenadas para Roger el extraterrestre
	     Coordenada c6 = new Coordenada(150,200);						 // Coordenadas para la Ventaja
	     Coordenada c7 = new Coordenada(175,400);						 // Coordenadas para la Desventaja
	     
	     Rectangulo r1 = new Rectangulo(c1,40,50);  					 // Rectangulo donde dibujar la nave 1
	     Rectangulo r2 = new Rectangulo(c1,40,50);						 // Rectangulo donde dibujar la nave 2 (ancho, alto)
	     Rectangulo r3 = new Rectangulo(c2,40,40);						 // Rectangulo para pintar los asteroides  
	     Rectangulo r4 = new Rectangulo(c3,40,40); 						 // Rectangulo para pintar los asteroides  
	     Rectangulo r5 = new Rectangulo(c4,60,60);						 // Rectangulo para pintar una nave extraterrestre 
	     Rectangulo r6 = new Rectangulo(c5,100,100);					 // Rectangulo para pintar a Roger el extraterrestre
	     Rectangulo r7 = new Rectangulo(c1,20,40);					     // Rectangulo para pintar la bala
	     Rectangulo r8 = new Rectangulo(c6,30,40);                       // Rectangulo para la Ventaja
	     Rectangulo r9 = new Rectangulo(c7,20,40);						 // Rectangulo para la Desventaja
	     
	     
	  // Creamos las naves y asteroides 
   	  
	     Nave nave1 = new Nave(r1, "n1.png", m,1);
	     Nave nave2 = new Nave(r2, "n2.png", m,1); 
   	  	 Asteroide a1 = new Asteroide(r3, "a3.png",m,-1);
	     Asteroide a2 = new Asteroide(r4, "a3.png",m,-1);
	     Asteroide a3 = new Asteroide(r5, "a4.png",m,-1); // nave extraterrestre
	     Asteroide a4 = new Asteroide(r6, "a5.png",m,-1); // Roger el extraterrestre 
	     Bala bala1 = new Bala(r7,"rayo.png",m,1);
	     Ventaja ventaja= new Ventaja(r8,"Ventaja.png",m,1);        //Ventaja
	     Desventaja desventaja= new Desventaja(r9,"Desventaja.png",m,1);        //Desventaja
	     boolean masPartidas = true;
	     String si = "si";
	     
	     
	     SuperSimpleGUI ssgui=m.getGUI();
	     
	     Ventana1 ventana1 = new Ventana1();
	     Ventana2 ventana2 = new Ventana2(); 
	     Ventana3 ventana3 = new Ventana3();
	     ventana1.open();
	    
	     
	     if(ventana1.respuesta.equals("si")){
	    	  try{
	    	  
	    	  jugadores = cargarJugadores(fichero);
	    	  }catch(FileNotFoundException z){z.getMessage();
	    	  }catch(IOException e){e.getMessage();}
	    	  finally{ File f = new File("fjugadores.txt");
	    	  }
	      }
	     
	     Scanner sc = new Scanner(System.in);
	   
	      while(masPartidas){
	    	  boolean salir = false;
	    	  masPartidas = false;
    	  
	    if (nivel==1) {
	    	 ventana1.dispose();
		     
	    	  try{
	    		
		    	  m.add(a1);          // AÃ±adimos dos asteroides y una nave al escenario.
		    	  m.add(a2);
		    	  //m.add(bala1);
		    	  m.add(ventaja);
		    	  m.add(desventaja);
		    	  m.add(nave1);
		      }catch(ExcepcionEscenarioLleno e){ } 	  
	    }
	    	  
	    if (nivel==2) {   	
	    	  try{
	    		  m.getGUI().borrar();
	     		  m.reinicializar();
	    		  m.setActores();
	    		  m.add(a1);          // AÃ±adimos los actores al escenario.
	    		  m.add(a2);
	    		  m.add(nave2);
	    		  m.dibujar();
	    	  }catch(ExcepcionEscenarioLleno e){ } catch (ExcepcionJuego excepcionJuego) {
				  excepcionJuego.printStackTrace();
			  }
	    }
	    	  
	    if (nivel==3) {
	    	  try{
	    		  m.getGUI().borrar();
	     		  //m.reinicializar();
				  m.setActores();
	     		 // m.add(a1);          // AÃ±adimos los actores al escenario.
		    	  m.add(a2);
		    	  m.add(a3);
		    	  m.borrarActor(nave1);
		    	  m.borrarActor(a1);
		    	  m.add(nave2);
		  
		      }catch(ExcepcionEscenarioLleno e){ }
	    	  catch (ExcepcionEscenarioVacio e){ }
	    }
	    	  
	    if (nivel==4) {
	    	  try {
				  m.setActores();
				  m.add(a2);
	    		  m.add(a3); 
	    		  m.add(a4);
	    		  m.add(nave2);
	    	  }catch(ExcepcionEscenarioLleno e){ }	  
	    }	
	    
     		while (!salir) {
     			salir = m.ejecutarCicloJuego();	 // Ejecutamos el ciclo de Juego.
     			try{
     			m.dibujar();	                 // Dibujamos los actores en el escenario.
     			}catch(ExcepcionJuego e){}
		}	
     		 ventana2.open();
	    	 ventana2.dispose();
	    	 
     		System.out.println("*  Su puntuacion ha sido de "+  m.getPuntuacion());
     	     		
     		if(ventana2.respuesta.equals("si")){
     			masPartidas = true;
     			m.getGUI().borrar();
     		}else
     		{
    		     
    		     Scanner scaner = new Scanner(System.in);

     			System.out.println("*                                            *");
     			System.out.println("*   ¿Desea exportar fichero de jugadores?    *");
     			System.out.println("*                                            *");  
     			  	if(scaner.nextLine().equals(si)){
     			  		try{
     			  			guardarJugadores("fjugadores.txt", jugadores);
     			  		}catch(IOException e){e.getMessage();}	
     			  }
       			  scaner.close(); 			

     			  	System.out.println("*                                            *");  
 			  		System.out.println("*   Fichero exportado satisfactoriamente     *");
 			  		System.out.println("*                                            *");
     			  	System.out.println("**********************************************");
     			  	System.out.println("*                                            *");
     			  	System.out.println("*    Ahora el universo estara  tranquilo !!  *");
     			  	System.out.println("*                                            *");
     			  	System.out.println("**********************************************");
     			System.exit(0);
     			
     		}
    
     		if(masPartidas) {
     		
     			nivel++;
     			if (nivel<5) {
     				System.out.println("**********************************************");
     				System.out.println("*                                            *");
     				System.out.println("*         Iniciando el NIVEL-> "+nivel+"              *");
     				System.out.println("*                                            *");
     			}
     		}
     		
     		if (nivel==2) {
     			System.out.println("*     Se ha desbloqueado una nueva nave      *");
     			System.out.println("*                                            *");
     			System.out.println("**********************************************");
     		} //if nivel 2 
     		
     		
     		if (nivel==3) {
         		System.out.println("*   Se ha desbloqueado una nueva galaxia     *");
         		System.out.println("*  ¡Cuidado que ahora hay mas asteroides!    *");
         		System.out.println("*                                            *"); 
         		System.out.println("**********************************************");
     		}//if nivel 3

    		if (nivel==4) {
         		System.out.println("*   Se ha desbloqueado una nueva galaxia     *");
         		System.out.println("*  ten cuidado con Roger el extraterrestre   *");
         		System.out.println("*                                            *");
         		System.out.println("**********************************************");
     		}//if nivel 4
    		
    		  if (nivel>4) {
     		     ventana3.open();
  
         		String nombre;
     			Jugador nuevo = new Jugador(nombre=ventana3.respuesta);
     			
         		if(!jugadores.contains(nuevo)){
         			jugadores.add(nuevo);
         		}
         		System.out.println("**********************************************");
     			System.out.println("*                                            *");
     			System.out.println("*         Ranking de puntuaciones:           *");
     			System.out.println("*                                            *");
         		for(Jugador j : jugadores){
         			if(j.equals(nuevo))
         				j.getPuntuaciones().add(m.getPuntuacion());
         			for(Integer i : j.getPuntuaciones()){
         				puntuacion =m.getPuntuacion();
         					System.out.println("* ->  Jugador: "+j.getNombre()+ " con puntuacion: "+i);
         			}
         		}
         		
         		 ventana3.dispose();
         		 
         		 
         		// ventana4.open();
         		System.out.println("*                                            *");
         		System.out.println("*    ¿Quiere actualizar las puntuaciones?    *");
         		System.out.println("*                                            *");
         		String respuesta = sc.nextLine();
         		
         		if(respuesta.equals(si)){
         			System.out.println("*                                            *");
    				System.out.println("*     Puntuaciones guardadas correctamente   *");
    				System.out.println("*                                            *");
         			for(Jugador j : jugadores){
         				int contador = 1;
         				i=j.getPuntuaciones().iterator();
         		
    					if(respuesta.equals("no")){
             				while(i.hasNext()) {
             					if(contador>3) {
             						if(i!=null)
             							j.getPuntuaciones().remove(i);
             					}
             				}contador=contador+1;
    					}			
         			}
         		}
         		System.out.println("**********************************************");
    		    System.out.println("*                                            *");
         		System.out.println("*   ¿Deseas exportar fichero de jugadores?   *");
         		System.out.println("*                                            *");  
         			  
         		if(sc.nextLine().equals(si)){
         			try{
         				guardarJugadores("fjugadores.txt", jugadores);
         			}catch(IOException e){e.getMessage();}		
         		}
         		System.out.println("*                                            *");  
     			System.out.println("*   Fichero exportado satisfactoriamente     *");
     			System.out.println("*                                            *");
         		System.out.println("**********************************************");
         		System.out.println("*                                            *");
         		System.out.println("*  Ahora el universo estara tranquilo !!     *");
         		System.out.println("*                                            *");
         		System.out.println("**********************************************");
         			
         		System.exit(0);
    		    }
	      }// while mas partidas
	}
}