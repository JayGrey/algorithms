package org.example.ex._1._3._43;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShowDirectory {
    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("input full directory name: ");
        final String rootDir = scanner.nextLine();

        printDirectoryContent(Paths.get(rootDir), 0);
    }

    private static void printDirectoryContent(Path directory, int depth) throws IOException {
        if (directory == null) {
            return;
        }

        final String leftAlign = IntStream.range(0, depth).mapToObj(_i -> "\t").collect(Collectors.joining());

        if (!Files.isDirectory(directory)) {
            System.out.println(leftAlign + directory.getFileName());
        }

        final List<Path> elements = Files.list(directory).collect(Collectors.toList());

        for (Path element : elements) {
            if (Files.isDirectory(element)) {
                System.out.println(leftAlign + element.getFileName() + ":");
                printDirectoryContent(element, depth + 1);
            } else {
                System.out.println(leftAlign + element.getFileName());
            }
        }
    }
}
