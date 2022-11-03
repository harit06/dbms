package com.app.wrapper;

import com.opencsv.bean.CsvBindByName;

import java.util.Comparator;

public class DatasetWrapper {

    @CsvBindByName(column = "authors", required = false)
    private String authors;

    @CsvBindByName(column = "bestsellers-rank", required = false)

    private String bestSellersRank;

    @CsvBindByName(column = "categories", required = false)
    private String categories;

    @CsvBindByName(column = "description", required = false)
    private String description;

    @CsvBindByName(column = "dimension-x", required = false)
    private String dimensionX;

    @CsvBindByName(column = "dimension-y", required = false)
    private String dimensionY;

    @CsvBindByName(column = "dimension-z", required = false)
    private String dimensionZ;

    @CsvBindByName(column = "edition", required = false)
    private String edition;

    @CsvBindByName(column = "edition-statement", required = false)
    private String editionStatement;

    @CsvBindByName(column = "for-ages", required = false)
    private String forAges;

    @CsvBindByName(column = "format", required = false)
    private String format;

    @CsvBindByName(column = "id", required = false)
    private String id;

    @CsvBindByName(column = "illustrations-note", required = false)
    private String illustrationsNote;

    @CsvBindByName(column = "image-checksum", required = false)
    private String imageChecksum;

    @CsvBindByName(column = "image-path", required = false)
    private String imagePath;

    @CsvBindByName(column = "image-url", required = false)
    private String imageUrl;

    @CsvBindByName(column = "imprint", required = false)
    private String imprint;

    @CsvBindByName(column = "index-date", required = false)
    private String indexDate;

    @CsvBindByName(column = "isbn10", required = false)
    private String isbn10;

    @CsvBindByName(column = "isbn13", required = false)
    private String isbn13;

    @CsvBindByName(column = "lang", required = false)
    private String lang;

    @CsvBindByName(column = "publication-date", required = false)
    private String publicationDate;

    @CsvBindByName(column = "publication-place", required = false)
    private String publicationPlace;

    @CsvBindByName(column = "rating-avg", required = false)
    private String ratingAvg;

    @CsvBindByName(column = "rating-count", required = false)
    private String ratingCount;

    @CsvBindByName(column = "title", required = true)
    private String title;

    @CsvBindByName(column = "url", required = false)
    private String url;

    @CsvBindByName(column = "weight", required = false)
    private String weight;

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getBestSellersRank() {
        return bestSellersRank;
    }

    public void setBestSellersRank(String bestSellersRank) {
        this.bestSellersRank = bestSellersRank;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensionX() {
        return dimensionX;
    }

    public void setDimensionX(String dimensionX) {
        this.dimensionX = dimensionX;
    }

    public String getDimensionY() {
        return dimensionY;
    }

    public void setDimensionY(String dimensionY) {
        this.dimensionY = dimensionY;
    }

    public String getDimensionZ() {
        return dimensionZ;
    }

    public void setDimensionZ(String dimensionZ) {
        this.dimensionZ = dimensionZ;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getEditionStatement() {
        return editionStatement;
    }

    public void setEditionStatement(String editionStatement) {
        this.editionStatement = editionStatement;
    }

    public String getForAges() {
        return forAges;
    }

    public void setForAges(String forAges) {
        this.forAges = forAges;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIllustrationsNote() {
        return illustrationsNote;
    }

    public void setIllustrationsNote(String illustrationsNote) {
        this.illustrationsNote = illustrationsNote;
    }

    public String getImageChecksum() {
        return imageChecksum;
    }

    public void setImageChecksum(String imageChecksum) {
        this.imageChecksum = imageChecksum;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImprint() {
        return imprint;
    }

    public void setImprint(String imprint) {
        this.imprint = imprint;
    }

    public String getIndexDate() {
        return indexDate;
    }

    public void setIndexDate(String indexDate) {
        this.indexDate = indexDate;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublicationPlace() {
        return publicationPlace;
    }

    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }

    public String getRatingAvg() {
        return ratingAvg;
    }

    public void setRatingAvg(String ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

    public String getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(String ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "DatasetWrapper{" +
                "authors='" + authors + '\'' +
                ", bestSellersRank='" + bestSellersRank + '\'' +
                ", categories='" + categories + '\'' +
                ", description='" + description + '\'' +
                ", dimensionX='" + dimensionX + '\'' +
                ", dimensionY='" + dimensionY + '\'' +
                ", dimensionZ='" + dimensionZ + '\'' +
                ", edition='" + edition + '\'' +
                ", editionStatement='" + editionStatement + '\'' +
                ", forAges='" + forAges + '\'' +
                ", format='" + format + '\'' +
                ", id='" + id + '\'' +
                ", illustrationsNote='" + illustrationsNote + '\'' +
                ", imageChecksum='" + imageChecksum + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", imprint='" + imprint + '\'' +
                ", indexDate='" + indexDate + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", lang='" + lang + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", publicationPlace='" + publicationPlace + '\'' +
                ", ratingAvg='" + ratingAvg + '\'' +
                ", ratingCount='" + ratingCount + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
