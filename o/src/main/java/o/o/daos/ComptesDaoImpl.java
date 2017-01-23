package o.o.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import o.o.entities.Comptes;

public class ComptesDaoImpl implements ComptesDao {
	
	
	public List<Comptes> listComptes() {
		String query = "SELECT * FROM connexion ORDER BY identifiant";
		List<Comptes> compte = new ArrayList<>(); 
		try (Connection connection =  DataSourceProvider.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while(resultSet.next()) {
						
						Comptes comptes = new Comptes(resultSet.getString("identifiant"), 
								resultSet.getString("motdepasse"));
						compte.add(comptes);
					}
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compte;
	}

	@Override
	public Comptes getComptes(String identifiant) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM connexion WHERE identifiant = ?")) {
				statement.setString(1, identifiant);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						
						return  new Comptes(resultSet.getString("identifiant"),resultSet.getString("motdepasse"));
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Comptes addComptes(Comptes compte) {
		// TODO Auto-generated method stub
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO connexion(identifiant,motdepasse) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, compte.getIdentifiant());
				statement.setString(2, compte.getMotdepasse());
				
				
				statement.executeUpdate();
				
				try (ResultSet resultSet = statement.getGeneratedKeys()) {
					if(resultSet.next()) {
						compte.setIdentifiant(resultSet.getString(1));
						return compte;
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
   public Comptes deleteComptes(String identifiant){
	   try(Connection connection = DataSourceProvider.getDataSource().getConnection()) {

		   String sqlQuery = "DELETE FROM connexion WHERE identifiant="+identifiant;

		   try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

		   statement.executeUpdate();

		   }
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return null;
   }

public Comptes ModifComptes(String identifiant) {
	// TODO Auto-generated method stub
	   try(Connection connection = DataSourceProvider.getDataSource().getConnection()) {

		   String sqlQuery = "UPDATE connexion SET motdepasse=? WHERE identifiant="+identifiant;

		   try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
			   

			   int rowsAffected    = statement.executeUpdate(sqlQuery);
			  

		   }
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return null;
   }

}
