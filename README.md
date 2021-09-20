# MovieManagementService

## Members
### Names
* DUPUIS Micaël
* PINNA Maxime

### Emails
* micaeldupuis@live.fr
* max.pinna@hotmail.fr

## Services' description
We have created two services to provide different functionalities around movie management. One is a REST web service and the other is a WS-* (or SOAP) web service.

Our services allow us to manage movies and actors. Indeed, different functionalities have been implemented to manage them. Movies and actors can be added to the services. When these movies and actors are added, they are not linked. However, added actors can be linked to movies by specifying the movie title and the actor's name. Finally, all information about a movie can be retrieved.

In addition, when the user requests information about a movie, the service will also make use of the OMDB api allowing us to retrieve the ranking of the movie concerned.

Furthermore, each movie in the services will include the following information:
* title
* release date
* list of genres
* list of actors playing in the film

Similarly, each actor present in the services will include the following information:
* a name
* the name of its role


The wsdl file of the WS service is available at the following address : [wsdl file](https://github.com/MrCookie78/MovieManagementService/blob/main/MovieManagementWS/movie.managementWS.web/WebContent/wsdl/moviemanagement.wsdl)

The Javadoc of the Restful service and the WS service are available at the following address : [javadoc folder](https://github.com/MrCookie78/MovieManagementService/tree/main/Javadoc)

## Clients' description
The different clients of the two services created are presented in the form of a graphical application, where the user can navigate between different windows to perform actions on the services.

The user will be able to navigate between the different tabs of the application in order to add films and actors, to link an actor to a film or to display all the information concerning a film. In addition, a form is present in the different tabs, allowing the user to fill in the necessary information. Once the form has been filled in, the user can execute the action concerned by pressing the appropriate button. Finally, the user will be able to observe the response to their request by means of a text box displaying the action carried out in the event of success, and the error made in the event of failure.

## Demonstration

Once the service has started, you can run the client. You will see a window that has just opened.
![add_movie_panel](https://github.com/MrCookie78/MovieManagementService/blob/main/demonstration_images/add_movie_panel.png)

In this first window, you can add a movie by filling in the various fields with the necessary information.
![add_movie_informations](https://github.com/MrCookie78/MovieManagementService/blob/main/demonstration_images/add_movie_informations.png)

By clicking on the "add" button, the service will send you the result, success or failure, of the operation.
![add_movie_response](https://github.com/MrCookie78/MovieManagementService/blob/main/demonstration_images/add_movie_response.png)

You can then add an actor, for this you need to change the window by clicking on the "add actor" button. And in the same way as for a movie, you can add an actor by filling in the fields and pressing the "add" button. The service will inform you of the result of the operation.
![add_actor](https://github.com/MrCookie78/MovieManagementService/blob/main/demonstration_images/add_actor.png)

Now that a movie and an actor are added, you can link them together. To do this, you have to go to the "Link an Actor to a Movie" and complete the fields with the name of the desired movie and the actor you want to link and then click on the "link" button. You can see the result of the operation in the text field.
![add_link](https://github.com/MrCookie78/MovieManagementService/blob/main/demonstration_images/add_link.png)

Finally, you can get the information from a movie. To do this, you must enter the title of the desired film in the field of the "Movie Informations" window and click on "Get Informations".
The movie information will be displayed in the text field. The information displayed is the title, the release date and the actors. The rank of the movie is only available through the REST service.
![add_informations](https://github.com/MrCookie78/MovieManagementService/blob/main/demonstration_images/add_informations.png)

