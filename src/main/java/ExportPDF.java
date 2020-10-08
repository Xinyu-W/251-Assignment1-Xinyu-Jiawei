import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.io.*;

public class ExportPDF extends AbstractAction {
    private JFileChooser filechooser;
    public ExportPDF(JFileChooser fileChooser) {
        this.filechooser = fileChooser;
        fileChooser.setDialogTitle("Export to PDF");
        fileChooser.setApproveButtonToolTipText("Save");
    }

    public void actionPerformed(ActionEvent e) {
        int chooser = filechooser.showSaveDialog(null);
        if (chooser == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            String path = file.getAbsolutePath();
            try {
                OutputStream os = new FileOutputStream(new File(path + ".pdf"));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }


        }
//        Document document=new Document();


    }
}
