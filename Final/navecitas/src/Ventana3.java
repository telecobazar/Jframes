
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
public class Ventana3 extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel texto1, texto2;           // etiqueta o texto no editable
    private JTextField caja1;        // caja de texto, para insertar datos
    private JButton boton, boton1, boton2;          // boton con una determinada accion
    public String respuesta1, respuesta;
    private Thread thread;

    public Ventana3() {
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
        texto2 = new JLabel();
        caja1 = new JTextField();
        boton = new JButton();
        boton1 = new JButton();
        boton2 = new JButton();
        
        // configuramos los componentes
        texto1.setText("Nombre del jugador "); 
        texto1.setBounds(70, 5, 600, 100); 			// colocamos posicion y tamaño al texto (x, y, ancho, alto)
        caja1.setBounds(160, 70, 50, 30);    // colocamos posicion y tama�o a la caja2 (x, y, ancho, alto)
        boton.setText("Hecho");              // colocamos un texto al boton
        boton.setBounds(80, 110, 220, 40);     // colocamos posicion y tamaño al boton (x, y, ancho, alto)
        boton.addActionListener(this);         // hacemos que el boton tenga una accion y esa accion estara en esta clase
        
         // añadimos los componentes a la ventana
        
        this.add(texto1);
        this.add(caja1);
        this.add(boton);
        
    }

    @Override

    public void actionPerformed(ActionEvent e) {
    		
    	respuesta= caja1.getText();// obtenemos el contenido de la caja de texto

    	   	if (respuesta!=null)
     		JOptionPane.showMessageDialog(this, "Sus datos han sido guardados "+respuesta);
     	thread.resume();
     		
    }

    public void open() {
    thread = Thread.currentThread();
    setVisible(true);
    thread.suspend();

    }
}
