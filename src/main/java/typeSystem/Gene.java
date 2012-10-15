

/* First created by JCasGen Sun Oct 14 15:04:01 EDT 2012 */
package typeSystem;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Oct 14 15:04:01 EDT 2012
 * XML source: /Users/zhenxiang/Documents/workspace/hw1-zhenxial/src/main/resources/decriptors/type_system/GeneTS.xml
 * @generated */
public class Gene extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Gene.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Gene() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Gene(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Gene(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Gene(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: tag

  /** getter for tag - gets 
   * @generated */
  public String getTag() {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_tag == null)
      jcasType.jcas.throwFeatMissing("tag", "typeSystem.Gene");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Gene_Type)jcasType).casFeatCode_tag);}
    
  /** setter for tag - sets  
   * @generated */
  public void setTag(String v) {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_tag == null)
      jcasType.jcas.throwFeatMissing("tag", "typeSystem.Gene");
    jcasType.ll_cas.ll_setStringValue(addr, ((Gene_Type)jcasType).casFeatCode_tag, v);}    
   
    
  //*--------------*
  //* Feature: sentenceId

  /** getter for sentenceId - gets 
   * @generated */
  public String getSentenceId() {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_sentenceId == null)
      jcasType.jcas.throwFeatMissing("sentenceId", "typeSystem.Gene");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Gene_Type)jcasType).casFeatCode_sentenceId);}
    
  /** setter for sentenceId - sets  
   * @generated */
  public void setSentenceId(String v) {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_sentenceId == null)
      jcasType.jcas.throwFeatMissing("sentenceId", "typeSystem.Gene");
    jcasType.ll_cas.ll_setStringValue(addr, ((Gene_Type)jcasType).casFeatCode_sentenceId, v);}    
   
    
  //*--------------*
  //* Feature: be

  /** getter for be - gets 
   * @generated */
  public int getBe() {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_be == null)
      jcasType.jcas.throwFeatMissing("be", "typeSystem.Gene");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Gene_Type)jcasType).casFeatCode_be);}
    
  /** setter for be - sets  
   * @generated */
  public void setBe(int v) {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_be == null)
      jcasType.jcas.throwFeatMissing("be", "typeSystem.Gene");
    jcasType.ll_cas.ll_setIntValue(addr, ((Gene_Type)jcasType).casFeatCode_be, v);}    
   
    
  //*--------------*
  //* Feature: en

  /** getter for en - gets 
   * @generated */
  public int getEn() {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_en == null)
      jcasType.jcas.throwFeatMissing("en", "typeSystem.Gene");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Gene_Type)jcasType).casFeatCode_en);}
    
  /** setter for en - sets  
   * @generated */
  public void setEn(int v) {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_en == null)
      jcasType.jcas.throwFeatMissing("en", "typeSystem.Gene");
    jcasType.ll_cas.ll_setIntValue(addr, ((Gene_Type)jcasType).casFeatCode_en, v);}    
  }

    