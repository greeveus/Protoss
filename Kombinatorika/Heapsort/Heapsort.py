def heapify(arr, n, i):
    largest = i           # Предполагаем, что текущий узел - наибольший
    left = 2 * i + 1      # Индекс левого потомка
    right = 2 * i + 2     # Индекс правого потомка

    # Если левый потомок существует и больше корня
    if left < n and arr[left] > arr[largest]:
        largest = left

    # Если правый потомок существует и больше "наибольшего" на данный момент
    if right < n and arr[right] > arr[largest]:
        largest = right

    # Если наибольший элемент оказался не корневым узлом
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]  # Меняем местами
        heapify(arr, n, largest)  # Рекурсивно heapify для изменённого узла

def build_max_heap(arr, n):
    # Преобразует массив в максимальную кучу.
    # Начинаем с последнего внутреннего узла и двигаемся вверх к корню
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

def heapsort(arr):
    n = len(arr)

    # 1. Построение максимальной кучи
    build_max_heap(arr, n)

    # 2. Извлечение элементов из кучи один за другим
    for i in range(n - 1, 0, -1):
        # Переносим текущий максимальный элемент (корень) в конец
        arr[0], arr[i] = arr[i], arr[0]
        # Восстанавливаем свойство кучи для уменьшенной кучи
        heapify(arr, i, 0)

data = [4, 10, -3, 3, 5, 5, 5, 1, 12, -7, 9]
heapsort(data)
print(data)
