import motor3R.TresEnRaya;
import java.util.Scanner;

public class InterfaceConsola {
    private TresEnRaya game;
    private char jugador;
    private char cpu;
    private char eleccion;
    private Scanner entrada;
   

    public InterfaceConsola() throws InterruptedException{
        entrada= new Scanner(System.in);
        this.jugador='P';
        this.cpu='C';
        instrucciones();
        this.game=new TresEnRaya();
        estructura();
               

        
    }

            

    void instrucciones(){
         System.out.println("\t\t\t\t-----------------------\t");
         System.out.println("\t\t\t\tTRES EN RAYA by BertoSC\t");
         System.out.println("\t\t\t\t-----------------------\t");
         System.out.println();
         System.out.println("¡Bienvenido, jugador!");
         System.out.println("Esta es una versión de mercadillo del clásico TRES EN RAYA");
         System.out.println();
         System.out.println("REGLAS:");
         System.out.println("1. Cada turno colocas una casilla con una coordenada fila-columna");
         System.out.println("2. Las filas y columnas están numeradas de 1 a 3");
         System.out.println("3. Jugarás contra una malévola IA destructora de mundos");
         System.out.println("4. Sus casillas se marcarán con una C y las tuyas con la P");
         System.out.println("5. Ganarás si logras hacer tres en raya en una fila, columna o diagonal antes que la CPU");
         System.out.println("6. ...bueno, en realidad eso era todo, ¿ARE TOU READY?");
         System.out.print("(¿(Y) or (N)?: ");
         eleccion = entrada.next().toUpperCase().charAt(0);
         if (eleccion=='Y') {
            System.out.println();
            System.out.println("\t\t\t\tLet's GO!\t");
            System.out.println();
            System.out.println("\t\t\t\tBATTLE\t");
            System.out.println("\t\t\t\tONE\t");
            System.out.println();
            System.out.println("\t\t\t\tDECIDE THE DESTINY\t");
            System.out.println();
         } else{
            System.exit(0);           
        } 
    }

    public void estructura() throws InterruptedException{
        game.gameOver(game.getTablero());
        while(game.gameOver(game.getTablero()) ==false || game.victoria(jugador) ==false || game.victoria(cpu)==false){
            System.out.println(); 
            imprimirTablero(game.getTablero()); 
            System.out.println();
            System.out.println("-TU TURNO-");
            System.out.print("Introduce la fila: ");
            int fila=entrada.nextInt();
            System.out.println();
            System.out.print("Introduce la columna: ");
            int columna=entrada.nextInt();
            game.turnoP(fila, columna); 
            if (game.victoria(jugador)) {
                System.out.println();
                System.out.println("YOU WIN");
                System.out.println();
                imprimirTablero(game.getTablero());
                return;
            }
            System.out.println(); 
            imprimirTablero(game.getTablero()); 
            System.out.println();
            System.out.println("-TURNO DE LA CPU-");
            Thread.sleep(4000);
            game.turnoC();
            if (game.victoria(cpu)) {
                System.out.println();
                System.out.println("YOU LOSE");
                System.out.println();
                imprimirTablero(game.getTablero());
                return; 
            }
            imprimirTablero(game.getTablero());
            game.gameOver(game.getTablero()); 

        } 
       
        
    }


    public void imprimirTablero(char[][] mapa){

        for (int i=0; i<mapa.length; i++){
            for (int j=0; j<mapa[i].length; j++){
                System.out.print(mapa[i][j]+" ");
            }       
            System.out.println(); 
        }
    }


    public static void main(String[] args) throws InterruptedException {
        
    new InterfaceConsola();
    

   

    }
}
