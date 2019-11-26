package maze;

import java.util.LinkedList;
import java.util.Queue;

public class Maze3D {
    private int[][][] maze;


    public class Coordenadas{
        int fila;
        int col;
        int plano;
        int data;

        public Coordenadas(int i,int c,int j){
            fila = i;
            col = c;
            plano = j;
            data = 0;
        }
        public int getFila(){
            return fila;
        }
        public int getCol(){
            return col;
        }
        public int getPlano(){
            return plano;
        }

    }

    public Maze3D(){

        maze = new int[3][3][3];
        for (int i = 0; i<maze.length;i ++){
            for (int a = 0; a<maze[0].length;a++){
                for (int j = 0; j<maze[0][0].length;j++){
                    int numBloques = (int)(Math.random()*3)-1;
                    if(numBloques<0) maze[i][a][j] = 1;
                    else  maze[i][a][j] = numBloques;
                }
            }
        }

    }

    public void recorrdoMazeEnAnchura(Coordenadas fin){

        boolean[][][] recorridos = new boolean[5][maze.length][maze[0].length];      //Se inicializan a false;
        Queue<Coordenadas> porExaminar = new LinkedList<Coordenadas>();
        porExaminar.add(new Coordenadas(0,0,0));
        boolean end = false;

        while(!porExaminar.isEmpty() & !end){
            Coordenadas cor = porExaminar.poll();
            int f = cor.getFila();
            int c = cor.getCol();
            int j = cor.getPlano();

            if(f == maze[0].length-1 & c == maze[0][0].length-1 & j == maze.length-1) end = true;

            else if(!recorridos[j][f][c]){
                procesarQueue(j,f-1,c,porExaminar,recorridos);
                procesarQueue(j,f,c+1,porExaminar,recorridos);
                procesarQueue(j,f+1,c,porExaminar,recorridos);
                procesarQueue(j,f,c-1,porExaminar,recorridos);
                procesarQueue(j+1,f,c,porExaminar,recorridos);
                procesarQueue(j-1,f,c,porExaminar,recorridos);

                recorridos[j][f][c] = true;
            }

        }
        System.out.println(end);
        System.out.println(maze[2][2][2]);
    }
    private void procesarQueue(int j, int f, int c, Queue<Coordenadas> porExaminar,boolean[][][] recorridos){
        if(posicionValida(j,f,c) ){
            if(maze[j][f][c] == 1) {
                porExaminar.add(new Coordenadas(j,f,c));
            }
        }

    }
    private boolean posicionValida(int j,int i, int a){
        if((i< maze[0].length & i>=0) & (a<maze[0][0].length & a>=0) & (j<maze.length & j>=0)){
            return true;
        }
        else return false;
    }

    public void mazeTestFacil(){
        recorrdoMazeEnAnchura(new Coordenadas(2,2,2));
    }

    public static void main(String[] args) {new Maze3D().mazeTestFacil(); }
}

