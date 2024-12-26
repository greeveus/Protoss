package ResponsibilityChain;

// Обработчик для логов уровня DEBUG
public class DebugHandler extends Handler {
    @Override
    public void handleRequest(String message, LogLevel level) {
        if (level == LogLevel.DEBUG) {
            System.out.println("DEBUG: " + message);
        } else if (next != null) {
            next.handleRequest(message, level);
        }
    }
}