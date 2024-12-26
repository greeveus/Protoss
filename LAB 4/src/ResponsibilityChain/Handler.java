package ResponsibilityChain;

public abstract class Handler {
    protected Handler next; // Ссылка на следующий обработчик в цепочке

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handleRequest(String message, LogLevel level);
}
