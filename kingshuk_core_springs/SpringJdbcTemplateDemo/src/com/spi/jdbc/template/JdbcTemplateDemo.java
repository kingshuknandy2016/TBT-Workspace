package com.spi.jdbc.template;

// 


import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo {
	
	JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;		
	}

	public void createTable() {
		jt.execute("create table SampleTest1(sno int, sname varchar(10))");
		// jt.execute();// returns void
		System.out.println("table created");
		
	}

	public void insertRecord() {
		String sql = "insert into SampleTest1 values(1,'New Entry')";
		jt.execute(sql);
		
		
		String sql1 = "insert into SampleTest1 values(2,'deepak')";
		jt.execute(sql1);		
		
		System.out.println("Inserted Successfully....");
	}
	
	
	public int updateRecord(){
		String sql="update SampleTest1 set sname='Amruta' where sno=1";
		return jt.update(sql);
	}

	public void loadAll() {	
		List l = jt.queryForList("select * from SampleTest1");
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			System.out.println(o.toString());
		}
	}
	
	public void test(){
		jt.execute("select *from sampletest1");
	}
	
	
	public void batchUpdateDemo() {
		
		String qry[]={
				"insert into SampleTest1 values(1,'New E-1')",
				"insert into SampleTest1 values(2,'New E-2')",
				"insert into SampleTest1 values(3,'New E-3')",
				"insert into SampleTest1 values(4,'New E-4')",
				"update SampleTest1 set sname='Exixst' where sno=3"
		};
		
		jt.batchUpdate(qry);
	}
	

}
