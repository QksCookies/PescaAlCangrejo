package co.edu.upb.pescaalcangrejo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class NumeroDePescadores extends JFrame{
	private int numeroPescadores;
	private JPanel panelContenedor;
	private ArrayList<String> apodosPescadores = new ArrayList<String>();
	
	public NumeroDePescadores() {
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
		
		JLabel cantPescadores = new JLabel("CANTIDAD DE PESCADORES");
		cantPescadores.setFont(new Font("Tahoma", Font.BOLD, 22));
		cantPescadores.setForeground(new Color(192, 0, 0));
		cantPescadores.setBounds(190, 90, 350, 300);
		panelContenedor.add(cantPescadores);
		
		JButton pescadoreButton = new JButton("UN PESCADOR");
		pescadoreButton.setForeground(Color.BLACK);
		pescadoreButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		pescadoreButton.setBackground(new Color(231,135,14));
		pescadoreButton.setBounds(135, 280, 180, 40);
		panelContenedor.add(pescadoreButton);
		pescadoreButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	setNumeroPescadores(1);
            	almacenarNombres();
            	Niveles niveles = new Niveles(numeroPescadores, apodosPescadores);
            	niveles.setVisible(true);
            	dispose();
            }
        });
		
		
		JButton pescadore2Button = new JButton("DOS PESCADORES");
		pescadore2Button.setForeground(Color.BLACK);
		pescadore2Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		pescadore2Button.setBackground(new Color(231,135,14));
		pescadore2Button.setBounds(365, 280, 180, 40);
		panelContenedor.add(pescadore2Button);
		pescadore2Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	setNumeroPescadores(2);
            	almacenarNombres();
            	Niveles niveles = new Niveles(numeroPescadores, apodosPescadores);
            	niveles.setVisible(true);
            	dispose();
            }
        });
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Playa.class.getResource("/imagenes/fondoplaya.jpg")));
		background.setBounds(0, 0, 680, 418);
		panelContenedor.add(background);
	}
	
	public int getCantidadJugadores() {
		System.out.println(numeroPescadores);
		return numeroPescadores;
	}

	public void setNumeroPescadores(int numeroPescadores) {
		this.numeroPescadores = numeroPescadores;
	}

	public ArrayList<String> getNombresJugadores() {
		return apodosPescadores;
	}

	public void almacenarNombres() {
	    List<String> apodosPescadores = new ArrayList<>();

	    for (int i = 1; i <= numeroPescadores; i++) {
	        String mensaje = "Pescador " + i + ". Ingrese su apodo:";
	        String apodo = JOptionPane.showInputDialog(null, mensaje);

	        if (apodo != null && !apodo.isEmpty()) {
	            apodosPescadores.add(apodo);
	        } else {
	            JOptionPane.showMessageDialog(null, "Debe ingresar su apodo para pescar.");
	            return;
	        }
	    }
	}
}
