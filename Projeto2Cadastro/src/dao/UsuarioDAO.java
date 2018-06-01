/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import BD.*;
import dbo.*;
import core.MeuResultSet;
import java.sql.SQLException;

public class UsuarioDAO
{
    public boolean validaLogin(String email, String senha) throws Exception {
        boolean ret = false;
         try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM USUARIO " +
                  "WHERE EMAIL = ? AND SENHA = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, email);
            BD.COMANDO.setString(2, senha);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            ret = resultado.first(); // pode-se usar resultado.last() ou resultado.next() ou resultado.previous() ou resultado.absotule(numeroDaLinha)

           
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar usuario");
        }

        return ret;
        
    }
    
    
    public boolean cadastrado (String email) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM USUARIO " +
                  "WHERE EMAIL = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, email);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            retorno = resultado.first(); // pode-se usar resultado.last() ou resultado.next() ou resultado.previous() ou resultado.absotule(numeroDaLinha)

            /* // ou, se preferirmos,

            String sql;

            sql = "SELECT COUNT(*) AS QUANTOS " +
                  "FROM USUARIO " +
                  "WHERE EMAIL = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            resultado.first();

            retorno = resultado.getInt("QUANTOS") != 0;

            */
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar usuario");
        }

        return retorno;
    }

    public void incluir (Usuario usuario) throws Exception
    {
        if (usuario==null)
            throw new Exception ("Usuario nao fornecido");

        try
        {
            String sql;

            sql = "INSERT INTO USUARIO " +
                  "(ID,EMAIL,NOME,SENHA) " +
                  "VALUES " +
                  "(?,?,?,?)";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setInt    (1, usuario.getID ());
            BD.COMANDO.setString    (2, usuario.getEmail ());
            BD.COMANDO.setString (3, usuario.getNome ());
            BD.COMANDO.setString  (4, usuario.getSenha ());

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir usuario");
        }
    }

    public void excluir (String email) throws Exception
    {
        if (!cadastrado (email))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM USUARIO " +
                  "WHERE EMAIL=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, email);

            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir usuario");
        }
    }

    public void alterar (Usuario usuario) throws Exception
    {
        if (usuario==null)
            throw new Exception ("Usuario nao fornecido");

        if (!cadastrado (usuario.getEmail()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE USUARIO " +
                  "SET NOME=? " +
                  ", SENHA=? "+
                  "WHERE EMAIL=?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString  (1, usuario.getNome ());
            BD.COMANDO.setString    (2, usuario.getSenha ());
            BD.COMANDO.setString    (3, usuario.getEmail ());


            BD.COMANDO.executeUpdate ();
            BD.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados do usuario");
        }
    }

        public Usuario getUsuario (String email) throws Exception
    {
        Usuario usuario = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM USUARIO " +
                  "WHERE EMAIL = ?";

            BD.COMANDO.prepareStatement (sql);

            BD.COMANDO.setString (1, email);

            MeuResultSet resultado = (MeuResultSet)BD.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            usuario = new Usuario (resultado.getInt   ("ID"),
                                resultado.getString   ("EMAIL"),
                               resultado.getString("NOME"),
                               resultado.getString ("SENHA"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar usuario");
        }

        return usuario;
    }

    public MeuResultSet getUsuarios () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM USUARIO";

            BD.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BD.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar usuarios");
        }

        return resultado;
    }
}