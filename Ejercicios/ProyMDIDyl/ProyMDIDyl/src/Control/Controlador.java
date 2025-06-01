package Control;

import Modelo.Numero;
import Vista.frmPotencia;
import Vista.frmPrincipal;
import Vista.frmSuma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Dyl
 */
public class Controlador implements ActionListener{
    frmPrincipal frmInicio;
    frmSuma frmS;
    frmPotencia frmP;
    Numero objNum;

    public Controlador() {
        frmInicio=new frmPrincipal();
        frmS=new frmSuma();
        frmP=new frmPotencia();
        objNum=new Numero();
    }
    public void iniciar(){
        frmInicio.setTitle("MDI");
        //addActionListener botones barra de herremientas
        frmInicio.getTbBtnSuma().addActionListener(this);
        frmInicio.getTbBtnPotencia().addActionListener(this);
        frmInicio.getTbBtnSalir().addActionListener(this);
        frmInicio.getTbBtnFecha().addActionListener(this);
        obtenerFecha();
        frmInicio.getTbEstado().setVisible(false);
        //addActionListener opción menu
        frmInicio.getOpcSuma().addActionListener(this);
        frmInicio.getOpcPotencia().addActionListener(this);
        frmInicio.getOpcSalir().addActionListener(this);
        //addActionListener opciones botones operaciones
        frmS.getBtnSumar().addActionListener(this);
        frmP.getBtnPotencia().addActionListener(this);
        frmInicio.setLocationRelativeTo(null);
        frmInicio.setVisible(true);
    }
    public void obtenerFecha(){
        Calendar fecha= Calendar.getInstance();
        frmInicio.getLblFecha().setText(
                    fecha.get(Calendar.DAY_OF_MONTH)+"/"+
                    (fecha.get(Calendar.MONTH)+1)+"/"+
                     fecha.get(Calendar.YEAR));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frmInicio.getTbBtnFecha())){
          if(frmInicio.getTbBtnFecha().isSelected()){
            frmInicio.getTbEstado().setVisible(true);}
          else{
           frmInicio.getTbEstado().setVisible(false);}
        }
        
        if(e.getSource().equals(frmInicio.getOpcSuma())||
        e.getSource().equals(frmInicio.getTbBtnSuma())){
            frmInicio.getEscritorio().add(frmS);
            frmS.setVisible(true);
        }
        if(e.getSource().equals(frmInicio.getOpcPotencia())||
        e.getSource().equals(frmInicio.getTbBtnPotencia())){
            frmInicio.getEscritorio().add(frmP);
            frmP.setVisible(true);
        }
        if(e.getSource().equals(frmInicio.getOpcSalir())||
        e.getSource().equals(frmInicio.getTbBtnSalir())){
            int resp= JOptionPane.showConfirmDialog(frmP, "¿Desea cerrar el programa?",
                    "Salir", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(resp==JOptionPane.YES_OPTION){
                frmInicio.dispose();
            }
        }
        if(e.getSource().equals(frmS.getBtnSumar())){
            objNum.setValor(Integer.parseInt(frmS.getTxtN1().getText()));
            JOptionPane.showMessageDialog(frmS, objNum.getValor() + " + "+ frmS.getTxtN2().getText() + " = " +
                    objNum.suma(Integer.parseInt(
                            frmS.getTxtN2().getText())));

        }
       
        if(e.getSource().equals(frmP.getBtnPotencia())){
            objNum.setValor(Integer.parseInt(frmP.getTxtBase().getText()));
            JOptionPane.showMessageDialog(frmP, objNum.getValor() + " ^ " + frmP.getTxtExponente().getText() + " = " +
                    objNum.potencia(Integer.parseInt(
                            frmP.getTxtExponente().getText())));
        }
         

    }
    
    
    
}
