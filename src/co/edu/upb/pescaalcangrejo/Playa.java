package co.edu.upb.pescaalcangrejo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Playa extends JFrame {
	
	private JPanel panelContenedor;
	
	public Playa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 688, 450);
		panelContenedor = new JPanel();
		panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelContenedor);
		panelContenedor.setLayout(null);
		
		JButton comoPescarButton = new JButton("REGLAS");
		comoPescarButton.setForeground(new Color(0, 0, 0));
		comoPescarButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		comoPescarButton.setBackground(new Color(231,135,14));
		comoPescarButton.setBounds(38, 50, 100, 30);
		panelContenedor.add(comoPescarButton);
		comoPescarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComoPescar comoPescar = new ComoPescar();
				comoPescar.setVisible(true);
				dispose();
			}
		});
		
		JLabel fishingACrab = new JLabel("FISHING A CRAB");
		fishingACrab.setForeground(Color.WHITE);
		fishingACrab.setFont(new Font("Matura", Font.BOLD | Font.ITALIC, 65));
		fishingACrab.setBounds(-75, 100, 800, 112);
		fishingACrab.setHorizontalAlignment(SwingConstants.CENTER);
		panelContenedor.add(fishingACrab);
		
		JButton creditos = new JButton("CREDITOS");
		creditos.setForeground(new Color(0, 0, 0));
		creditos.setFont(new Font("Segoe UI", Font.BOLD,14));
		creditos.setBackground(new Color(231,135,14));
		creditos.setPreferredSize(new Dimension(100, 45));
		creditos.setBounds(520, 50, 100, 30); // <- ajustar los valores de x e y aquí
		panelContenedor.add(creditos);
		creditos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Creditos creditos=new Creditos();
				creditos.setVisible(true);
				dispose();	
			}
		});
		
		JLabel playButton = new JLabel("");
		playButton.setIcon(new ImageIcon(Playa.class.getResource("/imagenes/botonempescap.png")));
		playButton.setBounds(190, 150, 300, 300); // <- Ajustamos las coordenadas y el tamaño del botón
		playButton.setHorizontalAlignment(SwingConstants.CENTER);
		panelContenedor.add(playButton);
		playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NumeroDePescadores numeroDePescadores = new NumeroDePescadores();
                numeroDePescadores.setVisible(true);
                dispose();
            }
        });
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Playa.class.getResource("/imagenes/fondoplaya.jpg")));
		background.setBounds(0, 0, 800, 400);
		panelContenedor.add(background);
		setVisible(true);
	}
}
