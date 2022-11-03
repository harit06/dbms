package com.app.wrapper.comporator;

import com.app.wrapper.DatasetWrapper;

import java.util.Comparator;

public class TitleComparator implements Comparator<DatasetWrapper> {
    public int compare(DatasetWrapper o1,DatasetWrapper o2){
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
