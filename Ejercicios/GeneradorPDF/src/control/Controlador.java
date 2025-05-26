package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Auto;
import modelo.ArchPDF;
import modelo.ArchPDFBox;
import vista.Ventana;

public class Controlador implements ActionListener {
    private ArrayList<Auto> listaA;
    private Auto objA;
    private Ventana frmR;

    public Controlador(ArrayList<Auto> listaA, Auto objA, Ventana frmR) {
        this.listaA = listaA;
        this.objA = objA;
        this.frmR = frmR;
    } 
    
    public Controlador() {
        this.frmR = new Ventana();
        this.objA = null;
        this.listaA = new ArrayList();
    }
    
    public void iniciar() {
        frmR.setTitle("PDF registro de Autos");
        frmR.setLocationRelativeTo(null);
        frmR.getBtnRegistrar().addActionListener(this);
        frmR.getBtnGenerarPdf().addActionListener(this);
        frmR.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frmR.getBtnRegistrar())) {
            objA = new Auto();
            objA.setPlaca(frmR.getTxtPlaca().getText());
            objA.setMarca(frmR.getTxtMarca().getText());
            objA.setModelo(Integer.parseInt(frmR.getTxtModelo().getText()));
            System.out.println(frmR.getTxtCilindraje().getText());
            objA.setCilindraje(Double.parseDouble(frmR.getTxtCilindraje().getText()));
            objA.setCantPass(Integer.parseInt(frmR.getTxtPasajeros().getText()));
            objA.setValor(Double.parseDouble(frmR.getTxtValor().getText()));
            listaA.add(objA);
            JOptionPane.showMessageDialog(frmR, objA.toString() + "\nImpuesto: " + objA.impuesto());
        }
        
        if(e.getSource().equals(frmR.getBtnGenerarPdf())) {
            if(objA != null) {
                try {
                    ArchPDF objArch = new ArchPDF();
                    ArchPDFBox objArchPDFBox = new ArchPDFBox();
                    objArch.crear_PDF(listaA);
                    objArchPDFBox.crear_PDF(listaA);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(frmR, "Primero debe registrar un auto");
            }
        }
    }
}