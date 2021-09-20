/**
 * Movie.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public class Movie implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private service.Actor[] linkMovieToActor;

    private java.lang.String[] genre;

    private java.lang.String release_date;

    private java.lang.String title;

    public Movie() {
    }

    public Movie(
           service.Actor[] linkMovieToActor,
           java.lang.String[] genre,
           java.lang.String release_date,
           java.lang.String title) {
           this.linkMovieToActor = linkMovieToActor;
           this.genre = genre;
           this.release_date = release_date;
           this.title = title;
    }


    /**
     * Gets the linkMovieToActor value for this Movie.
     * 
     * @return linkMovieToActor
     */
    public service.Actor[] getLinkMovieToActor() {
        return linkMovieToActor;
    }


    /**
     * Sets the linkMovieToActor value for this Movie.
     * 
     * @param linkMovieToActor
     */
    public void setLinkMovieToActor(service.Actor[] linkMovieToActor) {
        this.linkMovieToActor = linkMovieToActor;
    }

    public service.Actor getLinkMovieToActor(int i) {
        return this.linkMovieToActor[i];
    }

    public void setLinkMovieToActor(int i, service.Actor _value) {
        this.linkMovieToActor[i] = _value;
    }


    /**
     * Gets the genre value for this Movie.
     * 
     * @return genre
     */
    public java.lang.String[] getGenre() {
        return genre;
    }


    /**
     * Sets the genre value for this Movie.
     * 
     * @param genre
     */
    public void setGenre(java.lang.String[] genre) {
        this.genre = genre;
    }

    public java.lang.String getGenre(int i) {
        return this.genre[i];
    }

    public void setGenre(int i, java.lang.String _value) {
        this.genre[i] = _value;
    }


    /**
     * Gets the release_date value for this Movie.
     * 
     * @return release_date
     */
    public java.lang.String getRelease_date() {
        return release_date;
    }


    /**
     * Sets the release_date value for this Movie.
     * 
     * @param release_date
     */
    public void setRelease_date(java.lang.String release_date) {
        this.release_date = release_date;
    }


    /**
     * Gets the title value for this Movie.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this Movie.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Movie)) return false;
        Movie other = (Movie) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.linkMovieToActor==null && other.getLinkMovieToActor()==null) || 
             (this.linkMovieToActor!=null &&
              java.util.Arrays.equals(this.linkMovieToActor, other.getLinkMovieToActor()))) &&
            ((this.genre==null && other.getGenre()==null) || 
             (this.genre!=null &&
              java.util.Arrays.equals(this.genre, other.getGenre()))) &&
            ((this.release_date==null && other.getRelease_date()==null) || 
             (this.release_date!=null &&
              this.release_date.equals(other.getRelease_date()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getLinkMovieToActor() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLinkMovieToActor());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLinkMovieToActor(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGenre() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGenre());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGenre(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRelease_date() != null) {
            _hashCode += getRelease_date().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Movie.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service/", "movie"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkMovieToActor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "linkMovieToActor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service/", "actor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("genre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "genre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("release_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "release_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
