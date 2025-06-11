package modelo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ArchPDFBox {
    private File ruta_destino = null;
    private PDPageContentStream flujoContenidoActual;
    private PDPage paginaActual;
    private PDDocument documentoActual;
    private float margen = 50;
    private float posicionY;
    private float alturaFila = 25f;
    private String[] nombresColumnas = {"Placa", "Marca", "Modelo", "Cilindraje", "Pasajeros", "Impuesto"};
    private float[] anchosColumnas = {100, 100, 80, 80, 80, 80};
    private PDType1Font fuenteNegrita = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
    private PDType1Font fuenteNormal = new PDType1Font(Standard14Fonts.FontName.HELVETICA);

    public void Colocar_Destino() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo PDF", "pdf");
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileFilter(filtro);
        selectorArchivos.setSelectedFile(new File("RegistroDeAutos.pdf"));
        if (selectorArchivos.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            this.ruta_destino = selectorArchivos.getSelectedFile();
            if (!this.ruta_destino.getAbsolutePath().toLowerCase().endsWith(".pdf")) {
                this.ruta_destino = new File(this.ruta_destino.getAbsolutePath() + ".pdf");
            }
        }
    }

    private void nombreColumnas() throws IOException {
        flujoContenidoActual.setNonStrokingColor(new Color(0, 51, 102));
        flujoContenidoActual.addRect(margen, posicionY - alturaFila, 500, alturaFila);
        flujoContenidoActual.fill();

        float xActual = margen;
        flujoContenidoActual.setFont(fuenteNegrita, 12);
        flujoContenidoActual.setNonStrokingColor(Color.WHITE);
        for (String encabezado : nombresColumnas) {
            flujoContenidoActual.beginText();
            flujoContenidoActual.newLineAtOffset(xActual + 5, posicionY - alturaFila + 12);
            flujoContenidoActual.showText(encabezado);
            flujoContenidoActual.endText();
            xActual += anchosColumnas[java.util.Arrays.asList(nombresColumnas).indexOf(encabezado)];
        }
    }

    public void crear_PDF(ArrayList<Vehiculo> listaAutos) throws IOException {
        Colocar_Destino();

        if (this.ruta_destino == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada. No se seleccionó ruta de destino.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try (PDDocument documento = new PDDocument()) {
            documentoActual = documento;
            paginaActual = new PDPage(PDRectangle.A4);
            documentoActual.addPage(paginaActual);

            flujoContenidoActual = new PDPageContentStream(documentoActual, paginaActual);

            float yInicio = paginaActual.getMediaBox().getHeight() - margen;
            posicionY = yInicio;

            flujoContenidoActual.setFont(fuenteNegrita, 16);
            flujoContenidoActual.setNonStrokingColor(new Color(0, 51, 102));
            flujoContenidoActual.beginText();
            flujoContenidoActual.newLineAtOffset(margen, posicionY);
            flujoContenidoActual.showText("Registro de Autos");
            flujoContenidoActual.endText();
            posicionY -= 40;

            nombreColumnas();
            posicionY -= alturaFila + 10;

            flujoContenidoActual.setFont(fuenteNormal, 10);
            flujoContenidoActual.setNonStrokingColor(Color.BLACK);

            for (Vehiculo autoObj : listaAutos) {
                if (posicionY < margen + alturaFila) {
                    flujoContenidoActual.close();
                    paginaActual = new PDPage(PDRectangle.A4);
                    documentoActual.addPage(paginaActual);
                    flujoContenidoActual = new PDPageContentStream(documentoActual, paginaActual);
                    posicionY = paginaActual.getMediaBox().getHeight() - margen;

                    nombreColumnas();
                    posicionY -= alturaFila + 10;
                    flujoContenidoActual.setFont(fuenteNormal, 10);
                    flujoContenidoActual.setNonStrokingColor(Color.BLACK);
                }

                float xActual = margen;

                flujoContenidoActual.beginText();
                flujoContenidoActual.newLineAtOffset(xActual + 5, posicionY);
                flujoContenidoActual.showText(autoObj.getPlaca());
                flujoContenidoActual.endText();
                xActual += anchosColumnas[0];

                flujoContenidoActual.beginText();
                flujoContenidoActual.newLineAtOffset(xActual + 5, posicionY);
                flujoContenidoActual.showText(autoObj.getMarca());
                flujoContenidoActual.endText();
                xActual += anchosColumnas[1];

                flujoContenidoActual.beginText();
                flujoContenidoActual.newLineAtOffset(xActual + 5, posicionY);
                flujoContenidoActual.showText(String.valueOf(autoObj.getModelo()));
                flujoContenidoActual.endText();
                xActual += anchosColumnas[2];

                flujoContenidoActual.beginText();
                flujoContenidoActual.newLineAtOffset(xActual + 5, posicionY);
                flujoContenidoActual.showText(String.valueOf(autoObj.getCilindraje()));
                flujoContenidoActual.endText();
                xActual += anchosColumnas[3];

                flujoContenidoActual.beginText();
                flujoContenidoActual.newLineAtOffset(xActual + 5, posicionY);
                flujoContenidoActual.showText(autoObj instanceof Auto ? String.valueOf(((Auto)autoObj).getCantPasajeros()) : "2");
                flujoContenidoActual.endText();
                xActual += anchosColumnas[4];

                flujoContenidoActual.beginText();
                flujoContenidoActual.newLineAtOffset(xActual + 5, posicionY);
                flujoContenidoActual.showText(String.format("$%,.2f", autoObj.getImpuesto()));
                flujoContenidoActual.endText();
                xActual += anchosColumnas[5];

                posicionY -= alturaFila;
            }

            flujoContenidoActual.close();
            documentoActual.save(this.ruta_destino);
            JOptionPane.showMessageDialog(null, "PDF generado exitosamente en: " + this.ruta_destino.getAbsolutePath(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getRuta_destino() {
        return ruta_destino != null ? ruta_destino.getPath() : "";
    }
}