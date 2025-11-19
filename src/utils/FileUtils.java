package utils;

public class FileUtils {

    private static String getFilePathFromFileChooser() {
        // because i'm assigning value within a lambda function the variable needs to be final
        final String[] selectedPath = new String[1];
        try {
            // need to wait for the file selection
            javax.swing.SwingUtilities.invokeAndWait(() -> {
                javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
                fileChooser.setCurrentDirectory(new java.io.File("."));
                int dialogChoice = fileChooser.showOpenDialog(null);

                // handle user response
                if (dialogChoice == javax.swing.JFileChooser.APPROVE_OPTION) {
                    selectedPath[0] = fileChooser.getSelectedFile().getAbsolutePath();
                } else {
                    System.out.println("No file selected.");
                    System.exit(1);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return selectedPath[0];
    }

    public static String[] getInputAndOutputFilePathFromFileChooser() {
        String[] paths = new String[2];
        System.out.println("Select input file:");
        paths[0] = getFilePathFromFileChooser();
        System.out.println("Selected input file: " + paths[0]);
        // commenting out output file selection until implementation is done
//    System.out.println("Select output file:");
//    paths[1] = getFilePathFromFileChooser();
//    System.out.println("Selected output file: " + paths[1]);

        return paths;
    }

}
