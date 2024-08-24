package org.implementacao;

public class FordFusken {
    static  Grafos grafos(){
        Grafos grafos=new Grafos(4);
        // ligação das arestas do vertice 0
        grafos.insertedge(0,1,3);
        grafos.insertedge(0,2,10);
        grafos.insertedge(0,3,5);

        // ligaçao das arestas com vertice 1
        grafos.insertedge(1,0,3);
        grafos.insertedge(1,2,8);
        grafos.insertedge(1,3,10);

        // ligaçao das arestas com vertice 2
        grafos.insertedge(2,0,10);
        grafos.insertedge(2,1,8);
        grafos.insertedge(2,3,2);

        // ligaçao das arestas com vertice 3
        grafos.insertedge(3,0,10);
        grafos.insertedge(3,1,8);
        grafos.insertedge(3,3,2);

        return grafos;
    }

    public static void main(String[] args) {
        Grafos grafos=grafos();
        grafos.floydwordshall();
    }
}
