package o.o.manager;

import java.util.List;

import o.o.daos.ComptesDao;
import o.o.daos.ComptesDaoImpl;
import o.o.entities.Comptes;


public class Library {
	
	private static class FilmLibraryHolder {
		private final static Library instance = new Library();
	}
	
	public static Library getInstance() {
		return FilmLibraryHolder.instance;
	}
	
	private ComptesDao comptesDao = new ComptesDaoImpl();



	private Library() {
	}

	public List<Film> listFilms() {
		return filmDao.listFilms();
	}

	public Film getFilm(Integer id) {
		return filmDao.getFilm(id);
	}

	public Film addFilm(Film film) {
		return filmDao.addFilm(film);
	}
	public Acteur getActeur(Integer id_acteur){
		return acteurDao.getActeur(id_acteur);
	}
	public List<Acteur> listActeurs(){
		return acteurDao.listActeur();
	}
	public Acteur addActeur(Acteur acteur){
		return acteurDao.addActeur(acteur);
	}
    public void deleteActeur(Integer id_acteur){
    	acteurDao.deleteActeur(id_acteur);
    }
    public void ModifComptes(Integer id_acteur){
    	acteurDao.ModifActeur(id_acteur);
    }

}


