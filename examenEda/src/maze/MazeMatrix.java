package maze;

import java.util.LinkedList;
import java.util.Queue;

public class MazeMatrix {

    private Integer[][] maze;


    public class Coordenadas{
        int fila;
        int col;
        int data;

        public Coordenadas(int i,int c){
            fila = i;
            col = c;
            data = 0;
        }
        public int getFila(){
            return fila;
        }
        public int getCol(){
            return col;
        }

    }

    public MazeMatrix(){
        maze =  new Integer[10][10];

        for(int i = 0 ; i<maze.length;i++){
            for (int a = 0; a<maze[0].length;a++){
                maze[i][a] = 0;
            }
        }
    }

    public boolean recorrdoMazeEnAnchura(){
        boolean[][] recorridos = new boolean[maze.length][maze[0].length];      //Se inicializan a false;
        Queue<Coordenadas> porExaminar = new LinkedList<Coordenadas>();
        porExaminar.add(new Coordenadas(0,0));
        boolean salir = false;

        while(!porExaminar.isEmpty() & !salir){
            Coordenadas cor = porExaminar.poll();
            int f = cor.getFila();
            int c = cor.getCol();
            if(f == maze.length-1 & c== maze[0].length-1)salir = true;
            else if(!recorridos[f][c]){
                procesarQueue(f-1,c,porExaminar,recorridos);
                procesarQueue(f,c+1,porExaminar,recorridos);
                procesarQueue(f+1,c,porExaminar,recorridos);
                procesarQueue(f,c-1,porExaminar,recorridos);
                procesarQueue(f-1,c,porExaminar,recorridos);
                recorridos[f][c] = true;
            }

        }
        return salir;
    }
    private void procesarQueue(int f, int c, Queue<Coordenadas> porExaminar,boolean[][]recorridos){
        if(posicionValida(f,c) ){
            if(maze[f][c] == 1) {
                porExaminar.add(new Coordenadas(f, c));
            }
        }

    }
    private boolean posicionValida(int i, int a){
        if((i<= 9 & i>=0) & (a<=9 & a>=0)){
            return true;
        }
        else return false;
    }

    public void MazeTestFacil(){

        for(int i = 0; i<10;i++)maze[0][i] = 1;
        for(int a = 1 ; a<10;a++)maze[a][9]=1;
        System.out.println(recorrdoMazeEnAnchura());

    }
    public static void main(String[] args) {new MazeMatrix().MazeTestFacil(); }
}