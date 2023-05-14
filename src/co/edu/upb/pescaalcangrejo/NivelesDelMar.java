package co.edu.upb.pescaalcangrejo;

import java.util.*;
import javax.swing.*;
import javax.xml.*;
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

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.ActionEvent;

import javax.swing.border.BevelBorder;

public class NivelesDelMar extends JFrame implements ActionListener{
	//unforgiven le sserafim
	private Arena[] arrayArena;
	private JLabel etiquetaPuntuacionMaxima;
	private boolean[] arrayCrab;
	private boolean tiempoFuera = false;
	private int puntos = 0;
	private int segundosRestantes = 30;
	private int dimensiones = 0;
	private int size = 0;
	private static int numPescadores;
	private int puntajeMaximo = 0;
	private Timer timer;
	private ImageIcon arenaCrab;
	private ImageIcon crab;
	private JLabel cantidadTiempo = new JLabel("30");
	private JLabel puntuacion = new JLabel("0");
	private ArrayList<String> apodosPescadores = new ArrayList<String>();
	private HashMap<String, Integer> pescarResultados = new HashMap<String, Integer>();
	
	public NivelesDelMar(int dimensiones, ImageIcon arenaCrab, ImageIcon crab, int numPescadores, ArrayList<String> apodosPescadores) {
		this.apodosPescadores = apodosPescadores;
		this.dimensiones = dimensiones;
		this.size = dimensiones * dimensiones;
		arrayCrab = new boolean[size];
		arrayArena = new Arena[size];
		this.arenaCrab = arenaCrab;
		this.crab = crab;
		this.numPescadores = numPescadores;
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 937, 686);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(122,189,195));
		panelSuperior.setBounds(0, 0, 725, 64);
		getContentPane().add(panelSuperior);
		panelSuperior.setLayout(null);
		
		JPanel panelDerecho = new JPanel();
		panelDerecho.setBackground(new Color(122,189,195));
		panelDerecho.setBounds(721, 0, 400, 647);
		getContentPane().add(panelDerecho);
		panelDerecho.setLayout(null);

		JPanel panelTiempo = new JPanel();
		panelTiempo.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(187,163,136), new Color(187,163,136),
				new Color(187,163,136), new Color(187,163,136)));
		panelTiempo.setBounds(50, 100, 99, 30);
		panelTiempo.setBackground(new Color(233,208,171));
		panelDerecho.add(panelTiempo);
		panelTiempo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel tiempo = new JLabel("TIEMPO");
		tiempo.setForeground(new Color(0, 0, 0));
		tiempo.setLocation(64, 5);
		tiempo.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelTiempo.add(tiempo);

		JPanel panelPuntuacion = new JPanel();
		panelPuntuacion.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(187,163,136), new Color(187,163,136),
				new Color(187,163,136), new Color(187,163,136)));
		panelPuntuacion.setBackground(new Color(233,208,171));
		panelPuntuacion.setBounds(30, 200, 150, 30);
		panelDerecho.add(panelPuntuacion);
		panelPuntuacion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel pescadas = new JLabel("PUNTUACIÓN");
		pescadas.setForeground(new Color(0, 0, 0));
		pescadas.setLocation(64, 5);
		pescadas.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelPuntuacion.add(pescadas);

		JPanel panelMueveTiempo = new JPanel();
		panelMueveTiempo.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(187,163,136), new Color(187,163,136),
				new Color(187,163,136), new Color(187,163,136)));
		panelMueveTiempo.setBackground(new Color(233,208,171));
		panelMueveTiempo.setBounds(65, 150, 60, 30);
		panelDerecho.add(panelMueveTiempo);

		cantidadTiempo.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelMueveTiempo.add(cantidadTiempo);
		
		JLabel pesquero = new JLabel("");
		pesquero.setIcon(new ImageIcon(NivelesDelMar.class.getResource("/imagenes/pesqueromojarra4.png")));
		pesquero.setBounds(30, 500, 400, 170);
		panelDerecho.add(pesquero);

		JLabel fishingACrab = new JLabel("FISHING-A-CRAB");
		fishingACrab.setFont(new Font("Tahoma", Font.BOLD, 20));
		fishingACrab.setForeground(new Color(255, 255, 255));
		fishingACrab.setBounds(270, 10, 202, 51);
		panelSuperior.add(fishingACrab);

		final JButton inicioButton = new JButton("Empezar juego");
		inicioButton.setForeground(Color.BLACK);
		inicioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		inicioButton.setBackground(new Color(231,135,14));
		inicioButton.setBounds(20, 15, 131, 31);
		panelSuperior.add(inicioButton);
		inicioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empezarPescadores();
				inicioButton.setEnabled(false);
			}
		});

		JPanel panelDePuntuacion = new JPanel();
		panelDePuntuacion.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(187,163,136), new Color(187,163,136),
				new Color(187,163,136), new Color(187,163,136)));
		panelDePuntuacion.setBackground(new Color(233,208,171));
		panelDePuntuacion.setBounds(70, 250, 60, 30);
		panelDerecho.add(panelDePuntuacion);

		puntuacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelDePuntuacion.add(puntuacion);

		JPanel panelArena = new JPanel();
		panelArena.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(187,163,136), new Color(187,163,136),
				new Color(187,163,136), new Color(187,163,136)));
		panelArena.setForeground(new Color(0, 0, 0));
		panelArena.setBackground(new Color(233,208,171));
		panelArena.setBounds(1, 64, 720, 583);
		getContentPane().add(panelArena);
		panelArena.setLayout(new GridLayout(dimensiones, dimensiones));
		
		
		for (int ii = 0; ii < (size); ii++) {
			arrayArena[ii] = new Arena(ii);
			arrayArena[ii].setIcon(cargarImagen());
			panelArena.add(arrayArena[ii]);
		}	
	}

	private void marea() {	
		timer = new Timer(1000, this);
		timer.setInitialDelay(1000);
		timer.start(); 
		
		temporizadorActivador();
		generarTopoAleatorio();
			for (int ii = 0; ii < arrayArena.length; ii++) {
				arrayArena[ii].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Arena clickedHoyo = (Arena) e.getSource();
					int indice = clickedHoyo.getIndice();
					if ((arrayCrab[indice] == true) && (tiempoFuera == false)) {
						puntos++;
						puntuacion.setText(puntos + "");
						limpiarTablero();
						generarTopoAleatorio();
						timer.restart();		
					}
				}
				});
			}
	}
	
	private void empezarPescadores() {
		if (numPescadores == 1) {
			marea();
			System.out.println(1);
		}
		else if(numPescadores == 2) {
			marea();
			System.out.println(2);
		}
		
		
	}	
	
	private void cambiarTopo() {
		limpiarTablero();
		generarTopoAleatorio();
	}

	private ImageIcon cargarImagen() {
		return arenaCrab;
	}
	
	private void generarTopoAleatorio() {
		Random numrandom = new Random(System.currentTimeMillis());
		int numeroHoyo = numrandom.nextInt(size);
		
		arrayArena[numeroHoyo].setIcon(crab);
		arrayCrab[numeroHoyo] = true;
	}

	private void temporizadorActivador() {
		

	    Timer timer = new Timer(1000, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            segundosRestantes--;
	            if (segundosRestantes > 0) {
	                cantidadTiempo.setText(segundosRestantes + "");
	            } else {
	                tiempoFuera = true;
	                cantidadTiempo.setText("0");
	                ((Timer) e.getSource()).stop(); // Detener el temporizador cuando llega a 0
	                
	                if (tiempoFuera == true) {

	                	boolean dosJugadores = false;
	                	boolean unJugador = false;
	                	
	                	if(numPescadores == 2) {
	                		dosJugadores = true;
	                		unJugador = false;
	                	}
	                	
	                    if (dosJugadores == true) {
	                        if (numPescadores == 2) {
	                            JOptionPane.showMessageDialog(null, apodosPescadores.get(0) + " su puntuación es: " + puntos);
	                            pescarResultados.put(apodosPescadores.get(0), puntos);
	                            Pescadas pescadas = new Pescadas(pescarResultados, 2);
	                            Niveles s = new Niveles(1, apodosPescadores);
	                            s.setVisible(true);
	                            dispose();
	                        } else {
	                            if (tiempoFuera == true) {
	                                JOptionPane.showMessageDialog(null, apodosPescadores.get(1) + " su puntuación es: " + puntos);
	                                pescarResultados.put(apodosPescadores.get(1), puntos);
	                                Pescadas pescadas = new Pescadas(pescarResultados, 2);
	                                pescadas.setVisible(true);
	                                dispose();
	                            }

	                        }
	                    } else if (dosJugadores == false) {
	                        JOptionPane.showMessageDialog(null, apodosPescadores.get(0) + " su puntuación es: " + puntos);
	                        pescarResultados.put(apodosPescadores.get(0), puntos);
	                        Pescadas pescadas = new Pescadas(pescarResultados, 1);
	                        pescadas.setVisible(true);
	                        dispose();
	                    }

	                }
	            }
	        }
	    });
	    try {
	        timer.start();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	private void limpiarTablero() {
		for (int i = 0; i < size; i++) {
			arrayArena[i].setIcon(cargarImagen());
			arrayCrab[i] = false;
		}
	}

   private void guardarPuntuacionMaximaXML() {
   	try {
           //Se crea una fábrica de documentos
           DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();

           //Se crea un generador de documentos
           DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

           //Se crea un documento nuevo
           Document doc = docBuilder.newDocument();

           //Se crea el elemento raíz del documento
           Element rootElement = doc.createElement("highscore");
           doc.appendChild(rootElement);

           //Se crea el elemento que contendrá la puntuación máxima
           Element scoreElement = doc.createElement("score");
           scoreElement.appendChild(doc.createTextNode(Integer.toString(puntajeMaximo)));
           rootElement.appendChild(scoreElement);

           //Se crea un transformador para escribir el documento en un archivo
           TransformerFactory transformerFactory = TransformerFactory.newInstance();
           Transformer transformer = transformerFactory.newTransformer();
           DOMSource source = new DOMSource(doc);

           //Se crea un objeto de resultado para el archivo XML
           File xmlFile = new File(System.getProperty("user.dir") + "/HighScore.xml");
           StreamResult result = new StreamResult(xmlFile);

           //Se transfiere el contenido del documento al resultado (archivo)
           transformer.transform(source, result);
       }
   	catch(ParserConfigurationException | TransformerException e) {
           //En caso de error, muestra un mensaje y una traza del error
           JOptionPane.showMessageDialog(null, e.getMessage(), "Error al guardar la puntuación más alta", JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
       }
   }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(tiempoFuera == false) {
			cambiarTopo();
		}
	}
	
}
