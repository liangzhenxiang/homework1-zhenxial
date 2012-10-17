package analysisEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.uima.analysis_component.CasAnnotator_ImplBase;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.jcas.JCas;

import typeSystem.Gene;
import typeSystem.Line;

/**
 * an analysis engine that search a tag online to validate whether it is a gene
 * @author zhenxiang
 *
 */
public class OnlineCheckAE extends JCasAnnotator_ImplBase {

  /**
   * the function that search a tag online to validate whether it is a gene <br>
   * I get the tag from the gene annotation, if it's confident between 0.6 to 0.5, <br>
   * I search it online
   */
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    Iterator annotationIter = aJCas.getAnnotationIndex(Gene.type).iterator();
    while (annotationIter.hasNext())
    {
      Gene  gAnnotation = (Gene) annotationIter.next();
      if (gAnnotation.getConfidence() < 0.6 && gAnnotation.getConfidence() > 0.5)
      {
        String tag = gAnnotation.getTag();
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
            gAnnotation.setConfidence(1.0);
            System.out.println(gAnnotation.getSentenceId()+"|"+gAnnotation.getBegin()+" "+gAnnotation.getEnd()+"|"+gAnnotation.getTag()+"\n");
          }
   
          bin.close();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          //e.printStackTrace();
        }
      }
    }   
    
  }

}
