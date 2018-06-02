
public class Ventaja extends Actor{
	private int velocidadVentaja = 0;
	char tecla;
    int a;

    /**
     * Constructor de la clase Ventaja
     * @param velocidad Velocidad a la que ira la ventaja.
     * @param rectangulo Rectangulo en el que esta contenido la ventaja.
     * @param ficheroImagen Imagen que tendra la ventaja
     * @param escenario Escenario en el que se ubicara la ventaja.
     */
    public Ventaja(Rectangulo rectangulo, String ficheroImagen, Escenario escenario, int velocidadAsteroide){
        super(rectangulo, ficheroImagen, escenario);
        if(velocidadVentaja >= 0){
        	velocidadVentaja =2;
        this.velocidadVentaja = velocidadVentaja;}
        this.velocidadVentaja = velocidadVentaja;
    }
    /**
	 * Procesa la tecla.
	 * @param tecla tecla que se ha pulsado.
	 */
	public void procesarTecla(char tecla){
		this.tecla=tecla;
			if(tecla =='v'){
				velocidadVentaja=velocidadVentaja*2;
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
            r.setCoordenada(c.getX()+velocidadVentaja, c.getY());
    }
    	
    
	
	
	
}
