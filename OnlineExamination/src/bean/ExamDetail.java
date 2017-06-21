package bean;

/**
 * Created by hp on 3/30/2016.
 */
public class ExamDetail {
    int id,total;
    private String name;
    private String dept;
    private String sub1;
    private String sub2;
    private String sub3;

    public void setid(int i)
    {
        id=i;
    }
    public Integer getid()
    {
        return id;
    }

    public void setTotal(int j)
    {
        total=j;
    }
    public Integer getTotal()
    {
        return total;
    }


    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String title) {
        this.dept = title;
    }

    public String getSub1() {
        return sub1;
    }

    public void setSub1(String title) {
        this.sub1 = title;
    }

    public String getSub2() {
        return sub2;
    }

    public void setSub2(String title) {
        this.sub2 = title;
    }

    public String getSub3() {
        return sub3;
    }

    public void setSub3(String title) {
        this.sub3 = title;
    }




}


