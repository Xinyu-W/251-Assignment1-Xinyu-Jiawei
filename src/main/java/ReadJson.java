import com.alibaba.fastjson.*;

import java.io.*;

public class ReadJson {
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File file = new File(fileName);

            FileReader fileReader = new FileReader(file);

            Reader reader = new InputStreamReader(new FileInputStream(file),"utf-8");

            int counter = 0;
            StringBuffer stringBuffer = new StringBuffer();

            while ((counter = reader.read()) != -1) {
                stringBuffer.append((char) counter);
            }

            reader.close();
            fileReader.close();
            jsonStr = stringBuffer.toString();
            return jsonStr;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
