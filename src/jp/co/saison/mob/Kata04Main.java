package jp.co.saison.mob;

public class Kata04Main {

    public static void main(String[] args) {
        String filename = args[0];
        String parserType = args[1];

        try {
            KataParser parser = KataParserFactory.createParser(parserType);
            String result = parser.getResult(filename);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
