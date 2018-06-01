/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketMultiThread;

//Prefira implementar a interface Runnable do que extender a classe Thread, pois neste caso utilizaremos apena o método run.

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private Socket cliente;

    public Client(Socket cliente){
        this.cliente = cliente;
    }
}
    