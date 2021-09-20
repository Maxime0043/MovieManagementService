package service;

public class MovieManagementProxy implements service.MovieManagement {
  private String _endpoint = null;
  private service.MovieManagement movieManagement = null;
  
  public MovieManagementProxy() {
    _initMovieManagementProxy();
  }
  
  public MovieManagementProxy(String endpoint) {
    _endpoint = endpoint;
    _initMovieManagementProxy();
  }
  
  private void _initMovieManagementProxy() {
    try {
      movieManagement = (new service.MovieManagementImplServiceLocator()).getMovieManagementImplPort();
      if (movieManagement != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)movieManagement)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)movieManagement)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (movieManagement != null)
      ((javax.xml.rpc.Stub)movieManagement)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public service.MovieManagement getMovieManagement() {
    if (movieManagement == null)
      _initMovieManagementProxy();
    return movieManagement;
  }
  
  public int linkActorToMovie(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (movieManagement == null)
      _initMovieManagementProxy();
    return movieManagement.linkActorToMovie(arg0, arg1);
  }
  
  public int addActor(service.Actor arg0) throws java.rmi.RemoteException{
    if (movieManagement == null)
      _initMovieManagementProxy();
    return movieManagement.addActor(arg0);
  }
  
  public service.Movie getMovieInfo(java.lang.String arg0) throws java.rmi.RemoteException{
    if (movieManagement == null)
      _initMovieManagementProxy();
    return movieManagement.getMovieInfo(arg0);
  }
  
  public int addMovie(service.Movie arg0) throws java.rmi.RemoteException{
    if (movieManagement == null)
      _initMovieManagementProxy();
    return movieManagement.addMovie(arg0);
  }
  
  
}