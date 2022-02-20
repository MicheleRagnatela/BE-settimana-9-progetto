package it.films.dao;

import java.util.List;

import it.films.entity.Film;

public interface IFilmDao {

	public void memorizza(Film f);
	public List<Film> ricercaByRegista(String regista);
	public List<Film> trovaFilms();
}
