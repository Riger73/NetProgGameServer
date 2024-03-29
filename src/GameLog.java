import java.io.*;
import java.util.*;
public class GameLog {
    
    private Writer out;
    public GameLog(File f) throws IOException {
        FileWriter fw = new FileWriter(f);
        this.out = new BufferedWriter(fw);
    }
    public void writeEntry(String message) throws IOException {
        Date d = new Date();
        out.write(d.toString());
        out.write('\t');
        out.write(message);
        out.write("\r\n");
    }
    public void close() throws IOException {
        out.flush();
        out.close();
    }
}	