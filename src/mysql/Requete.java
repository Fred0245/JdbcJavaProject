package mysql;

public class Requete {

	public static String ajouterEmployeRequete() {

		return "insert into employe (nom,email,salaire) values(?,?,?)";
	}

	public static String ListeAllEmployeRequete() {

		return "select * from employe";
	}

	public static String getEmployeByIdRequete(int id) {

		return "select * from employe where id = "+id;
	}
	
	public static String deleteEmployeByIdRequete(int id) {

		return "delete from employe where id = "+id;
	}
	
	public static String updateEmployeByIdRequete(int id) {

		return "update employe set nom=?,email=?,salaire=? where id = "+id;
	}
}
