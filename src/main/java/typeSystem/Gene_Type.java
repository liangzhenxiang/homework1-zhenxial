
/* First created by JCasGen Sun Oct 14 15:04:01 EDT 2012 */
package typeSystem;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Sun Oct 14 15:04:01 EDT 2012
 * @generated */
public class Gene_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Gene_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Gene_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Gene(addr, Gene_Type.this);
  			   Gene_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Gene(addr, Gene_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Gene.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("typeSystem.Gene");
 
  /** @generated */
  final Feature casFeat_tag;
  /** @generated */
  final int     casFeatCode_tag;
  /** @generated */ 
  public String getTag(int addr) {
        if (featOkTst && casFeat_tag == null)
      jcas.throwFeatMissing("tag", "typeSystem.Gene");
    return ll_cas.ll_getStringValue(addr, casFeatCode_tag);
  }
  /** @generated */    
  public void setTag(int addr, String v) {
        if (featOkTst && casFeat_tag == null)
      jcas.throwFeatMissing("tag", "typeSystem.Gene");
    ll_cas.ll_setStringValue(addr, casFeatCode_tag, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sentenceId;
  /** @generated */
  final int     casFeatCode_sentenceId;
  /** @generated */ 
  public String getSentenceId(int addr) {
        if (featOkTst && casFeat_sentenceId == null)
      jcas.throwFeatMissing("sentenceId", "typeSystem.Gene");
    return ll_cas.ll_getStringValue(addr, casFeatCode_sentenceId);
  }
  /** @generated */    
  public void setSentenceId(int addr, String v) {
        if (featOkTst && casFeat_sentenceId == null)
      jcas.throwFeatMissing("sentenceId", "typeSystem.Gene");
    ll_cas.ll_setStringValue(addr, casFeatCode_sentenceId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_be;
  /** @generated */
  final int     casFeatCode_be;
  /** @generated */ 
  public int getBe(int addr) {
        if (featOkTst && casFeat_be == null)
      jcas.throwFeatMissing("be", "typeSystem.Gene");
    return ll_cas.ll_getIntValue(addr, casFeatCode_be);
  }
  /** @generated */    
  public void setBe(int addr, int v) {
        if (featOkTst && casFeat_be == null)
      jcas.throwFeatMissing("be", "typeSystem.Gene");
    ll_cas.ll_setIntValue(addr, casFeatCode_be, v);}
    
  
 
  /** @generated */
  final Feature casFeat_en;
  /** @generated */
  final int     casFeatCode_en;
  /** @generated */ 
  public int getEn(int addr) {
        if (featOkTst && casFeat_en == null)
      jcas.throwFeatMissing("en", "typeSystem.Gene");
    return ll_cas.ll_getIntValue(addr, casFeatCode_en);
  }
  /** @generated */    
  public void setEn(int addr, int v) {
        if (featOkTst && casFeat_en == null)
      jcas.throwFeatMissing("en", "typeSystem.Gene");
    ll_cas.ll_setIntValue(addr, casFeatCode_en, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Gene_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_tag = jcas.getRequiredFeatureDE(casType, "tag", "uima.cas.String", featOkTst);
    casFeatCode_tag  = (null == casFeat_tag) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tag).getCode();

 
    casFeat_sentenceId = jcas.getRequiredFeatureDE(casType, "sentenceId", "uima.cas.String", featOkTst);
    casFeatCode_sentenceId  = (null == casFeat_sentenceId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sentenceId).getCode();

 
    casFeat_be = jcas.getRequiredFeatureDE(casType, "be", "uima.cas.Integer", featOkTst);
    casFeatCode_be  = (null == casFeat_be) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_be).getCode();

 
    casFeat_en = jcas.getRequiredFeatureDE(casType, "en", "uima.cas.Integer", featOkTst);
    casFeatCode_en  = (null == casFeat_en) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_en).getCode();

  }
}



    