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
    Sentence annotation = new Sentence(jcas);
    annotation.setBegin(matcher.start());
    annotation.setEnd(matcher.end());
    annotation.setId(matcher.group(1));
    annotation.setText(matcher.group(2));
    
    annotation.addToIndexes();
    pos = matcher.end();
  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    // TODO Auto-generated method stub
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
