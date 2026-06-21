import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1 || !args[0].endsWith(".go"))
            throw new RuntimeException("Usage: java Main <file>.go");

        CharStream stream = CharStreams.fromFileName(args[0]);

        translatorLexer lexer = new translatorLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        translatorParser parser = new translatorParser(tokens);

        ParseTree tree = parser.program();

        if (parser.getNumberOfSyntaxErrors() > 0)
            throw new RuntimeException("Syntax errors in input — aborting.");

        String output = new GoCTranslatorVisitor().visit(tree);
        System.out.print(output);
    }
}
