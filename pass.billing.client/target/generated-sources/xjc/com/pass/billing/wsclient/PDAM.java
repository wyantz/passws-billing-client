//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.02.22 at 07:49:43 AM ICT 
//


package com.pass.billing.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PDAM complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PDAM"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="kodePDAM" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nama" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PDAM", namespace = "http://www.pass-pdam.com/ws/schemas/types", propOrder = {
    "kodePDAM",
    "nama"
})
public class PDAM {

    @XmlElement(required = true)
    protected String kodePDAM;
    @XmlElement(required = true)
    protected String nama;

    /**
     * Gets the value of the kodePDAM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKodePDAM() {
        return kodePDAM;
    }

    /**
     * Sets the value of the kodePDAM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKodePDAM(String value) {
        this.kodePDAM = value;
    }

    /**
     * Gets the value of the nama property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNama() {
        return nama;
    }

    /**
     * Sets the value of the nama property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNama(String value) {
        this.nama = value;
    }

}
