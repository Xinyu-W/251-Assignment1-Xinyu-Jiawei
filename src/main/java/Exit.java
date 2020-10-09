import javax.swing.*;
import java.awt.event.ActionEvent;



public class Exit extends AbstractAction {
private Editor editor;
    public Exit(Editor editor) {
        super("Exit");
        this.editor=editor;
    }
    public void actionPerformed(ActionEvent e) {
        editor.dispose();
    }
}
