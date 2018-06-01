/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbo;

import java.util.Objects;

/**
 *
 * @author Lucas
 */
public class Jogador {
    
    Usuario usuario;
    Float carteira;
    String nickname;
    Boolean conectado;
    
    public Jogador(){}
    
    public Jogador(Usuario usuario, Float carteira, String nickname, Boolean conectado){
        this.usuario = usuario;
        this.carteira = carteira;
        this.nickname = nickname;
        this.conectado = conectado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Float getCarteira() {
        return carteira;
    }

    public void setCarteira(Float carteira) {
        this.carteira = carteira;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Boolean getConectado() {
        return conectado;
    }

    public void setConectado(Boolean conectado) {
        this.conectado = conectado;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.usuario);
        hash = 89 * hash + Objects.hashCode(this.carteira);
        hash = 89 * hash + Objects.hashCode(this.nickname);
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
        final Jogador other = (Jogador) obj;
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.carteira, other.carteira)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jogador{" + "usuario=" + usuario + ", carteira=" + carteira + ", nickname=" + nickname + '}';
    }
    
    
    
}
