package pubsubs;

import java.util.Scanner;
import static pubsubs.ServidorBroke.Futebol;



public class PubEditor extends ServidorBroke {
    
    
    public void Editar(){
        
       int i=0;
       while(i<4){
       System.out.println("Digite calssificaçao da Noticia Sobre: Futebol 0, Politica 1, economia 2  Educaçao 3");         Scanner no = new Scanner(System.in); 

       String nm= no.next();
       int classifica = Integer.parseInt(nm); // Caso você queira tipo int, que é o usual.

       Scanner nt = new Scanner(System.in); 

       System.out.println(" Escreva uma Noticia");

       String not= nt.next();

int index=0;
switch(classifica) {
  case 0:
    Futebol[index] = not;
    break;
    case 1:
    Politica[index] = not;
    break;
    case 2:
    Economia[index] = not;
    break;
    case 3:
    Educacao[index] = not;
    break;
  default:
       Outros[index] = not;
}      
       i++;
      
}
  
    }
        
}