import time
from Util import Util

class Ordenacao:
    @staticmethod
    def bolha(lista):
        houve_troca = True
        qtd_comparacoes = 0
        qtd_trocas = 0
        while houve_troca:
            houve_troca = False
            for i in range(len(lista) - 1):
                qtd_comparacoes += 1
                if lista[i] > lista[i + 1]:
                    qtd_trocas += 1
                    houve_troca = True
                    lista[i], lista[i + 1] = lista[i + 1], lista[i]
        return qtd_comparacoes, qtd_trocas

    @staticmethod
    def selecao(lista):
        qtd_comparacoes = 0
        qtd_trocas = 0
        for i in range(len(lista) - 1):
            posMenor = i
            for j in range(i + 1, len(lista)):
                qtd_comparacoes += 1
                if lista[j] < lista[posMenor]:
                    posMenor = j
            if i != posMenor:
                qtd_trocas += 1
                lista[i], lista[posMenor] = lista[posMenor], lista[i]
        return qtd_comparacoes, qtd_trocas

    @staticmethod
    def insercao(lista):
        qtd_comparacoes = 0
        qtd_trocas = 0
        for i in range(1, len(lista)):
            tmp = lista[i]
            j = i - 1
            while j >= 0 and tmp < lista[j]:
                qtd_comparacoes += 1
                lista[j + 1] = lista[j]
                qtd_trocas += 1
                j -= 1
            qtd_comparacoes += 1
            lista[j + 1] = tmp
            qtd_trocas += 1
        return qtd_comparacoes, qtd_trocas

    @staticmethod
    def agitacao(lista):
        ini = 0
        fim = len(lista) - 1
        qtd_comparacoes = 0
        qtd_trocas = 0
        while True:
            houve_troca = False
            for i in range(ini, fim):
                qtd_comparacoes += 1
                if lista[i] > lista[i + 1]:
                    qtd_trocas += 1
                    lista[i], lista[i + 1] = lista[i + 1], lista[i]
                    houve_troca = True
            if not houve_troca:
                break
            fim -= 1
            houve_troca = False
            for i in range(fim, ini, -1):
                qtd_comparacoes += 1
                if lista[i] < lista[i - 1]:
                    qtd_trocas += 1
                    lista[i], lista[i - 1] = lista[i - 1], lista[i]
                    houve_troca = True
            ini += 1
            if not houve_troca:
                break
        return qtd_comparacoes, qtd_trocas

    @staticmethod
    def pente(lista):
        distancia = len(lista)
        houve_troca = True
        qtd_comparacoes = 0
        qtd_trocas = 0
        while houve_troca or distancia > 1:
            distancia = int(distancia / 1.3)
            if distancia < 1:
                distancia = 1
            houve_troca = False
            for i in range(len(lista) - distancia):
                qtd_comparacoes += 1
                if lista[i] > lista[i + distancia]:
                    qtd_trocas += 1
                    lista[i], lista[i + distancia] = lista[i + distancia], lista[i]
                    houve_troca = True
        return qtd_comparacoes, qtd_trocas

    @staticmethod
    def particiona(lista, ini, fim, cont):
        pivo = ini
        while fim > ini:
            while fim > pivo and lista[fim] > lista[pivo]:
                cont[0] += 1
                fim -= 1
            if fim > pivo:
                cont[1] += 1
                lista[pivo], lista[fim] = lista[fim], lista[pivo]
                pivo = fim
            ini += 1
            while ini < pivo and lista[ini] < lista[pivo]:
                cont[0] += 1
                ini += 1
            if ini < pivo:
                cont[1] += 1
                lista[pivo], lista[ini] = lista[ini], lista[pivo]
                pivo = ini
        return pivo

    @staticmethod
    def quickSort(lista):
        cont = [0, 0]
        def _quickSort(lista, ini, fim, cont):
            if ini < fim:
                pivo = Ordenacao.particiona(lista, ini, fim, cont)
                if ini < pivo - 1:
                    _quickSort(lista, ini, pivo - 1, cont)
                if pivo + 1 < fim:
                    _quickSort(lista, pivo + 1, fim, cont)
        _quickSort(lista, 0, len(lista) - 1, cont)
        return cont[0], cont[1]


# ---------------- MAIN ----------------

lista_bolha = []
lista_normal = []
lista_selecao = []
lista_insercao = []
lista_agitacao = []
lista_pente = []
lista_quick = []

tamanho = 1000

Util.popular_lista_aleatoria(lista_bolha, tamanho, 10000, 20000)
lista_normal.extend(lista_bolha)
lista_selecao.extend(lista_bolha)
lista_insercao.extend(lista_bolha)
lista_agitacao.extend(lista_bolha)
lista_pente.extend(lista_bolha)
lista_quick.extend(lista_bolha)

tempoInicio = time.perf_counter()
lista_normal.sort()
tempoFim = time.perf_counter()
print("Tempo da rotina ordenar por sort nativo: ", (tempoFim - tempoInicio), "s")

tempoInicio = time.perf_counter()
qtd_comparacoes, qtd_trocas = Ordenacao.bolha(lista_bolha)
tempoFim = time.perf_counter()
print("Tempo da rotina ordenar por bolha: ", (tempoFim - tempoInicio), "s")
print("Comparacoes:", qtd_comparacoes)
print("Trocas:", qtd_trocas)

tempoInicio = time.perf_counter()
qtd_comparacoes, qtd_trocas = Ordenacao.selecao(lista_selecao)
tempoFim = time.perf_counter()
print("Tempo da rotina ordenar por selecao: ", (tempoFim - tempoInicio), "s")
print("Comparacoes:", qtd_comparacoes)
print("Trocas:", qtd_trocas)

tempoInicio = time.perf_counter()
qtd_comparacoes, qtd_trocas = Ordenacao.insercao(lista_insercao)
tempoFim = time.perf_counter()
print("Tempo da rotina ordenar por insercao: ", (tempoFim - tempoInicio), "s")
print("Comparacoes:", qtd_comparacoes)
print("Trocas:", qtd_trocas)

tempoInicio = time.perf_counter()
qtd_comparacoes, qtd_trocas = Ordenacao.agitacao(lista_agitacao)
tempoFim = time.perf_counter()
print("Tempo da rotina ordenar por agitacao: ", (tempoFim - tempoInicio), "s")
print("Comparacoes:", qtd_comparacoes)
print("Trocas:", qtd_trocas)

tempoInicio = time.perf_counter()
qtd_comparacoes, qtd_trocas = Ordenacao.pente(lista_pente)
tempoFim = time.perf_counter()
print("Tempo da rotina ordenar por pente: ", (tempoFim - tempoInicio), "s")
print("Comparacoes:", qtd_comparacoes)
print("Trocas:", qtd_trocas)

tempoInicio = time.perf_counter()
qtd_comparacoes, qtd_trocas = Ordenacao.quickSort(lista_quick)
tempoFim = time.perf_counter()
print("Tempo da rotina ordenar por quick: ", (tempoFim - tempoInicio), "s")
print("Comparacoes:", qtd_comparacoes)
print("Trocas:", qtd_trocas)
