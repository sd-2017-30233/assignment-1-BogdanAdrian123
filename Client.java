package Business;

public class Client {

    private String name;
    private int icn;
    private long pnc;
    private String address;

    public Client()
    {

    }

    public Client(String name, int icn, long pnc, String address)
    {
        this.setName(name);
        this.setIcn(icn);
        this.setPnc(pnc);
        this.setAddress(address);
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setIcn(int icn)
    {
        this.icn=icn;
    }

    public int getIcn()
    {
        return icn;
    }

    public void setPnc(long pnc)
    {
        this.pnc=pnc;
    }

    public long getPnc()
    {
        return this.pnc;
    }

    public void setAddress(String address)
    {
        this.address=address;
    }

    public String getAddress()
    {
        return this.address;
    }
}