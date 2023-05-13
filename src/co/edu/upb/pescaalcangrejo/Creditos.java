package co.edu.upb.pescaalcangrejo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Creditos extends JFrame{
	private JPanel panelContenedor;

    public Creditos() {
    	setTitle("Créditos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // cambiar EXIT_ON_CLOSE a DISPOSE_ON_CLOSE para evitar cerrar la aplicación
        setBounds(100, 100, 688, 450);
        panelContenedor = new JPanel(new BorderLayout());
        setContentPane(panelContenedor);

        JLabel lblCreadoPor = new JLabel("DESARROLLADO POR");
        lblCreadoPor.setForeground(new Color(255,255,255));
        lblCreadoPor.setFont(new Font("Brodway", Font.BOLD| Font.ITALIC, 20));
        lblCreadoPor.setBounds(230, 100, 300, 30);
        panelContenedor.add(lblCreadoPor);

        JLabel juliana = new JLabel("JULIANA CHAVEZ KING - LIDER Y ADMINISTRADORA");
        juliana.setForeground(new Color(255,255,255));
        juliana.setFont(new Font("Brodway", Font.BOLD| Font.ITALIC, 17));
        juliana.setBounds(110, 130, 500, 30);
        panelContenedor.add(juliana);

        JLabel alex = new JLabel("ALEX DANIEL MONTAÑEZ VALENZUELA - COLABORADOR");
        alex.setForeground(new Color(255,255,255));
        alex.setFont(new Font("Brodway", Font.BOLD| Font.ITALIC, 17));
        alex.setBounds(100, 180, 500, 30);
        panelContenedor.add(alex);

        JButton btnJugar2 = new JButton("REGRESAR");
        btnJugar2.setForeground(new Color(0, 0, 0));
        btnJugar2.setFont(new Font("Arial", Font.BOLD, 13));
        btnJugar2.setBackground(new Color(231,135,14));
        btnJugar2.addMouseListener(new MouseAdapter() {
        	   @Override // Agregar la anotación @Override al método actionPerformed sin parámetros
               public void mouseClicked(MouseEvent e) {
   				// código para volver a la pantalla del juego
                   Playa playa = new Playa();
                   playa.setVisible(true);
                   dispose(); // cierra la ventana actual (créditos)
               }
           });

        // Agregar el botón en un panel adicional en la posición SOUTH
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(btnJugar2);
        panelContenedor.add(panelBoton, BorderLayout.SOUTH);

        // Código para agregar el diseño del panel de créditos
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(Creditos.class.getResource("/imagenes/fondoplaya.jpg")));
        background.setBounds(0, 0, 800, 600);
        panelContenedor.add(background, BorderLayout.CENTER);
    }
}
