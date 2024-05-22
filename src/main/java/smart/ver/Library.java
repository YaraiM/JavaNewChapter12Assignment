package smart.ver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Libraryクラス：Bookクラスをインスタンス化し、リストを作成する。 タイトル検索、著者検索、番号検索メソッドを持つ。
 */
public class Library {

  // 書籍をインスタンス化（≒図書館に書籍を登録するイメージ）
  Book book1 = new Book(1, "Javaの教科書", "ジャバ・マスター");
  Book book2 = new Book(2, "Javaの参考書", "ジャバプロ");
  Book book3 = new Book(3, "Pythonの教科書", "パイソン・レディー");
  Book book4 = new Book(4, "Pythonの問題集", "ミスター・パイソン");
  Book book5 = new Book(5, "Rubyの教科書", "ルビィ紅玉");
  Book book6 = new Book(6, "元祖Rubyの本", "まつもとゆきひろ");
  Book book7 = new Book(7, "誰でもわかるHTML", "マーク上松");
  Book book8 = new Book(8, "JavaScriptを学ぶ", "前端");

  // 書籍を入れるリストを定義（≒本棚を用意するイメージ）
  static List<Book> bookList = new ArrayList<>();

  // Libraryのコンストラクタ（≒本棚に書籍を入れる作業の計画を立てるイメージ。この時点ではまだ入れていない。）
  public Library() {
    bookList.add(book1);
    bookList.add(book2);
    bookList.add(book3);
    bookList.add(book4);
    bookList.add(book5);
    bookList.add(book6);
    bookList.add(book7);
    bookList.add(book8);
  }

  //タイトル検索、著者検索、番号検索メソッド
  public static void search() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      try {
        System.out.println("番号検索：1、タイトル検索：2、著者検索：3");
        System.out.print("検索方法（1~3）を入力してください：");

        if (!scanner.hasNextInt()) {
          scanner.nextLine(); //入力後の改行をクリア
          throw new IllegalArgumentException("整数の1~3以外は入力できません!");
        }

        int inputCode = scanner.nextInt();
        scanner.nextLine(); //入力後の改行をクリア

        List<Book> resultList; //検索結果を格納するリストを定義

        // 番号検索
        if (inputCode == 1) {
          System.out.print("書籍番号を入力してください：");
          int inputNumber = scanner.nextInt();
          scanner.nextLine(); //入力後の改行をクリア
          resultList = bookList.stream()
              .filter(book -> book.getIsbn() == inputNumber)
              .collect(Collectors.toList());

          // タイトル検索
        } else if (inputCode == 2) {
          System.out.print("タイトルを入力してください：");
          String inputTitle = scanner.nextLine();
          resultList = bookList.stream()
              .filter(book -> book.getTitle().contains(inputTitle))
              .collect(Collectors.toList());

          // 著者検索
        } else if (inputCode == 3) {
          System.out.print("著者を入力してください：");
          String inputAuthor = scanner.nextLine();
          resultList = bookList.stream()
              .filter(book -> book.getAuthor().contains(inputAuthor))
              .collect(Collectors.toList());

          // 存在しない検索方法を選択した場合にエラーを返す
        } else {
          throw new IllegalArgumentException("整数の1~3以外は入力できません!");
        }

        // 検索結果を出力
        if (!resultList.isEmpty()) {
          resultList.forEach(book -> System.out.println(
              "番号：" + book.getIsbn() + "　書籍タイトル：" + book.getTitle() + "　著者："
                  + book.getAuthor()));
          System.out.println("条件に合致する書籍は" + resultList.size() + "冊です");
        } else {
          System.out.println("条件に合致する書籍はありません");
        }
        break;

      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
    scanner.close();
  }
}
