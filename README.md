1. Dijkstra

O algoritmo de Dijkstra é utilizado para encontrar o caminho mínimo de um vértice de origem para todos os outros vértices em um grafo com pesos não negativos.
Complexidade: O(V²) ou O(E + V log V) com heap.

2. Bellman-Ford

O algoritmo de Bellman-Ford é capaz de lidar com grafos que possuem arestas com pesos negativos, mas não permite ciclos negativos.
Complexidade: O(V * E).

3. Floyd-Warshall

O algoritmo de Floyd-Warshall calcula os caminhos mínimos entre todos os pares de vértices em um grafo, podendo lidar com arestas de peso negativo (mas sem ciclos negativos).
Complexidade: O(V³).

