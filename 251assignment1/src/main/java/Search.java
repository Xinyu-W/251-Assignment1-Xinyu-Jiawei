import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Search extends AbstractAction {
    private JTextPane jTextPane;
    private JTextField jTextField;

    public Search(JTextPane jTextPane, JTextField jTextField) {
        this.jTextField = jTextField;
        this.jTextPane = jTextPane;
    }

    public void actionPerformed(ActionEvent e) {
        String text = jTextField.getText();
        ArrayList<String> resultList = new ArrayList<String>();
        String[] strings=text.split(",| |.|\\?|!|#|$|%|^|&|\\*|-|\\+|@|");

    }
}
