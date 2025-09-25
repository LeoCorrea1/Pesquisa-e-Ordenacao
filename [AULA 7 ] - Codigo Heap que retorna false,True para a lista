class Ordenacao:
    
    @staticmethod
    def heapify_max(arr, n, i, comparacoes, trocas):
        largest = i
        left = 2 * i + 1
        right = 2 * i + 2

        # Comparações com filhos
        if left < n:
            comparacoes[0] += 1
            if arr[left] > arr[largest]:
                largest = left
        if right < n:
            comparacoes[0] += 1
            if arr[right] > arr[largest]:
                largest = right

        # Troca se necessário
        if largest != i:
            arr[i], arr[largest] = arr[largest], arr[i]
            trocas[0] += 1
            print(arr, f"- Troca raiz {arr[largest]} com filho {arr[i]}")
            Ordenacao.heapify_max(arr, n, largest, comparacoes, trocas)

    @staticmethod
    def heap_sort_max(arr):
        n = len(arr)
        comparacoes = [0]
        trocas = [0]

        print("Original:", arr, "\n")

        # Construir heap máximo
        for i in range(n//2 - 1, -1, -1):
            Ordenacao.heapify_max(arr, n, i, comparacoes, trocas)
        print("Heap máximo construído:", arr, "\n")

        # Extrair elementos do heap
        for i in range(n-1, 0, -1):
            arr[0], arr[i] = arr[i], arr[0]  # move maior para o final
            trocas[0] += 1
            print(arr, f"- Troca raiz com último do heap (posição {i})")
            Ordenacao.heapify_max(arr, i, 0, comparacoes, trocas)

        print("\nHeap Sort finalizado :", arr)
        print("Comparações:", comparacoes[0], "Trocas:", trocas[0])
        return arr, comparacoes[0], trocas[0]
    
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

# Executa heap sort
ordenada, comp, troca = Ordenacao.heap_sort_max(lista)

print()
print("Heap:  ", ordenada, " . Comparações:", comp, "Trocas:", troca)

print("Lista ordenada é heap máximo?", Ordenacao.verifica_heap( ordenada, tipo='max'))
print("Lista ordenada é heap mínimo?", Ordenacao.verifica_heap( ordenada, tipo='min'))

