/**
 * MovieManagement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public interface MovieManagement extends java.rmi.Remote {
    public int linkActorToMovie(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public int addActor(service.Actor arg0) throws java.rmi.RemoteException;
    public service.Movie getMovieInfo(java.lang.String arg0) throws java.rmi.RemoteException;
    public int addMovie(service.Movie arg0) throws java.rmi.RemoteException;
}
