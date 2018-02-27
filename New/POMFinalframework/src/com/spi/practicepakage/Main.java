package com.spi.practicepakage;

import java.util.List;

import com.spi.data.ExcelLibrary;

public class Main {
     
	public static void main(String[] args) {
		ExcelLibrary ex=new ExcelLibrary("C:\\WorkSpace\\New\\POMFinalframework\\Lib\\KSRTC TestCase.xls");
		//String pathname=(String) ex.getCellData("ScenarioList", 7, 1);
        List li=ex.Pathfinder("CriticalPathFlow", 1);
        System.out.println("li:"+li);
}
	
}
