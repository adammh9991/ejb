package jsf_entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the movie database table.
 * 
 */
@Entity
@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmovie;

	@Lob
	private String description;

	@Lob
	@Column(name="famous_actors")
	private String famousActors;

	private byte length;

	private byte popular;

	private double rate;

	private String title;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="movie")
	private List<Comment> comments;

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="movie")
	private List<History> histories;

	//bi-directional many-to-one association to Genre
	@ManyToOne
	private Genre genre;

	public Movie() {
	}

	public int getIdmovie() {
		return this.idmovie;
	}

	public void setIdmovie(int idmovie) {
		this.idmovie = idmovie;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFamousActors() {
		return this.famousActors;
	}

	public void setFamousActors(String famousActors) {
		this.famousActors = famousActors;
	}

	public byte getLength() {
		return this.length;
	}

	public void setLength(byte length) {
		this.length = length;
	}

	public byte getPopular() {
		return this.popular;
	}

	public void setPopular(byte popular) {
		this.popular = popular;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setMovie(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setMovie(null);

		return comment;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public History addHistory(History history) {
		getHistories().add(history);
		history.setMovie(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setMovie(null);

		return history;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}