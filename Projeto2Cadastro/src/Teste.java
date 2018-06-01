
import dao.*;
import dbo.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class Teste {
    
    
    public static void main (String []args) throws Exception{
        
        System.out.println(BD.BD.USUARIODAO.validaLogin("lucas@email.com","1234"));
        
        
    }
    
}
