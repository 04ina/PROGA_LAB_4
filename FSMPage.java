class FSMPage extends Page {

    public FSMPage(int relOid, int pageNumber) {
        super(relOid, ForkType.FSM_FORK, pageNumber);
    }

    public void printRawData() {
        for (int i = 0; i < RAW_PAGE_SIZE; i++) {
            System.out.printf("%d ",
                    rawContent.data[i] & 0x000000FF);
        }
    }
}