/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubsubs;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ernani
 */
public class ServidorTCPBasico {
  public static void main(String[] args) {
    try {
      // Instancia o ServerSocket ouvindo a porta 12345
      ServerSocket servidor = new ServerSocket(12345);
      System.out.println("Servidor ouvindo a porta 12345");
      while(true) {
        // o método accept() bloqueia a execução até que
        // o servidor receba um pedido de conexão
        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

        ObjectInputStream num = new ObjectInputStream(cliente.getInputStream());
        Object n= (Object) num.readObject();
        JOptionPane.showMessageDialog(null,"Numero:" + n.toString());
        
        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
        
        
        saida.flush();
        String er="ernani";                     
        saida.writeObject(er);
        saida.close();
        cliente.close();
      }  
    }   
    catch(Exception e) {
       System.out.println("Erro: " + e.getMessage());
    }
  }     
}
