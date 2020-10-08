import javax.swing.*;
import java.awt.event.ActionEvent;

public class Author extends AbstractAction {
    private final Editor editor;
    public Author(Editor editor){
        super("Author ");
        this.editor=editor;
    }
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(editor
                ,"Xinyu Wang\nJiawei Feng","Author ",
                JOptionPane.PLAIN_MESSAGE);
    }
}
