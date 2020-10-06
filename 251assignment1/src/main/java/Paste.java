import javax.swing.*;
import java.awt.event.ActionEvent;

public class Paste extends AbstractAction {
    private Editor editor;
    private JTextPane jTextPane;
    public Paste(JTextPane jTextPane,Editor editor) {
        super("Paste     Ctrl+V");
        this.editor=editor;
        this.jTextPane=jTextPane;
    }
    public void actionPerformed(ActionEvent e) {
        jTextPane.paste();
    }
}
