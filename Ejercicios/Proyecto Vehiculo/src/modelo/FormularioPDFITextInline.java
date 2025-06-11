package modelo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JTable;
import java.io.FileOutputStream;
import java.io.IOException;

public class FormularioPDFITextInline {
    static int espaciado = 0;
    public static void main(String[] args) throws IOException, DocumentException {
        Object[] datosVeh = {"Ford", "Fiesta", "2020", "Azul", "ABC123", "XZ789", "2019"};
        PdfPTable[] tablasVeh = createVehicleTable(datosVeh, "A. IDENTIFICACION DEL VEHICULO");

        JTable tablaSwing = crearJTableDummyContrib();
        PdfPTable pdfContrib = convertJTable(tablaSwing, true, true, "B. DATOS DEL CONTRIBUYENTE");

        JTable tablaEsp = crearJTableDummyEspecial();
        PdfPTable pdfEsp = convertJTable(tablaEsp, false, false, "LIQUIDACION FACTURA");

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
        document.open();
        for (PdfPTable tv : tablasVeh) document.add(tv);
        document.add(pdfContrib);
        document.add(pdfEsp);
        document.close();
    }

    public static PdfPTable[] createVehicleTable(Object[] data, String titulo) throws DocumentException {
        // Tabla 4 columnas
        PdfPTable tabla4 = new PdfPTable(4);
        tabla4.setTotalWidth(540); tabla4.setLockedWidth(true); tabla4.setSpacingBefore(espaciado);
        tabla4.setWidths(new float[]{120,150,150,120});
        // Título
        Font fontTitle = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
        PdfPCell titleCell = new PdfPCell(new Phrase(titulo, fontTitle));
        titleCell.setColspan(4); titleCell.setBackgroundColor(BaseColor.BLACK);
        titleCell.setFixedHeight(20); titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        tabla4.addCell(titleCell);
        // Primera fila: primeros 4 datos
        for (int i = 0; i < 4; i++) {
            PdfPCell c = new PdfPCell(new Phrase(data[i] == null ? "" : data[i].toString()));
            c.setFixedHeight(20); c.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla4.addCell(c);
        }

        // Tabla 3 columnas con los siguientes 3 datos
        PdfPTable tabla3 = new PdfPTable(3);
        tabla3.setTotalWidth(540); tabla3.setLockedWidth(true);
        tabla3.setWidths(new float[]{160,220,160});
        for (int i = 4; i < 7; i++) {
            PdfPCell c = new PdfPCell(new Phrase(data[i] == null ? "" : data[i].toString()));
            c.setFixedHeight(20); c.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla3.addCell(c);
        }
        return new PdfPTable[]{tabla4, tabla3};
    }

    public static PdfPTable convertJTable(JTable table, boolean styledHeader, boolean barraTitulo, String titulo) {
        int cols = table.getColumnCount();
        PdfPTable pdfTable = new PdfPTable(cols);
        pdfTable.setTotalWidth(540);
        pdfTable.setLockedWidth(true);
        pdfTable.setSpacingBefore(espaciado);

        // Fuente para títulos
        Font fontTitle = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
        Font fontHeader = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.BLACK);

        // Barra de título spanned
        if (barraTitulo) {
            PdfPCell titleCell = new PdfPCell(new Phrase(titulo, fontTitle));
            titleCell.setColspan(cols);
            titleCell.setBackgroundColor(BaseColor.BLACK);
            titleCell.setFixedHeight(20);
            titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            pdfTable.addCell(titleCell);
        } else if (cols == 4) {
            // Fila especial de colores y título en primera celda
            BaseColor[] colBg = {BaseColor.BLACK, BaseColor.BLACK, BaseColor.GRAY, BaseColor.GRAY};
            for (int c = 0; c < 4; c++) {
                Phrase ph = new Phrase(c == 0 ? titulo : "", fontTitle);
                PdfPCell cell = new PdfPCell(ph);
                cell.setBackgroundColor(colBg[c]);
                cell.setFixedHeight(20);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                pdfTable.addCell(cell);
            }
        }

        // Header de columnas
        if (styledHeader) {
            for (int c = 0; c < cols; c++) {
                String header = table.getColumnName(c);
                PdfPCell cell = new PdfPCell(new Phrase(header, fontHeader));
                cell.setFixedHeight(20);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                pdfTable.addCell(cell);
            }
        }

        // Filas de datos
        Font fontData = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK);
        int rows = table.getRowCount();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Object val = table.getValueAt(r, c);
                PdfPCell cell = new PdfPCell(new Phrase(val == null ? "" : val.toString(), fontData));
                cell.setFixedHeight(20);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                pdfTable.addCell(cell);
            }
        }
        return pdfTable;
    }

    // EJEMPLOS DE JTABLE DUMMY PARA PRUEBAS:
    private static JTable crearJTableDummyContrib() {
        Object[] cols = {"8. TIPO", "9.No.IDENTIFICACION", "10.NOMBRES Y APELLIDOS/RAZON SOCIAL", "11. % PROP", "12. CALIDAD", "13. DIRECCION DE NOTIFICACION", "14. MUNICIPIO"};       Object[][] data = {
                {"1", "Ana Pérez", "Calle 1", "Bogotá", "Bogotá", "110111", "3001234567"},
                {"2", "Luis Gómez", "Calle 2", "Medellín", "Antioquia", "050022", "3007654321"}
        };
        return new JTable(data, cols);
    }

    private static JTable crearJTableDummyEspecial() {
        Object[] cols = {"C. LIQUIDACION FACTURA", "", "", ""};
        Object[][] data = {
                {"A1", "1", "Item uno", "Obs1"},
                {"A2", "2", "Item dos", "Obs2"}
        };
        return new JTable(data, cols);
    }
}
