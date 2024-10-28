package lab07;

import java.io.File;

/**
 * This Java program recursively searches for a file within a directory and its subdirectories.
 */
public class FileSearch {

	private boolean fileFound;
    private String foundFilePath;

    public FileSearch() {
        this.fileFound = false;
        this.foundFilePath = null;
    }

    public boolean isFileFound() {
        return fileFound;
    }

    public String getFoundFile() {
        return foundFilePath;
    }
    /**
     * Main method to execute the program.
     *
     * @param args Command-line arguments: directory path and target filename.
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java FileSearch <directory> <filename>");
            System.exit(1);
        }

        FileSearch f = new FileSearch();
        String directoryPath = args[0];
        String targetFileName = args[1];
        
        File directory = new File(directoryPath);
        
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            System.exit(1);
        }
        
        f.searchFile(directory, targetFileName);
    }

    /**
     * Recursively searches for the specified file within the given directory and its subdirectories.
     *
     * @param directory       The directory to start the search from.
     * @param targetFileName  The name of the file to search for.
     */
    public void searchFile(File directory, String targetFileName) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFile(file, targetFileName); // Recursively search subdirectories
                } else {
                    if (file.getName().equals(targetFileName)) {
                        System.out.println("File found at: " + file.getAbsolutePath());
                        fileFound = true; // Set the flag to true when the file is found
                        foundFilePath = file.getAbsolutePath(); // Store the found file path
                        return; // Stop searching after finding the file
                    }
                }
            }
        }
    }
}