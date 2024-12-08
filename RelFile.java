import java.io.*;
import java.util.*;

public class RelFile {
    static RandomAccessFile file;
    static int oid;
    static StringBuilder fileName;
    static ForkType fork;
    private static final int RAW_PAGE_SIZE = 8192;

    public static int Get_RAW_PAGE_SIZE() {
        return RAW_PAGE_SIZE;
    }

    public RelFile(int relOid, ForkType forkType)
    {
        oid = relOid;
        fork = forkType;
        fileName = new StringBuilder();

        fileName.append(oid);

        switch (fork) {
            case MAIN_FORK:
                break;
            case FSM_FORK:
                fileName.append("_fsm");
                break;
            case VM_FORK:
                fileName.append("_vm");
                break;
            case INIT_FORK:
                fileName.append("_init");
                break;
            default:
                throw new AssertionError("Unknown fork type");
        }
    }
    public void OpenForRead()
    {
        try {
            file = new RandomAccessFile(fileName.toString(), "r");
        } catch (FileNotFoundException e) {
            System.err.println("File " + fileName.toString() + " not found");
        }
    }
    public void Close()
    {
        try  {
            file.close();
        } catch(IOException e) {
            System.err.println("IO error");
        }
    }

    public boolean ReadRawPage(int pageNumber, byte[] rawPage) throws IOException {
        long offset = (long) RAW_PAGE_SIZE * pageNumber;

        file.seek(offset);


        if (file.getFilePointer() != offset) {
            // page not found
            return false;
        }

        file.readFully(rawPage, 0, RAW_PAGE_SIZE);

        file.seek(file.length());

        return true;
    }


}
