class Ordenacao:
    
    @staticmethod
    def heapify_min(arr, n, i, comparacoes, trocas):
        smallest = i
        left = 2 * i + 1
        right = 2 * i + 2

        # Comparações com filhos
        if left < n:
            comparacoes[0] += 1
            if arr[left] < arr[smallest]:
                smallest = left
        if right < n:
            comparacoes[0] += 1
            if arr[right] < arr[smallest]:
                smallest = right

        # Troca se necessário
        if smallest != i:
            arr[i], arr[smallest] = arr[smallest], arr[i]
            trocas[0] += 1
            print(arr, f"- Troca raiz {arr[smallest]} com filho {arr[i]}")
            Ordenacao.heapify_min(arr, n, smallest, comparacoes, trocas)

    @staticmethod
    def heap_sort_min_inicio(arr):
        n = len(arr)
        comparacoes = [0]
        trocas = [0]

        print("Original:", arr, "\n")

        # Construir heap mínimo
        for i in range(n//2 - 1, -1, -1):
            Ordenacao.heapify_min(arr, n, i, comparacoes, trocas)
        print("Heap mínimo construído:", arr, "\n")

        # Extrair elementos do heap e colocar no início
        resultado = []
        for i in range(n):
            # menor é arr[0]
            resultado.append(arr[0])
            arr[0], arr[-1] = arr[-1], arr[0]  # move último para raiz
            arr.pop()  # remove o último (menor já extraído)
            if arr:
                Ordenacao.heapify_min(arr, len(arr), 0, comparacoes, trocas)
            print(resultado + arr, f"- Estado do vetor após extração {i+1}")

        print("\nHeap Sort finalizado (menor no início):", resultado)
        print("Comparações:", comparacoes[0], "Trocas:", trocas[0])
        return resultado, comparacoes[0], trocas[0]

    @staticmethod
    def verifica_heap(arr, tipo='max'):
        n = len(arr)
        if tipo == 'max':
            for i in range(n // 2):
                left = 2 * i + 1
                right = 2 * i + 2
                if left < n and arr[i] < arr[left]:
                    return False
                if right < n and arr[i] < arr[right]:
                    return False
            return True
        elif tipo == 'min':
            for i in range(n // 2):
                left = 2 * i + 1
                right = 2 * i + 2
                if left < n and arr[i] > arr[left]:
                    return False
                if right < n and arr[i] > arr[right]:
                    return False
            return True
        else:
            raise ValueError("Tipo deve ser 'max' ou 'min'")
        
# Vetor padrão
lista = [15, 7, 4, 8, 12, 1, 3]

# Executa heap sort com menor no início
ordenada, comp, troca = Ordenacao.heap_sort_min_inicio(lista)

print("Heap:  ", ordenada, " . Comparações:", comp, "Trocas:", troca)

print("Lista ordenada é heap máximo?", Ordenacao.verifica_heap( ordenada, tipo='max'))
print("Lista ordenada é heap mínimo?", Ordenacao.verifica_heap( ordenada, tipo='min'))

