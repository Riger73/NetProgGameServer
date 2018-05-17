import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/*
 * This class implements threads for a the game server to use
 * thread that takes a message from main with console
 * input from another thread and then
 * and prints the result to the console before closing.
 */
public class ServerThreads implements Runnable {
    // Declare class level variables
    private String line;
    // points to persistent data
    File f = new File("serverlog.txt");

    // Thread implementation constructor
    public ServerThreads(String line){
        this.line = line;
    }
    // Overrides run() method to run tasks in the thread
    @Override
    public void run(){
        try {
           // Instantiate file reader
            FileReader fr = new FileReader(f);
            @SuppressWarnings("resource")
            BufferedReader br  = new BufferedReader(fr);
            StringBuilder stream = new StringBuilder();
            String str = null;
            // Reads in and prints to console in put from read thread
            while ((str = br.readLine()) != null) {
                stream.append(str).append("\n");
                    System.out.println(str);
            }
            // Prints the data received from main method
            System.out.println(line);
            // Closes file and buffer readers
            br.close();
            fr.close();
        // Catches input and output stream exceptions
        } catch (IOException ex){
            System.err.println(ex);
        }
        // Deletes file when finished
        if(f.exists()){
            f.delete();
        }
    }
}
