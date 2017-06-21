package bean;


public class QuesList {

    int id,marks,right_op,difficulty;
    private String name;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String subject;
    private String answered;
    private String fac;

    public String getAnswered() {
        return answered;
    }

    public void setAnswered(String title) {
        this.answered = title;
    }

    public void setquesid(int i)
    {
        id=i;
    }
    public Integer getquesid()
    {
        return id;
    }

    public void setMarks(int j)
    {
        marks=j;
    }
    public Integer getMarks()
    {
        return marks;
    }

    public String getQuestion() {
        return name;
    }

    public void setQuestion(String title) {
        this.name = title;
    }
    public String getFac_name() {
        return fac;
    }

    public void setFac_name(String title) {
        this.fac = title;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String title) {
        this.subject = title;
    }

    public String getOp1() {
        return option1;
    }


    public void setOp1(String title) {
        this.option1 = title;
    }

    public String getOp2() {
        return option2;
    }

    public void setOp2(String title) {
        this.option2 = title;
    }

    public String getOp3() {
        return option3;
    }

    public void setOp3(String title) {
        this.option3 = title;
    }


    public String getOp4() {
        return option4;
    }

    public void setOp4(String title) {
        this.option4 = title;
    }

    public int getRight_op() {
        return right_op;
    }

    public void setRight_op(int i) {
        this.right_op = i;
    }

    public void setDifficulty(int i)
    {
        difficulty=i;
    }
    public Integer getDifficulty()
    {
        return difficulty;
    }


}
