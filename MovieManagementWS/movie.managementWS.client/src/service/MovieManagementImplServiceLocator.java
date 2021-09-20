/**
 * MovieManagementImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public class MovieManagementImplServiceLocator extends org.apache.axis.client.Service implements service.MovieManagementImplService {

    public MovieManagementImplServiceLocator() {
    }


    public MovieManagementImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MovieManagementImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MovieManagementImplPort
    private java.lang.String MovieManagementImplPort_address = "http://localhost:8080/movie.managementWS.web/services/MovieManagementImplPort";

    public java.lang.String getMovieManagementImplPortAddress() {
        return MovieManagementImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MovieManagementImplPortWSDDServiceName = "MovieManagementImplPort";

    public java.lang.String getMovieManagementImplPortWSDDServiceName() {
        return MovieManagementImplPortWSDDServiceName;
    }

    public void setMovieManagementImplPortWSDDServiceName(java.lang.String name) {
        MovieManagementImplPortWSDDServiceName = name;
    }

    public service.MovieManagement getMovieManagementImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MovieManagementImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMovieManagementImplPort(endpoint);
    }

    public service.MovieManagement getMovieManagementImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            service.MovieManagementImplServiceSoapBindingStub _stub = new service.MovieManagementImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getMovieManagementImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMovieManagementImplPortEndpointAddress(java.lang.String address) {
        MovieManagementImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (service.MovieManagement.class.isAssignableFrom(serviceEndpointInterface)) {
                service.MovieManagementImplServiceSoapBindingStub _stub = new service.MovieManagementImplServiceSoapBindingStub(new java.net.URL(MovieManagementImplPort_address), this);
                _stub.setPortName(getMovieManagementImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MovieManagementImplPort".equals(inputPortName)) {
            return getMovieManagementImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service/", "MovieManagementImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service/", "MovieManagementImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MovieManagementImplPort".equals(portName)) {
            setMovieManagementImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
