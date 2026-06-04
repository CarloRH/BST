package umg.edu.progra.arboles;

/**
 * Clase principal que demuestra el uso del Arbol Binario de Busqueda (BST)
 * implementado manualmente, sin usar librerias como java.util.
 *
 * Ejecucion sugerida:
 *   mvn compile
 *   java -cp target/classes umg.edu.progra.arboles.Principal
 *
 * Para el Ejercicio Extra E4 con argumentos de linea de comandos:
 *   java -cp target/classes umg.edu.progra.arboles.Principal 15 9 25 4 12 20 30
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {

        // ========================================================
        // DEMO BASE: arbol del enunciado
        // ========================================================
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        /*
         *               50
         *              /  \
         *            30    70
         *           /  \   / \
         *          20  40 60  80
         *         /
         *        10
         */
        int[] valores = { 50, 30, 70, 20, 40, 60, 80, 10 };
        for (int v : valores) {
            arbol.insertar(v);
        }

        System.out.println("===== Arbol Binario de Busqueda =====");
        System.out.println("Tamanio: " + arbol.tamanio());
        System.out.println("Altura:  " + arbol.altura());
        System.out.println("Minimo:  " + arbol.minimo());
        System.out.println("Maximo:  " + arbol.maximo());
        System.out.println("Hojas:   " + arbol.contarHojas());

        System.out.println("\n--- Representacion visual (rotada 90 grados) ---");
        arbol.imprimirArbol();

        System.out.println("\n--- Recorridos ---");
        System.out.print("InOrden    (ascendente): ");
        arbol.inOrden();

        System.out.print("PreOrden   (raiz primero): ");
        arbol.preOrden();

        System.out.print("PostOrden  (raiz al final): ");
        arbol.postOrden();

        System.out.print("Por niveles (BFS):         ");
        arbol.recorridoPorNiveles();

        System.out.println("\n--- Busquedas ---");
        System.out.println("Contiene 40? " + arbol.contiene(40));
        System.out.println("Contiene 99? " + arbol.contiene(99));

        System.out.println("\n--- Eliminacion ---");
        System.out.println("Eliminando 20 (nodo con 1 hijo)...");
        arbol.eliminar(20);
        System.out.print("InOrden tras eliminar 20: ");
        arbol.inOrden();

        System.out.println("Eliminando 30 (nodo con 2 hijos)...");
        arbol.eliminar(30);
        System.out.print("InOrden tras eliminar 30: ");
        arbol.inOrden();

        System.out.println("Eliminando 50 (raiz)...");
        arbol.eliminar(50);
        System.out.print("InOrden tras eliminar la raiz: ");
        arbol.inOrden();

        System.out.println("\n--- Estado final ---");
        arbol.imprimirArbol();
        System.out.println("Tamanio final: " + arbol.tamanio());
        System.out.println("Altura final:  " + arbol.altura());

        // ========================================================
        // PROBLEMA 1: contarNodos recursivamente
        // ========================================================
        System.out.println("\n========================================");
        System.out.println("PROBLEMA 1 — contarNodos recursivo");
        System.out.println("========================================");

        ArbolBinarioBusqueda arbol1 = new ArbolBinarioBusqueda();
        int[] v1 = { 50, 30, 70, 20, 40, 60, 80, 10 };
        for (int v : v1) arbol1.insertar(v);

        System.out.println("Arbol con 8 nodos:");
        System.out.println("  tamanio()    = " + arbol1.tamanio());
        System.out.println("  contarNodos()= " + arbol1.contarNodos());
        System.out.println("  Coinciden?   " + (arbol1.tamanio() == arbol1.contarNodos()));

        arbol1.insertar(5);
        arbol1.insertar(90);
        System.out.println("Tras insertar 5 y 90 (10 nodos):");
        System.out.println("  tamanio()    = " + arbol1.tamanio());
        System.out.println("  contarNodos()= " + arbol1.contarNodos());
        System.out.println("  Coinciden?   " + (arbol1.tamanio() == arbol1.contarNodos()));

        arbol1.eliminar(10);
        System.out.println("Tras eliminar 10 (9 nodos):");
        System.out.println("  tamanio()    = " + arbol1.tamanio());
        System.out.println("  contarNodos()= " + arbol1.contarNodos());
        System.out.println("  Coinciden?   " + (arbol1.tamanio() == arbol1.contarNodos()));

        ArbolBinarioBusqueda arbolVacio = new ArbolBinarioBusqueda();
        System.out.println("Arbol vacio:");
        System.out.println("  contarNodos()= " + arbolVacio.contarNodos());

        // ========================================================
        // PROBLEMA 2: esBalanceado
        // ========================================================
        System.out.println("\n========================================");
        System.out.println("PROBLEMA 2 — esBalanceado");
        System.out.println("========================================");

        // Arbol balanceado: 50,30,70,20,40,60,80
        ArbolBinarioBusqueda arbolBal = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80 }) arbolBal.insertar(v);
        System.out.println("Arbol balanceado (50,30,70,20,40,60,80):");
        arbolBal.imprimirArbol();
        System.out.println("esBalanceado()= " + arbolBal.esBalanceado()); // true

        // Arbol desbalanceado: insertar 1,2,3,4,5 en orden (degenerado hacia la derecha)
        ArbolBinarioBusqueda arbolDesBal = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 1, 2, 3, 4, 5 }) arbolDesBal.insertar(v);
        System.out.println("\nArbol desbalanceado (1,2,3,4,5 en orden):");
        arbolDesBal.imprimirArbol();
        System.out.println("esBalanceado()= " + arbolDesBal.esBalanceado()); // false

        System.out.println("\nArbol vacio:");
        System.out.println("esBalanceado()= " + arbolVacio.esBalanceado()); // true

        // ========================================================
        // PROBLEMA 3: esBSTValido
        // ========================================================
        System.out.println("\n========================================");
        System.out.println("PROBLEMA 3 — esBSTValido");
        System.out.println("========================================");

        ArbolBinarioBusqueda arbol3 = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) arbol3.insertar(v);
        System.out.println("BST construido correctamente (50,30,70,20,40,60,80,10):");
        System.out.println("esBSTValido()= " + arbol3.esBSTValido()); // true

        // Arbol "roto": construir estructura invalida modificando nodos directamente
        // Raiz=50, izquierdo=Nodo(75) <- viola BST (75 > 50 pero esta a la izquierda)
        Nodo raizRota = new Nodo(50,
            new Nodo(75,  // INVALIDO: 75 > 50, no puede ir a la izquierda
                new Nodo(20), new Nodo(80)),
            new Nodo(70,
                new Nodo(60), new Nodo(90)));
        ArbolBinarioBusqueda arbolRoto = new ArbolBinarioBusqueda();
        // Accedemos directamente al campo raiz via getRaiz() y refactorizamos
        // con un constructor auxiliar (usamos el paquete):
        ArbolBinarioBusqueda arbolRoto2 = crearArbolConRaiz(raizRota);
        System.out.println("\nArbol 'roto' (nodo 75 a la izquierda de 50):");
        arbolRoto2.imprimirArbol();
        System.out.println("esBSTValido()= " + arbolRoto2.esBSTValido()); // false

        // ========================================================
        // PROBLEMA 4: ancestroComunMasBajo (LCA)
        // ========================================================
        System.out.println("\n========================================");
        System.out.println("PROBLEMA 4 — ancestroComunMasBajo (LCA)");
        System.out.println("========================================");

        ArbolBinarioBusqueda arbol4 = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) arbol4.insertar(v);
        System.out.println("Arbol de referencia:");
        arbol4.imprimirArbol();
        System.out.println("LCA(10, 40) = " + arbol4.ancestroComunMasBajo(10, 40) + "  (esperado: 30)");
        System.out.println("LCA(10, 80) = " + arbol4.ancestroComunMasBajo(10, 80) + "  (esperado: 50)");
        System.out.println("LCA(60, 80) = " + arbol4.ancestroComunMasBajo(60, 80) + "  (esperado: 70)");
        System.out.println("LCA(10, 20) = " + arbol4.ancestroComunMasBajo(10, 20) + "  (esperado: 20)");
        System.out.println("LCA(50, 80) = " + arbol4.ancestroComunMasBajo(50, 80) + "  (esperado: 50)");

        // Prueba con valor inexistente
        try {
            arbol4.ancestroComunMasBajo(10, 99);
        } catch (IllegalArgumentException e) {
            System.out.println("LCA(10, 99) -> Excepcion correcta: " + e.getMessage());
        }

        // ========================================================
        // PROBLEMA 5: invertir (espejo)
        // ========================================================
        System.out.println("\n========================================");
        System.out.println("PROBLEMA 5 — invertir (espejo)");
        System.out.println("========================================");

        ArbolBinarioBusqueda arbol5 = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) arbol5.insertar(v);

        System.out.println("ANTES de invertir:");
        arbol5.imprimirArbol();
        System.out.print("InOrden antes (ascendente): ");
        arbol5.inOrden();

        arbol5.invertir();
        System.out.println("\nDESPUES de invertir (espejo):");
        arbol5.imprimirArbol();
        System.out.print("InOrden despues (descendente): ");
        arbol5.inOrden();

        // Verificar que un solo nodo tambien funciona
        ArbolBinarioBusqueda arbolUno = new ArbolBinarioBusqueda();
        arbolUno.insertar(42);
        arbolUno.invertir();
        System.out.print("Arbol de un nodo (42) invertido, inOrden: ");
        arbolUno.inOrden(); // sigue siendo 42

        // ========================================================
        // EJERCICIO EXTRA E1: kEsimoMenor
        // ========================================================
        System.out.println("\n========================================");
        System.out.println("EXTRA E1 — kEsimoMenor");
        System.out.println("========================================");

        ArbolBinarioBusqueda arbolE1 = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) arbolE1.insertar(v);
        System.out.print("InOrden: ");
        arbolE1.inOrden(); // 10 20 30 40 50 60 70 80
        System.out.println("1er menor: " + arbolE1.kEsimoMenor(1) + "  (esperado: 10)");
        System.out.println("3er menor: " + arbolE1.kEsimoMenor(3) + "  (esperado: 30)");
        System.out.println("5to menor: " + arbolE1.kEsimoMenor(5) + "  (esperado: 50)");
        System.out.println("8vo menor: " + arbolE1.kEsimoMenor(8) + "  (esperado: 80)");

        try {
            arbolE1.kEsimoMenor(0);
        } catch (IllegalArgumentException e) {
            System.out.println("kEsimoMenor(0) -> Excepcion correcta: " + e.getMessage());
        }
        try {
            arbolE1.kEsimoMenor(9);
        } catch (IllegalArgumentException e) {
            System.out.println("kEsimoMenor(9) -> Excepcion correcta: " + e.getMessage());
        }

        // ========================================================
        // EJERCICIO EXTRA E2: imprimirRangoOrdenado
        // ========================================================
        System.out.println("\n========================================");
        System.out.println("EXTRA E2 — imprimirRangoOrdenado");
        System.out.println("========================================");

        ArbolBinarioBusqueda arbolE2 = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) arbolE2.insertar(v);
        System.out.print("Rango [20, 60]: ");
        arbolE2.imprimirRangoOrdenado(20, 60);  // 20 30 40 50 60
        System.out.print("Rango [1, 25]:  ");
        arbolE2.imprimirRangoOrdenado(1, 25);   // 10 20
        System.out.print("Rango [70, 80]: ");
        arbolE2.imprimirRangoOrdenado(70, 80);  // 70 80
        System.out.print("Rango [0, 100]: ");
        arbolE2.imprimirRangoOrdenado(0, 100);  // 10 20 30 40 50 60 70 80

        // ========================================================
        // EJERCICIO EXTRA E3: diametro
        // ========================================================
        System.out.println("\n========================================");
        System.out.println("EXTRA E3 — diametro");
        System.out.println("========================================");

        ArbolBinarioBusqueda arbolE3 = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 50, 30, 70, 20, 40, 60, 80, 10 }) arbolE3.insertar(v);
        System.out.println("Arbol (50,30,70,20,40,60,80,10):");
        arbolE3.imprimirArbol();
        // Camino mas largo: 10->20->30->50->70->80 = 5 aristas
        System.out.println("Diametro = " + arbolE3.diametro() + "  (esperado: 5)");

        ArbolBinarioBusqueda arbolE3b = new ArbolBinarioBusqueda();
        for (int v : new int[]{ 1, 2, 3, 4, 5 }) arbolE3b.insertar(v);
        // Arbol degenerado: 1-2-3-4-5 = 4 aristas
        System.out.println("Arbol degenerado (1,2,3,4,5):");
        arbolE3b.imprimirArbol();
        System.out.println("Diametro = " + arbolE3b.diametro() + "  (esperado: 4)");

        ArbolBinarioBusqueda soloRaiz = new ArbolBinarioBusqueda();
        soloRaiz.insertar(1);
        System.out.println("Arbol de un solo nodo, Diametro = " + soloRaiz.diametro() + "  (esperado: 0)");

        // ========================================================
        // EJERCICIO EXTRA E4: desdeArreglo (construir desde args)
        // ========================================================
        System.out.println("\n========================================");
        System.out.println("EXTRA E4 — desdeArreglo / args");
        System.out.println("========================================");

        if (args.length > 0) {
            System.out.println("Argumentos recibidos desde la linea de comandos:");
            int[] argsInt = new int[args.length];
            boolean validos = true;
            for (int i = 0; i < args.length; i++) {
                try {
                    argsInt[i] = Integer.parseInt(args[i]);
                    System.out.print(argsInt[i] + " ");
                } catch (NumberFormatException e) {
                    System.out.println("\nError: '" + args[i] + "' no es un entero valido.");
                    validos = false;
                    break;
                }
            }
            if (validos) {
                System.out.println();
                ArbolBinarioBusqueda arbolArgs = ArbolBinarioBusqueda.desdeArreglo(argsInt);
                System.out.println("BST construido desde args:");
                arbolArgs.imprimirArbol();
                System.out.print("InOrden (ascendente): ");
                arbolArgs.inOrden();
                System.out.println("Tamanio:  " + arbolArgs.tamanio());
                System.out.println("Altura:   " + arbolArgs.altura());
                System.out.println("Minimo:   " + arbolArgs.minimo());
                System.out.println("Maximo:   " + arbolArgs.maximo());
                System.out.println("Balanceado: " + arbolArgs.esBalanceado());
                System.out.println("BST valido: " + arbolArgs.esBSTValido());
            }
        } else {
            // Sin argumentos: demo con arreglo fijo
            System.out.println("(Sin args de consola — demo con arreglo fijo: 15,9,25,4,12,20,30)");
            int[] arregloDemo = { 15, 9, 25, 4, 12, 20, 30 };
            ArbolBinarioBusqueda arbolDemo = ArbolBinarioBusqueda.desdeArreglo(arregloDemo);
            System.out.println("BST construido desde arreglo:");
            arbolDemo.imprimirArbol();
            System.out.print("InOrden (ascendente): ");
            arbolDemo.inOrden();
            System.out.println("Tamanio:    " + arbolDemo.tamanio());
            System.out.println("Altura:     " + arbolDemo.altura());
            System.out.println("Balanceado: " + arbolDemo.esBalanceado());
            System.out.println("BST valido: " + arbolDemo.esBSTValido());
            System.out.println("Diametro:   " + arbolDemo.diametro());
        }

        System.out.println("\n===== FIN DE LA DEMOSTRACION =====");
    }

    /**
     * Metodo auxiliar para crear un ArbolBinarioBusqueda con una raiz personalizada.
     * Se usa en el Problema 3 para demostrar esBSTValido() con un arbol "roto".
     * Usa setRaiz() (acceso de paquete) definido en ArbolBinarioBusqueda.
     */
    private static ArbolBinarioBusqueda crearArbolConRaiz(Nodo raiz) {
        ArbolBinarioBusqueda a = new ArbolBinarioBusqueda();
        a.setRaiz(raiz);
        return a;
    }
}