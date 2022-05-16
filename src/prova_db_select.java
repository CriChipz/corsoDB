import java.sql.*;

public class prova_db_select {
    public static void main (String args[]) {
        try {
// Carichiamo un driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
// Creiamo la stringa di connessione
            String url = "jdbc:mysql://localhost:3306/rubrica2";
// Creiamo un oggetto Statement per poter interrogare il db
            try (// Otteniamo una connessione con username e password
                 Connection con = DriverManager.getConnection (url, "root", ""); // Creiamo un oggetto Statement per poter interrogare il db
                 Statement cmd = con.createStatement ()) {
                // Eseguiamo una query e immagazziniamone i risultati
                // in un oggetto ResultSet
                String qry = "SELECT anagrafica_clienti.id_anagrafica, anagrafica_clienti.ragione_sociale, vendite.data_di_vendita, vendita.prezzo_di_vendita FROM anagrafica_clienti" +
                        "INNER JOIN vendite ON vendite.id_anagrafica=anagrafica_clienti.id_anagrafica;";
// Stampiamone i risultati riga per riga
                try (ResultSet res = cmd.executeQuery(qry)) {
                    // Stampiamone i risultati riga per riga
                    while (res.next()) {
                        System.out.println(res.getString("id_anagrafica"));
                        System.out.println(res.getString("ragione_sociale"));
                        System.out.println(res.getDate("data_di_vendita"));
                        System.out.println(res.getInt("prezzo_di_vendita"));
                    }   }
            }
        } catch (SQLException | ClassNotFoundException e) {
        }
    }

}
