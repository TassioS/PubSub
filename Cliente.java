
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tassio
 */
public class Cliente {
  public static void main(String[] args) {
    try {
      Socket cliente = new Socket("200.235.87.6",12345);
      
      int aux = 9999;
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
