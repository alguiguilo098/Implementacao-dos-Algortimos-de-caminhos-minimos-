package org.implementacao;

public class FordFusken {
    static  Grafos grafos(){
        Grafos grafos=new Grafos(5);
        // ligação das arestas do vertice 0
        grafos.insertedge(0,1,3);
        grafos.insertedge(0,2,8);
        grafos.insertedge(0,4,-4);

        // ligação das arestas do  vertice 1
        grafos.insertedge(1,4,7);
        grafos.insertedge(1,3,1);

        // ligação da arestas do vertice 2
        grafos.insertedge(2,1,4);

        // ligação da arestas do vertice 3
        grafos.insertedge(3,2,-5);
        grafos.insertedge(3,0,2);

        //ligação da aresta do vertice 4
        grafos.insertedge(4,3,6);

        return grafos;
    }

    public static void main(String[] args) {
        Grafos grafos=grafos();
        int[][] dist=grafos.floydwordshall();

        for (int i[]:dist){
            for (int j:i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
