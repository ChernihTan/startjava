
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/
import java.nio.charset.Charset; // подключаем класс Charset,
import java.util.Scanner;

public class MyFirstApp {	
    public static void main(String[] args) {
        System.out.println(Charset.defaultCharset().displayName());
        System.out.println("Write once, run anywhere");
        System.out.println("Написано однажды, работает везде");

        Scanner console = new Scanner(System.in, "cp866");
        System.out.print("Введите свое имя: ");
        System.out.println(console.nextLine());
        // исправление
    }
}

