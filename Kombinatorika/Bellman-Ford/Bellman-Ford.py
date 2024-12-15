class Graph:
    def __init__(self, vertices):
        """
        Инициализация графа
        vertices: Количество вершин в графе
        """
        self.V = vertices  # Число вершин
        self.edges = []    # Список рёбер (каждое ребро представляется кортежем (u, v, вес))

    def add_edge(self, u, v, weight):
        """
        Добавляет ребро в граф
        u: Начальная вершина ребра
        v: Конечная вершина ребра
        weight: Вес ребра
        """
        self.edges.append((u, v, weight))

    def bellman_ford(self, src):
        """
        Реализация алгоритма Беллмана-Форда
        src: Исходная вершина
        return: Список расстояний от src до всех вершин или сообщение о наличии отрицательного цикла
        """
        # Шаг 1: Инициализация расстояний до всех вершин как бесконечности, кроме начальной
        d = [float('inf')] * self.V
        d[src] = 0  # Расстояние до исходной вершины равно 0

        # Шаг 2: Релаксация всех рёбер |V| - 1 раз
        for _ in range(self.V - 1):
            for u, v, weight in self.edges:
                # Если расстояние до u не бесконечное и можно улучшить путь до v
                if d[u] != float('inf') and d[u] + weight < d[v]:
                    d[v] = d[u] + weight

        # Шаг 3: Проверка на наличие отрицательных циклов
        for u, v, weight in self.edges:
            if d[u] != float('inf') and d[u] + weight < d[v]:
                return "Граф содержит отрицательный цикл"

        return d


# Создаём граф с 5 вершинами
g = Graph(5)

# Добавляем рёбра: (u, v, вес)
g.add_edge(0, 1, 10)
g.add_edge(0, 2, 50)
g.add_edge(1, 2, 30)
g.add_edge(1, 3, 40)
g.add_edge(1, 4, 20)
g.add_edge(3, 2, 25)
g.add_edge(3, 1, 15)

# Ребро с отрицательным весом
g.add_edge(4, 3, -10)

# Ребро для отрицательного цикла
g.add_edge(2, 0, -50)

result = g.bellman_ford(0)

if result == "Граф содержит отрицательный цикл":
    print(result)  # Сообщение о наличии отрицательного цикла
else:
    print("Кратчайшие расстояния от вершины 0:")
    for i, dist in enumerate(result):
        print(f'Вершина {i} : {dist}')
