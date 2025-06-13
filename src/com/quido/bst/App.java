package com.quido.bst;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        String inputFile = findInputFile();

        List<Integer> values = new ArrayList<>(0);

        if (inputFile == null) {
            System.out.println("Nenhum arquivo de entrada .txt válido encontrado,");
            return;
        }

        // Leitura do arquivo
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                values.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        if (values.isEmpty()) {
            System.out.println("Arquivo vazio.");
            return;
        }

        int searchKey = values.get(values.size() - 1);
        List<Integer> data = values.subList(0, values.size() -1);

        BinarySearchTree bst = new BinarySearchTree();
        for (int val : data) {
            bst.insert(val);
        }

        writeToFile("preordem.txt", bst.getPreOrder());
        writeToFile("posordem.txt", bst.getPostOrder());
        writeToFile("central.txt", bst.getInOrder());
        writeToFile("largura.txt", bst.levelOrder());

        BinarySearchTree.SearchResult result = bst.searchWithTrace(searchKey);
        writeSearchResult("resultado.txt", result, searchKey);
    }

    private static String findInputFile() {
        File dir = new File(".");
        String[] outputFiles = {
            "preordem.txt", "posordem.txt", "central.txt", "largura.txt", "resultado.txt"
        };

        Set <String> outputSet = new HashSet<>(Arrays.asList(outputFiles));

        for (File file : dir.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".txt") && !outputSet.contains(file.getName())) {
                return file.getName();
            }
        }
        return null;
    }

    private static void writeToFile(String fileName, List<Integer> values) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int val : values) {
                writer.write(val + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever em " + fileName + ": " + e.getMessage());
        }
    }

    private static void writeSearchResult(String fileName, BinarySearchTree.SearchResult result, int key) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Chaves visitadas: " + result.visited + "\n");
            writer.write("Total de nodos visitados: " + result.visited.size() + "\n");
            writer.write("Chave " + key + (result.found ? " encontrada." : " ausente.") + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao escrever resultado da busca: " + e.getMessage());
        }
    }
}