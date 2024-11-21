package model;

import java.util.*;

public class EulerianMethods {
    private final Map<Integer, List<Integer>> adjacencyList;

    public EulerianMethods(){
        this.adjacencyList = new HashMap<>();
    }

    public boolean addVertex(int vertexKey){
        if(!adjacencyList.containsKey(vertexKey)) {
            adjacencyList.putIfAbsent(vertexKey, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(int vertexA, int vertexB){
        if(!adjacencyList.containsKey(vertexA)||!adjacencyList.containsKey(vertexB)){
            return false;
        }
        adjacencyList.get(vertexA).add(vertexB);
        adjacencyList.get(vertexB).add(vertexA);
        return true;
    }


    public boolean hasEulerianCircuit() {
        if (!isConnected()) return false;

        for (int vertex : adjacencyList.keySet()) {
            if (adjacencyList.get(vertex).size() % 2 != 0) {
                return false;
            }
        }
        return true;
    }


    private boolean isConnected() {
        Set<Integer> verticesWithEdges = new HashSet<>();
        for (int vertex : adjacencyList.keySet()) {
            if (!adjacencyList.get(vertex).isEmpty()) {
                verticesWithEdges.add(vertex);
            }
        }
        if (verticesWithEdges.isEmpty()) return true;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int startVertex = verticesWithEdges.iterator().next();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (!visited.contains(current)) {
                visited.add(current);
                for (int neighbor : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                    if (verticesWithEdges.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return visited.equals(verticesWithEdges);
    }


    public boolean hasEulerianPath() {
        if (!isConnected()) return false;

        int verticesWithOddNeighbor = 0;

        for (int vertex : adjacencyList.keySet()) {
            if (adjacencyList.get(vertex).size() % 2 != 0) {
                verticesWithOddNeighbor++;
            }
        }

        return verticesWithOddNeighbor == 2;
    }
}

