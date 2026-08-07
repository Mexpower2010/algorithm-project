import java.util.*;

// arquivo: aula_grafo.java
// Objetivo: exemplo didático em Java cobrindo representações e algoritmos básicos sobre grafos.
// Compile: javac aula_grafo.java
// Execute: java aula_grafo

// Classe utilitária para arestas ponderadas
class Edge implements Comparable<Edge> {
    int u, v;
    long w;
    Edge(int u, int v) { this(u, v, 1); }
    Edge(int u, int v, long w) { this.u = u; this.v = v; this.w = w; }
    
    @Override
    public int compareTo(Edge other) { 
        return Long.compare(this.w, other.w); 
    }
    
    @Override
    public String toString() { 
        return "(" + u + " -" + w + "-> " + v + ")"; 
    }
}

class Graph {
    final int n;
    List<List<Edge>> adj; // Lista de adjacência
    
    // Usamos infinito / 4 para evitar "overflow" (estouro do limite numérico) 
    // quando somarmos uma distância ao infinito: (INF + peso)
    static final long INF = Long.MAX_VALUE / 4;

    Graph(int n) {
        this.n = n;
        adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addDirectedEdge(int u, int v, long w) {
        adj.get(u).add(new Edge(u, v, w));
    }

    void addUndirectedEdge(int u, int v, long w) {
        adj.get(u).add(new Edge(u, v, w));
        adj.get(v).add(new Edge(v, u, w));
    }

    // ---------------------------------------------------------
    // ALGORITMOS DE BUSCA (BFS e DFS)
    // ---------------------------------------------------------

    // Busca em Largura (BFS) - Complexidade: O(V + E)
    Pair<int[], int[]> bfs(int src) {
        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dist, -1);
        Arrays.fill(parent, -1);
        
        Queue<Integer> q = new ArrayDeque<>();
        dist[src] = 0;
        q.add(src);
        
        while (!q.isEmpty()) {
            int u = q.poll();
            for (Edge e : adj.get(u)) {
                int v = e.v;
                if (dist[v] == -1) { // Se não foi visitado
                    dist[v] = dist[u] + 1;
                    parent[v] = u;
                    q.add(v);
                }
            }
        }
        return new Pair<>(dist, parent);
    }

    // Busca em Profundidade (DFS) Recursiva
    Pair<int[], int[]> dfsAll() {
        int[] tin = new int[n]; // Tempo de descoberta (Time IN)
        int[] tout = new int[n]; // Tempo de término (Time OUT)
        Arrays.fill(tin, -1);
        Arrays.fill(tout, -1);
        
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (tin[i] == -1) {
                // Passamos e atualizamos o 'time' para manter o controle correto entre componentes
                time = dfsVisit(i, tin, tout, time);
            }
        }
        return new Pair<>(tin, tout);
    }

    private int dfsVisit(int u, int[] tin, int[] tout, int time) {
        tin[u] = time++;
        for (Edge e : adj.get(u)) {
            int v = e.v;
            if (tin[v] == -1) {
                time = dfsVisit(v, tin, tout, time);
            }
        }
        tout[u] = time++;
        return time;
    }

    // Busca em Profundidade Iterativa (com Pilha)
    // Nota didática: Como a pilha é LIFO, os vizinhos serão visitados na ordem 
    // inversa em que aparecem na lista de adjacência.
    List<Integer> dfsIterative(int src) {
        boolean[] vis = new boolean[n];
        List<Integer> order = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        
        stack.push(src);
        
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (vis[u]) continue;
            
            vis[u] = true;
            order.add(u);
            
            for (Edge e : adj.get(u)) {
                if (!vis[e.v]) {
                    stack.push(e.v);
                }
            }
        }
        return order;
    }

    // ---------------------------------------------------------
    // CAMINHOS MÍNIMOS
    // ---------------------------------------------------------

    // Dijkstra - Caminho mínimo para grafos sem pesos negativos. Complexidade: O((V+E) log V)
    Pair<long[], int[]> dijkstra(int src) {
        long[] dist = new long[n];
        int[] parent = new int[n];
        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        
        PriorityQueue<NodeDist> pq = new PriorityQueue<>();
        dist[src] = 0;
        pq.add(new NodeDist(src, 0));
        
        while (!pq.isEmpty()) {
            NodeDist cur = pq.poll();
            int u = cur.node;
            long d = cur.distance;
            
            // Lazy deletion: se a distância extraída for maior que a registrada, ignore
            if (d > dist[u]) continue;
            
            for (Edge e : adj.get(u)) {
                int v = e.v;
                long nextDist = d + e.w;
                
                if (nextDist < dist[v]) {
                    dist[v] = nextDist;
                    parent[v] = u;
                    pq.add(new NodeDist(v, nextDist));
                }
            }
        }
        return new Pair<>(dist, parent);
    }

    // Bellman-Ford - Caminho mínimo que suporta pesos negativos.
    // Retorna null APENAS se detectar um ciclo negativo que seja ALCANÇÁVEL a partir de 'src'.
    Pair<long[], int[]> bellmanFord(int src) {
        long[] dist = new long[n];
        int[] parent = new int[n];
        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        
        dist[src] = 0L;
        List<Edge> edges = allEdges();
        
        // Relaxamento de todas as arestas V - 1 vezes
        for (int i = 0; i < n - 1; i++) {
            boolean changed = false;
            for (Edge e : edges) {
                if (dist[e.u] != INF && dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                    parent[e.v] = e.u;
                    changed = true;
                }
            }
            if (!changed) break; // Otimização: se nada mudou, podemos parar cedo
        }
        
        // Checagem extra de ciclo negativo (se ainda puder relaxar no V-ésimo passo, há ciclo)
        for (Edge e : edges) {
            if (dist[e.u] != INF && dist[e.u] + e.w < dist[e.v]) {
                return null; 
            }
        }
        return new Pair<>(dist, parent);
    }

    // ---------------------------------------------------------
    // ÁRVORE GERADORA MÍNIMA (MST) - Apenas para grafos Não Direcionados
    // ---------------------------------------------------------

    // Kruskal - Retorna a MST (ou Floresta Geradora Mínima se o grafo for desconexo)
    Pair<List<Edge>, Long> kruskal() {
        List<Edge> edges = allEdges();
        Collections.sort(edges); 
        
        UnionFind uf = new UnionFind(n);
        List<Edge> mst = new ArrayList<>();
        long totalWeight = 0;
        
        for (Edge e : edges) {
            if (uf.union(e.u, e.v)) {
                mst.add(e);
                totalWeight += e.w;
            }
        }
        return new Pair<>(mst, totalWeight);
    }

    // Prim - Retorna a MST do COMPONENTE CONEXO que contém 'src'.
    Pair<List<Edge>, Long> prim(int src) {
        boolean[] inMST = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x.w));
        List<Edge> mst = new ArrayList<>();
        
        inMST[src] = true;
        pq.addAll(adj.get(src));
        
        long totalWeight = 0;
        
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int v = e.v;
            
            if (inMST[v]) continue;
            
            inMST[v] = true;
            mst.add(e);
            totalWeight += e.w;
            
            for (Edge ne : adj.get(v)) {
                if (!inMST[ne.v]) {
                    pq.add(ne);
                }
            }
        }
        return new Pair<>(mst, totalWeight);
    }

    // ---------------------------------------------------------
    // UTILITÁRIOS E CHECAGENS
    // ---------------------------------------------------------

    List<Edge> allEdges() {
        List<Edge> edges = new ArrayList<>();
        for (List<Edge> lst : adj) edges.addAll(lst);
        return edges;
    }

    // Ordenação Topológica (Kahn). Retorna null se não for um DAG (Grafo Acíclico Direcionado)
    List<Integer> topologicalSort() {
        int[] indegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (Edge e : adj.get(u)) indegree[e.v]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);
            for (Edge e : adj.get(u)) {
                indegree[e.v]--;
                if (indegree[e.v] == 0) q.add(e.v);
            }
        }
        return order.size() == n ? order : null;
    }

    // Componentes conexos (para grafos não direcionados)
    List<List<Integer>> connectedComponents() {
        boolean[] vis = new boolean[n];
        List<List<Integer>> comps = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                List<Integer> comp = new ArrayList<>();
                Deque<Integer> stack = new ArrayDeque<>();
                stack.push(i); 
                vis[i] = true;
                
                while (!stack.isEmpty()) {
                    int u = stack.pop();
                    comp.add(u);
                    for (Edge e : adj.get(u)) {
                        int v = e.v;
                        if (!vis[v]) { 
                            vis[v] = true; 
                            stack.push(v); 
                        }
                    }
                }
                comps.add(comp);
            }
        }
        return comps;
    }

    // Verifica se grafo é bipartido usando coloração (0 e 1)
    boolean isBipartite() {
        int[] color = new int[n]; 
        Arrays.fill(color, -1);
        
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i); 
                color[i] = 0;
                
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (Edge e : adj.get(u)) {
                        int v = e.v;
                        if (color[v] == -1) { 
                            color[v] = color[u] ^ 1; // Inverte a cor (0 vira 1, 1 vira 0)
                            q.add(v); 
                        }
                        else if (color[v] == color[u]) {
                            return false; // Dois vizinhos com a mesma cor
                        }
                    }
                }
            }
        }
        return true;
    }
}

// ---------------------------------------------------------
// ESTRUTURAS DE APOIO
// ---------------------------------------------------------

class Pair<A,B> {
    public final A first; 
    public final B second;
    Pair(A a, B b) { first = a; second = b; }
}

// Melhoria semântica: Substitui 'PairLongInt' para deixar o uso no Dijkstra mais claro.
class NodeDist implements Comparable<NodeDist> {
    int node;
    long distance;
    NodeDist(int node, long distance) { this.node = node; this.distance = distance; }
    
    @Override
    public int compareTo(NodeDist o) { 
        return Long.compare(this.distance, o.distance); 
    }
}

class UnionFind {
    int[] parent, rank;
    
    UnionFind(int n) { 
        parent = new int[n]; 
        rank = new int[n]; 
        for (int i = 0; i < n; i++) parent[i] = i; 
    }
    
    int find(int x) { 
        return parent[x] == x ? x : (parent[x] = find(parent[x])); // Path compression
    }
    
    boolean union(int a, int b) {
        int rootA = find(a); 
        int rootB = find(b);
        if (rootA == rootB) return false;
        
        // Union by rank
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootB] < rank[rootA]) {
            parent[rootB] = rootA;
        } else { 
            parent[rootB] = rootA; 
            rank[rootA]++; 
        }
        return true;
    }
}