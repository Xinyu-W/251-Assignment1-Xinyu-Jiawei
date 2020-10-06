
import com.sun.jmx.mbeanserver.JmxMBeanServer;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;


public class Editor extends JFrame {
    public  JTextPane textPane = new JTextPane();
    public JFileChooser fileChooser = new JFileChooser();
    public JTextField SearchText = new JTextField(20);
    public Editor(){

        DateFormat dateFormat=DateFormat.getDateTimeInstance();
        String dateTime=dateFormat.format(System.currentTimeMillis());
        this.setTitle("Text editor           "+dateTime);
        Action[] actions={
                new New(textPane,fileChooser,Editor.this),
                new Open(textPane,fileChooser,Editor.this),
                new Save(textPane,fileChooser),
                new Search(textPane,SearchText),
                new Exit(Editor.this),
                new Copy(textPane,Editor.this),
                new Cut(textPane,Editor.this),
                new Paste(textPane,Editor.this)
        };

        setJMenuBar(createJMenuBar(actions));

        Container container=getContentPane();
        container.add(textPane,BorderLayout.CENTER);
        setSize(700,700);
        setVisible(true);
        }
        private JMenuBar createJMenuBar(Action[] actions){
            JMenuBar menuBar=new JMenuBar();
            JMenu menuFile=new JMenu("File");
            JMenu menuView=new JMenu("View");
            JMenu menuEdior=new JMenu("Editor");
            JMenu menuAbout = new JMenu("About");
            menuFile.add(new JMenuItem(actions[0]));
            menuFile.add(new JMenuItem(actions[1]));
            menuFile.add(new JMenuItem(actions[2]));
            menuView.add(new JMenuItem(actions[3]));
            menuFile.add(new JMenuItem(actions[4]));
            menuEdior.add(new JMenuItem(actions[5]));
            menuEdior.add(new JMenuItem(actions[6]));
            menuEdior.add(new JMenuItem(actions[7]));
            menuBar.add(menuFile);
            menuBar.add(menuEdior);
            menuBar.add(menuView);
            menuBar.add(menuAbout);
            return menuBar;
        }

    public static void main(String[] args) {
        new Editor();
    }

    }

