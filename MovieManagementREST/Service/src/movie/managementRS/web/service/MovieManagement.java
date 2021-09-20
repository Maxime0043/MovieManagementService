package movie.managementRS.web.service;

import java.util.HashMap;

import movie.managementRS.web.data.Actor;
import movie.managementRS.web.data.Movie;

/**
 * Class where the web service data will be stored.
 * 
 * @author Maxime PINNA and Micaël DUPUIS.
 *
 */
public class MovieManagement {
	
	public HashMap<String, Movie> listMovies = new HashMap<String, Movie>();
	public HashMap<String, Actor> listActors = new HashMap<String, Actor>();

	/**
	 * Used to add a Movie in the list listMovies.
	 * 
	 * @param m. The movie that will be added.
	 * @return The movie that has been added.
	 */
	public Movie addMovie(Movie m) {
		if(!listMovies.containsKey(m.getTitle())) {
			listMovies.put(m.getTitle(), m);
			
			return m;
		}
		
		return null;
	}

	/**
	 * Used to add an Actor in the list listActors.
	 * 
	 * @param a. The actor that will be added.
	 * @return The actor that has been added.
	 */
	public Actor addActor(Actor a) {
		if(!listActors.containsKey(a.getName())) {
			listActors.put(a.getName(), a);
			
			return a;
		}
		
		return null;
	}

	/**
	 * Used to link an Actor to a Movie.
	 * 
	 * @param title_movie. Title of the targeted movie.
	 * @param name_actor. Name of the actor.
	 * @return If the connection has been made.
	 */
	public boolean linkActorToMovie(String title_movie, String name_actor) {
		Movie m = listMovies.get(title_movie);
		Actor a = listActors.get(name_actor);
		
		if(m == null || a == null) {
			return false;
		}
		
		if(m.containsActor(a)) {
			return false;
		}
		
		m.linkActorToMovie(a);
		
		return true;
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
