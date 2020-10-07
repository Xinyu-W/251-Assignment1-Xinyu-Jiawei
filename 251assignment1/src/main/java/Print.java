import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttribute;
import javax.print.attribute.standard.Copies;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Print extends AbstractAction {
    private JFileChooser filechooser;
    private Editor editor;
    public Print(JFileChooser filechooser,Editor editor){
        super("Print");
        this.filechooser=filechooser;
        this.editor=editor;

    }
    public void actionPerformed(ActionEvent e) {
        int i = filechooser.showOpenDialog(editor);//显示打开文件对话框
        if (i == JFileChooser.APPROVE_OPTION) {
            File f = filechooser.getSelectedFile();
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(f);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            if (fileInputStream==null){return;}
            DocFlavor docFlavor=DocFlavor.INPUT_STREAM.AUTOSENSE;
            HashPrintRequestAttributeSet requestAttribute=new HashPrintRequestAttributeSet();
            PrintService printServices[]= PrintServiceLookup.lookupPrintServices(docFlavor,requestAttribute);
            PrintService printService= PrintServiceLookup.lookupDefaultPrintService();
            PrintService printService1=ServiceUI.printDialog(null,250,250,printServices,printService,docFlavor,requestAttribute)



        }


    }
}
