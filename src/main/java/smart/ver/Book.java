package smart.ver;

/**
 * Bookクラス（タイトル,著者,番号）
 */
public class Book {

  private int isbn;
  private String title;
  private String author;

  public Book(int isbn, String title, String author) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
  }

  public int getIsbn() {
    return isbn;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }
}
