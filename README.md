# BST en Java — Tarea completada

**Curso:** Programación 3  
**Tema:** Árboles Binarios de Búsqueda  
**Autor:** Carlo René Hermógenes Rivera Estrada

\---

## Cómo compilar y ejecutar

```bash
# Desde la carpeta arboles/
mvn compile
java -cp target/classes umg.edu.progra.arboles.Principal

# Ejercicio Extra E4: construir árbol desde argumentos de consola
java -cp target/classes umg.edu.progra.arboles.Principal 15 9 25 4 12 20 30
```

\---

## Métodos nuevos implementados

### Problema 1 — `contarNodos()`

Cuenta el total de nodos del árbol usando recursividad pura, **sin** usar el campo `tamanio`.

**Lógica:** caso base = nodo `null` → retorna 0. Caso recursivo = `1 + contarNodos(izq) + contarNodos(der)`.

```
Árbol: 50,30,70,20,40,60,80,10
tamanio()     = 8
contarNodos() = 8   ✓
```

\---

### Problema 2 — `esBalanceado()`

Indica si el árbol está balanceado en altura: para **cada** nodo la diferencia de alturas entre subárbol izquierdo y derecho es `<= 1`.

**Lógica:** se calcula la altura verificando el balance al mismo tiempo con un valor centinela `-2` para propagar el fallo sin recorrer nodos innecesarios.

```
Árbol (50,30,70,20,40,60,80):  esBalanceado() = true
Árbol (1,2,3,4,5) degenerado:  esBalanceado() = false
```

\---

### Problema 3 — `esBSTValido()`

Verifica que el árbol cumple la propiedad BST en **todos** sus nodos.

**Lógica:** se pasa un rango `(min, max)` permitido en cada llamada recursiva. El subarbol izquierdo debe tener valores en `(min, nodo.dato)` y el derecho en `(nodo.dato, max)`.

```
BST construido por inserciones:   esBSTValido() = true
Árbol con nodo 75 a izquierda de 50: esBSTValido() = false
```

\---

### Problema 4 — `ancestroComunMasBajo(int a, int b)`

Devuelve el Ancestro Común Más Bajo (LCA) de dos valores.

**Lógica:** aprovecha la propiedad BST — si ambos valores son menores que el nodo actual se va a la izquierda; si ambos son mayores se va a la derecha; en caso contrario el nodo actual es el LCA.

```
LCA(10, 40) = 30
LCA(10, 80) = 50
LCA(60, 80) = 70
```

Lanza `IllegalArgumentException` si alguno de los valores no existe.

\---

### Problema 5 — `invertir()`

Invierte el árbol intercambiando `izquierdo` y `derecho` en todos los nodos (espejo).

**Lógica:** recursivo — intercambiar hijos del nodo actual, luego invertir recursivamente ambos subárboles.

```
InOrden antes:   10 20 30 40 50 60 70 80  (ascendente)
InOrden después: 80 70 60 50 40 30 20 10  (descendente)
```

\---

### Extra E1 — `kEsimoMenor(int k)`

Devuelve el k-ésimo valor más pequeño. Usa recorrido InOrden con contador manual (arreglo de un elemento).

```
kEsimoMenor(1) = 10
kEsimoMenor(3) = 30
kEsimoMenor(5) = 50
```

\---

### Extra E2 — `imprimirRangoOrdenado(int min, int max)`

Imprime en orden ascendente todos los valores en `\\\[min, max]`, podando subárboles que no pueden contener valores en ese rango.

```
Rango \\\[20, 60]: 20 30 40 50 60
Rango \\\[1, 25]:  10 20
```

\---

### Extra E3 — `diametro()`

Retorna el camino más largo (en aristas) entre dos nodos cualesquiera. Para cada nodo calcula `altIzq + altDer + 2` y guarda el máximo.

```
Árbol (50,30,70,20,40,60,80,10): diametro = 5
Árbol degenerado (1,2,3,4,5):   diametro = 4
```

\---

### Extra E4 — `desdeArreglo(int\\\[] valores)`

Método estático que crea un BST a partir de un arreglo de enteros. Se usa en `Principal.main(String\\\[] args)` para construir el árbol desde argumentos de consola.

```bash
java -cp target/classes umg.edu.progra.arboles.Principal 15 9 25 4 12 20 30
# Construye BST con esos 7 valores y muestra todas las estadísticas
```

\---

## Reglas cumplidas

* ✅ Sin `java.util.\\\*`
* ✅ Sin librerías externas
* ✅ Toda la lógica en `ArbolBinarioBusqueda`
* ✅ Cada método probado desde `Principal`
* ✅ Estructura auxiliar (cola) implementada manualmente
* ✅ Recursividad cuando aplica

