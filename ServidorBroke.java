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
import java.util.Scanner;
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
    //inicializarvetores com Não há nada


  public static void main(String[] args) {
 
        
     System.out.println(" Digite quantidade de noticias");
     Scanner Num = new Scanner(System.in); 
     String N= Num.next();
try{
int NM=Integer.parseInt(N);

PubEditor P= new  PubEditor();
     
     P.Editar(NM);
    
       
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
      
         Filtro F = new Filtro();
         F.Filtragem(v, saida);
        
        saida.close();
        cliente.close();
      }  
    }   
    catch(Exception e) {
       System.out.println("Erro: algum problema servidor " + e.getMessage());
    }
     

}catch(NumberFormatException e){
   System.out.println("Nao é numero");
   
}
}
}
     
     
     

