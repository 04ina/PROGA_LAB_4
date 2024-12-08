public class PageMetaInfo {
    public int number;
    public ForkType fork;
    public int relOid;

    public PageMetaInfo(int number, ForkType fork,  int relOid) {
        this.number = number;
        this.fork = fork;
        this.relOid = relOid;
    }
}
