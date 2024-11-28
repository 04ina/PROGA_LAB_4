public class Page {
    private PageHeader pageHeader;
    public RawPage rawContent;
    private int number;
    private ForkType fork;
    int relOid;
    private static final int RAW_PAGE_SIZE = 8192;

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

    public PageHeader getHeader()
    {
        return pageHeader;
    }

}
