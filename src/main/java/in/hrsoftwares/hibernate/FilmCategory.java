package in.hrsoftwares.hibernate;
// Generated 27 Aug, 2016 4:54:04 PM by Hibernate Tools 5.1.0.Beta1

import java.util.Date;

/**
 * FilmCategory generated by hbm2java
 */
public class FilmCategory implements java.io.Serializable {

	private FilmCategoryId id;
	private Category category;
	private Film film;
	private Date lastUpdate;

	public FilmCategory() {
	}

	public FilmCategory(FilmCategoryId id, Category category, Film film, Date lastUpdate) {
		this.id = id;
		this.category = category;
		this.film = film;
		this.lastUpdate = lastUpdate;
	}

	public FilmCategoryId getId() {
		return this.id;
	}

	public void setId(FilmCategoryId id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
