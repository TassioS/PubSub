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
import javax.swing.JOptionPane;


/**
 *
 * @author ernani
 */
public class ServidorBroke {
    
    static String[] Futebol = new String[1];
    static String[] Politica = new String[1];
    static String[] Economia = new String[1];
    static String[] Educacao = new String[1];
    static String[] Outros = new String[2];


  public static void main(String[] args) {
 
        
    
     PubEditor P= new  PubEditor();
     
     P.Editar();
    
       
      try {  
      // Instancia o ServerSocket ouvindo a porta 12345
      ServerSocket servidor = new ServerSocket(12345);
      System.out.println("Servidor ouvindo a porta 12345");
      while(true) {
        // o método accept() bloqueia a execução até que
        // o servidor receba um pedido de conexão
        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

        ObjectInputStream a = new ObjectInputStream(cliente.getInputStream());
        Object ne= (Object) a.readObject();
        JOptionPane.showMessageDialog(null,"Numero:" + ne.toString());
        
        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
        int v=(int) ne;
        if(v==0){
             saida.writeObject(Futebol[0]);
        } 
        if(v==1){
             saida.writeObject(Politica[0]);
        }
          if(v==2){
             saida.writeObject(Economia[0]);
        } 
            if(v==3){
             saida.writeObject(Educacao[0]);
        } 
        saida.close();
        cliente.close();
      }  
    }   
    catch(Exception e) {
       System.out.println("Erro: " + e.getMessage());
    }
  }     
}
