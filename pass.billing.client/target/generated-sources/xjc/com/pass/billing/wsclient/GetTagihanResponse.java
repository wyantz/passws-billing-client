//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.06 at 06:58:43 AM ICT 
//


package com.pass.billing.wsclient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="kodePDAM" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="noSambungan" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nama" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="alamat" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="golongan" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="periode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="kubikase" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="jumlahRekening" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="totalTagihan" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="totalDenda" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="grandTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="tagihan" type="{http://www.pass-pdam.com/ws/schemas/types}Tagihan" maxOccurs="10" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "kodePDAM",
    "noSambungan",
    "nama",
    "alamat",
    "golongan",
    "periode",
    "status",
    "kubikase",
    "jumlahRekening",
    "totalTagihan",
    "totalDenda",
    "grandTotal",
    "tagihan"
})
@XmlRootElement(name = "getTagihanResponse")
public class GetTagihanResponse {

    @XmlElement(required = true)
    protected String kodePDAM;
    @XmlElement(required = true)
    protected String noSambungan;
    @XmlElement(required = true)
    protected String nama;
    @XmlElement(required = true)
    protected String alamat;
    @XmlElement(required = true)
    protected String golongan;
    @XmlElement(required = true)
    protected String periode;
    @XmlElement(required = true)
    protected String status;
    @XmlElement(required = true)
    protected BigDecimal kubikase;
    protected int jumlahRekening;
    @XmlElement(required = true)
    protected BigDecimal totalTagihan;
    @XmlElement(required = true)
    protected BigDecimal totalDenda;
    @XmlElement(required = true)
    protected BigDecimal grandTotal;
    protected List<Tagihan> tagihan;

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
     * Gets the value of the noSambungan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoSambungan() {
        return noSambungan;
    }

    /**
     * Sets the value of the noSambungan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoSambungan(String value) {
        this.noSambungan = value;
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

    /**
     * Gets the value of the alamat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * Sets the value of the alamat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlamat(String value) {
        this.alamat = value;
    }

    /**
     * Gets the value of the golongan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGolongan() {
        return golongan;
    }

    /**
     * Sets the value of the golongan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGolongan(String value) {
        this.golongan = value;
    }

    /**
     * Gets the value of the periode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriode() {
        return periode;
    }

    /**
     * Sets the value of the periode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriode(String value) {
        this.periode = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the kubikase property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getKubikase() {
        return kubikase;
    }

    /**
     * Sets the value of the kubikase property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setKubikase(BigDecimal value) {
        this.kubikase = value;
    }

    /**
     * Gets the value of the jumlahRekening property.
     * 
     */
    public int getJumlahRekening() {
        return jumlahRekening;
    }

    /**
     * Sets the value of the jumlahRekening property.
     * 
     */
    public void setJumlahRekening(int value) {
        this.jumlahRekening = value;
    }

    /**
     * Gets the value of the totalTagihan property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalTagihan() {
        return totalTagihan;
    }

    /**
     * Sets the value of the totalTagihan property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalTagihan(BigDecimal value) {
        this.totalTagihan = value;
    }

    /**
     * Gets the value of the totalDenda property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalDenda() {
        return totalDenda;
    }

    /**
     * Sets the value of the totalDenda property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalDenda(BigDecimal value) {
        this.totalDenda = value;
    }

    /**
     * Gets the value of the grandTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    /**
     * Sets the value of the grandTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrandTotal(BigDecimal value) {
        this.grandTotal = value;
    }

    /**
     * Gets the value of the tagihan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tagihan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTagihan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tagihan }
     * 
     * 
     */
    public List<Tagihan> getTagihan() {
        if (tagihan == null) {
            tagihan = new ArrayList<Tagihan>();
        }
        return this.tagihan;
    }

}
