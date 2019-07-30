package framework.utils;


import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class XmlUtils {
    public static <T> T mapToObject(String filePath, Class<T> targetClass) {
        String xml = readFromFile(filePath);
        T result = null;
        try {
            result = new XmlMapper().readValue(xml, targetClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String readFromFile(String filePath) {
        String xml = null;
        try {
            File file = new File(filePath);
            xml = inputStreamToString(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }

    private static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    public static void writeToFile(String filepath, Object object) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    try {
            xmlMapper.writeValue(new File(filepath), object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
