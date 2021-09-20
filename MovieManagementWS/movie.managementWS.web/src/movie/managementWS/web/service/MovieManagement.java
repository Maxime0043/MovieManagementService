package movie.managementWS.web.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import movie.managementWS.web.data.Actor;
import movie.managementWS.web.data.Movie;

/**
 * Interface where the functions related to the service are defined.
 * 
 * @author Micael DUPUIS and Maxime PINNA.
 *
 */
@WebService(name = "MovieManagement", targetNamespace = "http://service/")
public interface MovieManagement {

	/**
	 * Used to add a Movie in the list listMovies.
	 * 
	 * @param m. The movie that will be added.
	 * @return The movie that has been added.
	 */
	@WebMethod(operationName = "addMovie", action = "urn:AddMovie")
	@WebResult(name = "return")
	public int addMovie(@WebParam(name = "movie") Movie m);

	/**
	 * Used to add an Actor in the list listActors.
	 * 
	 * @param a. The actor that will be added.
	 * @return The actor that has been added.
	 */
	@WebMethod(operationName = "addActor", action = "urn:AddActor")
	@WebResult(name = "return")
	public int addActor(@WebParam(name = "actor") Actor a);

	/**
	 * Used to link an Actor to a Movie.
	 * 
	 * @param title_movie. Title of the targeted movie.
	 * @param name_actor. Name of the actor.
	 * @return If the connection has been made.
	 */
	@WebMethod(operationName = "linkActorToMovie", action = "urn:LinkActorToMovie")
	@WebResult(name = "return")
	public int linkActorToMovie(@WebParam(name = "title_movie") String title_movie, @WebParam(name = "name_actor") String name_actor);

	/**
	 * Used to retrieve informations about a Movie.
	 * 
	 * @param title. Title of the targeted movie.
	 * @return The targeted Movie.
	 */
	@WebMethod(operationName = "getMovieInfo", action = "urn:GetMovieInfo")
	@WebResult(name = "return")
	public Movie getMovieInfo(@WebParam(name = "title_movie") String title);
	
}
