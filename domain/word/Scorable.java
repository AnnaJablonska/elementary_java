package vocabulator_app.domain.word;

public interface Scorable {
    int score();
    void incrementScore(int delta);
}
