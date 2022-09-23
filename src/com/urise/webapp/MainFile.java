package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {

    public static void showTreeFiles(File file) {
        File[] files = file.listFiles();
        assert files != null;
        for (File f : files) {
            if (f.getName().equals(".git") || f.getName().equals(".gitignore") || f.getName().equals(".idea") ||
                    f.getName().equals("basejava.iml") || f.getName().equals("lesson") || f.getName().equals("lib") ||
                    f.getName().equals("out") || f.getName().equals("README.md") || f.getName().equals("test")) {
                continue;
            }
            if (f.isFile()) {
                System.out.println(f.getName());
            }
            if (f.isDirectory()) {
                System.out.println(f.getName());
                showTreeFiles(f);
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Professional\\IdeaProjects\\basejava\\.gitignore";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        System.out.println("----------------------------------------------------------------------------------");

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        System.out.println("----------------------------------------------------------------------------------");

        File dir = new File("C:\\Users\\Professional\\IdeaProjects\\basejava");
        showTreeFiles(dir);
    }
}
