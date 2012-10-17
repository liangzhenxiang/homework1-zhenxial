package analysisEngine;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import typeSystem.Line;
import typeSystem.Sentence;

/**
 * a simple annotator that parse a sentence with id and text content <br>
 * @author zhenxiang
 *
 */
public class SentenceAE extends JCasAnnotator_ImplBase {
  /**
   * a  regular expression that parses a sentence with id and text content <br>
   */
  private Pattern sentencePattern = Pattern.compile("([^ ]*)[ ](.*)");

  /**
   * the function that parses a sentence with id and text content <br>
   */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    Iterator annotationIter = aJCas.getAnnotationIndex(Line.type).iterator();
    
    while (annotationIter.hasNext())
    {
      Line lannotation =  (Line) annotationIter.next();
      String line = lannotation.getText();
      
      Matcher matcher = sentencePattern.matcher(line);
      int pos = 0;
      while (matcher.find(pos)){
        Sentence annotation = new Sentence(aJCas);
        annotation.setId(matcher.group(1));
        annotation.setText(matcher.group(2));
        annotation.addToIndexes();
        //System.out.println(matcher.group(2));
        pos = matcher.end();
      }
    }
  }
}
