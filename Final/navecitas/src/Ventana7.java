
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
public class Ventana7 extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel texto1, texto2, texto3;           // etiqueta o texto no editable
    private JTextField caja1, caja2, caja3;   	     // caja de texto, para insertar datos
    private JButton boton;          				 // boton con una determinada accion
    public String respuesta;
    private Thread thread;
	public Object respuesta2;
	
    public Ventana7() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
    }

    private void configurarVentana() {
        this.setTitle("Space invaders");                        // colocamos titulo a la ventana
        this.setSize(300, 200);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    private void inicializarComponentes() {
        // creamos los componentes
        texto1 = new JLabel();
 
        // configuramos los componentes
        
        texto1.setText(" EL UNIVERSO YA ESTA TRANQUILO !!!");   // colocamos un texto a la etiqueta
        texto1.setBounds(30, 5, 500, 100);   // colocamos posicion y tamaño al texto (x, y, ancho, alto)
       
        this.add(texto1);
             
    }

	@Override
    public void actionPerformed(ActionEvent e) {
         
		JOptionPane.showMessageDialog(this, "Ahora el universo estara tranquilo");
     	thread.resume();
    }

    public void open() {
        thread = Thread.currentThread();
        setVisible(true);
        thread.suspend();
    }
}