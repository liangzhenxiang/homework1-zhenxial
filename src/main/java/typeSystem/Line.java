

/* First created by JCasGen Tue Oct 16 19:14:27 EDT 2012 */
package typeSystem;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue Oct 16 19:14:27 EDT 2012
 * XML source: /Users/zhenxiang/Documents/workspace/homework1-zhenxial/src/main/resources/decriptors/type_system/Line.xml
 * @generated */
public class Line extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Line.class);
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
  protected Line() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Line(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Line(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Line(JCas jcas, int begin, int end) {
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
  //* Feature: text

  /** getter for text - gets 
   * @generated */
  public String getText() {
    if (Line_Type.featOkTst && ((Line_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "typeSystem.Line");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Line_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets  
   * @generated */
  public void setText(String v) {
    if (Line_Type.featOkTst && ((Line_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "typeSystem.Line");
    jcasType.ll_cas.ll_setStringValue(addr, ((Line_Type)jcasType).casFeatCode_text, v);}    
  }

    