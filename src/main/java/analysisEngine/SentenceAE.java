package analysisEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import typeSystem.Sentence;

public class SentenceAE extends JCasAnnotator_ImplBase {
  private Pattern sentencePattern = Pattern.compile("([^ ]*)[ ](.*)[\n]");

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    String docText = aJCas.getDocumentText();
    
    Matcher matcher = sentencePattern.matcher(docText);
    int pos = 0;
    while (matcher.find(pos)){
      Sentence annotation = new Sentence(aJCas);
      annotation.setBegin(matcher.start());
      annotation.setEnd(matcher.end());
      annotation.setId(matcher.group(1));
      annotation.setText(matcher.group(2));
      annotation.addToIndexes();
      pos = matcher.end();
    }
  }
}
