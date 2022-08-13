package utp.misiontic2022.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import utp.misiontic2022.controller.RequestController;
import utp.misiontic2022.model.vo.CompraPorProveedorVo;
import utp.misiontic2022.model.vo.LiderPorCiudadVo;
import utp.misiontic2022.model.vo.ProyectoCasaCampestreVo;

public class RequestView extends JFrame {

    public static final RequestController controller = new RequestController();

    private static final long serialVersionUID = 1L;

    private JPanel contenPane;
    private JTextArea textArea;

    public RequestView(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 800, 650);

        contenPane = new JPanel();
        contenPane.setBorder(new EmptyBorder(12, 12, 12, 12));
        setContentPane(contenPane);
        contenPane.setLayout(null);

        JLabel lTitle = new JLabel(" RETO 5 ");
        lTitle.setBounds(120, 12, 80, 24);
        contenPane.add(lTitle);


        //Content
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 60, 747, 455);
        contenPane.add(scrollPane);

        //text Area
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnFirstQuery = new JButton("Primer Informe");
        btnFirstQuery.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                FirstQuery();
            }
        });
        btnFirstQuery.setBounds(28, 537, 133, 29);
        contenPane.add(btnFirstQuery);

        JButton btnSecondQuery = new JButton("Segundo Informe");
        btnSecondQuery.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                SecondQuery();
            }
        });
        btnSecondQuery.setBounds(164, 537, 133, 29);
        contenPane.add(btnSecondQuery);

        JButton btnThirdQuery = new JButton("Tercer Informe");
        btnThirdQuery.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ThirdQuery();
            }
        });
        btnThirdQuery.setBounds(302, 537, 133, 29);
        contenPane.add(btnThirdQuery);

        JButton btnClean = new JButton("Limpiar");
        btnClean.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                textArea.setText("");
            }
        });
        btnClean.setBounds(654, 537, 120, 29);
        contenPane.add(btnClean);
    }

    public void FirstQuery() {
        try{
            ArrayList<LiderPorCiudadVo> lideres = controller.listarLiderPorCiudad();
            String data = " ==========  Reporte de Lideres por Ciudad de Residencia  ========== \n\nId Lider \t Nombre \t Primer Apellido \t Ciudad\n\n";

            for (LiderPorCiudadVo lider: lideres){
                data += lider.getIdLider() + " \t ";
                data += lider.getNombre() + " \t ";
                data += lider.getPrimerApellido() + " \t\t ";
                data += lider.getCiudadResidencia() + " \n ";
            }
            textArea.setText(data);
        }catch(SQLException e){
            System.err.println("Error: " + e.getMessage());
        }
    }


    public void SecondQuery() {
        try{
            ArrayList<ProyectoCasaCampestreVo> casas = controller.listarProyectoCasaCampestre();
            String data = " ==========  Reporte Proyectos Casa Campestre  ========== \n\nId Proyecto \t Constructora \t\t\t Habitaciones \t Ciudad\n\n";

            for (ProyectoCasaCampestreVo casa: casas){
                data += casa.getIdProyecto() + " \t ";
                data += casa.getConstructora() + " \t ";
                if (casa.getConstructora().length() <= 11){
                    data += " \t\t ";
                }else {
                    data += " \t ";
                }
                data += casa.getNumeroHabitaciones() + " \t ";
                data += casa.getCiudad() + " \n ";
            }
            textArea.setText(data);
        }catch(SQLException e){
            System.err.println("Error: " + e.getMessage());
        }
    }


    public void ThirdQuery() {
        try{
            ArrayList<CompraPorProveedorVo> compras = controller.listarCompraPorProveedor();
            String data = " ==========  Reporte Compra por Proveedor Homecenter en Salento  ========== \n\nId Compra \t Constructora \t\t\t Banco Vinculado\n\n";

            for (CompraPorProveedorVo compra: compras){
                data += compra.getIdCompra() + " \t ";
                data += compra.getConstructora() + " \t ";
                if (compra.getConstructora().length() <= 11){
                    data += " \t\t ";
                }else {
                    data += " \t ";
                }
                data += compra.getBanco() + " \n ";
            }
            textArea.setText(data);
        }catch(SQLException e){
            System.err.println("Error: " + e.getMessage());
        }
    }

}
