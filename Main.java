import java.io.IOException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        boolean pageFound = false;

        RelFile relFile = new RelFile(1247, ForkType.FSM_FORK);
        relFile.OpenForRead();

        RawPage rawPage = new RawPage();
        try {
            pageFound = relFile.ReadRawPage(0, rawPage.data);
            if (!pageFound) {
                System.err.println("Страница не найдена");
            }
        }
        catch (IOException e)
        {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
        relFile.Close();

        rawPage.Read(1247, ForkType.VM_FORK, 0);

        //Page page = new Page(1247, ForkType.VM_FORK, 0);
        //System.out.println("pd_pagesize_version: " + page.getHeader().pd_pagesize_version);

        VMPage vmPage = new VMPage(1247, 0);
        System.out.println("Содержимое файла 1247_vm:");
        vmPage.printRawData();
        System.out.println();

        FSMPage fsmPage = new FSMPage(1247, 0);
        System.out.println("Содержимое файла 1247_fsm:");
        fsmPage.printRawData();
        System.out.println();

        PageHandler pageHandler = new PageHandler();

        System.out.println("Содержимое файла 1247_fsm:");
        pageHandler.printRawFSMPage(1247, 0);
        System.out.println();

        System.out.println("Содержимое файла 1247_vm:");
        pageHandler.printRawVMPage(1247, 0);
        System.out.println();
        System.out.println();


       FSMPage[] fsmPages = {
            new FSMPage(1247, 0),
            new FSMPage(1247, 0),
            new FSMPage(1247, 0),
            new FSMPage(1247, 0)
       };

       for (int i = 0; i < 4; i++) {
           fsmPages[i].printRawData();
           System.out.println();
       }

       //PageMetaInfo pmi = page.GetMetaInfo();

       System.out.println("RAW_PAGE_SIZE (in bits): " + RelFile.Get_RAW_PAGE_SIZE());
       try {
           VMPage vmp1 = vmPage.clone();
           VMPage vmp2 = vmPage.deepClone();
       } catch (CloneNotSupportedException e) {
            e.printStackTrace();
       }

    }
}