from collections import deque

class Edge:
    """
    Класс для представления ребра в сети потока.
    Каждый экземпляр содержит информацию о вершине назначения, индексе обратного ребра,
    пропускной способности и текущем потоке.
    """
    def __init__(self, to, rev, capacity):
        self.to = to          # Вершина назначения
        self.rev = rev        # Индекс обратного ребра в списке рёбер вершины 'to'
        self.capacity = capacity  # Остаточная пропускная способность
        self.flow = 0         # Текущий поток через ребро

class Dinic:
    """
    Класс для реализации Алгоритма Диница для нахождения максимального потока в сети.
    """
    def __init__(self, N):
        """
        Инициализация графа.
        
        N: Количество вершин в графе
        """
        self.size = N
        self.graph = [[] for _ in range(N)]  # Список смежности для каждой вершины
        self.level = [ -1 ] * N              # Уровни вершин
        self.ptr = [0] * N                   # Текущие индексы для оптимизации DFS

    def add_edge(self, fr, to, capacity):
        """
        Добавление ребра в граф.
        
        fr: Вершина начала ребра
        to: Вершина конца ребра
        capacity: Пропускная способность ребра
        """
        forward = Edge(to, len(self.graph[to]), capacity)
        backward = Edge(fr, len(self.graph[fr]), 0)  # Обратное ребро с нулевой пропускной способностью
        self.graph[fr].append(forward)
        self.graph[to].append(backward)

    def bfs(self, s, t):
        """
        Поиск в ширину для построения уровневого графа.
        
        s: Источник
        t: Сток
        True, если сток достижим из источника, иначе False
        """
        queue = deque()
        queue.append(s)
        self.level = [-1] * self.size
        self.level[s] = 0  # Уровень источника равен 0

        while queue:
            v = queue.popleft()
            for edge in self.graph[v]:
                if self.level[edge.to] == -1 and edge.flow < edge.capacity:
                    self.level[edge.to] = self.level[v] + 1
                    queue.append(edge.to)
                    print(f"Вершина {edge.to} достигнута из вершины {v} с уровнем {self.level[edge.to]}")
                    if edge.to == t:
                        return True  # Сток найден, можно прекратить BFS

        return self.level[t] != -1  # Возвращает True, если сток был достигнут

    def dfs(self, v, t, pushed):
        """
        Поиск в глубину для отправки потока.
        
        :param v: Текущая вершина
        :param t: Сток
        :param pushed: Поток, который нужно отправить
        :return: Поток, который был отправлен
        """
        if v == t:
            return pushed  # Поток достиг стока
        while self.ptr[v] < len(self.graph[v]):
            edge = self.graph[v][self.ptr[v]]
            if self.level[edge.to] == self.level[v] + 1 and edge.flow < edge.capacity:
                # Минимальная остаточная пропускная способность на пути
                tr = self.dfs(edge.to, t, min(pushed, edge.capacity - edge.flow))
                if tr > 0:
                    # Обновление потока и обратного потока
                    edge.flow += tr
                    self.graph[edge.to][edge.rev].flow -= tr
                    print(f"Отправлен поток {tr} через ребро {v} -> {edge.to}")
                    return tr
            self.ptr[v] += 1  # Перейти к следующему ребру
        return 0  # Невозможно отправить больше потока из этой вершины

    def max_flow(self, s, t):
        """
        Вычисление максимального потока из вершины s в вершину t.
        
        :param s: Источник
        :param t: Сток
        :return: Максимальный поток
        """
        flow = 0
        while self.bfs(s, t):
            self.ptr = [0] * self.size  # Сброс указателей для DFS
            pushed = self.dfs(s, t, float('inf'))
            while pushed > 0:
                flow += pushed
                print(f"Текущий общий поток: {flow}")
                pushed = self.dfs(s, t, float('inf'))
        return flow

def main():
    """
    Основная функция для демонстрации работы Алгоритма Диница.
    Создаётся пример сети, аналогичный приведённому в отчёте.
    """
    N = 4
    s = 0  # Источник
    t = 3  # Сток

    # Инициализация Алгоритма Диница
    dinic = Dinic(N)

    # Добавление рёбер (источник, вершина, пропускная способность)
    dinic.add_edge(0, 1, 3)  # s -> a
    dinic.add_edge(0, 2, 2)  # s -> b
    dinic.add_edge(1, 2, 1)  # a -> b
    dinic.add_edge(1, 3, 2)  # a -> t
    dinic.add_edge(2, 3, 3)  # b -> t

    # Вычисление максимального потока
    max_flow = dinic.max_flow(s, t)
    print(f"\nМаксимальный поток: {max_flow}")

    # Вывод потоков по рёбрам
    print("\nПотоки по рёбрам:")
    for u in range(N):
        for edge in dinic.graph[u]:
            if edge.capacity > 0:
                print(f"{u} -> {edge.to} : {edge.flow}")

if __name__ == "__main__":
    main()
