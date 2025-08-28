class Insercao:
    @staticmethod
    def ordenar(vetor):
        i = j = 0
        tmp = 0
        qtdComparacoes = 0
        qtdTrocas = 0
        n = len(vetor)

        for i in range(1, n):
            tmp = vetor[i]
            j = i - 1
            while j >= 0:
                qtdComparacoes += 1
                if tmp < vetor[j]:
                    vetor[j + 1] = vetor[j]
                    qtdTrocas += 1
                    j -= 1
                else:
                    break
            vetor[j + 1] = tmp
            qtdTrocas += 1

        print("Quantidade comparações:", qtdComparacoes)
        print("Quantidade trocas:", qtdTrocas, "\n")

        return qtdComparacoes, qtdTrocas
