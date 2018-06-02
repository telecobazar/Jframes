
public class Desventaja extends Actor {
	
	 private int velocidadDesventaja = 0;
	 	char tecla;
	    int a;

	    /**
	     * Constructor de la clase Desventaja
	     * @param velocidad Velocidad a la que ira la desventaja.
	     * @param rectangulo Rectangulo en el que esta contenido la desventaja.
	     * @param ficheroImagen Imagen que tendra la desventaja
	     * @param escenario Escenario en el que se ubicara la desventaja.
	     */
	    public Desventaja(Rectangulo rectangulo, String ficheroImagen, Escenario escenario, int velocidadDesventaja){
	        super(rectangulo, ficheroImagen, escenario);
	        if(velocidadDesventaja >= 0){
	        	velocidadDesventaja = 2;
		        this.velocidadDesventaja = velocidadDesventaja;
	        }
	        this.velocidadDesventaja = velocidadDesventaja;
	    }

		/**
		 * Procesa la tecla.
		 * @param tecla tecla que se ha pulsado.
		 */
		public void procesarTecla(char tecla){
			this.tecla=tecla;
				if(tecla =='v'){
					velocidadDesventaja=velocidadDesventaja*2;
				}		
		}
		
	    /**
	     * Realiza sus acciones.
	     */
	    public void actuar(){
	        Rectangulo r =this.getRectangulo();
	        Coordenada c =r.getCoordenada();
	        int aleatorio =(int)(Math.random()*460);
	        if(c.getX()==0){
	            r.setCoordenada(460, aleatorio);
	        }
	        else
	            r.setCoordenada(c.getX()+velocidadDesventaja, c.getY());
	    }

}
