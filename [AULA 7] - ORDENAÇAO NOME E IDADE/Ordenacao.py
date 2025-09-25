class Pessoa:
    def __init__(self, nome, idade):
        self.nome = nome
        self.idade = idade
        
    def __repr__(self):
        return f"Nome: {self.nome}, Idade: {self.idade}"


# Lista corrigida
listaNI = [
    Pessoa("Ana", 23),
    Pessoa("João", 31),
    Pessoa("Maria", 19),
    Pessoa("Pedro", 25),
    Pessoa("Ana", 20),
    Pessoa("João", 21),
]

class Ordenacao:
    @staticmethod
    def bolha(listaNI):
        lista = listaNI.copy()
        houve_troca = True
        qtd_comparacoes = 0
        qtd_trocas = 0
        while houve_troca:
            houve_troca = False
            for i in range(len(lista) - 1):
                qtd_comparacoes += 1
                # compara primeiro pelo nome, depois pela idade
                if (lista[i].nome > lista[i + 1].nome) or \
                   (lista[i].nome == lista[i + 1].nome and lista[i].idade > lista[i + 1].idade):
                    qtd_trocas += 1
                    houve_troca = True
                    lista[i], lista[i + 1] = lista[i + 1], lista[i]
        return lista, qtd_comparacoes, qtd_trocas

    @staticmethod
    def selecao(listaNI):
        lista = listaNI.copy()
        qtd_comparacoes = 0
        qtd_trocas = 0
        for i in range(len(lista) - 1):
            posMenor = i
            for j in range(i + 1, len(lista)):
                qtd_comparacoes += 1
                if (lista[j].nome < lista[posMenor].nome) or \
                   (lista[j].nome == lista[posMenor].nome and lista[j].idade < lista[posMenor].idade):
                    posMenor = j
            if i != posMenor:
                qtd_trocas += 1
                lista[i], lista[posMenor] = lista[posMenor], lista[i]
        return lista, qtd_comparacoes, qtd_trocas

    @staticmethod
    def pente(listaNI):
        lista = listaNI.copy()

        def calcular_gap(tamanho):
            gap = 1
            while gap < tamanho / 3:
                gap = 3 * gap + 1
            return gap

        tamanho = len(lista)
        gap = calcular_gap(tamanho)
        comparacoes = 0
        trocas = 0

        while gap > 0:
            for i in range(gap, tamanho):
                temp = lista[i]
                j = i
                while j >= gap and ((lista[j - gap].nome > temp.nome) or \
                                    (lista[j - gap].nome == temp.nome and lista[j - gap].idade > temp.idade)):
                    comparacoes += 1
                    lista[j] = lista[j - gap]
                    trocas += 1
                    j -= gap
                comparacoes += 1
                lista[j] = temp
                trocas += 1
            gap //= 3

        return lista, comparacoes, trocas


print("Original:", listaNI, "\n")

ordenada, comp, troca = Ordenacao.bolha(listaNI)
print("Bolha     :", ordenada, " . Comparações:", comp, "Trocas:", troca)

ordenada, comp, troca = Ordenacao.pente(listaNI)
print("Pente     :", ordenada, " . Comparações:", comp, "Trocas:", troca)

ordenada, comp, troca = Ordenacao.selecao(listaNI)
print("Seleção   :", ordenada, " . Comparações:", comp, "Trocas:", troca)


