package com.ccsoft.yunqudao.ui.customers;

import java.util.ArrayList;
import java.util.List;

public class IntentServiceResult {
    ArrayList<Integer> list = new ArrayList<>();
    List<String> lists = new ArrayList<>();
    IntentServiceResult(ArrayList<Integer> list,List<String> lists){
        this.list = list;
        this.lists = lists;
    }

    public List<String> getLists() {
        return lists;
    }

    public ArrayList<Integer> getList() {

        return list;
    }
}
