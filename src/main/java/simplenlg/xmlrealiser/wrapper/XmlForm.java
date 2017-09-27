//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.04 at 09:14:07 AM EST 
//


package simplenlg.xmlrealiser.wrapper;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for form.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="form">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BARE_INFINITIVE"/>
 *     &lt;enumeration value="GERUND"/>
 *     &lt;enumeration value="IMPERATIVE"/>
 *     &lt;enumeration value="INFINITIVE"/>
 *     &lt;enumeration value="NORMAL"/>
 *     &lt;enumeration value="PAST_PARTICIPLE"/>
 *     &lt;enumeration value="PRESENT_PARTICIPLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "form")
@XmlEnum
public enum XmlForm {

    BARE_INFINITIVE,
    GERUND,
    IMPERATIVE,
    INFINITIVE,
    NORMAL,
    PAST_PARTICIPLE,
    PRESENT_PARTICIPLE;

    public String value() {
        return name();
    }

    public static XmlForm fromValue(String v) {
        return valueOf(v);
    }

}
