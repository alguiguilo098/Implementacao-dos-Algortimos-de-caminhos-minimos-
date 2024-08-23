import org.example.Grafos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BellmanFordTest {
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

    static Grafos grafos5verticesnegative(){
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

        return grafos;
    }

    @Test
    void bellmanfordpositive(){// testa se o caminho minimo de disjisktras
        // verifica se o resultado do bellman-ford é igual dijikstra para 0 e 1 como inicial
        Grafos grafos=grafos5verticesdijisktra();
        Assertions.assertArrayEquals(grafos.dijisktra(0),
                grafos.bellmanford(0));
        Assertions.assertArrayEquals(grafos.dijisktra(1),
                grafos.bellmanford(1));
        Assertions.assertArrayEquals(grafos.dijisktra(2),
                grafos.bellmanford(2));
    }

    @Test
    void detectioncyclenegative(){// testa caso exista ciclos negativcs
        // -1 não pode ser considerada uma aresta negativa
        // valor utilizado para determinar se uma aresta existe ou não
        Grafos grafos=grafos5verticesnegative();
        int[] pred={-1,-1,-1,-1,-1,-1};
        Assertions.assertArrayEquals(grafos.bellmanford(0),pred);
    }

}

