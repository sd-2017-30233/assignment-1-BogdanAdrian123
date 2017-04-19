package Business;

import java.sql.Timestamp;
import java.util.Date;

public class Account {

    private int ID;
    private String type;
    private long funds;
    private long ownerPNC;
    private Date creationDate;

    public Account()
    {

    }

    public Account(int ID,String type,long funds,long ownerPNC,Date creationDate)
    {
        this.setID(ID);
        this.setType(type);
        this.setFunds(funds);
        this.setOwnerPNC(ownerPNC);
        this.setCreationDate(creationDate);
    }

    public Account(int ID,String type,long funds,long ownerPNC)
    {
        this.setID(ID);
        this.setType(type);
        this.setFunds(funds);
        this.setOwnerPNC(ownerPNC);
        this.setCreationDate(new Date());
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getFunds() {
        return funds;
    }

    public void setFunds(long funds) {
        this.funds = funds;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public long getOwnerPNC() {
        return ownerPNC;
    }

    public void setOwnerPNC(long ownerPNC) {
        this.ownerPNC = ownerPNC;
    }
}