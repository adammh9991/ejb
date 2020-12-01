package jsf_entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the history database table.
 * 
 */
@Entity
@NamedQuery(name="History.findAll", query="SELECT h FROM History h")
public class History implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idhistory;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="idmovie")
	private Movie movie;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="iduser")
	private User user;

	public History() {
	}

	public int getIdhistory() {
		return this.idhistory;
	}

	public void setIdhistory(int idhistory) {
		this.idhistory = idhistory;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}