/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;


import core.*;
import dao.*;

public class BD
{
    public static final MeuPreparedStatement COMANDO;
    public static final UsuarioDAO USUARIODAO; //um como esse para cada classe DAO

    static
    {
    	MeuPreparedStatement comando = null;
     	UsuarioDAO               usuarioDAO  = null; //um como esse para cada classe DAO

    	try
        {
            comando =
            new MeuPreparedStatement (
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/mydb",
                "root", "1234");

            usuarioDAO = new UsuarioDAO (); //um como esse para cada classe DAO
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0); // aborta o programa
        }
        
        COMANDO = comando;
        USUARIODAO  = usuarioDAO; //um como esse para cada classe DAO
    }
}