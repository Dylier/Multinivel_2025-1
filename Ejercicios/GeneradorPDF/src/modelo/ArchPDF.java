package modelo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ArchPDF {
    private File ruta_destino = null;
    
    public void crear_PDF(ArrayList<Auto> listaA) throws FileNotFoundException {
        Colocar_Destino();
        Document mipdf = new Document();
        try {
            PdfWriter.getInstance(mipdf, new FileOutputStream(this.ruta_destino + ".pdf"));
            mipdf.open();
            mipdf.addTitle("Registro Auto");
            for (Auto objA : listaA) {
                if(this.ruta_destino != null) {               
                    mipdf.add(new Paragraph("Datos Auto:\n" + objA.toString() + "\n"));
                    mipdf.add(new Paragraph("Impuesto: " + objA.impuesto() + "\n"));
                    mipdf.add(new Paragraph("-/-/-/-/-/-/-/-/"));                   
                }
            }
            mipdf.close();     
            JOptionPane.showMessageDialog(null, "Documento PDF creado");
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear Documento PDF...");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error: el archivo no se encuentra...");
        }
    }
    
    public void Colocar_Destino() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PDF", "pdf", "PDF");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION) {
            this.ruta_destino = fileChooser.getSelectedFile().getAbsoluteFile();
        }
    }
    
    public String getRuta_destino() {
        return ruta_destino.getPath();
    }
}