import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Save extends AbstractAction {
    private JTextPane textPane;
    private JFileChooser filechooser;

    public Save(JTextPane textPane, JFileChooser filechooser){
        super("Save     Ctrl+S");
        this.textPane = textPane;
        this.filechooser = new JFileChooser();
        this.filechooser.setDialogTitle("Save");
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
