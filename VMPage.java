class VMPage extends Page implements Cloneable {

    public VMPage(int relOid, int pageNumber) {
        super(relOid, ForkType.VM_FORK, pageNumber);
    }

    // Мелкое клонирование
    @Override
    protected VMPage clone() throws CloneNotSupportedException {
        return (VMPage) super.clone();
    }

    // Глубокое клонирование
    public VMPage deepClone() throws CloneNotSupportedException {
        VMPage cloned = (VMPage) super.clone();
        cloned.rawContent = (RawPage) cloned.rawContent.clone();
        return cloned;
    }

    @Override
    public void printRawData() {
        for (int i = 0; i < RAW_PAGE_SIZE; i++) {
            System.out.printf("%x ", rawContent.data[i]);
        }
    }

    public void GetVMPageInfo() {
        System.out.println("VMPage info without base class method call");
    }

    public void GetVMPageInfo(PageMetaInfo mi)
    {
        GetPageInfo(mi);
    }
/*
    public void GetVMPageInfo(Page page) {
        GetPageInfo(page);
    }
 */
}