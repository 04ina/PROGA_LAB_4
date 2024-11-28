class FSMPage extends Page {
    private RawPage rawContent;
    private static final int RAW_PAGE_SIZE = 8192;

    public FSMPage(int relOid, ForkType fork, int pageNumber) {
        super(relOid, fork, pageNumber);
    }

    public void printRawData() {
        for (int i = 0; i < RAW_PAGE_SIZE; i++) {
            System.out.printf("%d ",
                    rawContent.data[i] & 0x000000FF);
        }
    }
}