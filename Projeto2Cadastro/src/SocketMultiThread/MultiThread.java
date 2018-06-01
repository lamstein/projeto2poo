/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketMultiThread;

import dbo.Usuario;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.err;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class MultiThread extends Thread{
    Socket cliente = null;
    
    public MultiThread(Socket cliente){
        this.cliente = cliente; 
    }
    
    public void run(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
            Solicitacao solicitacao;
            solicitacao = (Solicitacao) in.readObject();
            if(solicitacao.getComando().equals("LOG")){
               
                    if(BD.BD.USUARIODAO.validaLogin(solicitacao.getComplemento1(), solicitacao.getComplemento2())){
                        Solicitacao sol = new Solicitacao("SUC");
                        out.writeObject(sol);
                        System.out.println("COMANDO SOLICITACAO: "+sol.getComando().toString());
                    }else{
                       Solicitacao sol = new Solicitacao("ERR");
                        out.writeObject(sol); 
                        System.out.println("COMANDO SOLICITACAO: "+sol.getComando().toString());
                    }
                
            }else if(solicitacao.getComando().equals("CAD")){
                try{
                    Usuario user = new Usuario(solicitacao.getComplemento1(),solicitacao.getComplemento2(),solicitacao.getComplemento3());
                    BD.BD.USUARIODAO.incluir(user);
                    if(BD.BD.USUARIODAO.cadastrado(user.getEmail())){
                        Solicitacao sol = new Solicitacao("SUC");
                        out.writeObject(sol);
                        System.out.println("COMANDO SOLICITACAO: "+sol.getComando().toString());
                    }else{
                        Solicitacao sol = new Solicitacao("ERR");
                        out.writeObject(sol); 
                        System.out.println("COMANDO SOLICITACAO: "+sol.getComando().toString());
                    }
                       
                }catch(Exception err){
                    JOptionPane.showMessageDialog(null, err, "Warning",JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err, "Warning",JOptionPane.WARNING_MESSAGE);

        }
    } 
}
