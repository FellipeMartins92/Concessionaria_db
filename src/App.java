import entities.Comandos_sql;

public class App {
    public static void main(String[] args) throws Exception {
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        Comandos_sql comandos = new Comandos_sql();

        comandos.ver_tudo_carros();

        

        

    }
}
