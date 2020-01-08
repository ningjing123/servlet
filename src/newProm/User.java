package newProm;

public class User {
private int uid;
private String uname;
private String upwd;
private int usex;
private int uage;

public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUpwd() {
	return upwd;
}
public void setUpwd(String upwd) {
	this.upwd = upwd;
}
public int getUsex() {
	return usex;
}
public void setUsex(int usex) {
	this.usex = usex;
}
public int getUage() {
	return uage;
}
public void setUage(int uage) {
	this.uage = uage;
}
@Override
public String toString() {
	return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", usex=" + usex + ", uage=" + uage + "]";
}


	
	
}
