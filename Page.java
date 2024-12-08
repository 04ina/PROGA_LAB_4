abstract public class Page {
    private PageHeader pageHeader;
    protected RawPage rawContent;
    private int number;
    private ForkType fork;
    int relOid;
    protected static final int RAW_PAGE_SIZE = 8192;

    public Page(int relPageOid, ForkType forkType,  int pageNumber)
    {
        rawContent = new RawPage();
        pageHeader = new PageHeader();

        rawContent.Read(relPageOid, forkType, pageNumber);
        rawContent.GetHeader(pageHeader);

        number = pageNumber;
        fork = forkType;
        relOid = relPageOid;
    }

    public abstract void printRawData();

    public void GetPageInfo(PageMetaInfo mi)
    {
        mi = this.GetMetaInfo();
    }
/*
    public void GetPageInfo(Page page) {
        page = new Page(relOid, fork, number);
    }
 */

    public PageHeader getHeader()
    {
        return pageHeader;
    }

    public PageMetaInfo GetMetaInfo()
    {
        return new PageMetaInfo(number, fork, relOid);
    }

}
