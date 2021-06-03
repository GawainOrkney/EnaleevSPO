package Enaleev.interpreter;

public class Main {

    static public void main (String args[]) {

        Enaleev.interpreter.TextDriver text = new Enaleev.interpreter.TextDriver("SourceFiles/Example_1.txt");
        Lexer lexer = new Lexer();
        try {
            lexer.analysis(text.get_source());
        } catch (Exception e) {
            e.printStackTrace();
        }
        lexer.printLexemeList();
        Enaleev.interpreter.Parser parser = new Enaleev.interpreter.Parser(lexer.getLexemes());
        parser.analysis();
        parser.AST.print();
        Enaleev.interpreter.TranslatorRPN RPN = new Enaleev.interpreter.TranslatorRPN(parser.getTree());
        RPN.translate();
        RPN.print();
        Enaleev.interpreter.StackMachine machine = new Enaleev.interpreter.StackMachine(RPN.getRPN());
        machine.run();
        machine.print();
    }

    /*public static void main(String[] args) {

        HashSetInt list = new HashSetInt();

        list.add(1);
        list.add(5);
        list.add(9);
        list.add(13);
        list.add(17);
        list.add(21);
        list.add(25);
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(13);
        list.add(17);
        list.add(21);
        list.add(25);


        list.print();

        list.delete(5);

        list.print();
    }*/
}
