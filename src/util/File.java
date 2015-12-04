/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme
 */
public class File {

    private static final String FOLDER_DEFAULT = System.getProperty("user.home");
    private static final String FILE_NAME = "loginDaily.txt";
    private Path path;
    private String fileName;

    public File(String fileName) {
        this.fileName = fileName;
        if (path == null) {
            path = Paths.get(FOLDER_DEFAULT.concat("/").concat("sisgav"));
            try {
                if (!Files.exists(path)) {
                    Files.createDirectory(path);
                }
            } catch (IOException ex) {
                Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Método que cria o arquivo de Log diário
     *
     * @throws java.io.IOException
     */
    public void createFile() throws IOException {
        if (!Files.exists(path)) {
            if (System.getProperty("os.name").equalsIgnoreCase("Windows")) {
                Files.setAttribute(path, "dos:hidden", true);
            }
            Files.createFile(path);
        }
    }

    /**
     * Método que cria a pasta
     *
     * @throws java.io.IOException
     */
    public void createDirectory() throws IOException {
        if (Files.exists(path)) {
            path = Paths.get(path.toString().concat("/").concat(fileName));
            if (System.getProperty("os.name").equalsIgnoreCase("Windows")) {
                Files.setAttribute(path, "dos:hidden", true);
            }
            if (!Files.exists(path)) {
                Files.createDirectory(path);
            }
        }
    }

    /**
     * Método que escreve no arquivo.
     *
     * @param text
     * @throws java.io.IOException
     */
    public void writeFile(String text) throws IOException {
        if (Files.isWritable(path)) {
            Files.write(path, text.getBytes());
        }
    }

    /**
     * Deleta o arquivo de Log.
     *
     * @throws IOException
     */
    public void deleteFile() throws IOException {
        Files.deleteIfExists(path);
    }

    /**
     * Retorna o último horário de login.
     *
     * @return
     * @throws IOException
     */
    public Long lastLogin() throws IOException {
        Long longs = new Long(0);
        if (Files.exists(path)) {
            List<String> lines = Files.readAllLines(path);
            longs = Long.parseLong(lines.get(lines.size() - 1)
                    .replaceAll("\\D", ""));
        }
        return longs;
    }

}
