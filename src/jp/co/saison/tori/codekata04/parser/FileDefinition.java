package jp.co.saison.tori.codekata04.parser;

public class FileDefinition {

    private final String path;

    private int headerRow = 0;

    private int footerRow = 0;

    public FileDefinition(String path) {
        this.path = path;
    }

    public FileDefinition(String path, int headerRow, int footerRow) {
        this.path = path;
        this.headerRow = headerRow;
        this.footerRow = footerRow;
    }
}
