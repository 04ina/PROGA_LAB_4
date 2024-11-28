public class PageHandler {
    public void printRawFSMPage (int relOid, ForkType fork, int pageNumber) {
        FSMPage fsmPage = new FSMPage(relOid, fork, pageNumber);
        fsmPage.printRawData();
    }

    public void printRawVMPage (int relOid, ForkType fork, int pageNumber) {
        VMPage vmPage = new VMPage(relOid, fork, pageNumber);
        vmPage.printRawData();
    }
}
