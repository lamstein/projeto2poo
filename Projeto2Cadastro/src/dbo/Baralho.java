/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbo;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;

/**
 *
 * @author Lucas
 */
public class Baralho {
    
    ArrayList<Carta> baralho;
    ArrayList<Carta> baralho2;
    private final int TAMANHO = 48;
    
    //CONSTRUTOR BARALHO()
    public Baralho(){
       
    }
    
    //METODO PARA CRIAR UM BARALHO (ARRAY TIPO CARTA) COM AS CARTAS E UM ARRAY2 DO TIPO CARTA VAZIO PARA FUTURO USO NO METODO EMBARALHAR()
    public void criarBaralho(){
        baralho = new ArrayList<>();
        baralho2 = new ArrayList<>();
        String naipe;
        String valor;
        for (int i = 1; i < 5; i++) {
            switch(i) {
                    case 1:
                        naipe = "paus";
                        break;
                    case 2:
                        naipe = "ouros";
                        break;
                    case 3:
                        naipe = "copas";
                        break;
                    case 4:
                        naipe = "espadas";
                        break;
                    default:
                        naipe = "";
                }
            for ( int j = 1; j < 13; j++ ) {
                switch(j) {
                    case 1:
                        valor = "A";
                        break;
                    case 10:
                        valor = "J";
                        break;
                    case 11:
                        valor = "Q";
                        break;
                    case 12:
                        valor = "K";
                        break;
                    default:
                        valor = j + "";
                }
                baralho.add( new Carta(naipe,valor) );
                baralho2.add( new Carta() );
            }
        }
    }
   
    //METODO VOID QUE EMBARALHA O BARALHO COM BASE EM UM ARRAY BARALHO ORDENADO UM VETOR COM NUMEROS SORTEADOS
    public void embaralhar(){
        int a;
        ArrayList<Integer> sorteados = new ArrayList();
        System.out.println("Array sorteados criado");
        this.criarBaralho();
        System.out.println("executando criarBaralho()");
        int pos=0;
        System.out.println("int pos = "+pos);
        while(pos<48){
            System.out.println("int pos = "+pos);
            a = getRandomInt(0,47);
            System.out.println("int a = "+a);
            while(sorteadoExiste(a,sorteados)){
                a = getRandomInt(0,47);
            }
            sorteados.add(pos, a);
            System.out.println("Add em sorteados valor a =  "+a+" posicao = "+pos);
            baralho2.set(pos,baralho.get(a));
            System.out.println("Add em baralho2 valor a =  "+a+" posicao = "+pos+"     *********  baralho.get(a) = "+baralho.get(a).getNaipe()+" "+baralho.get(a).getValor());
            pos++;
        }
    }
    
    public String tirarCarta(ArrayList baralho, int quantidadeCarta){
        int i=0;
        String retorno ="";
        while(!(i==quantidadeCarta)){
            if(retorno.isEmpty()){
            retorno = baralho.get(i).toString();
            baralho.remove(i);
            }else{
                retorno = retorno+","+baralho.get(i).toString();
                baralho.remove(i);
            }
            i++;
        }
        return retorno+",";
    }
    
    
    //METODO COM RETORNO BOOLEANO PARA CHECAR SE O NUMERO SORTEADO PELO METODO GETRANDOMINT() JA FOI SORTEADO E ADICIONADO NO BARALHO EMBARALHADO
    public boolean sorteadoExiste(int a, ArrayList sorteados){
        System.out.println("Ëxecutando metodo sorteadoExiste()");
        ListIterator<String> listIterator = sorteados.listIterator();
       if(sorteados.size()==0){
           System.out.println("Sorteado size = 0 Retornando false");
           return false;
       }
        for(int i =0;i<TAMANHO;i++){
            if(sorteados.contains(a)){
                System.out.println("Essa posicao ja foi sorteada Retornando true");
                return true;
            }
            if(listIterator.hasNext()){
                System.out.println("Nao existem mais elementos para serem checados Retornando false");
                return false;
            }
        }
        return false;
    }
    
    //METODO COM MATHRANDOM() RETORNO INTEGER COM UM NUMERO ALEATORIO NO INTERVALO RECEBIDO COMO PARAMETRO
    public int getRandomInt(int min, int max) {
        int a= (int) Math.floor(Math.random() * (max - min + 1)) + min;
        return a;
    }

    public ArrayList<Carta> getBaralho() {
        return baralho;
    }

    public void setBaralho(ArrayList<Carta> baralho) {
        this.baralho = baralho;
    }

    public ArrayList<Carta> getBaralho2() {
        return baralho2;
    }

    public void setBaralho2(ArrayList<Carta> baralho2) {
        this.baralho2 = baralho2;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.baralho);
        hash = 17 * hash + Objects.hashCode(this.baralho2);
        hash = 17 * hash + this.TAMANHO;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Baralho other = (Baralho) obj;
        if (this.TAMANHO != other.TAMANHO) {
            return false;
        }
        if (!Objects.equals(this.baralho, other.baralho)) {
            return false;
        }
        if (!Objects.equals(this.baralho2, other.baralho2)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Baralho{" + "baralho=" + baralho + ", baralho2=" + baralho2 + ", TAMANHO=" + TAMANHO + '}';
    }


}

