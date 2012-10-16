package analysisEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceAccessException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.FileUtils;

import typeSystem.Gene;
import typeSystem.Sentence;
import regonizer.PosTagNamedEntityRecognizer;

public class GeneAE extends JCasAnnotator_ImplBase {
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

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {

  /*  try {
      String filePath = getContext().getResourceFilePath("genes");
      File file = new File(filePath);
      String genes = FileUtils.file2String(file);
      Gene  Annotation = new Gene(aJCas);
      Annotation.setTag(genes);
      Annotation.addToIndexes();
    } catch (ResourceAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    */
    PosTagNamedEntityRecognizer re = null;
    try {
       re= new PosTagNamedEntityRecognizer();
    } catch (ResourceInitializationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    // iterate and print annotations
    Iterator annotationIter = aJCas.getAnnotationIndex(Sentence.type).iterator();
    while (annotationIter.hasNext()) {
      Sentence sAnnotation = (Sentence) annotationIter.next();
      Map<Integer, Integer> begin2end= re.getGeneSpans(sAnnotation.getText());
      Iterator it = begin2end.entrySet().iterator();
     /* System.out.println(begin2end.size());
      Gene  nAnnotation = new Gene(aJCas);
      nAnnotation.setTag(((Integer)begin2end.size()).toString());
      nAnnotation.setSentenceId(sAnnotation.getId());
      nAnnotation.addToIndexes(); */
      while (it.hasNext())
      {
        Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
        Integer begin = entry.getKey();
        Integer end = entry.getValue();
        Gene  gAnnotation = new Gene(aJCas);
        gAnnotation.setTag(sAnnotation.getText().substring(begin, end));
        gAnnotation.setBegin(countOffSet(begin,sAnnotation.getText()));
        gAnnotation.setSentenceId(sAnnotation.getId());
        //System.out.println(gAnnotation.getSentenceId()+"|"+gAnnotation.getBe()+" "+gAnnotation.getEn()+"|"+gAnnotation.getTag()+"\n");
        gAnnotation.addToIndexes();
      }
    }
    //annotationIter = aJCas.getAnnotationIndex(Gene.type).iterator();
    //while (annotationIter.hasNext()) {
      //Gene gannotation = (Gene) annotationIter.next();
      //System.out.println(gannotation.getSentenceId()+"|"+gannotation.getBe()+" "+gannotation.getEn()+"|"+gannotation.getTag()+"\n");
    //}
  }

}
