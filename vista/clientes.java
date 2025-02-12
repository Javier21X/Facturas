package vista;
import javax.swing.JFrame;
import java.awt.GridLayout;

import control.controlclientes;
import control.controlventanas;
import modelo.connection;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


                public class clientes extends JFrame implements ActionListener {
                    
                    private controlventanas control;
                    private controlclientes controlclientes;
                    private JScrollPane panelExtra;  
                    private JTable table;
                    
                    public DefaultTableModel getTableModel() {
                        return (DefaultTableModel) table.getModel();
                    }
                    
                    public clientes() {
                        // Configurar propiedades de la ventana
                        setTitle("Clientes");
                        setSize(1200, 300);
                        setLayout(new GridLayout(1, 2));

                        // Panel de botones
                        JPanel panelBotones = new JPanel();
                        panelBotones.setLayout(new GridLayout(6, 1));
                        panelBotones.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregar margen

                        // Agregar componente JLabel con el texto "CLIENTES" en grande
                        JLabel label = new JLabel("CLIENTES");
                        Font font = new Font("Arial", Font.BOLD, 24);
                        label.setFont(font);
                        label.setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
                        panelBotones.add(label);

                        // Añadir botón "Ver clientes"
                        JButton btnVerClientes = new JButton("Ver clientes");
                        btnVerClientes.setActionCommand("ver");
                        btnVerClientes.addActionListener(this);
                        panelBotones.add(btnVerClientes);

                        // Añadir botón "Añadir cliente"
                        JButton btnAddCliente = new JButton("Añadir cliente");
                        btnAddCliente.setActionCommand("agregar");
                        btnAddCliente.addActionListener(this);
                        panelBotones.add(btnAddCliente);

                        // Añadir botón "Eliminar cliente"
                        JButton btnEliminarCliente = new JButton("Eliminar cliente");
                        btnEliminarCliente.setActionCommand("eliminar");
                        btnEliminarCliente.addActionListener(this);
                        panelBotones.add(btnEliminarCliente);

                        // Añadir botón "Modificar cliente"
                        JButton btnModificarCliente = new JButton("Modificar cliente");
                        btnModificarCliente.setActionCommand("modificar");
                        btnModificarCliente.addActionListener(this);
                        panelBotones.add(btnModificarCliente);

                        add(panelBotones);

                        // Panel adicional a la derecha
                        this.panelExtra = new JScrollPane();
                        add(this.panelExtra);
                        // Centrar la ventana en la pantalla
                        setLocationRelativeTo(null);

                    }

                    public void setControlVentanas(controlventanas control) {
                        this.control = control;
                    }

                    public void setControlClientes(controlclientes controlclientes) {
                        this.controlclientes = controlclientes;
                    }

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String command = e.getActionCommand();
                        controlclientes.hacer(command);
                    
                    }

                    public void setPanel(JScrollPane scrollPane) {
                        panelExtra.setViewportView(scrollPane); // Establecer el nuevo JScrollPane como la vista del JScrollPane existente
                        panelExtra.revalidate(); // Recalcular el layout de panelExtra
                        panelExtra.repaint(); // Redibujar panelExtra
                    }

                    public void setPanel(JPanel newPanel) {
                        panelExtra.setViewportView(newPanel); // Establecer el nuevo JPanel como la vista del JScrollPane
                        panelExtra.revalidate(); // Recalcular el layout de panelExtra
                        panelExtra.repaint(); // Redibujar panelExtra
                    }

                }


    


