package analysisEngine;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceAccessException;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;

import typeSystem.Gene;
import typeSystem.Sentence;

/**
 * an analysis engine that analyze a string and find the gene tag in it <br>
 * I use lingpipe to analyze the string and generate a confident value <br>
 * @author zhenxiang
 *
 */

public class LingpipeAE extends JCasAnnotator_ImplBase {
  /**
   * chunker is the object that analyzes the string
   */
  static ConfidenceChunker chunker = null;
  
  /**
   * a function that calculates the number of chars,except space,  before a position in the string <br>
   * @param end: position
   * @param sentence: the string to be calculate
   * @return
   */
  int countOffSet(int end, String sentence)
  {
    int count = 0;
    for(int i=0; i<end; i++)
    {
      if (sentence.charAt(i)!=' ')
        count++;
    }
    return count;  
  }

  /**
   * the function that analyze all the sentences in the JCas and use lingpipe to analyze the sentence,<br>
   * then generate gene tags with confidence value
   */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    if (chunker == null)
    {
      String filePath = null;
      try {
        filePath = (String) getContext().getResourceFilePath("modelFile");
      } catch (ResourceAccessException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      File modelFile = new File(filePath);
      try {
        chunker = (ConfidenceChunker) AbstractExternalizable.readObject(modelFile);
        } catch (IOException e) {
     // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (ClassNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
    }
    
    Iterator annotationIter = aJCas.getAnnotationIndex(Sentence.type).iterator();
    while (annotationIter.hasNext()) {
      Sentence sAnnotation = (Sentence) annotationIter.next();
      char[] cs = sAnnotation.getText().toCharArray();
      Iterator<Chunk> it = chunker.nBestChunks(cs,0,cs.length,10);
      while(it.hasNext())
      {
        Chunk chunk = it.next();
        int begin = chunk.start();
        int end = chunk.end();
        //if (Math.pow(2.0,chunk.score()) > 0.6)
        //{
          Gene  gAnnotation = new Gene(aJCas);
          gAnnotation.setTag(sAnnotation.getText().substring(begin, end));
          gAnnotation.setBegin(countOffSet(begin,sAnnotation.getText()));
          gAnnotation.setEnd(countOffSet(end,sAnnotation.getText())-1);
          gAnnotation.setSentenceId(sAnnotation.getId());
          gAnnotation.setConfidence(Math.pow(2.0,chunk.score()));
          //System.out.println(gAnnotation.getSentenceId()+"|"+gAnnotation.getBe()+" "+gAnnotation.getEn()+"|"+gAnnotation.getTag()+"\n");
          gAnnotation.addToIndexes();
       /* }
        else if (Math.pow(2.0,chunk.score()) < 0)
        {
          String tag = sAnnotation.getText().substring(begin, end);
          String newTag = null;
          if (!tag.contains("%"))
          {
            Scanner scan = new Scanner(tag);
            scan.useDelimiter(" ");
            while(scan.hasNext())
            {
              if (newTag == null)
                newTag = scan.next();
              else
                newTag = newTag + " " + scan.next();
            }                             
          }
          try
          {
          URL url = new URL("http://bergmanlab.smith.man.ac.uk:8081/?text="+newTag);
          InputStream in = url.openStream();
          BufferedReader bin = new BufferedReader(new InputStreamReader(in, "GB2312"));
          
            if (bin.readLine() != null)
            {
              Gene  gAnnotation = new Gene(aJCas);
              gAnnotation.setTag(sAnnotation.getText().substring(begin, end));
              gAnnotation.setBegin(countOffSet(begin,sAnnotation.getText()));
              gAnnotation.setEnd(countOffSet(end,sAnnotation.getText())-1);
              gAnnotation.setSentenceId(sAnnotation.getId());
              //System.out.println(gAnnotation.getSentenceId()+"|"+gAnnotation.getBe()+" "+gAnnotation.getEn()+"|"+gAnnotation.getTag()+"\n");
              gAnnotation.addToIndexes();
            }
     
            bin.close();
          } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
          }
        }*/
      }
    }

  }

}
