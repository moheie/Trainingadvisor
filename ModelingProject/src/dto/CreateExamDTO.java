package dto;

import java.util.ArrayList;
import java.util.List;

public class CreateExamDTO {
    private List<Integer> mcqList;
    private List<Integer> tofList;

    public CreateExamDTO(List<Integer> mcqList, List<Integer> tofList) {
        this.mcqList = mcqList;
        this.tofList = tofList;
    }

    public CreateExamDTO() {
        this.mcqList = new ArrayList<>();
        this.tofList = new ArrayList<>();
    }

    public List<Integer> getMcqList() {
        return mcqList;
    }

    public List<Integer> getTofList() {
        return tofList;
    }

    public void addMCQ(int id) {
        mcqList.add(id);
    }

    public void addTrueOrFalse(int id) {
        tofList.add(id);
    }
}
