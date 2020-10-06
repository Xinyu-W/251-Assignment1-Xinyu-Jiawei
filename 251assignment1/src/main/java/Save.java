import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Save extends AbstractAction {
    private JTextPane textPane;
    private JFileChooser filechooser;
    private Editor editor;
    public Save(JTextPane textPane, JFileChooser fileChooser,Editor editor){
        super("Save     Ctrl+S");
        this.textPane = textPane;
        this.filechooser = fileChooser;
        this.editor=editor;
    }
    public void actionPerformed(ActionEvent e) {
        int option = filechooser.showSaveDialog(null);
        if(option==JFileChooser.APPROVE_OPTION){
            File file = filechooser.getSelectedFile();
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(textPane.getText().getBytes());
                fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }
}
