import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class NewAction extends AbstractAction	//新建
{
    private JTextPane textPane;
    public NewAction(JTextPane textPane)
    {
        super("New     Ctrl+N");
        this.textPane=textPane;
    }
    public void actionPerformed(ActionEvent e)
    {
        textPane.setDocument(new DefaultStyledDocument());
    }
}
