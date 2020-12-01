package jsf_ejbDAO;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jsf_entities.Movie;


public class MovieDao {
	
	// Dependency injection (no setter method is needed)
			@PersistenceContext
			protected EntityManager em;
			
			public void insert(Movie movie) {
				em.persist(movie);
			}

			public Movie update(Movie movie) {
				return em.merge(movie);
			}

			public void delete(Movie movie) {
				em.remove(em.merge(movie));
			}

			public Movie get(Movie id) {
				return em.find(Movie.class, id);
			}

}
