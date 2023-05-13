package co.edu.upb.pescaalcangrejo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Niveles extends JFrame{
	private JPanel panelContenedor;
	private int numPescadores;
	private ArrayList<String> apodosPescadores = new ArrayList<>(); 

	public Niveles(int canJugadores, ArrayList<String> apodosPescadores) {	
		this.numPescadores = canJugadores;
		this.apodosPescadores = apodosPescadores;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 688, 450);
		panelContenedor = new JPanel();
		panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelContenedor);
		panelContenedor.setLayout(null);
		
		JLabel fishingACrab = new JLabel("FISHING A CRAB");
		fishingACrab.setForeground(Color.WHITE);
		fishingACrab.setFont(new Font("Matura", Font.BOLD | Font.ITALIC, 65));
		fishingACrab.setBounds(-75, 100, 800, 112);
		fishingACrab.setHorizontalAlignment(SwingConstants.CENTER);
		panelContenedor.add(fishingACrab);
		
		JLabel niveles = new JLabel("SELECCIONE EL NIVEL");
		niveles.setFont(new Font("Tahoma", Font.BOLD, 22));
		niveles.setForeground(new Color(192, 0, 0));
		niveles.setBounds(210, 90, 350, 300);
		panelContenedor.add(niveles);
		
		JButton easyButton = new JButton("4X4");
		easyButton.setForeground(Color.BLACK);
		easyButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		easyButton.setBackground(new Color(231,135,14));
		easyButton.setBounds(100, 280, 100, 40);
		panelContenedor.add(easyButton);
		easyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	ImageIcon imagenHoyo = new ImageIcon(NivelesDelMar.class.getResource("/imagenes/huecoarena4x4.png"));
            	ImageIcon imagenTopo = new ImageIcon(NivelesDelMar.class.getResource("/imagenes/cangrejohueco4x4.png"));
            	NivelesDelMar nivelesDelMar = new NivelesDelMar(4, imagenHoyo, imagenTopo, canJugadores, apodosPescadores);
            	nivelesDelMar.setVisible(true);
            	dispose();
            }
        });
		
		JButton mediumButton = new JButton("6X6");
		mediumButton.setForeground(Color.BLACK);
		mediumButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		mediumButton.setBackground(new Color(231,135,14));
		mediumButton.setBounds(280, 280, 100, 40);
		panelContenedor.add(mediumButton);
		mediumButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	ImageIcon imagenHoyo = new ImageIcon(NivelesDelMar.class.getResource("/imagenes/huecoarena6x6.png"));
            	ImageIcon imagenTopo = new ImageIcon(NivelesDelMar.class.getResource("/imagenes/cangrejohueco6x6.png"));
            	NivelesDelMar nivelesDelMar = new NivelesDelMar(6, imagenHoyo, imagenTopo, canJugadores, apodosPescadores);
            	nivelesDelMar.setVisible(true);
            	dispose();
            }
        });
		
		JButton difficultButton = new JButton("8X8");
		difficultButton.setForeground(Color.BLACK);
		difficultButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		difficultButton.setBackground(new Color(231,135,14));
		difficultButton.setBounds(460, 280, 100, 40);
		panelContenedor.add(difficultButton);
		difficultButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	ImageIcon imagenHoyo = new ImageIcon(NivelesDelMar.class.getResource("/imagenes/huecoarena8x8.png"));
            	ImageIcon imagenTopo = new ImageIcon(NivelesDelMar.class.getResource("/imagenes/cangrejohueco8x8.png"));
            	NivelesDelMar nivelesDelMar = new NivelesDelMar(8, imagenHoyo, imagenTopo, canJugadores, apodosPescadores);
            	nivelesDelMar.setVisible(true);
            	dispose();
            }
        });
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Niveles.class.getResource("/imagenes/fondoplaya.jpg")));
		background.setBounds(0, 0, 680, 418);
		panelContenedor.add(background);
	}
}
