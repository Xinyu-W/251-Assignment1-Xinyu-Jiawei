import com.alibaba.fastjson.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Author extends AbstractAction {
    private final Editor editor;
    private JSONObject jsonObject;
    public Author(Editor editor, JSONObject jsonObject){
        super("Author ");
        this.editor=editor;
        this.jsonObject=jsonObject;
    }
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(editor
                ,jsonObject.get("Author1")+"\n"+jsonObject.get("Author2"),"Author ",
                JOptionPane.PLAIN_MESSAGE);
    }
}
