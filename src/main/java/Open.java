import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Open extends AbstractAction{
    private JTextPane textPane;
    private JFileChooser filechooser;
    private Editor editor;
    public Open(JTextPane textPane, JFileChooser filechooser,Editor editor) {
        super("Open     Ctrl+O");
        this.textPane = textPane;
        this.filechooser = new JFileChooser();
        this.editor=editor;
        this.filechooser.setDialogTitle("Open");
    }

    public void actionPerformed(ActionEvent e) {

        int i = filechooser.showOpenDialog(editor);
        if (i == JFileChooser.APPROVE_OPTION)
        {
            File f = filechooser.getSelectedFile();
            try {
                InputStream is = new FileInputStream(f);
                textPane.read(is, "d");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}