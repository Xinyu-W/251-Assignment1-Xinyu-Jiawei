import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
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
        filechooser.setDialogTitle("Print");

    }
    public void actionPerformed(ActionEvent e) {
        int i = filechooser.showOpenDialog(editor);//显示打开文件对话框

        if (i == JFileChooser.APPROVE_OPTION) {
            File f = filechooser.getSelectedFile();

            DocFlavor docFlavor=DocFlavor.INPUT_STREAM.AUTOSENSE;

            HashPrintRequestAttributeSet requestAttribute=new HashPrintRequestAttributeSet();

            PrintService printServices[]= PrintServiceLookup.lookupPrintServices(docFlavor,requestAttribute);

            PrintService printService= PrintServiceLookup.lookupDefaultPrintService();

            PrintService printService1=ServiceUI.printDialog(null,250,250,printServices,printService,docFlavor,requestAttribute);
            if (printService1!=null){
                try {
                    DocPrintJob docPrintJob=printService1.createPrintJob();
                    FileInputStream fileInputStream = new FileInputStream(f);
                    DocAttributeSet docAttributeSet=new HashDocAttributeSet();
                    Doc doc=new SimpleDoc(fileInputStream,docFlavor,docAttributeSet);
                    docPrintJob.print(doc,requestAttribute);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (PrintException printException) {
                    printException.printStackTrace();
                }


            }



        }


    }
}
