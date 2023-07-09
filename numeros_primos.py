def es_primo(numero):
    if numero < 2:
        return False
    for i in range(2, int(numero ** 0.5) + 1):
        if numero % i == 0:
            return False
    return True


num = 5
if es_primo(num):
    print(f"{num} es un número primo")
else:
    print(f"{num} no es un número primo")