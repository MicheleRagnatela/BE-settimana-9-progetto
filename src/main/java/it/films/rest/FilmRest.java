package it.films.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.films.dao.FilmDao;
import it.films.dto.FilmDto;
import it.films.entity.Film;

@RestController
@RequestMapping("/film")
@Api(value="FilmRest", tags="Gestione servizio rest")
public class FilmRest {

	FilmDao filmDao;
	
	
	public FilmDao getFilmDao() {
		if(filmDao == null) {
			filmDao = new FilmDao();
		}
		return filmDao;
	}


	@GetMapping
	@ApiOperation(
			value="Ricerca di tutti i film",
			produces="application/json",
			response=Film.class, responseContainer = "List"
			)
	public ResponseEntity<List<Film>> trovaFilms() {
		try {
			return new ResponseEntity<List<Film>>(getFilmDao().trovaFilms(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.METHOD_NOT_ALLOWED);

		}
	}
	
	@PostMapping
	@ApiOperation(
			value="Salvataggio film",
			consumes="application/json"
			)
	public ResponseEntity<String> memorizzaFilm(@RequestBody FilmDto fDto) {
		Film f = new Film();
		f.setAnno(fDto.getAnno());
		String incassoCriptato = BCrypt.hashpw(fDto.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato);
		f.setRegista(fDto.getRegista());
		f.setTitolo(fDto.getTitolo());
		f.setTipo(fDto.getTipo());
		
		try {
			getFilmDao().memorizza(f);
			return new ResponseEntity<String>("Inserimento avvenuto con successo!", HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>("Errore nell'inserimento!", HttpStatus.METHOD_NOT_ALLOWED);

		}
	}
	
	@GetMapping("/byregista")
	@ApiOperation(
			value="Ricerca film per regista",
			produces="application/json",
			response=Film.class
			)
	public ResponseEntity<List<Film>> ricercaByRegista(@RequestParam String regista) {
		try {
			return new ResponseEntity<List<Film>>(getFilmDao().ricercaByRegista(regista), HttpStatus.OK);		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.METHOD_NOT_ALLOWED);		

		}
	}
}
