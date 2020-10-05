import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class NewAction extends AbstractAction	//新建
{
    private JTextPane textPane;
    private JFileChooser filechooser;
    private Editor editor;
    public NewAction(JTextPane textPane,JFileChooser filechooser,Editor editor)
    {
        super("New     Ctrl+N");
        this.textPane=textPane;
        this.filechooser = filechooser;
        this.editor=editor;
    }
    public void actionPerformed(ActionEvent e)
    {
        int i = filechooser.showOpenDialog(editor);            //显示打开文件对话框
        if (i == JFileChooser.APPROVE_OPTION)            //点击对话框打开选项
        {
            File f = filechooser.getSelectedFile();    //得到选择的文件
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
