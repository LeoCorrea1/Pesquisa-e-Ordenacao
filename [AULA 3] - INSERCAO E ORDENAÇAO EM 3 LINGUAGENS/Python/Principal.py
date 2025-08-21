from Util import Util
from Ordenacao import Ordenacao
from Insercao import Insercao
import time
 
lista_bolha = []
lista_normal = []
lista_insercao = []
Util.popular_lista_aleatoria(lista_insercao, 10000, 100, 20000)
Util.popular_lista_aleatoria(lista_bolha, 10000, 100, 20000)
Util.popular_lista_aleatoria(lista_normal, 10000, 100, 20000)
 
 
tempoInicio = time.time()
lista_normal.sort()
tempoFim = time.time()
print("Tempo da rotina ordenar por sort nativo: ", (tempoFim - tempoInicio) , "s")        
 
tempoInicio = time.time()
qtd_comparacoes, qtd_trocas = Ordenacao.bolha(lista_bolha)
tempoFim = time.time()
print("Tempo da rotina ordenar por bolha: ", (tempoFim - tempoInicio) , "s")      
print('Comparacoes:', qtd_comparacoes)
print('Trocas:', qtd_trocas)  

tempoInicio = time.time()
qtdComparacoes, qtdTrocas = Insercao.ordenar(lista_insercao)
tempoFim = time.time()

print("Tempo da rotina ordenar por insercao: ", (tempoFim - tempoInicio), "s")
print("Comparacoes:", qtdComparacoes)
print("Trocas:", qtdTrocas)