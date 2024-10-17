package utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.fusesource.jansi.AnsiConsole;

public class LogManager {
    private static final Logger logger = Logger.getLogger(LogManager.class.getName());

    private LogManager() {
        AnsiConsole.systemInstall();
    }

    public static void info(String message) {
        logger.log(Level.INFO, "\u001B[32m" + message + "\u001B[0m"); // Зеленый
    }

    public static void warning(String message) {
        logger.log(Level.WARNING, "\u001B[33m" + message + "\u001B[0m"); // Желтый
    }

    public static void error(String message) {
        logger.log(Level.SEVERE, "\u001B[31m" + message + "\u001B[0m"); // Красный
    }

    public static void close() {
        AnsiConsole.systemUninstall(); // Отключаем поддержку ANSI
    }
}

