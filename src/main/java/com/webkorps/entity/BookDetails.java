package com.webkorps.entity;

public class BookDetails {
private Integer bId;
private String bookName;
private String author;
private String price;
private String img;
private String pdf;
private String status;
private String email;

public BookDetails() {
	super();
	// TODO Auto-generated constructor stub
}


public BookDetails(String bookName, String author, String price, String img, String pdf, String email) {
	super();
	this.bookName = bookName;
	this.author = author;
	this.price = price;
	this.img = img;
	this.pdf = pdf;
	this.status = status;
	this.email = email;
}


public Integer getbId() {
	return bId;
}
public void setbId(Integer bId) {
	this.bId = bId;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public String getPdf() {
	return pdf;
}
public void setPdf(String pdf) {
	this.pdf = pdf;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


@Override
public String toString() {
	return "BookDetails [bId=" + bId + ", bookName=" + bookName + ", author=" + author + ", price=" + price + ", img="
			+ img + ", pdf=" + pdf + ", status=" + status + ", email=" + email + "]";
}



}
