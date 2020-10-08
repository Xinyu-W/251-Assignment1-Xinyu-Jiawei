import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.event.ActionEvent;
import java.io.*;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class ExportPDF extends AbstractAction {
    private JFileChooser filechooser;
    private JTextPane jTextPane;
    private JScrollPane jScrollBar;
    private static final String FONT = "C:\\Windows\\Fonts\\simhei.ttf";
    public ExportPDF(JTextPane jTextPane,JScrollPane jScrollBar) {
        super("Export");
        this.filechooser = new JFileChooser("F:\\");
        filechooser.setDialogTitle("export");
        this.jTextPane=jTextPane;
        this.jScrollBar=jScrollBar;
    }

    public void actionPerformed(ActionEvent e) {
        JTextPane edit_text_area;
        JScrollPane scroll_bar;
        File file = null;
        int chooser = filechooser.showSaveDialog(null);
        if (chooser == JFileChooser.APPROVE_OPTION) {
            file = filechooser.getSelectedFile();
        }
        Document document = new Document();
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File(file.getAbsolutePath()+".pdf"));
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        try {
            PdfWriter.getInstance(document, os);
        } catch (DocumentException documentException) {
            documentException.printStackTrace();
        }
        document.open();
        //方法一：使用Windows系统字体(TrueType)
        BaseFont baseFont = null;
        try {
            baseFont = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        } catch (DocumentException documentException) {
            documentException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Font font = new Font(baseFont);
        try {
            document.add(new Paragraph(jTextPane.getText(), font));
        } catch (DocumentException documentException) {
            documentException.printStackTrace();
        }
        document.close();
    }
}

