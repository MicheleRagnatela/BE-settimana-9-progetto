package it.films.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.films.entity.Film;

public class FilmDao implements IFilmDao{

	private EntityManager em = EntityManagerHelper.getEntityManager();
	
	@Override
	public void memorizza(Film f) {
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
	}

	/**
	 * Il metodo ricerca tutti i film in base al regista che passiamo
	 * nel metodo come paramtro 
	 * 
	 * @param regista passiamo come parametro un regista
	 * @return listaFilm ritorna i film di quel regista
	 */
	@Override
	public List<Film> ricercaByRegista(String regista) {
		Query q = em.createQuery("SELECT f FROM Film f WHERE f.regista = :regista");
		q.setParameter("regista", regista);
		List<Film> listaFilm = q.getResultList();
		return listaFilm;
	}

	@Override
	public List<Film> trovaFilms() {
		Query q = em.createQuery("SELECT f FROM Film f");
		List<Film> listaFilm = q.getResultList();
		return listaFilm;
	}

}
