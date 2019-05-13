package com.pj.model;

/**
 * Created on 2019/5/13 18:42
 * 条件类  / condition also means role
 * @author pj Deng
 */
public class StageCondition {
    private boolean caseThree ;
    private boolean caseFive ;
    private boolean caseThreeAndFive ;

    public StageCondition() {
    }

    /**
     * 根据序号得出规则  / get role by index number
     * @param index pupil's index number
     */
    public StageCondition(Integer index) {
        this.caseThree = (index % 3 == 0);
        this.caseFive = (index % 5 == 0);
        this.caseThreeAndFive = (index % 3 == 0 && index % 5 == 0);
    }

    //setter and getter

    public boolean isCaseThree() {
        return caseThree;
    }

    public void setCaseThree(boolean caseThree) {
        this.caseThree = caseThree;
    }

    public boolean isCaseFive() {
        return caseFive;
    }

    public void setCaseFive(boolean caseFive) {
        this.caseFive = caseFive;
    }

    public boolean isCaseThreeAndFive() {
        return caseThreeAndFive;
    }

    public void setCaseThreeAndFive(boolean caseThreeAndFive) {
        this.caseThreeAndFive = caseThreeAndFive;
    }
}
