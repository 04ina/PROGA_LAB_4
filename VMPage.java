class VMPage extends Page {
    private static final int RAW_PAGE_SIZE = 8192;

    public VMPage(int relOid, ForkType fork, int pageNumber) {
        super(relOid, fork, pageNumber);
    }

    public void printRawData() {
        for (int i = 0; i < RAW_PAGE_SIZE; i++) {
            System.out.printf("%x ", rawContent.data[i]);
        }
    }
}