import javafx.stage.FileChooser;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;


public class New extends AbstractAction	//New
{
    private final JTextPane textPane;
    private JFileChooser filechooser;
    private Editor editor;
    public New(JTextPane textPane,JFileChooser filechooser,Editor editor)
    {
        super("New     Ctrl+N");
        this.textPane=textPane;
        this.filechooser = new JFileChooser();
        this.editor=editor;
        this.filechooser.setDialogTitle("New");
    }
    public void actionPerformed(ActionEvent e)
    {
        int i = filechooser.showOpenDialog(editor);
        if (i == JFileChooser.APPROVE_OPTION)
        {
            File f = filechooser.getSelectedFile();
            try {
                textPane.setDocument(new DefaultStyledDocument());
                FileOutputStream fos = new FileOutputStream(f);
                fos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


}
