package com.qa.testng.utility;

import com.creditdatamw.zerocell.annotation.Column;
import com.creditdatamw.zerocell.annotation.RowNumber;
import lombok.Getter;

@Getter
public class MathsPojo {
    @RowNumber
    private int rowNumber;

    @Column(name = "Input1", index = 0, convertorClass = Integer.class)
    private int input1;

    @Column(name = "Input2", index = 1, convertorClass = Integer.class)
    private int input2;

}
