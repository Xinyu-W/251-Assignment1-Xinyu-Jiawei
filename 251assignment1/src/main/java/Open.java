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
        this.filechooser = filechooser;
        this.editor=editor;
        filechooser.setDialogTitle("Open");
    }

    public void actionPerformed(ActionEvent e) {

        int i = filechooser.showOpenDialog(editor);            //显示打开文件对话框
        if (i == JFileChooser.APPROVE_OPTION)            //点击对话框打开选项
        {
            File f = filechooser.getSelectedFile();    //得到选择的文件
            try {
                InputStream is = new FileInputStream(f);
                textPane.read(is, "d");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}