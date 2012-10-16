import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class test {
public static void main(String[] args) throws Exception {
    
    URL url = new URL("http://bergmanlab.smith.man.ac.uk:8081/?text=Albumin");
    InputStream in = url.openStream();
    BufferedReader bin = new BufferedReader(new InputStreamReader(in, "GB2312"));
    String s = null;
    while((s=bin.readLine())!=null){
      System.out.println(s);
    }
    bin.close();
  }

}
