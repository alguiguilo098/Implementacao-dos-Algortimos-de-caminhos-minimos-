package org.example;

import java.util.Arrays;

public class Main {
    static  Grafos grafos5verticesdfollward(){
        Grafos grafos=new Grafos(6);
        return  grafos;
    }
    static Grafos grafos5verticesdijisktra(){
        // grafo com 5 arestas
        // representação do grafo:
        Grafos grafos=new Grafos(6);

        // ligação da aresta do vertice 0
        grafos.insertedge(0,1,4);
        grafos.insertedge(0,2,2);

        //ligação das aresta  do vetices 1
        grafos.insertedge(1,0,4);
        grafos.insertedge(1,2,1);
        grafos.insertedge(1,3,5);

        // ligação da aresta do vertice 2
        grafos.insertedge(2,0,2);
        grafos.insertedge(2,1,1);
        grafos.insertedge(2,3,8);
        grafos.insertedge(2,4,10);

        // ligação do vertice 3
        grafos.insertedge(3,1,5);
        grafos.insertedge(3,2,8);
        grafos.insertedge(3,4,2);
        grafos.insertedge(3,5,6);

        // ligação do vertice 4
        grafos.insertedge(4,2,10);
        grafos.insertedge(4,3,2);
        grafos.insertedge(4,5,2);

        // ligação do vertice 5
        grafos.insertedge(5,3,6);
        grafos.insertedge(5,4,2);

        return  grafos;
    }
    static Grafos grafos5verticesbellmanford(){
        // grafo com 5 arestas
        // representação do grafo:
        Grafos grafos=new Grafos(6);

        // ligação da aresta do vertice 0
        grafos.insertedge(0,1,-4);
        grafos.insertedge(0,2,-2);

        //ligação das aresta  do vetices 1
        grafos.insertedge(1,0,4);
        grafos.insertedge(1,2,-3);
        grafos.insertedge(1,3,5);

        // ligação da aresta do vertice 2
        grafos.insertedge(2,0,2);
        grafos.insertedge(2,1,1);
        grafos.insertedge(2,3,8);
        grafos.insertedge(2,4,10);

        // ligação do vertice 3
        grafos.insertedge(3,1,5);
        grafos.insertedge(3,2,8);
        grafos.insertedge(3,4,2);
        grafos.insertedge(3,5,6);

        // ligação do vertice 4
        grafos.insertedge(4,2,10);
        grafos.insertedge(4,3,2);
        grafos.insertedge(4,5,2);

        // ligação do vertice 5
        grafos.insertedge(5,3,6);
        grafos.insertedge(5,4,2);

        return  grafos;
    }

    public static void main(String[] args) {

        Grafos grafos=grafos5verticesbellmanford();// cria o grafo para aplicar o algortimo de dijisktra
        System.out.println("Resultado do caminho minimo de dijisktra\n");

//        int [] pred=grafos.dijisktra(0);

        System.out.println(" Resultado do caminho minimo de bellmanford\n");
        int[] predbellmanford=grafos.bellmanford(0);


    }
}