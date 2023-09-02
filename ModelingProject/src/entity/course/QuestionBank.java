package entity.course;

import entity.course.material.MCQ;
import entity.course.material.TrueOrFalse;

import java.util.*;

public class QuestionBank {
    private int nextMcqId = 1;
    private int nextTOFId = 1;
    private HashMap<Integer, MCQ> mcqList = new HashMap<>();
    private HashMap<Integer, TrueOrFalse> trueOrFalseList = new HashMap<>();

    public void addMCQ(MCQ question) {
        mcqList.put(nextMcqId++, question);
    }

    public void addTrueOrFalse(TrueOrFalse question) {
        trueOrFalseList.put(nextTOFId++, question);
    }

    public MCQ getMCQ(int id) {
        return mcqList.get(id);
    }

    public TrueOrFalse getTrueOrFalse(int id) {
        return trueOrFalseList.get(id);
    }
}
