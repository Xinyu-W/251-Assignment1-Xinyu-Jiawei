import javax.swing.*;
import java.awt.event.ActionEvent;

public class Cut extends AbstractAction {
    private Editor editor;
    private JTextPane jTextPane;
    public Cut(JTextPane jTextPane,Editor editor) {
        super("Cut     Ctrl+X");
        this.editor=editor;
        this.jTextPane=jTextPane;
    }
    public void actionPerformed(ActionEvent e) {
        jTextPane.cut();
    }
}
