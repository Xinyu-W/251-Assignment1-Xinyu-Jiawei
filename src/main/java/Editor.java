import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.text.*;
import java.awt.*;
import java.text.DateFormat;
import java.util.HashSet;
import java.util.Set;
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
            textPane.getDocument().addDocumentListener(new SyntaxHighlighter(textPane));
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
            menuView.add(new JMenuItem(new Search(textPane,Editor.this)));
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
    public static class SyntaxHighlighter implements DocumentListener {
        private Set<String> keywords;
        private Style keywordStyle;
        private Style normalStyle;

        public SyntaxHighlighter(JTextPane editor) {

            keywordStyle = ((StyledDocument) editor.getDocument()).addStyle("Keyword_Style", null);

            normalStyle = ((StyledDocument) editor.getDocument()).addStyle("Keyword_Style", null);

            StyleConstants.setForeground(keywordStyle, Color.RED);

            StyleConstants.setForeground(normalStyle, Color.BLACK);


            keywords = new HashSet<String>();

            keywords.add("public");

            keywords.add("protected");

            keywords.add("private");

            keywords.add("_int9");

            keywords.add("float");

            keywords.add("double");

        }



        public void colouring(StyledDocument doc, int pos, int len) throws BadLocationException {
            int start = indexOfWordStart(doc, pos);
            int end = indexOfWordEnd(doc, pos + len);


            char ch;

            while (start < end) {
                ch = getCharAt(doc, start);

                if (Character.isLetter(ch) || ch == '_') {
// 如果是以字母或者下划线开头, 说明是单词

// pos为处理后的最后一个下标

                    start = colouringWord(doc, start);

                } else {
                    SwingUtilities.invokeLater(new ColouringTask(doc, start, 1, normalStyle));

                    ++start;
                }
            }
        }

        public int colouringWord(StyledDocument doc, int pos) throws BadLocationException {
            int wordEnd = indexOfWordEnd(doc, pos);

            String word = doc.getText(pos, wordEnd - pos);



            if (keywords.contains(word)) {

                SwingUtilities.invokeLater(new ColouringTask(doc, pos, wordEnd - pos, keywordStyle));

            } else {
                SwingUtilities.invokeLater(new ColouringTask(doc, pos, wordEnd - pos, normalStyle));

            }
            return wordEnd;
        }
        public char getCharAt(Document doc, int pos) throws BadLocationException {
            return doc.getText(pos, 1).charAt(0);
        }
        public int indexOfWordStart(Document doc, int pos) throws BadLocationException {
            for (; pos > 0 && isWordCharacter(doc, pos - 1); --pos);
            return pos;
        }
        public int indexOfWordEnd(Document doc, int pos) throws BadLocationException {
            for (; isWordCharacter(doc, pos); ++pos);
            return pos;
        }
        public boolean isWordCharacter(Document doc, int pos) throws BadLocationException {
            char ch = getCharAt(doc, pos);
            if (Character.isLetter(ch) || Character.isDigit(ch) || ch == '_') { return true; }
            return false;
        }
        @Override
        public void changedUpdate(DocumentEvent e) {

        }



        @Override

        public void insertUpdate(DocumentEvent e) {
            try {
                colouring((StyledDocument) e.getDocument(), e.getOffset(), e.getLength());

            } catch (BadLocationException e1) {
                e1.printStackTrace();
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            try {
                colouring((StyledDocument) e.getDocument(), e.getOffset(), 0);
            } catch (BadLocationException e1) {
                e1.printStackTrace();
            }
        }
        private class ColouringTask implements Runnable {
            private StyledDocument doc;
            private Style style;
            private int pos;
            private int len;
            public ColouringTask(StyledDocument doc, int pos, int len, Style style) {
                this.doc = doc;
                this.pos = pos;
                this.len = len;
                this.style = style;
            }
            public void run() {
                try {
                    doc.setCharacterAttributes(pos, len, style, true);
                } catch (Exception e) {}
            }
        }
    }
}

