package controller;

import model.EulerianMethods;


public class EulerianController {

    private final EulerianMethods model;

    public EulerianController(EulerianMethods model) {
        this.model = model;
    }

    public boolean addVertex(int vertex) {
        if(model.addVertex(vertex)){
            return true;
        }
        return false;
    }

    public boolean addEdge(int vertex1, int vertex2) {
        if(!model.addEdge(vertex1, vertex2)) {
            return false;
        }
        return true;
    }

    public boolean hasEulerianCircuit() {
        return model.hasEulerianCircuit();
    }

    public boolean hasEulerianPath() {
        return model.hasEulerianPath();
    }
}