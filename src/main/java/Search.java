import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search extends AbstractAction
{
    private final Editor editor;
    private final JTextPane textPane;

    public Search(JTextPane textPane,Editor editor)
    {

        super("Search");
        this.textPane = textPane;
        this.editor = editor;

    }

    public void actionPerformed(ActionEvent e) {
        final JDialog findDialog = new JDialog(this.editor, "查找", false);
        Container con = findDialog.getContentPane();
        con.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel findContentLabel = new JLabel("查找内容(N)：");
        final JTextField findText = new JTextField(15);
        JButton findNextButton = new JButton("查找下一个(F)：");
        final JCheckBox matchCheckBox = new JCheckBox("区分大小写(C)");
        ButtonGroup bGroup = new ButtonGroup();
        final JRadioButton upButton = new JRadioButton("向上(U)");
        final JRadioButton downButton = new JRadioButton("向下(U)");
        downButton.setSelected(true);
        bGroup.add(upButton);
        bGroup.add(downButton);
        JButton cancel = new JButton("取消");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findDialog.dispose();
            }
        });
        findNextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int k = 0, m = 0;
                final String str1, str2, str3, str4, strA, strB;
                str1 = textPane.getText().replaceAll("\r", "");
                str2 = findText.getText();
                str3 = str1.toUpperCase();
                str4 = str2.toUpperCase();
                if (matchCheckBox.isSelected())
                {
                    strA = str1;
                    strB = str2;
                } else
                {
                    strA = str3;
                    strB = str4;
                }
                if (upButton.isSelected()) {
                    if (textPane.getSelectedText() == null)
                        k = strA.lastIndexOf(strB, textPane.getCaretPosition() - 1);
                    else
                        k = strA.lastIndexOf(strB, textPane.getCaretPosition() - findText.getText().length() - 1);
                    if (k > -1) {
                        textPane.setCaretPosition(k);
                        textPane.select(k, k + strB.length());
                    } else {
                        JOptionPane.showMessageDialog(null, "找不到您查找的内容！", "查找", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (downButton.isSelected()) {
                    if (textPane.getSelectedText() == null)
                        k = strA.indexOf(strB, 1);
                    else
                        k = strA.indexOf(strB, textPane.getCaretPosition() - findText.getText().length() + 1);
                    if (k > -1) {   //String strData=strA.subString(k,strB.getText().length()+1);
                        textPane.setCaretPosition(k);
                        textPane.select(k, k + strB.length());
                    } else {
                        JOptionPane.showMessageDialog(null, "找不到您查找的内容！", "查找", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });//"查找下一个"按钮监听结束
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel directionPanel = new JPanel();
        directionPanel.setBorder(BorderFactory.createTitledBorder("方向"));
        directionPanel.add(upButton);
        directionPanel.add(downButton);
        panel1.setLayout(new GridLayout(2, 1));
        panel1.add(findNextButton);
        panel1.add(cancel);
        panel2.add(findContentLabel);
        panel2.add(findText);
        panel2.add(panel1);
        panel3.add(matchCheckBox);
        panel3.add(directionPanel);
        con.add(panel2);
        con.add(panel3);
        findDialog.setSize(410, 180);
        findDialog.setResizable(false);//不可调整大小
        findDialog.setLocation(230, 280);
        findDialog.setVisible(true);
    }
}

