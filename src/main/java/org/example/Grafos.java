package org.example;

import java.util.*;
/*
 * Guilherme Almeida Lopes a2458802
 * github: alguiguilo098
 * Data de criação:20/07/2024
 * Data de atualização: 20/07/2024
 * */
public class Grafos {
    int[][] matriz;
    int sizevertice;
    public Grafos(int vertices) {// criar um grafo vazio
        // inicializa o valor com menos 1 para numeros negativos
        matriz=new int[vertices][];
        for (int i = 0; i < vertices; i++) {
            matriz[i]= new int[vertices];
            Arrays.fill(matriz[i],-1);
        }
        sizevertice=vertices;
    }

    public int getSizevertice(){// retorna a quantidade de vertices de um grafo
        return  sizevertice;
    }
    public boolean insertedge(int beging, int end, int value){// inserir no em grafo
        try {
            matriz[beging][end]=value;
            return  true;
        }catch (ArrayIndexOutOfBoundsException e){
            return  false;
        }
    }

    private int[][] matrixdist(){ // cria a matriz de custos de grafo
        int [][]matrizcustos=new int[sizevertice][sizevertice];
        for (int i = 0; i <matrizcustos.length; i++) {
            for (int j = 0; j <matrizcustos[i].length ; j++) {
                if (i==j){// inicaliza com zero a diagonal principal
                    matrizcustos[i][j]=0;
                }else{// inicializa o valor das arestas na posicao
                    matrizcustos[i][j]=matrizcustos[i][j];
                }
            }
        }
        return matrizcustos;
    }
    private int[][] matrizpred(){// cria a matriz de pred
        int[][] matrizpred=new int[sizevertice][sizevertice];
        for (int i = 0; i <matrizpred.length; i++) {
            for (int j = 0; j <matrizpred[i].length ; j++) {
                if (i==j || matriz[i][j]==-1){// se vertice não existir inicializa o pred como inif
                    matrizpred[i][j]=Integer.MAX_VALUE;
                }else {// se a aresta existe então coloca o pred
                    matrizpred[i][j]=i;
                }
            }
        }
        return matrizpred;
    }
    private  int [] vectorpred(){// inicializa o vetor de pred -1
        int [] pred=new int[sizevertice];
        for (int i = 0; i < sizevertice; i++) {
            pred[i]=-1;
        }
        return  pred;
    }
    private int[] vetcordist(){// inicializa o vetor de disticia igual a inf
        int[] dist=new int[sizevertice];
        for(int i=0; i<sizevertice;i++){// inicializa todos os valores od grafo como inifinito
            dist[i]=Integer.MAX_VALUE;
        }
        return dist;
    }
    private boolean allpositiveedge(){// verifica se todos os vertices são positivos
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <matriz[i].length; j++) {
                if (matriz[i][j]<0){
                    return false;
                }
            }
        }
        return true;
    }
    void imprimirPredecessores(int[] vetor,int destino) {// imprima a o vetor de predecessores
        ArrayList<Integer> caminho = new ArrayList<>();

        // Reconstroi o caminho mínimo do destino até a origem
        for (int v = destino; v != -1; v = vetor[v]) {
            caminho.add(v);
        }

        // Inverte a lista para exibir o caminho da origem até o destino
        Collections.reverse(caminho);

        // Imprime o caminho no formato v1 -> v2 -> v3
        for (int i = 0; i < caminho.size(); i++) {
            System.out.print("v" + caminho.get(i));
            if (i < caminho.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
    public int[] bellmanford(int pos){
        int []pred=vectorpred(); // inicializa o vetor de predecessores
        int [] dist=vetcordist(); //
        dist[pos]=0;

        for (int k = 0; k < getSizevertice()-1; k++) {// percorre todas os vertices  do grafos
            for (int j = 0; j <getSizevertice(); j++) {
                for (int i = 0; i <getSizevertice(); i++) {
                    if (matriz[i][j]!=-1 &&  dist[i]!=Integer.MAX_VALUE &&dist[i]+matriz[i][j]<dist[j]) {
                        // caso exista uma distancia menor atualiza
                        dist[j]=matriz[i][j]+dist[i];
                        pred[j]=i;
                    }
                }
            }
        }

        for (int k = 0; k < getSizevertice() - 1; k++){
            // realiza novamente a busca para verificar se as distancias se alteraram
            // pois indicaria que existe um ciclo  negativo do grafo no grafo
            for (int i = 0; i < getSizevertice(); i++)
                for (int j = 0; j < getSizevertice(); j++)
                    if (matriz[i][j]!=-1 && dist[i] + matriz[i][j] < dist[j]) {
                        dist[j] = Integer.MIN_VALUE;
                        pred[j] = -1;
                    }
        }

        imprimirPredecessores(pred,pred.length-1);
        return pred;
    }
    public int[] dijisktra(int posvertice){
        int[] pred=vectorpred();// cria o vetor de predecessores
        int[] dist= vetcordist(); // cria um vetor de distância
        dist[posvertice]=0; // a distância do vertice para ele mesmo é 0
        Queue<Integer>queue=verticesQueue(posvertice); // cria uma fila com todos os vertices coloca o vertice inicial no começo

        while (!queue.isEmpty()){// caso a lista esteja vazia todos os vertices foi percorridos.
            int vertice=queue.remove();// remove o primeiro elemento da fila
            for (int i = 0; i < matriz[vertice].length; i++) {
                // percorre as arestas de um grafo
                if (matriz[vertice][i]!=-1 && dist[i]>dist[vertice]+matriz[vertice][i]){
                    // verifica se a aresta existe e compara com vetor de distância e atualiza
                    dist[i]=dist[vertice]+matriz[vertice][i];
                    pred[i]=vertice;
                }
            }
        }
        imprimirPredecessores(pred,pred.length-1);
        System.out.println();
        return  pred;
    }

    private Queue<Integer> verticesQueue(int vertice) {// cria uma fila
        // com todos os  vertices do grafo
        // vertice inicial é inserido primeiro
        Queue<Integer> queue=new LinkedList<>();
        queue.add(vertice);
        for (int i = 0; i <matriz.length; i++) {
            if (i!=vertice){
                queue.add(i);
            }
        }
        return queue;
    }

    public  int[][] floydwordshall(){
        int [][] pred=matrizpred(); // inicializa a  matriz de pred
        int [][] dist=matrixdist(); // inicializa a matriz de custo
        for (int k = 0; k < sizevertice; k++) {// vertice inicial
            for (int j = 0; j < sizevertice; j++) { // vertice final
                for (int i=0;i<sizevertice;i++){// vertice intermediario
                    if (dist[i][j]>dist[i][k]+dist[k][j]){// atualiza o novo caminho minimo
                        dist[i][j]=dist[i][k]+dist[k][j];
                        pred[i][j]=pred[k][j];
                    }
                }
            }
        }
        return  dist;
    }

    public void printgraf(){// imprimir de grafo
        for (int[] i :matriz) {
            for (int j: i){
                System.out.print(j +" ");
            }
            System.out.println();
        }
    }


}