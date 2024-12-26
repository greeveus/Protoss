package ResponsibilityChain;

public class ResponsibilityChainDemo {
    public static void main(String[] args) {
        // Создаем обработчики
        Handler infoHandler = new InfoHandler();
        Handler debugHandler = new DebugHandler();
        Handler errorHandler = new ErrorHandler();

        // Устанавливаем цепочку обязанностей
        infoHandler.setNext(debugHandler);
        debugHandler.setNext(errorHandler);

        // Создаем запросы
        infoHandler.handleRequest("This is an information message.", LogLevel.INFO);
        infoHandler.handleRequest("This is a debug message.", LogLevel.DEBUG);
        infoHandler.handleRequest("This is an error message.", LogLevel.ERROR);
    }
}
