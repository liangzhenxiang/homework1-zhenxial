package collectionReader;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

import typeSystem.Line;
import typeSystem.Sentence;

public class MyFileReader extends CollectionReader_ImplBase {
  public static final String PARAM_INPUTDIR = "InputDirectory";
  
  private File myFile;
  private Pattern sentencePattern = Pattern.compile("(.*)[\n]");
  private Matcher matcher;
  private int pos;

  public void initialize() throws ResourceInitializationException {
    /*File directory = new File(((String) getConfigParameterValue(PARAM_INPUTDIR)).trim());
    File[] files = directory.listFiles();
    for (int i = 0; i < files.length; i++) {
      if (!files[i].isDirectory())
        myFile = files[i];
    }*/
    String path = ((String) getConfigParameterValue(PARAM_INPUTDIR)).trim();
    myFile = new File(path+"/hw1.in");
    String text = null;
    try {
      text = FileUtils.file2String(myFile);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    //System.out.println(text);
    matcher = sentencePattern.matcher(text);
    pos = 0;
    
  }
  @Override
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    // TODO Auto-generated method stub
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new CollectionException(e);
    }
    Line annotation = new Line(jcas);
    annotation.setText(matcher.group(1));
    //System.out.println(matcher.group(1));
    
    annotation.addToIndexes();
    pos = matcher.end();
  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    // TODO Auto-generated method stub
    //System.out.println(pos);
    return matcher.find(pos);
  }

  @Override
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return new Progress[] { new ProgressImpl(1, 1, Progress.ENTITIES) };
  }

  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub

  }

}
