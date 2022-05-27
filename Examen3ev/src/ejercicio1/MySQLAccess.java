package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
	
	/*
	 * Almacenamos la conexi�n con nuestra bd en 
	 * un objeto de tipo Connection. La abrimos cuando
	 * queremos empezar a operar con la BD y siempre
	 * debemos cerrarla al finalizar.
	 */
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	/*
	 * Almacena el resultado de las consultas en un dato de 
	 * tipo ResultSet, que tiene sus propios m�todos para trabajar
	 * con las tablas y columnas.
	 */
	private ResultSet resultSet = null;
	
	/*
	 * Almacenamos los datos de conexi�n con nuestra BD.
	 */
	final private String host = "localhost:3306/ex3ev";
	final private String user = "root";
	final private String passwd = "root";

	
	public void readDataBase() throws Exception {
		try {
			/*
			 * Cargamos el driver MySQL que hemos descargado anteriormente.
			 * Cada BD tiene su propio driver, este �nicamente es para 
			 * las BD MysSQL.
			 */
			Class.forName("com.mysql.jdbc.Driver");
   
			// Setup the connection with the DB
			/*
			 * Establecemos la conexi�n con nuestra BD utilizando
			 * los datos de conexi�n que ten�amos almacenados
			 * anteriormente.
			 */
			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?"
							+ "user=" + user + "&password=" + passwd );

		   /*
		    * Creamos statement para que la BD nos permita realizar
		    * consultas
		    */
		   statement = connect.createStatement();
		   /*
		    * Almacenamos en resultTest el resultado de ejecutar la consulta
		    * select.
		    */
		   resultSet = statement
		       .executeQuery("select * from registro");
		   /*
		    * Invocamos al m�todo escribir, que muestra por pantalla
		    * el resultado de la consulta anterior.
		    */
		   writeResultSet(resultSet);
		   /*
		    * Cuando queremos utilizar variables para realizar las consultas y 
		    * adem�s queremos hacerlas de forma m�s eficiente podemos usar
		    * preparedStatement.
		    */
		   preparedStatement = connect
		       .prepareStatement("insert into registro(id, letra, palabra, linea) values (?, ?, ?, ?)");
		   /*
		    * Cada uno de los "?" de la consulta indica que ah� se sit�a un par�metro que 
		    * todav�a no se ha a�adido. Para poder hacerlo, ejecutamos las consultas set con 
		    * la posici�n del parametro que estamos colocando y su valor. LAS POSICIONES
		    * EMPIEZAN DESDE 1!.
		    */
		   //preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
		   System.out.println("QUERY ---> insert into user(id, password, username)");
		   preparedStatement.executeUpdate();
		
		   preparedStatement = connect
				   .prepareStatement("SELECT * from user");
		   System.out.println("QUERY ---> select * from user");
		   resultSet = preparedStatement.executeQuery();
		   writeResultSet(resultSet);
		
		   // Remove again the insert comment
		   preparedStatement = connect
				   .prepareStatement("delete from user where username= ?");
		   preparedStatement.setString(1, "Juan Carlos");
		   preparedStatement.executeUpdate();		
		   System.out.println("QUERY ---> delete from user where");
		   writeResultSet(resultSet);
		   
		   preparedStatement = connect
				   .prepareStatement("SELECT * from user");
		   System.out.println("QUERY ---> select * from user");
		   resultSet = preparedStatement.executeQuery();
		   writeResultSet(resultSet);
		} catch (Exception e) {
			throw e;
		} finally {
		    close();
		}
	}

	/**
	 * Pre: ---
	 * Post: muestra por pantalla el nombre de la tabla sobre la que se ha ejecutado
	 * 		la consulta, seguido de todas sus columnas. 
	 */
	private void writeMetaData(ResultSet resultSet) throws SQLException {
		System.out.println("The columns in the table are: ");
		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
			System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
		}
	}
 
	/**
	 * Pre: ---
	 * Post: muestra por pantalla el contenido almacenado en [resultSet].
	 */
	private void writeResultSet(ResultSet resultSet) throws SQLException {
		/*
		 * Mientras resultSet contenga m�s usuarios, seguimos avanzando
		 * de manera similar a los ficheros de texto.
		 */
		while (resultSet.next()) {
			/*
			 * Podemos seleccionar la columna de la que queremos leer el dato
			 * poniendo su nombre, o tambi�n indicando su n�mero de columna...
			 * siempre empezando desde 1!
			 * 				EJ: resultSet.getSTring(2);
			 */
		   int id = resultSet.getInt(1);
		   String username = resultSet.getString(2);
		   String password = resultSet.getString(3);
		   System.out.println("\tID: " + id);
		   System.out.println("\tUsername: " + username);
		   System.out.println("\tPassword: " + password);
		}
	}

	/**
	 * Pre: ---
	 * Post: cerramos todas las conexiones abiertas, el resultSet
	 * 		y el statement. Si no se cierran correctamente, puede
	 * 		ocurrir que las consultas no devuelvan el resultado esperado.
	 * 		Adem�s, si dejamos muchas conexiones a la BD abiertas
	 * 		podemos llegar a saturarla y no aceptar� m�s conexiones. 
	 */
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			} if (statement != null) {
				statement.close();
			} if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {}
	}

}
