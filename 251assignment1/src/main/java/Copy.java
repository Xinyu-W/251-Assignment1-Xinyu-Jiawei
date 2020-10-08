import javax.swing.*;
import java.awt.event.ActionEvent;

public class Copy extends AbstractAction{
    private Editor editor;
    private JTextPane jTextPane;
    public Copy(JTextPane jTextPane,Editor editor) {
        super("Copy     Ctrl+C");
        this.editor=editor;
        this.jTextPane=jTextPane;
    }
    public void actionPerformed(ActionEvent e) {
        jTextPane.copy();
    }
}
