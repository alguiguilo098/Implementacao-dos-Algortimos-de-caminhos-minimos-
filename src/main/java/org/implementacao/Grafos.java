package org.implementacao;

import java.util.*;
/*
 * Guilherme Almeida Lopes a2458802
 * github: alguiguilo098
 * Data de criação:20/07/2024
 * Data de atualização: 24/07/2024
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

    private int[][] matrixpred(){ // cria a matriz de custos de grafo
        int [][]matrizpred=new int[sizevertice][sizevertice];
        for (int i = 0; i <matrizpred.length; i++) {
            for (int j = 0; j <matrizpred[i].length ; j++) {
                if (i==j){// inicaliza com zero a diagonal principal
                    matrizpred[i][j]=Integer.MAX_VALUE;
                } else if (matriz[i][j]==-1) {
                    matrizpred[i][j]=Integer.MAX_VALUE;
                } else{// inicializa o valor das arestas na posicao
                    matrizpred[i][j]=i;
                }
            }
        }
        return matrizpred;
    }

    private int[][] matrizdist(){// cria a matriz de pred
        int[][] matrizdist=new int[sizevertice][sizevertice];
        for (int i = 0; i <matrizdist.length; i++) {
            for (int j = 0; j <matrizdist[i].length ; j++) {
                if (i==j){// se vertice não existir inicializa o pred como inif
                    matrizdist[i][j]=0;
                }else if (matriz[i][j]==-1){
                    matrizdist[i][j]=Integer.MAX_VALUE;
                }
                else {// se a aresta existe então coloca o pred
                    matrizdist[i][j]=matriz[i][j];
                }
            }
        }

        return matrizdist;
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
                if (matriz[i][j]<0 && matriz[i][j]!=-1){
                    return false;
                }
            }
        }
        return true;
    }
    private void imprimirPredecessores(int[] vetor,int destino) {// imprima a o vetor de predecessores
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
        int []pred=vectorpred(); // inicializa o vetor de predecessores com -1
        int [] dist=vetcordist(); // cria um vetir de distancias que é igual a inf
        dist[pos]=0; // inicializa em zero a posicao do vetor

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
        int[] prednegative_1={-1,-1,-1,-1,-1,-1};
        if(!Arrays.equals(pred,prednegative_1)){
            imprimirPredecessores(pred,pred.length-1);
        }else{
            System.out.println("Erro apresenta ciclo negativo este grafo");
        }

        return pred;
    }
    public int[] dijisktra(int posvertice){
        int[] pred=vectorpred();// cria o vetor de predecessores
        int[] dist= vetcordist(); // cria um vetor de distância
        dist[posvertice]=0; // a distância do vertice para ele mesmo é 0
        Queue<Integer>queue=verticesQueue(posvertice); // cria uma fila com todos os vertices coloca o vertice inicial no começo
        if (!allpositiveedge()) {
            System.out.println(" Error: Apresenta arestas negativas");
            return  pred;
        }
        while (!queue.isEmpty()){// caso a lista esteja vazia todos os vertices foi percorridos.
            int vertice=queue.remove();// remove o primeiro elemento da fila
            for (int i = 0; i < matriz[vertice].length; i++) {
                // percorre as arestas de um grafo
                if (matriz[vertice][i]!=-1 &&dist[i]>dist[vertice]+matriz[vertice][i]){
                    // verifica se a aresta existe e compara com vetor de distância e atualiza
                    dist[i]=dist[vertice]+matriz[vertice][i];
                    pred[i]=vertice;
                }
            }
        }
        System.out.print(" ");
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

        int [][] pred=matrixpred(); // inicializa a  matriz de pred
        int [][] dist=matrizdist(); // inicializa a matriz de custo

        for (int k = 0; k < sizevertice; k++) {// vertice inicial
            for (int j = 0; j < sizevertice; j++) { // vertice final
                for (int i=0;i<sizevertice;i++){// vertice intermediario
                    if (dist[i][j]>dist[i][k]+dist[k][j] && dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE){// atualiza o novo caminho minimo
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