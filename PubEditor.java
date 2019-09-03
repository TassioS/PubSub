package pubsubs;

import java.util.Scanner;
import static pubsubs.ServidorBroke.Futebol;



public class PubEditor extends ServidorBroke {
    
    public void Editar(int N){
     
       int i=0;
       int f=0, p=0,e=0,ed=0,o=0;
       while(i<N){
       System.out.println("Digite calssificaçao da Noticia Sobre: Futebol 0, Politica 1, economia 2  Educaçao 3");         
       Scanner no = new Scanner(System.in); 

       String nm= no.next();
       int classifica = Integer.parseInt(nm); // inteiro que classifica noticia

       Scanner nt = new Scanner(System.in); 

       System.out.println(" Escreva uma Noticia");

       String not= nt.next();

switch(classifica) {
  case 0:
    if(Futebol.length==f){
       System.out.println("Espaço de noticias Futebol completo");
       continue;
    }      
    Futebol[f] = not;
    f++;
    break;
    case 1:
      if(Politica.length==p){
       System.out.println("Espaço de noticias Politica completo");
       continue;
    }     
    Politica[p] = not;
    p++;
    break;
    case 2:
          if(Economia.length==e){
       System.out.println("Espaço de noticias Economia completo");
       continue;
    } 
    Economia[e] = not;
    e++;
    break;
    case 3:
          if(Educacao.length==ed){
       System.out.println("Espaço de noticias Economia completo");
       continue;
    } 
    Educacao[ed] = not;
    ed++;
    break;
  default:
        if(Outros.length==1){
       System.out.println("Espaço de noticias Outras completo");
       continue;
    } 
       Outros[o] = not;
      o++;
}      
       i++;
      
}
  
    }
        
}