package com.aaa.bbb;

public class SimpleAttributes {

	private String author;
	private String title;
	private String wykonawca;
	private String gatunek;
	private String cena;
	private String podtytul;
	

	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWykonawca() {
		return wykonawca;
	}
	public void setWykonawca(String wykonawca) {
		this.wykonawca = wykonawca;
	}
	public String getGatunek() {
		return gatunek;
	}
	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}
	public String getCena() {
		return cena;
	}
	public void setCena(String cena) {
		this.cena = cena;
	}
	public String getPodtytul() {
		return podtytul;
	}
	public void setPodtytul(String podtytul) {
		this.podtytul = podtytul;
	}
	@Override
	public String toString() {
		return "SimpleAttributes [author=" + author + ", title=" + title + ", wykonawca=" + wykonawca + ", gatunek="
				+ gatunek + ", cena=" + cena + ", podtytul=" + podtytul + "]";
	}
	
	
	
}
