### Revisão de Algoritmos de Ordenação

---

## 1. O que é ordenação e por que é importante

**Ordenação:** organizar elementos de uma estrutura de dados em ordem crescente ou decrescente.

**Importância:**
- Facilita buscas (ex.: pesquisa binária).
- Melhora desempenho em consultas e relatórios.
- Torna visualização e interpretação mais intuitiva.

---

## 2. Categorias de algoritmos de ordenação

### a) Estabilidade
Algoritmo é estável se mantém a ordem relativa de elementos iguais.
- **Exemplo:** `[A(3), B(1), C(3)]` → A permanece antes de C.

**Estabilidade dos métodos estudados:**
| Algoritmo | Estável? |
|-----------|----------|
| Bolha     | Sim      |
| Inserção  | Sim      |
| Seleção   | Não      |
| Pente     | Sim      |
| Shell     | Não      |
| Agitação  | Sim      |

### b) Complexidade
- Mede o tempo ou número de operações realizadas.
- **Tempo:** comparações e trocas.
- **Espaço:** memória usada.

**Complexidade dos métodos estudados:**
| Algoritmo  | Melhor caso | Caso médio | Pior caso |
|------------|------------|------------|-----------|
| Bolha      | O(n)       | O(n²)      | O(n²)     |
| Inserção   | O(n)       | O(n²)      | O(n²)     |
| Seleção    | O(n²)      | O(n²)      | O(n²)     |
| Pente      | O(n)       | O(n log n) | O(n²)     |
| Shell      | O(n log n) | O(n^1.25)  | O(n²)     |
| Agitação   | O(n)       | O(n²)      | O(n²)     |

---

## 3. Melhor método de ordenação
- Pequenas listas: Inserção ou Bolha.
- Médias/grandes: Pente ou Shell.
- Muito grandes: QuickSort/MergeSort (não estudados).

---

## 4. Verificar se lista está ordenada (Python)
```python
//python
def esta_ordenada(lista):
    for i in range(len(lista) - 1):
        if lista[i] > lista[i+1]:
            return False
    return True

# Teste
lista = [10, 20, 30, 40]
print(esta_ordenada(lista))  # True
```

---

## 5. Contabilizar comparações e trocas
Sequência: `[30, 90, 10, 20, 80, 10, 20, 40, 10]`

- Bolha: 56 comparações, 22 trocas
- Pente: 35 comparações, 8 trocas
- Seleção: implementar para contar

```python
//python
def selecao_conta(vetor):
    n = len(vetor)
    comparacoes = 0
    trocas = 0
    for i in range(n-1):
        min_idx = i
        for j in range(i+1, n):
            comparacoes += 1
            if vetor[j] < vetor[min_idx]:
                min_idx = j
        if min_idx != i:
            vetor[i], vetor[min_idx] = vetor[min_idx], vetor[i]
            trocas += 1
    return comparacoes, trocas

# Teste
vetor = [30, 90, 10, 20, 80, 10, 20, 40, 10]
comp, troca = selecao_conta(vetor.copy())
print("Seleção - Comparações:", comp, "Trocas:", troca)
```

```java
//java
public class SelecaoContagem {
    public static void main(String[] args) {
        int[] vetor = {30, 90, 10, 20, 80, 10, 20, 40, 10};

        int[] resultado = selecaoContar(vetor.clone());
        System.out.println("Seleção - Comparações: " + resultado[0] + ", Trocas: " + resultado[1]);
    }

    public static int[] selecaoContar(int[] vetor) {
        int n = vetor.length;
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (vetor[j] < vetor[min_idx]) {
                    min_idx = j;
                }
            }
            if (min_idx != i) {
                int temp = vetor[i];
                vetor[i] = vetor[min_idx];
                vetor[min_idx] = temp;
                trocas++;
            }
        }

        return new int[]{comparacoes, trocas};
    }
}

```


---

## 6. Ordenar por segunda ou terceira chave
```python
//python
class Aluno:
    def __init__(self, codigo, curso, nome):
        self.codigo = codigo
        self.curso = curso
        self.nome = nome
    def __repr__(self):
        return f"{self.codigo}-{self.curso}-{self.nome}"

alunos = [
    Aluno(1, "Engenharia", "Alice"),
    Aluno(2, "Medicina", "Bob"),
    Aluno(3, "Engenharia", "Carlos"),
    Aluno(4, "Medicina", "Diana"),
]

# Ordena por curso e dentro do curso por nome
alunos.sort(key=lambda x: (x.curso, x.nome))
print(alunos)
```

```JAVA
//java
class Aluno {
    int codigo;
    String curso;
    String nome;

    public Aluno(int codigo, String curso, String nome) {
        this.codigo = codigo;
        this.curso = curso;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return codigo + "-" + curso + "-" + nome;
    }
}

public class OrdenacaoAlunos {
    // Método bolha por duas chaves: curso e nome
    public static void bubbleSort(Aluno[] alunos) {
        int n = alunos.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compara primeiro pelo curso
                if (alunos[j].curso.compareTo(alunos[j + 1].curso) > 0 ||
                    (alunos[j].curso.equals(alunos[j + 1].curso) &&
                     alunos[j].nome.compareTo(alunos[j + 1].nome) > 0)) {
                    // Troca
                    Aluno temp = alunos[j];
                    alunos[j] = alunos[j + 1];
                    alunos[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Aluno[] alunos = {
            new Aluno(1, "Engenharia", "Alice"),
            new Aluno(2, "Medicina", "Bob"),
            new Aluno(3, "Engenharia", "Carlos"),
            new Aluno(4, "Medicina", "Diana")
        };

        bubbleSort(alunos);

        // Imprime a lista ordenada
        for (Aluno a : alunos) {
            System.out.println(a);
        }
    }
}

```


