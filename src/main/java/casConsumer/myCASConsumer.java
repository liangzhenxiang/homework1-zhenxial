package casConsumer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.CasToInlineXml;
import org.apache.uima.util.ProcessTrace;

import typeSystem.Gene;
import typeSystem.Sentence;

public class myCASConsumer extends CasConsumer_ImplBase {
  File outFile;

  FileWriter fileWriter;

  /**
   * Initializes this CAS Consumer with the parameters specified in the descriptor.
   * 
   * @throws ResourceInitializationException
   *           if there is error in initializing the resources
   */
  public void initialize() throws ResourceInitializationException {

    // extract configuration parameter settings
    String oDir = (String) getUimaContext().getConfigParameterValue("OutputDir");
    outFile = new File(oDir.trim()+"/hw1-zhenxial.out");
    try {
      fileWriter = new FileWriter(outFile);
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
  }

  /**
   * Processes the CasContainer which was populated by the TextAnalysisEngines. <br>
   * In this case, the CAS index is iterated over selected annotations and printed out into an
   * output file
   * 
   * @param aCAS
   *          CasContainer which has been populated by the TAEs
   * 
   * @throws ResourceProcessException
   *           if there is an error in processing the Resource
   * 
   * @see org.apache.uima.collection.base_cpm.CasObjectProcessor#processCas(CAS)
   */
  public void processCas(CAS aCAS) throws ResourceProcessException {
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    
    // iterate and print annotations
    Iterator annotationIter = jcas.getAnnotationIndex(Gene.type).iterator();
    while (annotationIter.hasNext()) {
      Gene gannotation = (Gene) annotationIter.next();
      try {
        fileWriter.write(gannotation.getSentenceId()+"|"+gannotation.getBegin()+" "+gannotation.getEnd()+"|"+gannotation.getTag()+"\n");
        fileWriter.flush();
        //System.out.println(gannotation.getSentenceId()+"|"+gannotation.getBe()+" "+gannotation.getEn()+"|"+gannotation.getTag()+"\n");
      } catch (IOException e) {
        throw new ResourceProcessException(e);
      }
    }
     
  }
  public void collectionProcessComplete(ProcessTrace aTrace) throws ResourceProcessException,
    IOException {
      if (fileWriter != null) {
        fileWriter.close();
      }
  }
  public void destroy() {
    if (fileWriter != null) {
      try {
        fileWriter.close();
      } catch (IOException e) {
        // ignore IOException on destroy
      }
    }
  }
  
}
