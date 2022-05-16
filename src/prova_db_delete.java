import java.sql.*;

public class prova_db_delete {
    // url che punta al database mysql
    static final String url
            = "jdbc:mysql://localhost:3306/rubrica";

    public static void main(String[] args)
            throws ClassNotFoundException
    {
        try {

            // utilizziamo il driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");


            // stabiliamo una connessione
            Connection conn = DriverManager.getConnection(
                    url, "root", "");

            // creiamo lo statement incaricato di eseguire le operazioni sul database
            Statement stmt = conn.createStatement();

            // executeUpdate() è utilizzato per INSERT, UPDATE,DELETE statements.
            int result = stmt.executeUpdate("DELETE FROM anagrafica_clienti WHERE id_anagrafica=2");

            // se il risultato della query è maggiore di 0 l'operazione è andata a buon fine
            if (result > 0)
                System.out.println("Record eliminato correttamente");

            else
                System.out.println(
                        "Record non eliminato. Verificare funzione");

            // closing connection
            conn.close();
        }

        catch (SQLException e) {
            System.out.println(e);
        }
    }
}
