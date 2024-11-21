package view;

    import controller.EulerianController;

    import java.util.Scanner;

    public class EulerianView {

        private final EulerianController controller;
        private final Scanner scanner;


        public EulerianView(EulerianController controller) {
            this.controller = controller;
            this.scanner = new Scanner(System.in);
        }


        public void start() {
            int choice;
            do {
                printMenu();
                choice = getIntInput("Selecciona una opcion: ");
                handleChoice(choice);
            } while (choice != 4);
        }


        private void printMenu() {
            System.out.println("\n--- Herramienta Camino y circuito euleriano ---");
            System.out.println("1. Añadir un vertice");
            System.out.println("2. Añadir una arista");
            System.out.println("3. Verificar si el grafo actual tiene circuito euleriano");
            System.out.println("4. Verificar si el grafo actual tiene camino euleriano");
            System.out.println("5. Salir");
        }


        private void handleChoice(int choice) {
            switch (choice) {
                case 1 -> addVertex();
                case 2 -> addEdge();
                case 3 -> checkEulerianCircuit();
                case 4 -> checkEulerianPath();
                case 5 -> System.out.println("Saliendo...");
                default -> System.err.println("Opcion invalida, intente de de nuevo.");
            }
        }


        private void checkEulerianPath() {
            boolean hasPath = controller.hasEulerianPath();
            if (hasPath) {
                System.err.println("El grafo SI tiene camino euleriano.");
            } else {
                System.err.println("El grafo NO tiene camino euleriano.");
            }
        }


        private void addVertex() {
            int vertex = getIntInput("Digite el vertice a añadir (entero): ");
            if(controller.addVertex(vertex)) {
                System.err.println("Vertice " + vertex + " añadido.");
            }else{
                System.err.println("El vertice "+vertex+" ya existe.");
            }
        }


        private void addEdge() {
            int vertex1 = getIntInput("Digite el primer vertice: ");
            int vertex2 = getIntInput("Digite el segundo vertice: ");

            if (!controller.addEdge(vertex1, vertex2)) {
                System.err.println("Uno o dos vertices no existen");
            }else if(vertex1==vertex2){
                System.out.println("Los vertices deben ser diferentes");
            }else {
                System.err.println("Arista añadida entre  " + vertex1 + " y " + vertex2 + ".");
            }
        }


        private void checkEulerianCircuit() {
            boolean hasCircuit = controller.hasEulerianCircuit();
            if (hasCircuit) {
                System.err.println("El grafo SI tiene circuito euleriano.");
            } else {
                System.err.println("El grafo NO tiene circuito euleriano.");
            }
        }


        private int getIntInput(String prompt) {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.err.print("Entrada invalida digite un numero : ");
                scanner.next();
            }
            return scanner.nextInt();
        }
    }

