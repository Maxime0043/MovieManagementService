package client;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.xml.rpc.ServiceException;

import service.*;

/**
 * Class allowing to launch the client in graphic mode. The user can interact with the web service.
 * 
 * @author Maxime PINNA and Micaël DUPUIS
 *
 */
public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panel, menuPanel, contentPanel, moviePanel, actorPanel, linkPanel, infoPanel;
	private CardLayout cl;
	private MovieManagement MovieManagement;

	public Gui() {
		this.panel = new JPanel();
		this.menuPanel = new JPanel();
		this.contentPanel = new JPanel();
		this.moviePanel = new JPanel();
		this.actorPanel = new JPanel();
		this.linkPanel = new JPanel();
		this.infoPanel = new JPanel();
		this.cl = new CardLayout();
		
		MovieManagementImplServiceLocator locator = new MovieManagementImplServiceLocator();
		
		try {
			this.MovieManagement = locator.getMovieManagementImplPort();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
		initPanel();

		this.setTitle("MovieManagementService");
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setContentPane(panel);
	}
	
	/**
	 * Initialize the main panel.
	 */
	public void initPanel() {
		panel.setBackground(Color.WHITE);
		panel.setLayout(new BorderLayout());
		
		initMenuPanel();
		initContentPanel();
		
		panel.add(menuPanel, BorderLayout.NORTH);
		panel.add(contentPanel, BorderLayout.CENTER);
	}

	/**
	 * Initialize the panel where we change the current window.
	 */
	public void initMenuPanel() {
		menuPanel.setBackground(Color.WHITE);
		menuPanel.setLayout(new FlowLayout());
		
		JButton movieButton = new JButton("Add Movie");
		JButton actorButton = new JButton("Add Actor");
		JButton linkButton = new JButton("Link an Actor to a Movie");
		JButton infoButton = new JButton("Movie Informations");

		movieButton.setEnabled(false);
		movieButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPanel, "1");
				movieButton.setEnabled(false);
				actorButton.setEnabled(true);
				linkButton.setEnabled(true);
				infoButton.setEnabled(true);
			}
		});
		actorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPanel, "2");
				movieButton.setEnabled(true);
				actorButton.setEnabled(false);
				linkButton.setEnabled(true);
				infoButton.setEnabled(true);
			}
		});
		linkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPanel, "3");
				movieButton.setEnabled(true);
				actorButton.setEnabled(true);
				linkButton.setEnabled(false);
				infoButton.setEnabled(true);
			}
		});
		infoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPanel, "4");
				movieButton.setEnabled(true);
				actorButton.setEnabled(true);
				linkButton.setEnabled(true);
				infoButton.setEnabled(false);
			}
		});
		
		menuPanel.add(movieButton);
		menuPanel.add(actorButton);
		menuPanel.add(linkButton);
		menuPanel.add(infoButton);
	}

	/**
	 * Initialize the panel where the different windows are located.
	 */
	public void initContentPanel() {
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setLayout(cl);
		
		initMoviePanel();
		initActorPanel();
		initLinkPanel();
		initInfoPanel();
		
		contentPanel.add(moviePanel, "1");
		contentPanel.add(actorPanel, "2");
		contentPanel.add(linkPanel, "3");
		contentPanel.add(infoPanel, "4");
		
		cl.show(contentPanel, "1");
	}
	
	/**
	 * Initialize the movie panel where the user can add a Movie.
	 */
	public void initMoviePanel() {
		moviePanel.setBackground(Color.WHITE);
		moviePanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		JLabel movieTitle = new JLabel("Movie Title :");
		moviePanel.add(movieTitle, gbc);
		gbc.gridx++;
		
		JTextField addMovieField = new JTextField(20);
		moviePanel.add(addMovieField, gbc);
		gbc.gridx--;
		gbc.gridy++;
		
		JLabel movieDate = new JLabel("Release Date :");
		moviePanel.add(movieDate, gbc);
		gbc.gridx++;
		
		PlaceholderTextField addDateField = new PlaceholderTextField(20);
		addDateField.setPlaceholder("DD-MM-YYYY");
		moviePanel.add(addDateField, gbc);
		gbc.gridx--;
		gbc.gridy++;
		
		JLabel movieGenre = new JLabel("Genres :");
		moviePanel.add(movieGenre, gbc);
		gbc.gridx++;
		
		PlaceholderTextField addGenreField = new PlaceholderTextField(20);
		addGenreField.setPlaceholder("animation,action,...");
		moviePanel.add(addGenreField, gbc);
		
		gbc.gridx--;
		gbc.gridy++;
		gbc.gridwidth = 2;
		JButton addMovieButton = new JButton("Add");
		moviePanel.add(addMovieButton, gbc);
		
		gbc.gridy++;
		JLabel responseText = new JLabel("Response :");
		moviePanel.add(responseText, gbc);
		
		gbc.gridy++;
		JTextArea response = new JTextArea(20, 40);
		response.setBorder(BorderFactory.createLineBorder(Color.BLACK , 2));
		moviePanel.add(response, gbc);
		
		addMovieButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(addDateField.getText().replace(" ", "").isEmpty() || 
				   addMovieField.getText().replace(" ", "").isEmpty() ||
				   addGenreField.getText().replace(" ", "").isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "You must fill in all the fields !", "Error", JOptionPane.WARNING_MESSAGE);
                    
				    return;
				}
				
				int result = -1;
				Actor[] linkMovieToActor = {};
				ArrayList<String> genreList = new ArrayList<String>();
				
				for(String genre : addGenreField.getText().split(",")) {
					genreList.add(genre);
				}
				
				String[] genreArray = new String[genreList.size()];
				int i = 0;
				for(String genre : genreList) {
					genreArray[i] = genre;
					i++;
				}
				
				Movie m = new Movie(linkMovieToActor, genreArray, addDateField.getText(), addMovieField.getText().replace(" ", "-"));
				try {
					result = MovieManagement.addMovie(m);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(result == 0) response.setText("Movie added");
				else response.setText("The film has already been added !");
				
			}
		});
	}

	/**
	 * Initialize the actor panel where the user can add an Actor.
	 */
	public void initActorPanel() {
		actorPanel.setBackground(Color.WHITE);
		actorPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		JLabel actorFullName = new JLabel("Actor Full Name :");
		actorPanel.add(actorFullName, gbc);
		gbc.gridx++;

		JTextField addActorField = new JTextField(20);
		actorPanel.add(addActorField, gbc);
		gbc.gridx--;
		gbc.gridy++;
		
		JLabel actorRoleName = new JLabel("Role Name :");
		actorPanel.add(actorRoleName, gbc);
		gbc.gridx++;

		JTextField addRoleField = new JTextField(20);
		actorPanel.add(addRoleField, gbc);
		
		gbc.gridx--;
		gbc.gridy++;
		gbc.gridwidth = 2;
		JButton addActorButton = new JButton("Add");
		actorPanel.add(addActorButton, gbc);
		
		gbc.gridy++;
		JTextArea response = new JTextArea(20, 40);
		response.setBorder(BorderFactory.createLineBorder(Color.BLACK , 2));
		response.setEditable(false);
		
		actorPanel.add(response, gbc);
		
		addActorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(addActorField.getText().replace(" ", "").isEmpty() ||
				        addRoleField.getText().replace(" ", "").isEmpty()) {
				    JOptionPane.showMessageDialog(null, "You must fill in all the fields !", "Error", JOptionPane.WARNING_MESSAGE);
				                    
				    return;
				}
				
				int result = -1;
				Actor a = new Actor(addActorField.getText(), addRoleField.getText());
				try {
					result = MovieManagement.addActor(a);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(result == 0) response.setText("Actor added");
				else response.setText("The Actor has already been added !");
			}
		});
	}

	/**
	 * Initialize the link panel where the user can link an Actor to a Movie.
	 */
	public void initLinkPanel() {
		linkPanel.setBackground(Color.WHITE);
		linkPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		JLabel movieTitleLink = new JLabel("Movie Title :");
		linkPanel.add(movieTitleLink, gbc);
		gbc.gridx++;
		
		JTextField linkMovieField = new JTextField(20);
		linkPanel.add(linkMovieField, gbc);
		
		gbc.gridx--;
		gbc.gridy++;
		
		JLabel actorNameLink = new JLabel("Actor Full Name :");
		linkPanel.add(actorNameLink, gbc);
		gbc.gridx++;
		
		JTextField linkActorField = new JTextField(20);
		linkPanel.add(linkActorField, gbc);
		
		gbc.gridx--;
		gbc.gridy++;
		gbc.gridwidth = 2;
		JButton linkButton = new JButton("Link");
		linkPanel.add(linkButton, gbc);
		
		gbc.gridy++;
		JLabel responseText = new JLabel("Response :");
		linkPanel.add(responseText, gbc);
		
		gbc.gridy++;
		JTextArea response = new JTextArea(20, 40);
		response.setBorder(BorderFactory.createLineBorder(Color.BLACK , 2));
		response.setEditable(false);
		
		linkPanel.add(response, gbc);
		
		linkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(linkMovieField.getText().replace(" ", "").isEmpty() ||
				        linkActorField.getText().replace(" ", "").isEmpty()) {
				    JOptionPane.showMessageDialog(null, "You must fill in all the fields !", "Error", JOptionPane.WARNING_MESSAGE);
				            
				    return;
				}
				
				int result = 1;
				
				try {
					result = MovieManagement.linkActorToMovie(linkMovieField.getText().replace(" ", "-"), linkActorField.getText());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				if(result == 0) response.setText("Linked");
				else if (result == -1) response.setText("The movie and/or actor do not exist");
				else if (result == -2) response.setText("The Actor has already been linked to the Movie.");
				else response.setText("Error.");
			}
		});
	}

	/**
	 * Initialize the information panel where the user can see the informations about a Movie.
	 */
	public void initInfoPanel() {
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		JLabel movieTitleLink = new JLabel("Movie Title :");
		infoPanel.add(movieTitleLink, gbc);
		gbc.gridx++;
		
		JTextField getMovieField = new JTextField(20);
		infoPanel.add(getMovieField, gbc);
		
		gbc.gridx--;
		gbc.gridy++;
		gbc.gridwidth = 2;
		JButton infoButton = new JButton("Get Informations");
		infoPanel.add(infoButton, gbc);
		
		gbc.gridy++;
		JLabel responseText = new JLabel("Response :");
		infoPanel.add(responseText, gbc);
		
		gbc.gridy++;
		JTextArea response = new JTextArea(20, 40);
		response.setEditable(false);
		JScrollPane scroll = new JScrollPane(response, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK , 2));
		
		infoPanel.add(scroll, gbc);
		
		infoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getMovieField.getText().replace(" ", "").isEmpty()) {
				    JOptionPane.showMessageDialog(null, "You must fill in the field !", "Error", JOptionPane.WARNING_MESSAGE);
				                    
				    return;
				}
				
				Movie m = null;
				try {
					m = MovieManagement.getMovieInfo(getMovieField.getText().replace(" ", "-"));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(m != null) {
					String s = "Title : " + m.getTitle() + "\n"
							+ "Release Date : " + m.getRelease_date() + "\n"
							+ "\nGenre : ";
					
					for(String genre : m.getGenre()) {
						s += "\n  - " + genre;
					}
					
					if (m.getLinkMovieToActor() != null) {
						s += "\n\nActors : ";
						
						for(Actor actor : m.getLinkMovieToActor()) {
							s += "\n  - " + actor.getName() + " as " + actor.getRole();
						}
					}
					
					response.setText(s);
				}
				
				else response.setText("Movie doesn't exist !");
			}
		});
	}

}