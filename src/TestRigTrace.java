import static file_utils.FileUtils.getInputAndOutputFilePathFromFileChooser;

public class TestRigTrace {

    public static void main(String... args) throws Exception {
        if (args.length < 1) {
            args = getInputAndOutputFilePathFromFileChooser();
        }
        org.antlr.v4.gui.TestRig.main(new String[]{"parser.Cmm", "program", "-trace", args[0]});
    }

}
