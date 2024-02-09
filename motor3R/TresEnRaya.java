package motor3R;
import java.util.Random;
   /** Juego clásico del Tres en Raya 
     Consiste en un jugador 'P' (que mueve primero) vs una CPU 'C'
      Incluye diversos métodos para comprobar el estado del  tablero y
      controlar la partida. 
     */
  
public class TresEnRaya {
    
    private char[][] tablero;
    
/** Constructor de la clase que inicializa el tablero */
    public TresEnRaya(){
        
        this.tablero= new char [][] {{'-','-','-'}, {'-','-','-'}, {'-','-','-'}};
        
    }

 /** getTablero: Devuelve una copia de un tablero a una clase externa que lo solicite */
    public char[][] getTablero() {
       
        char[][] tablerocopia = new char[3][3];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablerocopia[i][j] = tablero[i][j];
            }
        }
        return tablerocopia;
    }

/**  turnoP: Se encarga del turno del jugador*/
    public void turnoP(int fila, int columna){
        
        if (analizarPosJ(tablero, fila, columna)){
            tablero[fila-1][columna-1]='P';
        } else {
            return;
    
        }
        

    }   

/** turnoC: Se encarga del turno de la CPU (modo fácil) */
   public void turnoC(){
      
       Random r= new Random(); 
       int filC= r.nextInt(3);
       int colC=r.nextInt(3);
            if (analizarPos(tablero, filC, colC)){
                tablero[filC][colC]='C';
            } else {
                turnoC();
        
            }
        
    }
 /** analizarPos: Comprueba que la posición le permite poner ficha a la CPU */
   private boolean analizarPos(char[][] otro, int a, int b) {
   
        if (otro[a][b] == '-') {
            return true;
        } else {
            return false;
        }
    }
/** analizarPosJ: Comprueba que la posición del jugador permite poner ficha */
    private boolean analizarPosJ(char[][] otro, int a, int b) {
        
            if (otro[a-1][b-1] == '-') {
                return true;
            } else {
                return false;
            }
        }
    /** gameOver: Verifica si el tablero está completo y, por tanto, se acaba la partida */ 
   public boolean gameOver(char[][] mapita){

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
/** victoria: Comprueba si existe una victoria por filas, columnas o diagonales */
    public boolean victoria(char ficha) {
        
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == ficha && tablero[i][1] == ficha && tablero[i][2] == ficha) {
                return true;
            }
        }

        
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == ficha && tablero[1][j] == ficha && tablero[2][j] == ficha) {
                return true;
            }
        }

        
        if ((tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) ||
            (tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha)) {
            return true;
        }

        
        return false;
    }
    
   
}





    
