import java.io.IOException;

public class RawPage {
       public byte[] data;

       public RawPage()
       {
            data = new byte[8192];
       }

        public boolean Read(int relOid, ForkType forkType, int pageNumber)
        {
            boolean found = false;

            RelFile relFile = new RelFile(1247, forkType);
            relFile.OpenForRead();

            try {
                found = relFile.ReadRawPage(pageNumber, data);
            }
            catch (IOException e)
            {
                System.err.println("An I/O error occurred: " + e.getMessage());
            }

            relFile.Close();

            return found;
        }
        public void GetHeader(PageHeader pageHeader) {
            System.arraycopy(data, 0, pageHeader.rawHeader, 0, PageHeader.SIZE);
            pageHeader.ParseAndFill();
        }
}
