package movie.managementRS.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import movie.managementRS.web.data.Actor;
import movie.managementRS.web.data.Movie;

/**
 * Class used to interact with the web service.
 * 
 * @author Maxime PINNA and Micaël DUPUIS
 *
 */
public class RequestManagement {

	private static String webServiceUrl = "http://localhost:8080/movie.managementRS.web/api/movies";
	private static String SEARCH_URL = "http://www.omdbapi.com/?apikey=945ae9a5&t=";
	
	/**
	 * Used to add a Movie to the web service.
	 */
	public static Movie addMovie(String title, String release_date, ArrayList<String> genre) {
		System.out.println("Adding Movie " + title + "...");
		
		WebClient c = WebClient.create(webServiceUrl).path("movie");
		Movie m = new Movie(title, release_date, genre);
		
		Response r = c.post(m);
		
		if(r.getStatus() == 400) {
			System.out.println("Oops!");
			
			return null;
		}
		
		System.out.println("OK.");
		
		return m;
	}
	
	/**
	 * Used to add an Actor to the web service.
	 */
	public static Actor addActor(String name, String role) {
		System.out.println("Adding Actor " + name + "...");
		
		WebClient c = WebClient.create(webServiceUrl).path("actor");
		Actor a = new Actor(name, role);
		
		Response r = c.post(a);
		
		if(r.getStatus() == 400) {
			System.out.println("Oops!");
			
			return null;
		}
		
		System.out.println("OK.");
		
		return a;
	}
	
	/**
	 * Used to link an Actor to a Movie in the web service.
	 */
	public static boolean link(String title, String actor) {
		System.out.println("Linking " + actor + " with " + title + "...");
		
		WebClient c = WebClient.create(webServiceUrl).path("movie/" + title + "/actor/" + actor);
		
		Response r = c.post(title);
		
		if(r.getStatus() == 400) {
			System.out.println("Oops!");
			
			return false;
		}
		
		System.out.println("OK.");
		
		return true;
	}
	
	/**
	 * Used to retrieve informations about a Movie in the web service.
	 */
	public static Movie get(String title) {
		System.out.println("Getting " + title + "... ");
		
		WebClient c = WebClient.create(webServiceUrl).path(title);
		Movie m = null;
		
		try {
			m = c.get(Movie.class);
		
			System.out.println("Title : " + m.getTitle());
			System.out.println("Release Date : " + m.getRelease_date());
			System.out.println("Genre : ");
			
			for(String genre : m.getGenre()) {
				System.out.println("  - " + genre);
			}
			
			System.out.println("Actors : " + m.getLinkMovieToActor().size());
			
			for(Actor actor : m.getLinkMovieToActor()) {
				System.out.println("  - " + actor.getName() + " as " + actor.getRole());
			}
		}
		
		catch(NotFoundException e) {
			System.out.println("Oops!");
		}
		
		return m;
	}
	
	/**
	 * Used to retrieve the ranks about a Movie in the api omdbapi.
	 */
	public static String getRanking(String title) {
	    StringBuffer response = new StringBuffer();
	    String result = "Ranking for " + title + ":\n";
	    
	    try {
	        URL url = new URL(SEARCH_URL + title.replace(" ", "%20"));
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        
	        connection.setRequestMethod("GET");
	        connection.setRequestProperty("Accept", "*/*");
	        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        
	        InputStream stream = connection.getInputStream();
	        InputStreamReader reader = new InputStreamReader(stream);
	        BufferedReader buffer = new BufferedReader(reader);
	        
	        String line;
	        
	        while((line = buffer.readLine()) != null) {
	            response.append(line);
	        }
	        
	        buffer.close();
	        connection.disconnect();
	        
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    try {
	        JSONObject json = new JSONObject(response.toString());
	        JSONArray RatingsJSON = json.getJSONArray("Ratings");
	        JSONObject rating;
	        
	        for(int i = 0 ; i < RatingsJSON.length() ; i++) {
	            rating = RatingsJSON.getJSONObject(i);
	            result += "  - " + rating.getString("Source") + " : " + rating.getString("Value") + "\n";
	        }
	        
	    } catch (JSONException e) {
	        e.printStackTrace();
	    }
	    
	    if(result.isEmpty()) {
	        result = "No ranking found";
	    }
	    
	    return result;
	}
	
}
