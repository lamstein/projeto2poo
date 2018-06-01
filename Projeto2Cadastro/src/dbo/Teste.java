/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Lucas
 */
public class Teste {
    
    
     public static void main(String[] args) {
        // TODO code application logic here
        Baralho baralho = new Baralho();
        baralho.embaralhar();
        
         for(int i=0;i<baralho.baralho.size();i++){
           System.out.println(String.format("CARTA: %s de %s", baralho.baralho.get(i).getValor(), baralho.baralho.get(i).getNaipe()));
        }
        String ret=baralho.tirarCarta(baralho.baralho2, 3);
        
        System.out.println(ret);
        String[] textoSeparado = ret.split(",");
        System.out.println(Arrays.toString(textoSeparado));
       

        }
    
     
}
