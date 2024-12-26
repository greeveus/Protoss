package ResponsibilityChain;

// Обработчик для логов уровня INFO
public class InfoHandler extends Handler {
    @Override
    public void handleRequest(String message, LogLevel level) {
        if (level == LogLevel.INFO) {
            System.out.println("INFO: " + message);
        } else if (next != null) {
            next.handleRequest(message, level);
        }
    }
}
