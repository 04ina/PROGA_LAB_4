public class PageHandler {
    public void printRawFSMPage (int relOid,  int pageNumber) {
        FSMPage fsmPage = new FSMPage(relOid, pageNumber);
        fsmPage.printRawData();
    }

    public void printRawVMPage (int relOid, int pageNumber) {
        VMPage vmPage = new VMPage(relOid, pageNumber);
        vmPage.printRawData();
    }
}
