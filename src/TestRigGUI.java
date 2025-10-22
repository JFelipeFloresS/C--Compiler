

public class TestRigGUI {
	
	public static void main(String... args) throws Exception {
		if (args.length < 1) {
	        System.err.println("Please, pass me the input file.");
	        return;
	    }

		// get input file from command line
		String filename = args[0];

		main("parser.Cmm", "program", "-gui", filename);
	}
	

}
