package o.o.daos;

import java.util.List;

import o.o.entities.Comptes;

public interface ComptesDao {
		public List<Comptes> listComptes();
		public Comptes getComptes(String identifiant);
		public Comptes addComptes(Comptes compte);
		public Comptes deleteComptes(String identifiant);
		public Comptes ModifComptes(String identifiant);
	}

