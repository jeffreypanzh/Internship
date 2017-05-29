package pl.valueadd.equicty.model.dashboard;

/**
 * Created by piotr on 08/05/17.
 */

public class Task {

    int id;
    int horseId;
    String text;

    public Task(int id, int horseId, String text) {
        this.id = id;
        this.horseId = horseId;
        this.text = text;
    }

    public String getText() {
        return text;
    }


}
