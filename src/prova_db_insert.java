import java.sql.*;

public class prova_db_insert {

    //url che ounta la database mysql
    static final String url= "jdbc:mysql://localhost:3306/rubrica";

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

            // executeUpdate() è utilizzato per INSERT, UPDATE, DELETE statements.
            int result = stmt.executeUpdate("INSERT INTO anagrafica_clienti(ragione_sociale,indirizzo,cap) VALUES('Caputo','Via Santa Caterina, 45','70100')");

            // se il risultato della query è maggiore di 0 l'operazione è andata a buon fine
            if (result > 0)
                System.out.println("Record inserito correttamente");

            else
                System.out.println(
                        "Record non inserito. Verificare funzione");

            // closing connection
            conn.close();
        }

        catch (SQLException e) {
            System.out.println(e);
        }
    }
}




