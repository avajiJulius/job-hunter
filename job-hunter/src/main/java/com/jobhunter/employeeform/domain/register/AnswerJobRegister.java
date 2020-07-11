package com.jobhunter.employeeform.domain.register;

import java.util.ArrayList;
import java.util.List;

public class AnswerJobRegister {
    private List<AnswerJobRegisterItem> items;

    public void addItem(AnswerJobRegisterItem item) {
        if(items == null) {
            items = new ArrayList<>(10);
        }
        items.add(item);
    }

    public List<AnswerJobRegisterItem> getItems() {
        return items;
    }
}
