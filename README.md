# Implementação de Algoritmos de Caminhos Mínimos

Este repositório contém a implementação de algoritmos clássicos para a resolução de problemas de caminhos mínimos em grafos. Os algoritmos implementados incluem:

1. **Dijkstra**
2. **Bellman-Ford**
3. **Floyd-Warshall**

## Descrição dos Algoritmos

### 1. Dijkstra

O algoritmo de Dijkstra é utilizado para encontrar o caminho mínimo de um vértice de origem para todos os outros vértices em um grafo com pesos **não negativos**.

**Complexidade:**  
- O(V²) para implementação simples.  
- O(E + V log V) quando utilizando uma fila de prioridade (heap).

### 2. Bellman-Ford

O algoritmo de Bellman-Ford é capaz de lidar com grafos que possuem arestas com pesos **negativos**, mas não permite ciclos negativos.

**Complexidade:** O(V * E).

### 3. Floyd-Warshall

O algoritmo de Floyd-Warshall calcula os caminhos mínimos entre **todos os pares de vértices** em um grafo, podendo lidar com arestas de peso negativo (mas sem ciclos negativos).

**Complexidade:** O(V³).

### Como Executar
Executando o Arquivo Principal (Main.java)

Navegue até a pasta do projeto.

  Compile o arquivo Main.java e as classes necessárias:
    bash
    Copy

    javac Main.java Grafos.java

    Execute o arquivo Main.java:
    bash
    Copy

    java Main

    Isso executará o código de exemplo contido no arquivo Main.java, que demonstra o uso dos algoritmos implementados.

### Executando os Testes

1. Navegue até a pasta do projeto.
2. Compile os testes:

   ```bash
   javac -cp . test/*.java
   ```
   
3. Execute os testes usando o JUnit:

   ```bash
   java -cp .:junit-x.y.z.jar org.junit.runner.JUnitCore BellmanFordTest 
   ```

   Substitua `junit-x.y.z.jar` pelo caminho correto do arquivo JAR do JUnit.
