package ResponsibilityChain;

// Обработчик для логов уровня ERROR
public class ErrorHandler extends Handler {
    @Override
    public void handleRequest(String message, LogLevel level) {
        if (level == LogLevel.ERROR) {
            System.out.println("ERROR: " + message);
        } else if (next != null) {
            next.handleRequest(message, level);
        }
    }
}