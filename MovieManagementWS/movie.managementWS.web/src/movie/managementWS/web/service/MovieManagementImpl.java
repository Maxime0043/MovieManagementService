package movie.managementWS.web.service;

import java.util.HashMap;

import javax.jws.WebService;

import movie.managementWS.web.data.Actor;
import movie.managementWS.web.data.Movie;

/**
 * Class defining the functions declared in the interface MovieManagement.
 * 
 * @author Micael DUPUIS and Maxime PINNA.
 *
 */
@WebService(targetNamespace = "http://service/", endpointInterface = "movie.managementWS.web.service.MovieManagement", portName = "MovieManagementImplPort", serviceName = "MovieManagementImplService")
public class MovieManagementImpl implements MovieManagement{
	
	public HashMap<String, Movie> listMovies = new HashMap<String, Movie>();
	public HashMap<String, Actor> listActors = new HashMap<String, Actor>();
	
	/**
	 * Used to add a Movie in the list listMovies.
	 * 
	 * @param m. The movie that will be added.
	 * @return The movie that has been added.
	 */
	public int addMovie(Movie m) {
		if(!listMovies.containsKey(m.getTitle())) {
			listMovies.put(m.getTitle(), m);
			
			return 0;
		}
		
		return -1;
	}

	/**
	 * Used to add an Actor in the list listActors.
	 * 
	 * @param a. The actor that will be added.
	 * @return The actor that has been added.
	 */
	public int addActor(Actor a) {
		if(!listActors.containsKey(a.getName())) {
			listActors.put(a.getName(), a);
			
			return 0;
		}
		
		return -1;
	}

	/**
	 * Used to link an Actor to a Movie.
	 * 
	 * @param title_movie. Title of the targeted movie.
	 * @param name_actor. Name of the actor.
	 * @return If the connection has been made.
	 */
	public int linkActorToMovie(String title_movie, String name_actor) {
		Movie m = listMovies.get(title_movie);
		Actor a = listActors.get(name_actor);
		
		if(m == null || a == null) {
			return -1;
		}
		
		if(m.containsActor(a)) {
			return -2;
		}
		
		m.linkActorToMovie(a);
		
		return 0;
	}

	/**
	 * Used to retrieve informations about a Movie.
	 * 
	 * @param title. Title of the targeted movie.
	 * @return The targeted Movie.
	 */
	public Movie getMovieInfo(String title) {
		if(listMovies.containsKey(title)) {
			Movie m = listMovies.get(title);
			
			return m;
		}
		
		return null;
	}

}
