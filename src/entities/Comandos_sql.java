package entities;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Comandos_sql {

    public static Connection obterConexao(){

        final String url = "jdbc:mysql://localhost/concessionaria";
        final String user = "root";
        final String pass = "paopaopao";

        Connection con = null;

        try{

            con = DriverManager.getConnection(url, user, pass);

            return con;

        } catch(SQLException e){
            e.printStackTrace();
        } 

        return con;

    }

    public void Criar_db(){

            Connection con = Comandos_sql.obterConexao();

            String criar_db = "Create database if not exists concessionaria";

            PreparedStatement prep;

            try {

                prep = con.prepareStatement(criar_db);

                prep.execute();

                System.out.println("Criado com sucesso.");

            } catch (SQLException e) {

                e.printStackTrace();
            }

    }

    public void Criar_tabela_carros(){

        Connection con = Comandos_sql.obterConexao();

            String criar_tabela = "Create table if not exists carros(" +
            "id_carro int not null Primary key AUTO_INCREMENT, " +
            "modelo varchar(50) not null, " +
            "placa varchar(12) not null, "+
            "ano Date," +
            "cor int not null"+
            ")";

            PreparedStatement prep;

            try {

                prep = con.prepareStatement(criar_tabela);

                prep.execute();

                System.out.println("Criado com sucesso.");

            } catch (SQLException e) {

                e.printStackTrace();
            }


    }

    public void Criar_tabela_cores(){

        Connection con = Comandos_sql.obterConexao();

            String criar_tabela = "Create table if not exists cores( "+
            "corId int not null Primary key AUTO_INCREMENT, "+
            "cor varchar(20) not null) ";

            PreparedStatement prep;

            try {

                prep = con.prepareStatement(criar_tabela);

                prep.execute();

                System.out.println("Criado com sucesso.");

            } catch (SQLException e) {

                e.printStackTrace();
            }

    }

    public void Inserir_cor(String cor){

        Connection con = Comandos_sql.obterConexao();

        PreparedStatement prep;

        String inserir_cor = "insert into cores(cor) values( ? )";

            try {

                prep = con.prepareStatement(inserir_cor);

                prep.setString(1, cor);

                prep.execute();

                System.out.println("cor implementada com sucesso.");

            } catch (SQLException e) {

                e.printStackTrace();
            }
    }

    public void Inserir_carro(String modelo, String placa, String ano, int cor){

        Connection con = Comandos_sql.obterConexao();

        PreparedStatement prep;

        String inserir_cor = "insert into carros(modelo,placa,ano,cor) values( ? ,  ? ,  ? ,  ?)";

            try {

                prep = con.prepareStatement(inserir_cor);

                prep.setString(1, modelo);

                prep.setString(2, placa);

                prep.setString(3, ano);
                
                prep.setInt(4, cor);

                prep.execute();

                System.out.println("carro implementado com sucesso.");

            } catch (SQLException e) {

                e.printStackTrace();
            }

    }

    public void ver_tudo_carros() throws SQLException{

        Connection con = Comandos_sql.obterConexao();

        Statement prep = con.createStatement();

        String pegar_carros = "select * from carros";

        ResultSet result = prep.executeQuery(pegar_carros);


        while (result.next())
         {
            int id_carro = result.getInt("id_carro");
            String modelo = result.getString("modelo");
            String placa = result.getString("placa");
            Date ano = result.getDate("ano");
            int cor = result.getInt("cor");

            System.out.println(id_carro + " " + modelo + " " + placa + " " + ano + " " + cor);
            
        }

    }

    

}
