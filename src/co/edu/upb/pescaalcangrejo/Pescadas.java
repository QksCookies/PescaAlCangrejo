package co.edu.upb.pescaalcangrejo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Pescadas extends JFrame{
	private JPanel panelContenedor;
	private HashMap<String, Integer> pescadosOb = new HashMap<String, Integer>();
	private JLabel pescador1 = new JLabel("");
	private JLabel pescador2 = new JLabel("");
	private JLabel pescadas1 = new JLabel("");
	private JLabel pescadas2 = new JLabel("");
	private JLabel ganador = new JLabel("New label");
	private static String nicknamePescador = null;
	private static String nicknamePescador1 = null;
	private static Integer puntaje = 0;
	private static Integer puntaje1 = 0;
	private static int puntajeMaximo = 0;
	private int numPescadores;
	private JLabel lblGanador = new JLabel("Ganador");
	
	private static boolean cambiojugador = false;
	private final JLabel unicoJugador = new JLabel("");
	
	public Pescadas(HashMap<String, Integer> pescadosOb, int numPescadores) {
		this.numPescadores = numPescadores;
		System.out.println(numPescadores + "holabola");
		getContentPane().setLayout(null);
		this.pescadosOb = pescadosOb;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 450);
		panelContenedor = new JPanel();
		panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelContenedor);
		panelContenedor.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(102, 37, 461, 285);
		panelContenedor.add(panel);
		panel.setLayout(null);
		
		JLabel pescadas = new JLabel("Pescadas");
		pescadas.setHorizontalAlignment(SwingConstants.CENTER);
		pescadas.setFont(new Font("Rockwell", Font.BOLD, 20));
		pescadas.setBounds(10, 11, 441, 36);
		panel.add(pescadas);
		
		pescador1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pescador1.setBounds(110, 58, 71, 28);
		panel.add(pescador1);
		
		pescador2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pescador2.setBounds(110, 113, 71, 28);
		panel.add(pescador2);
		
		pescadas1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pescadas1.setBounds(274, 58, 71, 28);
		panel.add(pescadas1);
		
		pescadas2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pescadas2.setBounds(274, 113, 71, 28);
		panel.add(pescadas2);		
		ganador.setHorizontalAlignment(SwingConstants.CENTER);
		
		ganador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ganador.setBounds(10, 188, 441, 28);
		panel.add(ganador);
		
		JButton returnPlayButton = new JButton("VOLVER A PESCAR");
		returnPlayButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		returnPlayButton.setForeground(Color.WHITE);
		returnPlayButton.setBackground(new Color(231,135,14));
		returnPlayButton.setBounds(167, 227, 117, 23);
		panel.add(returnPlayButton);
		
		
		lblGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanador.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblGanador.setBounds(10, 152, 441, 36);
		panel.add(lblGanador);
		
		returnPlayButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	clean();
                NumeroDePescadores numeroDePescadores = new NumeroDePescadores();
                numeroDePescadores.setVisible(true);
                dispose();
            }
        });
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Playa.class.getResource("/imagenes/fondoplaya.jpg")));
		background.setBounds(0, 0, 680, 418);
		panelContenedor.add(background);
		
		cambiarPescadores();
		
}
	
	public void cambiarPescadores() {
	    if (numPescadores == 2) {
	        if (!cambiojugador) {
	            for (Map.Entry<String, Integer> entry : pescadosOb.entrySet()) {
	                nicknamePescador = entry.getKey();
	                puntaje = entry.getValue();
	            }
	            cambiojugador = true;
	        } else {
	            for (Map.Entry<String, Integer> entry : pescadosOb.entrySet()) {
	                nicknamePescador1 = entry.getKey();
	                puntaje1 = entry.getValue();
	            }
	            changee();
	        }
	    } else if (numPescadores == 1) {
	        for (Map.Entry<String, Integer> entry : pescadosOb.entrySet()) {
	            nicknamePescador = entry.getKey();
	            puntaje = entry.getValue();
	        }
	        changee();
	    }
	}

	public void changee() {
	    if (numPescadores == 2) {
	        pescador1.setText(nicknamePescador);
	        pescador2.setText(nicknamePescador1);
	        pescadas1.setText(puntaje + " puntos");
	        pescadas2.setText(puntaje1 + " puntos");

	        compararPescadas();

	        if (puntaje > puntaje1) {
	            ganador.setText(nicknamePescador);
	        } else if (puntaje < puntaje1) {
	            ganador.setText(nicknamePescador1);
	        } else {
	            ganador.setText("Empate");
	        }
	    } else if (numPescadores == 1) {
	        pescador1.setText(nicknamePescador);
	        pescadas1.setText(puntaje + " puntos");
	        compararPescadas();
	        lblGanador.setText("");
	        ganador.setText("");
	    }
	}
	
	public void clean() {
		nicknamePescador = null;
		nicknamePescador1 = null;
		cambiojugador = false;
		puntaje = 0;
		puntaje1 = 0;
	}
	
	private void compararPescadas() {
	    if (numPescadores == 2) {
	        if (puntaje > puntajeMaximo || puntaje1 > puntajeMaximo) {
	            puntajeMaximo = Math.max(puntaje, puntaje1);
	            guardarMaximoPuntaje();
	            System.out.println(puntaje > puntaje1 ? "Vamoos" : "siuuuuu");
	        }
	    } else if (numPescadores == 1) {
	        if (puntaje > puntajeMaximo) {
	            puntajeMaximo = puntaje;
	            guardarMaximoPuntaje();
	            System.out.println("uepaaaa");
	        }
	    }
	}
	
	private void guardarMaximoPuntaje() {
	   	try {
	           DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	           DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	          
	           Document doc = docBuilder.newDocument();
	           Element rootElement = doc.createElement("PuntajeMaximo");
	           doc.appendChild(rootElement);

	           Element scoreElement = doc.createElement("puntaje");
	           scoreElement.appendChild(doc.createTextNode(Integer.toString(puntajeMaximo)));
	           rootElement.appendChild(scoreElement);

	           TransformerFactory transformerFactory = TransformerFactory.newInstance();
	           Transformer transformer = transformerFactory.newTransformer();
	           DOMSource source = new DOMSource(doc);

	           File xmlFile = new File(System.getProperty("user.dir") + "/PuntajeMaximo.xml");
	           StreamResult result = new StreamResult(xmlFile);

	           transformer.transform(source, result);
	       }
	   	catch(ParserConfigurationException | TransformerException e) {
	           JOptionPane.showMessageDialog(null, e.getMessage(), "Error al guardar la puntuación más alta", JOptionPane.ERROR_MESSAGE);
	           e.printStackTrace();
	       }
		}
}
