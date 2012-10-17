package analysisEngine;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import typeSystem.Line;
import typeSystem.Sentence;

public class SentenceAE extends JCasAnnotator_ImplBase {
  private Pattern sentencePattern = Pattern.compile("([^ ]*)[ ](.*)");

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
