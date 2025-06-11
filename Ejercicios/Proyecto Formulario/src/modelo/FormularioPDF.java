package modelo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.*;
import com.google.zxing.qrcode.decoder.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font;

/**
 *
 * @author Dyl
 */
public class FormularioPDF {
    static int espaciado = 0;

    /**
     * Crea un archivo PDF con el formulario
     * @param objF
     * @throws DocumentException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void archivoFormularioPdf(Formulario objF) throws DocumentException, FileNotFoundException, IOException {
        String placaVehiculo = objF.getDatosVehiculo()[0].toString();
        PdfPTable header = crearHeaderPDF(placaVehiculo);

        PdfPTable[] tablasVeh = crearTablaVehiculo(objF.getDatosVehiculo(), "A. IDENTIFICACION DEL VEHICULO");
        PdfPTable pdfContrib = convertirJTable(objF.getTableContribuyentes(), true, true, "B. DATOS DEL CONTRIBUYENTE");
        PdfPTable pdfOtros = crearOtros();
        PdfPTable pdfFecha = convertirJTable(objF.getDatosFecha(), false, false, "FECHAS FORMULARIO");
        PdfPTable pdfLiqui = convertirJTable(objF.getDatosLiquidacion(), false, false, "C. LIQUIDACION FACTURA");
        PdfPTable pdfPago = convertirJTable(objF.getDatosPago(), false, false, "D. PAGO");
        PdfPTable pdfPagoAd = convertirJTable(objF.getDatosPagoVoluntario(), false, false, "E. PAGO CON ADICIONAL VOLUNTARIO");

        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("FORMULARIO.pdf"));
        document.open();

        document.add(header);
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
     * Crea una tabla PDF para "Otros"
     * @return PdfPTable
     */
    public PdfPTable crearOtros() {
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
     * Crea el encabezado del PDF con logo texto y QR
     * @param placaVehiculo
     * @return PdfPTable
     * @throws BadElementException
     * @throws IOException
     * @throws DocumentException
     */
    private PdfPTable crearHeaderPDF(String placaVehiculo) throws BadElementException, IOException, DocumentException {
        PdfPTable header = new PdfPTable(3);
        header.setTotalWidth(540);
        header.setLockedWidth(true);
        header.setWidths(new float[]{1, 3, 1});

        try {
            Image logo = Image.getInstance("./gobierno.png");
            logo.scaleToFit(80, 80);
            PdfPCell cellLogo = new PdfPCell(logo);
            cellLogo.setBorder(Rectangle.NO_BORDER);
            cellLogo.setHorizontalAlignment(Element.ALIGN_LEFT);
            cellLogo.setPadding(5);

            Font fontHeader = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
            Paragraph p = new Paragraph();
            p.add(new Chunk("ANO GRAVABLE\n", fontHeader));
            p.add(new Chunk("2025\n\n", fontHeader));
            p.add(new Chunk("UNIVERSIDAD DISTRITAL\n", fontHeader));
            p.add(new Chunk("Formulario de Impuesto.\n\n", fontHeader));
            p.add(new Chunk("No. Refer: \n" + placaVehiculo, fontHeader));

            PdfPCell cellText = new PdfPCell(p);
            cellText.setBorder(Rectangle.NO_BORDER);
            cellText.setHorizontalAlignment(Element.ALIGN_LEFT);

            Image qrImage = codQr(placaVehiculo);
            qrImage.scaleToFit(80, 80);
            PdfPCell cellQr = new PdfPCell(qrImage);
            cellQr.setBorder(Rectangle.NO_BORDER);
            cellQr.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cellQr.setPadding(5);

            header.addCell(cellLogo);
            header.addCell(cellText);
            header.addCell(cellQr);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar encabezado: " + e.getMessage());
        }

        return header;
    }

    /**
     * Genera un codigo de barras 128
     * @param doc
     * @param pw
     * @param datos
     * @return Image
     */
    public Image codBar(Document doc, PdfWriter pw, String datos) {
        PdfContentByte cimg = pw.getDirectContent();
        Barcode128 code128 = new Barcode128();
        code128.setCode(datos);
        code128.setCodeType(Barcode128.CODE128);
        code128.setTextAlignment(Element.ALIGN_CENTER);

        Image img = code128.createImageWithBarcode(cimg, BaseColor.BLACK, BaseColor.BLACK);
        img.setAlignment(Element.ALIGN_CENTER);
        return img;
    }

    /**
     * Genera un codigo QR para los datos
     * @param datos
     * @return Image
     * @throws WriterException
     * @throws IOException
     */
    public Image codQr(String datos) throws WriterException, IOException {
        try {
            Map<EncodeHintType, Object> hintMap = new EnumMap<>(EncodeHintType.class);
            hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

            int size = 125;
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix byteMatrix = qrCodeWriter.encode(datos, BarcodeFormat.QR_CODE, size, size, hintMap);

            int matrixWidth = byteMatrix.getWidth();
            BufferedImage bufferedImage = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();

            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, matrixWidth, matrixWidth);
            graphics.setColor(Color.BLACK);

            for (int i = 0; i < matrixWidth; i++) {
                for (int j = 0; j < matrixWidth; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }

            String tempDir = System.getProperty("java.io.tmpdir");
            File qrFile = new File(tempDir + "vehiculo_qr.png");
            ImageIO.write(bufferedImage, "png", qrFile);

            Image pdfImage = Image.getInstance(qrFile.getAbsolutePath());

            qrFile.delete();

            return pdfImage;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar QR: " + e.getMessage());
        }
        return null;
    }

    /**
     * Crea tablas PDF para datos del vehiculo
     * @param data
     * @param titulo
     * @return PdfPTable[]
     * @throws DocumentException
     */
    public PdfPTable[] crearTablaVehiculo(Object[] data, String titulo) throws DocumentException {
        PdfPTable tabla4 = new PdfPTable(4);
        tabla4.setTotalWidth(540);
        tabla4.setLockedWidth(true);
        tabla4.setSpacingBefore(espaciado);
        tabla4.setWidths(new float[]{120,150,150,120});
        Font fontTitle = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
        PdfPCell titleCell = new PdfPCell(new Phrase(titulo, fontTitle));
        titleCell.setColspan(4);
        titleCell.setBackgroundColor(BaseColor.BLACK);
        titleCell.setFixedHeight(20);
        titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        tabla4.addCell(titleCell);
        for (int i = 0; i < 4; i++) {
            PdfPCell c = new PdfPCell(new Phrase(data[i].toString()));
            c.setFixedHeight(20);
            c.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla4.addCell(c);
        }
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
     * Convierte un JTable en una tabla PDF
     * @param table
     * @param styledHeader
     * @param barraTitulo
     * @param titulo
     * @return PdfPTable
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