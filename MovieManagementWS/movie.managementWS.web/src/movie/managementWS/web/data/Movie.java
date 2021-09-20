package movie.managementWS.web.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class allowing to create a movie.
 * 
 * @author Micael DUPUIS and Maxime PINNA.
 *
 */
@XmlRootElement
public class Movie {
	
	private String title;
	private String release_date;
	private ArrayList<String> genre;
	public ArrayList<Actor> linkMovieToActor = new ArrayList<Actor>();
	
	public Movie() {};
	
	public Movie(String title, String release_date, ArrayList<String> genre) {
		this.title = title;
		this.release_date = release_date;
		this.genre = genre;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getRelease_date() {
		return release_date;
	}
	
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	
	public ArrayList<String> getGenre() {
		return genre;
	}
	
	public void setGenre(ArrayList<String> genre) {
		this.genre = genre;
	}
	
	public ArrayList<Actor> getLinkMovieToActor() {
		return linkMovieToActor;
	}
	
	public void linkActorToMovie(Actor actor) {
		linkMovieToActor.add(actor);
	}
	
	public boolean containsActor(Actor actor) {
		return linkMovieToActor.contains(actor);
	}
}
