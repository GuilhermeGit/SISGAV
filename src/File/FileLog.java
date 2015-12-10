/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

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
public class FileLog {

    private static final String FOLDER_DEFAULT = System.getProperty("user.home");
    private static final String FILE_NAME = "logPerceptron.txt";
    private Path path;

    public static void main(String[] args) throws IOException {
        FileLog file = new FileLog();
        file.createFile();

    }

    public FileLog() {
        if (path == null) {
            path = Paths.get(FOLDER_DEFAULT.concat("/".concat(
                    System.getProperty("os.name").equalsIgnoreCase("Windows")
                            ? FILE_NAME : ".".concat(FILE_NAME))));
            System.out.println("Arquivo: " + path.toString());
            try {
                createFile();
            } catch (IOException ex) {
                Logger.getLogger(FileLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public FileLog(String paths) {
        if (path == null) {
            path = Paths.get(paths);
            System.out.println("Arquivo: " + path.toString());
            try {
                createFile();
            } catch (IOException ex) {
                Logger.getLogger(FileLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Método que cria o arquivo de Log diário
     *
     * @param opt
     * @throws java.io.IOException
     */
    public void createFile(String... opt) throws IOException {
        if (opt != null) {
            if (opt.length > 0) {
                path = Paths.get(opt[0]);
                Files.createFile(path);
            } else if (!Files.exists(path)) {
                Files.createFile(getPath());
            }
        } else if (!Files.exists(path)) {
            if (System.getProperty("os.name").equalsIgnoreCase("Windows")) {
                Files.setAttribute(getPath(), "dos:hidden", true);
            }
            Files.createFile(getPath());
        }
    }

    /**
     * Método que escreve no arquivo.
     *
     * @param text
     * @throws java.io.IOException
     */
    public void writeFile(String text) throws IOException {
        if (Files.isWritable(getPath())) {
            Files.write(path, text.getBytes());
        }
    }

    /**
     * Deleta o arquivo de Log.
     *
     * @throws IOException
     */
    public void deleteFile() throws IOException {
        Files.deleteIfExists(getPath());
    }

    public List<String> readFile() throws IOException {
        return Files.readAllLines(path);
    }

    /**
     * @return the path
     */
    public Path getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(Path path) {
        this.path = path;
    }

}
