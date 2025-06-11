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
import java.io.FileNotFoundException;

import javax.swing.JTable;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dyl
 */
public class FormularioPDF {
    static int espaciado = 0;
                 
    /**
     *
     * @param objF
     * @throws DocumentException
     * @throws FileNotFoundException
     */
    public void archivoFormularioPdf(Formulario objF) throws DocumentException, FileNotFoundException{
        PdfPTable[] tablasVeh = crearTablaVehiculo(objF.getDatosVehiculo(), "A. IDENTIFICACION DEL VEHICULO"); 
        String[] nColContrib = new String[] {"8. TIPO", "9.No.IDENTIFICACION", "10.NOMBRES Y APELLIDOS/RAZON SOCIAL", "11. % PROP", "12. CALIDAD", "13. DIRECCION DE NOTIFICACION", "14. MUNICIPIO"};
        PdfPTable pdfContrib = convertirJTable(objF.getTableContribuyentes(), true, true, "B. DATOS DEL CONTRIBUYENTE");
        PdfPTable pdfOtros = crearOtros();
        PdfPTable pdfFecha = convertirJTable(objF.getDatosFecha(), false, false, "FECHAS FORMULARIO");
        PdfPTable pdfLiqui = convertirJTable(objF.getDatosLiquidacion(), false, false, "C. LIQUIDACION FACTURA");
        PdfPTable pdfPago = convertirJTable(objF.getDatosPago(), false, false, "D. PAGO");
        PdfPTable pdfPagoAd = convertirJTable(objF.getDatosPagoVoluntario(), false, false, "E. PAGO CON ADICIONAL VOLUNTARIO");
        
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("FORMULARIO.pdf"));
        document.open();
        
        for (PdfPTable tv : tablasVeh) document.add(tv);
        
        document.add(pdfContrib);
        document.add(pdfOtros);
        document.add(pdfFecha);
        document.add(pdfLiqui);
        document.add(pdfPago);
        document.add(pdfPagoAd);
        document.close();
    }

    /**
     *
     * @return
     */
    public PdfPTable crearOtros(){
        PdfPTable pdfOtros = new PdfPTable(1);
        pdfOtros.setTotalWidth(540);
        pdfOtros.setLockedWidth(true);
        pdfOtros.setSpacingBefore(espaciado);
        PdfPCell celda = new PdfPCell(new Phrase("15. OTROS"));
        celda.setColspan(1); 
        celda.setFixedHeight(20); 
        celda.setHorizontalAlignment(Element.ALIGN_LEFT);
        pdfOtros.addCell(celda);
        return pdfOtros;
    }
    
    /**
     *
     * @param data
     * @param titulo
     * @return
     * @throws DocumentException
     */
    public PdfPTable[] crearTablaVehiculo(Object[] data, String titulo) throws DocumentException {
        // Tabla de 4 columnas
        PdfPTable tabla4 = new PdfPTable(4);
        tabla4.setTotalWidth(540); 
        tabla4.setLockedWidth(true);
        tabla4.setSpacingBefore(espaciado);
        tabla4.setWidths(new float[]{120,150,150,120});
        // Titulo
        Font fontTitle = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
        PdfPCell titleCell = new PdfPCell(new Phrase(titulo, fontTitle));
        titleCell.setColspan(4); 
        titleCell.setBackgroundColor(BaseColor.BLACK);
        titleCell.setFixedHeight(20);
        titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        tabla4.addCell(titleCell);
        // Primera fila: primeros 4 datos
        for (int i = 0; i < 4; i++) {
            PdfPCell c = new PdfPCell(new Phrase(data[i].toString()));
            c.setFixedHeight(20);
            c.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla4.addCell(c);
        }
        // Tabla de 3 columnas
        PdfPTable tabla3 = new PdfPTable(3);
        tabla3.setTotalWidth(540); 
        tabla3.setLockedWidth(true);
        tabla3.setWidths(new float[]{160,220,160});
        for (int i = 4; i < 7; i++) {
            PdfPCell c = new PdfPCell(new Phrase(data[i].toString()));
            c.setFixedHeight(20); 
            c.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla3.addCell(c);
        }
        return new PdfPTable[]{tabla4, tabla3};
    }

    /**
     *
     * @param table
     * @param styledHeader
     * @param barraTitulo
     * @param titulo
     * @return
     */
    public static PdfPTable convertirJTable(JTable table, boolean styledHeader, boolean barraTitulo, String titulo) {
        int cols = table.getColumnCount();
        PdfPTable pdfTable = new PdfPTable(cols);
        pdfTable.setTotalWidth(540);
        pdfTable.setLockedWidth(true);
        pdfTable.setSpacingBefore(espaciado);
        Font fontTitle = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
        Font fontHeader = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.BLACK);
        if (barraTitulo) {
            PdfPCell titleCell = new PdfPCell(new Phrase(titulo, fontTitle));
            titleCell.setColspan(cols);
            titleCell.setBackgroundColor(BaseColor.BLACK);
            titleCell.setFixedHeight(20);
            titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            pdfTable.addCell(titleCell);
        } else if (cols == 4 && !"FECHAS FORMULARIO".equals(titulo)) {
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
        if (styledHeader) {
            for (int c = 0; c < cols; c++) {
                String header = table.getColumnName(c);
                PdfPCell cell = new PdfPCell(new Phrase(header, fontHeader));
                cell.setFixedHeight(20);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                pdfTable.addCell(cell);
            }
        }
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
}
