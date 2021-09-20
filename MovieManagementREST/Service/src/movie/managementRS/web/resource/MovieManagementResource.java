package movie.managementRS.web.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import movie.managementRS.web.data.Actor;
import movie.managementRS.web.data.Movie;
import movie.managementRS.web.service.MovieManagement;

/**
 * Class allowing to perform actions on the web service.
 * 
 * @author Maxime PINNA and Micaël DUPUIS.
 *
 */
@Path("/movies")
public class MovieManagementResource {
	
	MovieManagement service = new MovieManagement();
	
	@Context
	UriInfo uriInfo;
	
	/**
	 * Used to add a Movie in the list listMovies.
	 * 
	 * @param m. The movie that will be added.
	 * @return The movie that has been added.
	 */
	@POST
	@Path("/movie")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addMovie(Movie m) {
		Movie movie = service.addMovie(m);
		
		if(movie == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		URI uri = uriInfo.getRequestUri();
		String newUri = uri.getPath() + "/" + movie.getTitle();
		
		return Response.status(Response.Status.CREATED).entity(movie).contentLocation(uri.resolve(newUri)).build();
	}

	/**
	 * Used to add an Actor in the list listActors.
	 * 
	 * @param a. The actor that will be added.
	 * @return The actor that has been added.
	 */
	@POST
	@Path("/actor")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addActor(Actor a) {
		Actor actor = service.addActor(a);
		
		if(actor == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		URI uri = uriInfo.getRequestUri();
		String newUri = uri.getPath() + "/" + actor.getName();
		
		return Response.status(Response.Status.CREATED).entity(actor).contentLocation(uri.resolve(newUri)).build();
	}

	/**
	 * Used to link an Actor to a Movie.
	 * 
	 * @param title_movie. Title of the targeted movie.
	 * @param name_actor. Name of the actor.
	 * @return If the connection has been made.
	 */
	@POST
	@Path("/movie/{title}/actor/{actor}")
	@Produces(MediaType.APPLICATION_XML)
	public Response linkActorToMovie(@PathParam("title") String title_movie, @PathParam("actor") String name_actor) {
		if(!service.linkActorToMovie(title_movie, name_actor)) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		return Response.status(Response.Status.OK).build();
	}

	/**
	 * Used to retrieve informations about a Movie.
	 * 
	 * @param title. Title of the targeted movie.
	 * @return The targeted Movie.
	 */
	@GET
	@Path("/{title}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getMovieInfo(@PathParam("title") String title) {
		Movie movie = service.getMovieInfo(title);
		
		if(movie == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		Link link = Link.fromUri(uriInfo.getRequestUri()).rel("self").type("application/xml").build();
		
		return Response.status(Response.Status.OK).entity(movie).links(link).build();
	}
	
}
