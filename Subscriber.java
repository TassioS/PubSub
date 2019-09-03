package pubsubs;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;



public class Subscriber {
  public static void main(String[] args) {
    try {
      Socket cliente = new Socket("192.168.0.107",12345);
      
      int aux = 1;
      ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
      saida.flush();
      saida.writeObject(aux);
      
      ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
      Object data_atual = (Object) entrada.readObject();
      JOptionPane.showMessageDialog(null,"Data recebida do servidor:" + data_atual.toString());

      
      
              
      saida.close();
      entrada.close();
      System.out.println("Conexão encerrada");
    }
    catch(Exception e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }
}
