package cn.appsys.pojo;

import java.util.Date;

public class Student {
	private Integer sId;// 主键id
	private String sName;// 学生姓名
	private Integer sAge;// 年龄
	private Date sBornDate;// 出生日期
	private String sHobby;// 爱好
	private String sAddress;// 地址
	private String sPhone;// 电话

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Integer getsAge() {
		return sAge;
	}

	public void setsAge(Integer sAge) {
		this.sAge = sAge;
	}

	public Date getsBornDate() {
		return sBornDate;
	}

	public void setsBornDate(Date sBornDate) {
		this.sBornDate = sBornDate;
	}

	public String getsHobby() {
		return sHobby;
	}

	public void setsHobby(String sHobby) {
		this.sHobby = sHobby;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public String getsPhone() {
		return sPhone;
	}

	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}

}
