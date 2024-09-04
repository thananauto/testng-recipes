package com.qa.testng.utility;

import com.creditdatamw.zerocell.annotation.Column;
import com.creditdatamw.zerocell.annotation.RowNumber;
import lombok.Getter;

@Getter
public class PupilPojo {

    @RowNumber
    private int rowNumber;

    @Column(name = "Name", index = 0)
    private String name;
    @Column(name = "Block", index = 1)
    private String block;
    @Column(name = "Rank", index = 2)
    private int rank;

    @Column(name = "Total Mark", index = 3)
    private double marks;


    @Override
    public String toString() {
        return "PupilPojo{" +
                "rowNumber=" + rowNumber +
                ", name='" + name + '\'' +
                ", Block='" + block + '\'' +
                ", Rank='" + rank + '\'' +
                ", marks=" + marks +
                '}';
    }

}
