package com.zyg.exam.model;

import java.io.Serializable;

/**
 * question
 * @author 
 */
public class Question implements Serializable {
    /**
     * 试题id
     */
    private Integer subjectid;

    /**
     * 试题类型
     */
    private String type;

    /**
     * 题目内容
     */
    private String content;

    /**
     * 选项1
     */
    private String option1;

    /**
     * 选项2
     */
    private String option2;

    /**
     * 选项3
     */
    private String option3;

    /**
     * 选项4
     */
    private String option4;

    /**
     * 答案
     */
    private String answer;

    /**
     * 难度
     */
    private String difficulty;

    /**
     * 章节id
     */
    private Integer chapterid;

    private static final long serialVersionUID = 1L;

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getChapterid() {
        return chapterid;
    }

    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Question other = (Question) that;
        return (this.getSubjectid() == null ? other.getSubjectid() == null : this.getSubjectid().equals(other.getSubjectid()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getOption1() == null ? other.getOption1() == null : this.getOption1().equals(other.getOption1()))
            && (this.getOption2() == null ? other.getOption2() == null : this.getOption2().equals(other.getOption2()))
            && (this.getOption3() == null ? other.getOption3() == null : this.getOption3().equals(other.getOption3()))
            && (this.getOption4() == null ? other.getOption4() == null : this.getOption4().equals(other.getOption4()))
            && (this.getAnswer() == null ? other.getAnswer() == null : this.getAnswer().equals(other.getAnswer()))
            && (this.getDifficulty() == null ? other.getDifficulty() == null : this.getDifficulty().equals(other.getDifficulty()))
            && (this.getChapterid() == null ? other.getChapterid() == null : this.getChapterid().equals(other.getChapterid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSubjectid() == null) ? 0 : getSubjectid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getOption1() == null) ? 0 : getOption1().hashCode());
        result = prime * result + ((getOption2() == null) ? 0 : getOption2().hashCode());
        result = prime * result + ((getOption3() == null) ? 0 : getOption3().hashCode());
        result = prime * result + ((getOption4() == null) ? 0 : getOption4().hashCode());
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
        result = prime * result + ((getDifficulty() == null) ? 0 : getDifficulty().hashCode());
        result = prime * result + ((getChapterid() == null) ? 0 : getChapterid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", subjectid=").append(subjectid);
        sb.append(", type=").append(type);
        sb.append(", content=").append(content);
        sb.append(", option1=").append(option1);
        sb.append(", option2=").append(option2);
        sb.append(", option3=").append(option3);
        sb.append(", option4=").append(option4);
        sb.append(", answer=").append(answer);
        sb.append(", difficulty=").append(difficulty);
        sb.append(", chapterid=").append(chapterid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}