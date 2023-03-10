package jp.co.saison.mob;

import java.util.List;
import java.util.Set;

public interface Strategy {
    Set<Column> makeColumnSet();
    Object handle(List<Record> records);

}
