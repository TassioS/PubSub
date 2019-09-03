package pubsubs;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;



public class Subscriber {
  public static void main(String[] args) {
    try {
      Socket cliente = new Socket("200.235.93.4",12345);
      
      int aux = 1;
      ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
      saida.flush();
      saida.writeObject(aux);
      
      ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
      Object tipo_menssagem = (Object) entrada.readObject();
      JOptionPane.showMessageDialog(null,"Data recebida do servidor:" + tipo_menssagem.toString());

      
      
              
      saida.close();
      entrada.close();
      System.out.println("Conexão encerrada");
    }
    catch(Exception e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }
}
