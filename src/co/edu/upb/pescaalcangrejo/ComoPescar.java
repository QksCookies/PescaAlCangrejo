package co.edu.upb.pescaalcangrejo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.border.EmptyBorder;

public class ComoPescar extends JFrame{
	private JPanel panelContenedor;


	/**
	 * Create the frame.
	 */
	public ComoPescar() {
		setTitle("Como Pescar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 688, 450);
		panelContenedor = new JPanel(new BorderLayout());
		setContentPane(panelContenedor);
		
		JButton btnJugar = new JButton("REGRESAR");
		btnJugar.setForeground(new Color(0, 0, 0));
		btnJugar.setFont(new Font("Brodway", Font.BOLD, 13));
		btnJugar.setBackground(new Color(231,135,14));
        btnJugar.addMouseListener(new MouseAdapter() {
        	   @Override // Agregar la anotación @Override al método actionPerformed sin parámetros
               public void mouseClicked(MouseEvent e) {
   				// código para volver a la pantalla del juego
                   Playa playa = new Playa();
                   playa.setVisible(true);
                   dispose(); // cierra la ventana actual (créditos)
               }
           });
        
        // Agregar el botón en un panel adicional en la posición SOUTH
        JPanel panelBoton1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton1.add(btnJugar);
        panelContenedor.add(panelBoton1, BorderLayout.SOUTH);

        // Código para agregar el diseño del panel de créditos
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(Creditos.class.getResource("/imagenes/fondoplaya.jpg")));
        background.setBounds(0, 0, 800, 600);
        panelContenedor.add(background, BorderLayout.CENTER);

	}
}
