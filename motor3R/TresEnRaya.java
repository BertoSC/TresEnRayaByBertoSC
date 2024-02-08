package motor3R;
import java.util.Random;
public class TresEnRaya {
    private char[][] tablero;
    

    public TresEnRaya(){
        this.tablero= new char [][] {{'-','-','-'}, {'-','-','-'}, {'-','-','-'}};
        
    }


    public char[][] getTablero() {
        char [][] tablerocopia=tablero;
        return tablerocopia;
    }


    public void turnoP(int fila, int columna){
        //turno del jugador
        if (analizarPosJ(tablero, fila, columna)){
            tablero[fila-1][columna-1]='P';
        } else {
            return;
    
        }
        

    }   


   public void turnoC(){
      //turno de la máquina en modo fácil
       Random r= new Random(); 
       int filC= r.nextInt(3);
       int colC=r.nextInt(3);
            if (analizarPos(tablero, filC, colC)){
                tablero[filC][colC]='C';
            } else {
                turnoC();
        
            }
        
    }

   private boolean analizarPos(char[][] otro, int a, int b) {
    //comprueba que la posición permite poner ficha
        if (otro[a][b] == '-') {
            return true;
        } else {
            return false;
        }
    }

    private boolean analizarPosJ(char[][] otro, int a, int b) {
        //comprueba que la posición permite poner ficha
            if (otro[a-1][b-1] == '-') {
                return true;
            } else {
                return false;
            }
        }

   public boolean gameOver(char[][] mapita){
    // se verifica si el tablero está completo
    int contador=0;
        for (int i=0; i<mapita.length; i++){
            for (int j=0; j<mapita[i].length; j++){
                if (mapita[i][j]!='-'){
                    contador++;
                }       
            }
        }

        if (contador==9){
            return true;
        } else {
            return false;
        }
    }

    public boolean victoria(char ficha) {
        // comprobar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == ficha && tablero[i][1] == ficha && tablero[i][2] == ficha) {
                return true;
            }
        }

        // comprobar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == ficha && tablero[1][j] == ficha && tablero[2][j] == ficha) {
                return true;
            }
        }

        // combrobar diagonales
        if ((tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) ||
            (tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha)) {
            return true;
        }

        
        return false;
    }
    
   
}





    

    
