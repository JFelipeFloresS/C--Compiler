import static file_utils.FileUtils.getInputAndOutputFilePathFromFileChooser;

public class TestRigGUI {

    public static void main(String... args) throws Exception {
        if (args.length < 1) {
            args = getInputAndOutputFilePathFromFileChooser();
        }

        org.antlr.v4.gui.TestRig.main(new String[]{"parser.Cmm", "program", "-gui", args[0]});
    }


}
