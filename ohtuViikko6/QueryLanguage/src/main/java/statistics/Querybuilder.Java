public class Querybuilder {
    Pino pino;

    public Querybuilder() {
        query = new Query();
    }

    public Query query() {
        return query;
    }

    public Querybuilder prepaid(int kreditit) {
        this.pino = new PrepaidPino(pino, kreditit);
        return this;
    }
}