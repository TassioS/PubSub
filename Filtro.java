package pubsubs;

import java.io.IOException;
import java.io.ObjectOutputStream;





public class Filtro extends ServidorBroke {
    
    
    
    public void Filtragem(int v,  ObjectOutputStream saida) throws IOException{
        
        
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
    }
}