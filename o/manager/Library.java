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


	public Comptes getComptes(String nom){
		return comptesDao.getComptes(nom);
	}
	public List<Comptes> listComptes(){
		return comptesDao.listComptes();
	}
	public Comptes addComptes(Comptes compte){
		return comptesDao.addComptes(compte);
	}
    public void deleteComptes(String nom){
    	comptesDao.deleteComptes(nom);
    }
    public void ModifComptes(String nom){
    	comptesDao.ModifComptes(nom);
    }

}


