
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase Ventana
 * Muestra la estructuta que deberia tener una Ventana en Java con la libreria
 * Swing, contiene una etiqueta, un caja de texto y un boton, que tiene la
 * accion de mostrar el texto en la caja por una ventana de mensaje.
 */
public class Ventana4 extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel texto1;           // etiqueta o texto no editable
    private JButton boton1, boton2;          // boton con una determinada accion
    public String respuesta;
    private Thread thread;

    public Ventana4() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
    }

    private void configurarVentana() {
        this.setTitle("Space invaders");                        // colocamos titulo a la ventana
        this.setSize(400, 300);        
        this.getContentPane().setBackground(Color.LIGHT_GRAY);		// le damos un poco de color a la ventana// colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    private void inicializarComponentes() {
        // creamos los componentes
        texto1 = new JLabel();
        boton1 = new JButton();
        boton2 = new JButton();
        
        // configuramos los componentes
        
        texto1.setText("Desea exportar el fichero de puntuaciones?");
        texto1.setBounds(70, 30, 600, 100); 			// colocamos posicion y tamaño al texto (x, y, ancho, alto)
    	
    	boton1.setText("si");
        boton1.setBackground(Color.green);
        boton1.setBounds(70,100,80,40);  		 // colocamos posicion y tamaÃ±o al boton (x, y, ancho, alto)
        boton1.addActionListener(this);
        boton2.setText("no");
        boton2.setBackground(Color.red);
        boton2.setBounds(220,100,80,40);
        boton2.addActionListener(this);
        
        // añadimos los componentes a la ventana
        
        this.add(texto1);
        this.add(boton1);
        this.add(boton2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    		 if(e.getActionCommand().equals("si")){//podemos comparar por el contenido del boton
 	            JOptionPane.showMessageDialog(this, "Fichero exportado satisfactoriamente!");
 	            respuesta = boton1.getText();
 	        }
    		 if(e.getActionCommand().equals("no")){//podemos comparar por el contenido del boton
 	            JOptionPane.showMessageDialog(this, "Saliendo del juego");
 	            respuesta = boton2.getText();
 	        }
     	thread.resume();     		
    }

    public void open() {
    thread = Thread.currentThread();
    setVisible(true);
    thread.suspend();

    }
}
