package modelo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.awt.Color;
import java.io.IOException;

public class FormularioPDF {
    public static void main(String[] args) throws IOException {
        try (PDDocument documento = new PDDocument()) {
            PDPage pagina = new PDPage(PDRectangle.A4);
            documento.addPage(pagina);

            try (PDPageContentStream contenido = new PDPageContentStream(documento, pagina)) {
                contenido.setStrokingColor(Color.BLACK);

                float inicioX = 30;
                float inicioY = 700;

                dibujarSeccionVehiculo(contenido, inicioX, inicioY);

                float seccion2Y = inicioY - 60;
                dibujarSeccionContribuyente(contenido, inicioX, seccion2Y);

                float seccion3Y = seccion2Y - 100;
                dibujarCelda(contenido, inicioX, seccion3Y, 540, 20);

                float seccion4Y = seccion3Y - 20;
                dibujarSeccionEspecial(contenido, inicioX, seccion4Y, 2);

                float seccion5Y = seccion3Y - 60;
                dibujarSeccionEspecial(contenido, inicioX, seccion5Y, 6);

                float seccion6Y = seccion3Y - 200;
                dibujarSeccionEspecial(contenido, inicioX, seccion6Y, 6);
            }
            documento.save("formulario.pdf");
        }
    }

    // ================= SECCIONES =================

    private static void dibujarSeccionVehiculo(PDPageContentStream cs, float x, float y) throws IOException {
        dibujarCeldaConColor(cs, x, y, 540, 20, Color.BLACK);

        float[] anchosFila1 = {120, 150, 150, 120};
        dibujarFila(cs, x, y - 20, anchosFila1, 20);

        float[] anchosFila2 = {160, 220, 160};
        dibujarFila(cs, x, y - 40, anchosFila2, 20);
    }

    private static void dibujarSeccionContribuyente(PDPageContentStream cs, float x, float y) throws IOException {
        dibujarCeldaConColor(cs, x, y, 540, 20, Color.BLACK);

        float[] anchos = {50, 100, 140, 60, 70, 80, 40};
        for (int offsetY = 0; offsetY < 20 * 4; offsetY += 20) {
            dibujarFila(cs, x, y - offsetY - 20, anchos, 20);
        }
    }


    private static void dibujarSeccionEspecial(PDPageContentStream cs, float x, float y, int filas) throws IOException {
        float[] anchos = {100, 20, 210, 210};

        dibujarFila(cs, x, y, anchos, 20, new Color[] {Color.BLACK, Color.BLACK, Color.GRAY, Color.GRAY});
        dibujarFila(cs, x, y - 20, anchos, (filas*20));
    }

    private static void dibujarFila(PDPageContentStream cs, float x, float y, float[] anchos, float alto) throws IOException {
        float posX = x;
        for (float ancho : anchos) {
            dibujarCelda(cs, posX, y, ancho, alto);
            posX += ancho;
        }
    }

    private static void dibujarCelda(PDPageContentStream cs, float x, float y, float ancho, float alto) throws IOException {
        cs.setStrokingColor(Color.BLACK);
        cs.addRect(x, y, ancho, -alto);
        cs.stroke();
    }


    public static void dibujarFila(PDPageContentStream cs, float x, float y, float[] anchos, float alto, Color[] colores) throws IOException {
        float posX = x;
        float anchoTotal = 0;

        for (int i = 0; i < anchos.length; i++) {
            Color color = (colores != null && i < colores.length) ? colores[i] : null;
            if (color != null) {
                cs.saveGraphicsState();
                cs.setNonStrokingColor(color);
                cs.addRect(posX, y, anchos[i], -alto);
                cs.fill();
                cs.restoreGraphicsState();
            }
            anchoTotal += anchos[i];
            posX += anchos[i];
        }

        cs.setStrokingColor(Color.BLACK);
        cs.addRect(x, y, anchoTotal, -alto);
        cs.stroke();
    }

    private static void dibujarCeldaConColor(PDPageContentStream cs, float x, float y, float ancho, float alto, Color color) throws IOException {
        cs.saveGraphicsState();
        cs.setNonStrokingColor(color);
        cs.addRect(x, y, ancho, -alto);
        cs.fill();
        cs.restoreGraphicsState();

        cs.setStrokingColor(color);
        cs.addRect(x, y, ancho, -alto);
        cs.stroke();
    }
}