package power.play;

/**
 * Bookクラス（タイトル,著者,番号）
 */
public class Book {

  private int number;
  private String title;
  private String author;

  public Book(int number, String title, String author) {
    this.number = number;
    this.title = title;
    this.author = author;
  }

  public int getNumber() {
    return number;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }
}
