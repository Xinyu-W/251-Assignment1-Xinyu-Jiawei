import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import com.alibaba.fastjson.*;

public class Editor extends JFrame {

    public  JTextPane textPane = new JTextPane();
    public JFileChooser fileChooser = new JFileChooser();
    public JScrollPane jScrollPane=new JScrollPane();
    public JTextField SearchText = new JTextField(20);
    String path = ReadJson.class.getClassLoader().getResource("TestJson.json").getPath();
    String json = ReadJson.readJsonFile(path);
    JSONObject jsonObject = JSON.parseObject(json);
    public Editor(){

        DateFormat dateFormat=DateFormat.getDateTimeInstance();
        String dateTime=dateFormat.format(System.currentTimeMillis());
        this.setTitle("Text editor           "+dateTime);

        setJMenuBar(createJMenuBar());
        Container container=getContentPane();
        container.add(textPane,BorderLayout.CENTER);
        setSize(Integer.parseInt(jsonObject.get("width").toString()),Integer.parseInt(jsonObject.get("height").toString()));
        setVisible(true);
        }

        private JMenuBar createJMenuBar(){
            JMenuBar menuBar=new JMenuBar();
            JMenu menuFile=new JMenu("File");
            JMenu menuView=new JMenu("View");
            JMenu menuEdior=new JMenu("Editor");
            JMenu menuAbout = new JMenu("About");
            menuFile.add(new JMenuItem(new New(textPane,fileChooser,Editor.this)));
            menuFile.add(new JMenuItem(new Open(textPane,fileChooser,Editor.this)));
            menuFile.add(new JMenuItem(new Save(textPane,fileChooser)));
            menuFile.add(new JMenuItem(new Print(Editor.this)));
            menuFile.add(new JMenuItem(new ExportPDF(textPane,jScrollPane)));
            menuFile.add(new JMenuItem(new Exit(Editor.this)));
            menuEdior.add(new JMenuItem(new Copy(textPane,Editor.this)));
            menuEdior.add(new JMenuItem(new Cut(textPane,Editor.this)));
            menuEdior.add(new JMenuItem(new Paste(textPane,Editor.this)));
            menuBar.add(menuFile);
            menuBar.add(menuEdior);
            menuBar.add(menuView);
            menuAbout.add(new JMenuItem(new Author(Editor.this,jsonObject)));
            menuBar.add(menuAbout);
            return  menuBar;
        }

    public static void main(String[] args) {

        new Editor();

    }

    }

