import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.tex=t.pdf.PdfWriter;

public class Search extends AbstractAction {
    private JTextPane jTextPane;
    private JTextField jTextField;

    public Search(JTextPane jTextPane, JTextField jTextField) {
        this.jTextField = jTextField;
        this.jTextPane = jTextPane;
    }

    public void actionPerformed(ActionEvent e) {
        String text = jTextField.getText();
        ArrayList<String> resultList = new ArrayList<String>();
        String[] strings=text.split(",| |.|\\?|!|#|$|%|^|&|\\*|-|\\+|@|");

    }
}
