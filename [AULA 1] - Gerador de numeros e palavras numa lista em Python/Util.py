import random

class Util:

    @staticmethod
    def popular_aleatorio_numeros(lista, quantidade, inicio, fim):
        for _ in range(quantidade):
            lista.append(random.randint(inicio, fim - 1))

    @staticmethod
    def popular_aleatorio_palavras(lista, quantidade, tamanho):
        letras = "abcdefghijklmnopqrstuvwxyz "
        for _ in range(quantidade):
            palavra_gerada = ''.join(random.choice(letras) for _ in range(tamanho))
            lista.append(palavra_gerada)
            
    @staticmethod
    def exibir_lista_numeros(lista):
        for item in lista:
            print(item)

    @staticmethod
    def exibir_lista_palavras(lista):
        for item in lista:
            print(item)

lista_numeros = []
lista2_numeros = []
lista_palavras= []


Util.popular_aleatorio_numeros(lista_numeros, 10, 100, 500)
Util.exibir_lista_numeros(lista_numeros)

lista2_numeros.extend(lista_numeros)