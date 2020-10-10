import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

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
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(f));
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String readline = "";
                while ((readline = reader.readLine())!=null){
                    textPane.setText(textPane.getText()+readline+"\n");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}