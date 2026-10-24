import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("================ МЕНЮ ================");
            System.out.println(" ПР1 ч.1:  1 - сумма/среднее (for)      2 - ввод массива (while, do while)");
            System.out.println("           3 - аргументы командной строки 4 - гармонический ряд");
            System.out.println("           5 - факториал");
            System.out.println(" ПР1 доп.: 6 - поиск ошибок + Rectangle + Stock");
            System.out.println(" ПР2:      7 - Author");
            System.out.println(" ПР3:      8 - Shape (полиморфизм)       9 - Movable");
            System.out.println(" ПР4:     10 - Времена года  11 - Ателье  12 - Интернет-магазин  13 - Компьютер");
            System.out.println(" ПР4.1:   14..23 - задания 1..10");
            System.out.println("          99 - запустить все НЕинтерактивные задания подряд");
            System.out.println("           0 - выход");
            System.out.print("Ваш выбор: ");

            if (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Нужно ввести число.");
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0: System.out.println("Пока!"); return;
                case 1: Pr1.task3(); break;
                case 2: Pr1.task4(sc); break;
                case 3: Pr1.task5(args); break;
                case 4: Pr1.task6(); break;
                case 5: Pr1.task7(); break;
                case 6: Pr1Dop.run(); break;
                case 7: Pr2.TestAuthor.run(); break;
                case 8: Pr3.TestShape.run(); break;
                case 9: Pr3.TestMovable.run(); break;
                case 10: Pr4.task1(); break;
                case 11: Pr4.task2(); break;
                case 12: Pr4.task3(sc); break;
                case 13: Pr4.task4(); break;
                case 14: Pr41.task1(); break;
                case 15: Pr41.task2(); break;
                case 16: Pr41.task3(); break;
                case 17: Pr41.task4(); break;
                case 18: Pr41.task5(); break;
                case 19: Pr41.task6(); break;
                case 20: Pr41.task7(); break;
                case 21: Pr41.task8(); break;
                case 22: Pr41.task9(); break;
                case 23: Pr41.task10(); break;
                case 99: runAll(args); break;
                default: System.out.println("Нет такого пункта.");
            }
        }
    }

    static void runAll(String[] args) {
        Pr1.task3(); Pr1.task5(args); Pr1.task6(); Pr1.task7();
        Pr1Dop.run();
        Pr2.TestAuthor.run();
        Pr3.TestShape.run(); Pr3.TestMovable.run();
        Pr4.task1(); Pr4.task2(); Pr4.task4();
        Pr41.task1(); Pr41.task2(); Pr41.task3(); Pr41.task4(); Pr41.task5();
        Pr41.task6(); Pr41.task7(); Pr41.task8(); Pr41.task9(); Pr41.task10();
    }

    static void title(String s) {
        System.out.println();
        System.out.println("---------- " + s + " ----------");
    }
}

class Pr1 {
    static void task3() {
        Main.title("ПР1 Задание 3: сумма и среднее (for)");
        int[] arr = {5, 12, -3, 8, 20, 7};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double avg = (double) sum / arr.length;
        System.out.print("Массив: ");
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
        System.out.println();
        System.out.println("Сумма = " + sum);
        System.out.printf("Среднее арифметическое = %.2f%n", avg);
    }

    static void task4(Scanner sc) {
        Main.title("ПР1 Задание 4: ввод массива");
        System.out.print("Введите количество элементов: ");
        int n = sc.nextInt();
        while (n <= 0) {
            System.out.print("Количество должно быть больше 0, введите ещё раз: ");
            n = sc.nextInt();
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt();
        }
        sc.nextLine();

        int sumWhile = 0;
        int i = 0;
        while (i < n) {
            sumWhile += arr[i];
            i++;
        }

        int sumDoWhile = 0;
        int j = 0;
        do {
            sumDoWhile += arr[j];
            j++;
        } while (j < n);

        int max = arr[0];
        int min = arr[0];
        for (int k = 1; k < n; k++) {
            if (arr[k] > max) max = arr[k];
            if (arr[k] < min) min = arr[k];
        }

        System.out.println("Сумма (while)    = " + sumWhile);
        System.out.println("Сумма (do while) = " + sumDoWhile);
        System.out.println("Максимум = " + max);
        System.out.println("Минимум  = " + min);
    }

    static void task5(String[] args) {
        Main.title("ПР1 Задание 5: аргументы командной строки");
        if (args.length == 0) {
            System.out.println("Аргументов нет. Задайте их: Run -> Edit Configurations -> Program arguments");
        }
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }
    }

    static void task6() {
        Main.title("ПР1 Задание 6: гармонический ряд");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%2d) 1/%-2d = %.4f%n", i, i, 1.0 / i);
        }
    }

    static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static void task7() {
        Main.title("ПР1 Задание 7: факториал");
        for (int n = 0; n <= 10; n++) {
            System.out.println(n + "! = " + factorial(n));
        }
        System.out.println("20! = " + factorial(20) + " (больше long не вместит)");
    }
}

class Pr1Dop {
    static class A {
        String s;
        A() { s = "строка по умолчанию"; }
        A(String newS) { s = newS; }
        public void print() { System.out.println(s); }
    }

    static class A2 {
        boolean x;
    }

    static class Rectangle {
        double width = -1;
        double height = -1;

        Rectangle() {
        }

        Rectangle(double newWidth, double newHeight) {
            width = newWidth;
            height = newHeight;
        }

        double getArea() {
            return width * height;
        }

        double getPerimeter() {
            return 2 * (width + height);
        }
    }

    static class Stock {
        String symbol;
        String name;
        double previousClosingPrice;
        double currentPrice;

        Stock(String newSymbol, String newName) {
            symbol = newSymbol;
            name = newName;
        }

        double getChangePercent() {
            return (currentPrice - previousClosingPrice) / previousClosingPrice * 100;
        }
    }

    static void run() {
        Main.title("ПР1 доп. Задание 1: исправленный класс A");
        A a1 = new A();
        a1.print();
        A a2 = new A("Привет из конструктора A(String)");
        a2.print();

        Main.title("ПР1 доп. Задание 2: значение boolean по умолчанию");
        A2 a = new A2();
        System.out.println(a.x);

        Main.title("ПР1 доп. Задание №1: Rectangle");
        Rectangle r1 = new Rectangle(4, 40);
        Rectangle r2 = new Rectangle(3.5, 35.9);
        Rectangle[] rects = {r1, r2};
        for (int i = 0; i < rects.length; i++) {
            System.out.println("Прямоугольник " + (i + 1) + ":");
            System.out.println("  ширина   = " + rects[i].width);
            System.out.println("  высота   = " + rects[i].height);
            System.out.printf("  площадь  = %.2f%n", rects[i].getArea());
            System.out.printf("  периметр = %.2f%n", rects[i].getPerimeter());
        }
        Rectangle def = new Rectangle();
        System.out.println("Прямоугольник по умолчанию: ширина = " + def.width + ", высота = " + def.height);

        Main.title("ПР1 доп. Задание №2: Stock");
        Stock stock = new Stock("SBER", "ПАО Сбербанк");
        stock.previousClosingPrice = 281.50;
        stock.currentPrice = 282.87;
        System.out.println("Акция: " + stock.symbol + " (" + stock.name + ")");
        System.out.println("Цена закрытия вчера: " + stock.previousClosingPrice);
        System.out.println("Текущая цена:        " + stock.currentPrice);
        System.out.printf("Изменение: %.2f%%%n", stock.getChangePercent());
    }
}

class Pr2 {
    static class Author {
        private String name;
        private String email;
        private char gender;

        public Author(String name, String email, char gender) {
            this.name = name;
            this.email = email;
            if (gender == 'M' || gender == 'F' || gender == 'U') {
                this.gender = gender;
            } else {
                this.gender = 'U';
            }
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public char getGender() {
            return gender;
        }

        @Override
        public String toString() {
            String g;
            if (gender == 'M') g = "m";
            else if (gender == 'F') g = "ms";
            else g = "u";
            return name + " (" + g + ") at " + email;
        }
    }

    static class TestAuthor {
        static void run() {
            Main.title("ПР2: Author");
            Author a1 = new Author("Tan Ah Teck", "ahTeck@somewhere.com", 'M');
            Author a2 = new Author("Sue Grant", "suGrant@somewhere.com", 'F');
            Author a3 = new Author("Anonymous", "anon@somewhere.com", 'U');

            System.out.println(a1);
            System.out.println(a2);
            System.out.println(a3);

            System.out.println("Имя: " + a1.getName() + ", email: " + a1.getEmail() + ", пол: " + a1.getGender());
            a1.setEmail("tan.new@mail.ru");
            System.out.println("После setEmail: " + a1);
        }
    }
}

class Pr3 {
    static abstract class Shape {
        protected String color;
        protected boolean filled;

        public Shape() {
            color = "red";
            filled = true;
        }

        public Shape(String color, boolean filled) {
            this.color = color;
            this.filled = filled;
        }

        public String getColor() { return color; }
        public void setColor(String color) { this.color = color; }
        public boolean isFilled() { return filled; }
        public void setFilled(boolean filled) { this.filled = filled; }

        public abstract double getArea();
        public abstract double getPerimeter();

        @Override
        public String toString() {
            return "Shape[color=" + color + ", filled=" + filled + "]";
        }
    }

    static class Circle extends Shape {
        protected double radius;

        public Circle() {
            super();
            radius = 1.0;
        }

        public Circle(double radius) {
            super();
            this.radius = radius;
        }

        public Circle(double radius, String color, boolean filled) {
            super(color, filled);
            this.radius = radius;
        }

        public double getRadius() { return radius; }
        public void setRadius(double radius) { this.radius = radius; }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public String toString() {
            return "Circle[" + super.toString() + ", radius=" + radius + "]";
        }
    }

    static class Rectangle extends Shape {
        protected double width;
        protected double length;

        public Rectangle() {
            super();
            width = 1.0;
            length = 1.0;
        }

        public Rectangle(double width, double length) {
            super();
            this.width = width;
            this.length = length;
        }

        public Rectangle(double width, double length, String color, boolean filled) {
            super(color, filled);
            this.width = width;
            this.length = length;
        }

        public double getWidth() { return width; }
        public void setWidth(double width) { this.width = width; }
        public double getLength() { return length; }
        public void setLength(double length) { this.length = length; }

        @Override
        public double getArea() {
            return width * length;
        }

        @Override
        public double getPerimeter() {
            return 2 * (width + length);
        }

        @Override
        public String toString() {
            return "Rectangle[" + super.toString() + ", width=" + width + ", length=" + length + "]";
        }
    }

    static class Square extends Rectangle {
        public Square() {
            super(1.0, 1.0);
        }

        public Square(double side) {
            super(side, side);
        }

        public Square(double side, String color, boolean filled) {
            super(side, side, color, filled);
        }

        public double getSide() { return width; }

        public void setSide(double side) {
            width = side;
            length = side;
        }

        @Override
        public void setWidth(double side) { setSide(side); }

        @Override
        public void setLength(double side) { setSide(side); }

        @Override
        public String toString() {
            return "Square[" + super.toString() + "]";
        }
    }

    static class TestShape {
        static void run() {
            Main.title("ПР3 Задание 1: Shape и полиморфизм");

            Shape s1 = new Circle(5.5, "RED", false);
            System.out.println(s1);
            System.out.println(s1.getArea());
            System.out.println(s1.getPerimeter());
            System.out.println(s1.getColor());
            System.out.println(s1.isFilled());

            Circle c1 = (Circle) s1;
            System.out.println(c1);
            System.out.println(c1.getArea());
            System.out.println(c1.getPerimeter());
            System.out.println(c1.getColor());
            System.out.println(c1.isFilled());
            System.out.println(c1.getRadius());

            Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
            System.out.println(s3);
            System.out.println(s3.getArea());
            System.out.println(s3.getPerimeter());
            System.out.println(s3.getColor());

            Rectangle r1 = (Rectangle) s3;
            System.out.println(r1);
            System.out.println(r1.getArea());
            System.out.println(r1.getColor());
            System.out.println(r1.getLength());

            Shape s4 = new Square(6.6);
            System.out.println(s4);
            System.out.println(s4.getArea());
            System.out.println(s4.getColor());

            Rectangle r2 = (Rectangle) s4;
            System.out.println(r2);
            System.out.println(r2.getArea());
            System.out.println(r2.getColor());

            System.out.println(r2.getLength());

            Square sq1 = (Square) r2;
            System.out.println(sq1);
            System.out.println(sq1.getArea());
            System.out.println(sq1.getColor());
            System.out.println(sq1.getSide());
            System.out.println(sq1.getLength());

            try {
                Rectangle wrong = (Rectangle) s1;
                System.out.println(wrong);
            } catch (ClassCastException e) {
                System.out.println("ClassCastException: Circle нельзя привести к Rectangle");
            }
        }
    }

    interface Movable {
        void moveUp();
        void moveDown();
        void moveLeft();
        void moveRight();
    }

    static class MovablePoint implements Movable {
        int x;
        int y;
        int xSpeed;
        int ySpeed;

        public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
            this.x = x;
            this.y = y;
            this.xSpeed = xSpeed;
            this.ySpeed = ySpeed;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ") скорость=(" + xSpeed + "," + ySpeed + ")";
        }

        @Override public void moveUp()    { y -= ySpeed; }
        @Override public void moveDown()  { y += ySpeed; }
        @Override public void moveLeft()  { x -= xSpeed; }
        @Override public void moveRight() { x += xSpeed; }
    }

    static class MovableCircle implements Movable {
        private int radius;
        private MovablePoint center;

        public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
            center = new MovablePoint(x, y, xSpeed, ySpeed);
            this.radius = radius;
        }

        @Override
        public String toString() {
            return "MovableCircle[центр=" + center + ", радиус=" + radius + "]";
        }

        @Override public void moveUp()    { center.moveUp(); }
        @Override public void moveDown()  { center.moveDown(); }
        @Override public void moveLeft()  { center.moveLeft(); }
        @Override public void moveRight() { center.moveRight(); }
    }

    static class MovableRectangle implements Movable {
        private MovablePoint topLeft;
        private MovablePoint bottomRight;

        public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
            topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
            bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
        }

        public boolean isSameSpeed() {
            return topLeft.xSpeed == bottomRight.xSpeed && topLeft.ySpeed == bottomRight.ySpeed;
        }

        @Override
        public String toString() {
            return "MovableRectangle[верх-лево=" + topLeft + ", низ-право=" + bottomRight + "]";
        }

        @Override
        public void moveUp() {
            if (isSameSpeed()) { topLeft.moveUp(); bottomRight.moveUp(); }
            else System.out.println("Скорости точек разные — прямоугольник не двигается!");
        }

        @Override
        public void moveDown() {
            if (isSameSpeed()) { topLeft.moveDown(); bottomRight.moveDown(); }
            else System.out.println("Скорости точек разные — прямоугольник не двигается!");
        }

        @Override
        public void moveLeft() {
            if (isSameSpeed()) { topLeft.moveLeft(); bottomRight.moveLeft(); }
            else System.out.println("Скорости точек разные — прямоугольник не двигается!");
        }

        @Override
        public void moveRight() {
            if (isSameSpeed()) { topLeft.moveRight(); bottomRight.moveRight(); }
            else System.out.println("Скорости точек разные — прямоугольник не двигается!");
        }
    }

    static class TestMovable {
        static void run() {
            Main.title("ПР3 Задание 2: интерфейс Movable");

            Movable p = new MovablePoint(0, 0, 2, 3);
            System.out.println("Точка: " + p);
            p.moveRight(); p.moveDown();
            System.out.println("После вправо+вниз: " + p);

            Movable c = new MovableCircle(10, 10, 1, 1, 5);
            System.out.println(c);
            c.moveLeft(); c.moveUp();
            System.out.println("После влево+вверх: " + c);

            MovableRectangle r = new MovableRectangle(0, 0, 4, 3, 2, 2);
            System.out.println(r);
            System.out.println("Скорости одинаковые? " + r.isSameSpeed());
            r.moveRight(); r.moveDown();
            System.out.println("После вправо+вниз: " + r);

            Movable[] all = {p, c, r};
            for (int i = 0; i < all.length; i++) {
                all[i].moveUp();
                System.out.println("moveUp(): " + all[i]);
            }
        }
    }
}

class Pr4 {
    enum Season {
        WINTER("Зима", -10),
        SPRING("Весна", 8),
        SUMMER("Лето", 22) {
            @Override
            public String getDescription() {
                return "Теплое время года";
            }
        },
        AUTUMN("Осень", 6);

        private final String russianName;
        private final int averageTemperature;

        Season(String russianName, int averageTemperature) {
            this.russianName = russianName;
            this.averageTemperature = averageTemperature;
        }

        public String getRussianName() { return russianName; }
        public int getAverageTemperature() { return averageTemperature; }

        public String getDescription() {
            return "Холодное время года";
        }
    }

    static void loveSeason(Season s) {
        switch (s) {
            case WINTER: System.out.println("Я люблю зиму"); break;
            case SPRING: System.out.println("Я люблю весну"); break;
            case SUMMER: System.out.println("Я люблю лето"); break;
            case AUTUMN: System.out.println("Я люблю осень"); break;
        }
    }

    static void task1() {
        Main.title("ПР4 Задание 1: Времена года");

        Season favorite = Season.SUMMER;
        System.out.println("Любимое время года: " + favorite.getRussianName()
                + " (" + favorite.name() + ")");
        System.out.println("  порядковый номер (ordinal): " + favorite.ordinal());
        System.out.println("  средняя температура: " + favorite.getAverageTemperature() + " °C");
        System.out.println("  описание: " + favorite.getDescription());

        loveSeason(favorite);
        loveSeason(Season.valueOf("WINTER"));

        System.out.println("Все времена года:");
        Season[] all = Season.values();
        for (int i = 0; i < all.length; i++) {
            System.out.println("  " + all[i].getRussianName() + ": "
                    + all[i].getAverageTemperature() + " °C, " + all[i].getDescription());
        }
    }

    enum Size {
        XXS(32) {
            @Override
            public String getDescription() {
                return "Детский размер";
            }
        },
        XS(34), S(36), M(38), L(40);

        private final int euroSize;

        Size(int euroSize) {
            this.euroSize = euroSize;
        }

        public int getEuroSize() { return euroSize; }

        public String getDescription() {
            return "Взрослый размер";
        }
    }

    interface MenClothing {
        void dressMan();
    }

    interface WomenClothing {
        void dressWomen();
    }

    static abstract class Clothes {
        protected Size size;
        protected double price;
        protected String color;

        public Clothes(Size size, double price, String color) {
            this.size = size;
            this.price = price;
            this.color = color;
        }

        public abstract String getName();

        public String getInfo() {
            return getName() + ": размер " + size + " (EU " + size.getEuroSize() + ", "
                    + size.getDescription() + "), цвет " + color + ", цена " + price + " руб.";
        }
    }

    static class TShirt extends Clothes implements MenClothing, WomenClothing {
        public TShirt(Size size, double price, String color) { super(size, price, color); }
        public String getName() { return "Футболка"; }
        @Override public void dressMan() { System.out.println("  [мужская] " + getInfo()); }
        @Override public void dressWomen() { System.out.println("  [женская] " + getInfo()); }
    }

    static class Pants extends Clothes implements MenClothing, WomenClothing {
        public Pants(Size size, double price, String color) { super(size, price, color); }
        public String getName() { return "Штаны"; }
        @Override public void dressMan() { System.out.println("  [мужская] " + getInfo()); }
        @Override public void dressWomen() { System.out.println("  [женская] " + getInfo()); }
    }

    static class Skirt extends Clothes implements WomenClothing {
        public Skirt(Size size, double price, String color) { super(size, price, color); }
        public String getName() { return "Юбка"; }
        @Override public void dressWomen() { System.out.println("  [женская] " + getInfo()); }
    }

    static class Tie extends Clothes implements MenClothing {
        public Tie(Size size, double price, String color) { super(size, price, color); }
        public String getName() { return "Галстук"; }
        @Override public void dressMan() { System.out.println("  [мужская] " + getInfo()); }
    }

    static class Atelier {
        public void dressWomen(Clothes[] clothes) {
            System.out.println("Одеваем женщину:");
            for (int i = 0; i < clothes.length; i++) {
                if (clothes[i] instanceof WomenClothing) {
                    ((WomenClothing) clothes[i]).dressWomen();
                }
            }
        }

        public void dressMan(Clothes[] clothes) {
            System.out.println("Одеваем мужчину:");
            for (int i = 0; i < clothes.length; i++) {
                if (clothes[i] instanceof MenClothing) {
                    ((MenClothing) clothes[i]).dressMan();
                }
            }
        }
    }

    static void task2() {
        Main.title("ПР4 Задание 2: Ателье");
        Clothes[] clothes = {
                new TShirt(Size.M, 1200, "белый"),
                new Pants(Size.L, 3500, "черный"),
                new Skirt(Size.XS, 2700, "красный"),
                new Tie(Size.S, 900, "синий"),
                new TShirt(Size.XXS, 700, "желтый")
        };
        Atelier atelier = new Atelier();
        atelier.dressWomen(clothes);
        atelier.dressMan(clothes);
    }

    enum Category {
        ELECTRONICS("Электроника"),
        CLOTHES("Одежда"),
        BOOKS("Книги");

        private final String title;

        Category(String title) { this.title = title; }

        public String getTitle() { return title; }
    }

    static class Product {
        String name;
        double price;
        Category category;

        Product(String name, double price, Category category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }
    }

    static class User {
        String login;
        String password;

        User(String login, String password) {
            this.login = login;
            this.password = password;
        }
    }

    static class Shop {
        User[] users = {
                new User("admin", "1234"),
                new User("lera", "java")
        };

        Product[] products = {
                new Product("Смартфон", 25000, Category.ELECTRONICS),
                new Product("Наушники", 3500, Category.ELECTRONICS),
                new Product("Ноутбук", 65000, Category.ELECTRONICS),
                new Product("Футболка", 1200, Category.CLOTHES),
                new Product("Джинсы", 3900, Category.CLOTHES),
                new Product("Java. Полное руководство", 2100, Category.BOOKS),
                new Product("Чистый код", 1500, Category.BOOKS)
        };

        Product[] cart = new Product[20];
        int cartCount = 0;
        User currentUser = null;

        boolean login(Scanner sc) {
            for (int attempt = 1; attempt <= 3; attempt++) {
                System.out.print("Логин: ");
                String l = sc.nextLine();
                System.out.print("Пароль: ");
                String p = sc.nextLine();
                for (int i = 0; i < users.length; i++) {
                    if (users[i].login.equals(l) && users[i].password.equals(p)) {
                        currentUser = users[i];
                        System.out.println("Добро пожаловать, " + l + "!");
                        return true;
                    }
                }
                System.out.println("Неверный логин или пароль. Осталось попыток: " + (3 - attempt));
            }
            return false;
        }

        void showCategories() {
            Category[] cats = Category.values();
            System.out.println("Каталоги:");
            for (int i = 0; i < cats.length; i++) {
                System.out.println("  " + (i + 1) + ") " + cats[i].getTitle());
            }
        }

        int showProducts(Category cat) {
            System.out.println("Товары каталога \"" + cat.getTitle() + "\":");
            int count = 0;
            for (int i = 0; i < products.length; i++) {
                if (products[i].category == cat) {
                    System.out.println("  " + (i + 1) + ") " + products[i].name + " — " + products[i].price + " руб.");
                    count++;
                }
            }
            return count;
        }

        void addToCart(int productIndex) {
            if (productIndex < 0 || productIndex >= products.length) {
                System.out.println("Нет такого товара.");
                return;
            }
            if (cartCount == cart.length) {
                System.out.println("Корзина заполнена.");
                return;
            }
            cart[cartCount] = products[productIndex];
            cartCount++;
            System.out.println("\"" + products[productIndex].name + "\" добавлен в корзину.");
        }

        void showCart() {
            if (cartCount == 0) {
                System.out.println("Корзина пуста.");
                return;
            }
            double total = 0;
            System.out.println("Корзина:");
            for (int i = 0; i < cartCount; i++) {
                System.out.println("  " + cart[i].name + " — " + cart[i].price + " руб.");
                total += cart[i].price;
            }
            System.out.println("Итого: " + total + " руб.");
        }

        void buy() {
            if (cartCount == 0) {
                System.out.println("Корзина пуста, покупать нечего.");
                return;
            }
            showCart();
            System.out.println("Покупка оформлена! Спасибо, " + currentUser.login + ".");
            cartCount = 0;
        }
    }

    static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.print("Введите число: ");
        }
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }

    static void task3(Scanner sc) {
        Main.title("ПР4 Задание 3: Интернет-магазин");
        System.out.println("(тестовые пользователи: admin / 1234, lera / java)");
        Shop shop = new Shop();
        if (!shop.login(sc)) {
            System.out.println("Вход не выполнен.");
            return;
        }
        while (true) {
            System.out.println();
            System.out.println("1 - каталоги  2 - товары каталога  3 - добавить в корзину");
            System.out.println("4 - корзина   5 - купить           0 - выйти из магазина");
            System.out.print("> ");
            int cmd = readInt(sc);
            if (cmd == 0) break;
            switch (cmd) {
                case 1:
                    shop.showCategories();
                    break;
                case 2: {
                    shop.showCategories();
                    System.out.print("Номер каталога: ");
                    int c = readInt(sc);
                    Category[] cats = Category.values();
                    if (c >= 1 && c <= cats.length) shop.showProducts(cats[c - 1]);
                    else System.out.println("Нет такого каталога.");
                    break;
                }
                case 3: {
                    System.out.print("Номер товара (из списка товаров): ");
                    int p = readInt(sc);
                    shop.addToCart(p - 1);
                    break;
                }
                case 4:
                    shop.showCart();
                    break;
                case 5:
                    shop.buy();
                    break;
                default:
                    System.out.println("Нет такой команды.");
            }
        }
    }

    enum Brand {
        APPLE, LENOVO, ASUS, HP, DELL, ACER
    }

    static class Processor {
        private String model;
        private int cores;
        private double frequencyGHz;

        public Processor(String model, int cores, double frequencyGHz) {
            this.model = model;
            this.cores = cores;
            this.frequencyGHz = frequencyGHz;
        }

        public String getModel() { return model; }
        public int getCores() { return cores; }
        public double getFrequencyGHz() { return frequencyGHz; }

        @Override
        public String toString() {
            return model + " (" + cores + " ядер, " + frequencyGHz + " ГГц)";
        }
    }

    static class Memory {
        private int sizeGb;
        private String type;

        public Memory(int sizeGb, String type) {
            this.sizeGb = sizeGb;
            this.type = type;
        }

        public int getSizeGb() { return sizeGb; }
        public void setSizeGb(int sizeGb) { this.sizeGb = sizeGb; }
        public String getType() { return type; }

        @Override
        public String toString() {
            return sizeGb + " ГБ " + type;
        }
    }

    static class Monitor {
        private double diagonal;
        private String resolution;

        public Monitor(double diagonal, String resolution) {
            this.diagonal = diagonal;
            this.resolution = resolution;
        }

        public double getDiagonal() { return diagonal; }
        public String getResolution() { return resolution; }

        @Override
        public String toString() {
            return diagonal + "\" " + resolution;
        }
    }

    static class Computer {
        private Brand brand;
        private Processor processor;
        private Memory memory;
        private Monitor monitor;
        private boolean on;

        public Computer(Brand brand, Processor processor, Memory memory, Monitor monitor) {
            this.brand = brand;
            this.processor = processor;
            this.memory = memory;
            this.monitor = monitor;
            this.on = false;
        }

        public void turnOn() {
            on = true;
            System.out.println(brand + ": компьютер включён");
        }

        public void turnOff() {
            on = false;
            System.out.println(brand + ": компьютер выключен");
        }

        public void upgradeMemory(int addGb) {
            memory.setSizeGb(memory.getSizeGb() + addGb);
            System.out.println(brand + ": добавлено " + addGb + " ГБ памяти, теперь " + memory);
        }

        public void printInfo() {
            System.out.println("Компьютер " + brand);
            System.out.println("  Процессор: " + processor);
            System.out.println("  Память:    " + memory);
            System.out.println("  Монитор:   " + monitor);
            System.out.println("  Состояние: " + (on ? "включён" : "выключен"));
        }
    }

    static void task4() {
        Main.title("ПР4 Задание 4: Компьютер");
        Computer pc1 = new Computer(Brand.LENOVO,
                new Processor("Intel Core i5-12400", 6, 2.5),
                new Memory(16, "DDR4"),
                new Monitor(23.8, "1920x1080"));
        Computer pc2 = new Computer(Brand.APPLE,
                new Processor("Apple M3", 8, 4.05),
                new Memory(8, "LPDDR5"),
                new Monitor(13.6, "2560x1664"));

        pc1.printInfo();
        pc1.turnOn();
        pc1.upgradeMemory(16);
        pc1.printInfo();
        pc1.turnOff();
        System.out.println();
        pc2.printInfo();

        System.out.print("Все марки (enum Brand): ");
        Brand[] brands = Brand.values();
        for (int i = 0; i < brands.length; i++) System.out.print(brands[i] + " ");
        System.out.println();
    }
}

class Pr41 {
    static class Shape {
        public String getType() { return "Фигура"; }
        public double getArea() { return 0; }
        public double getPerimeter() { return 0; }

        @Override
        public String toString() {
            return getType() + ": площадь = " + String.format("%.2f", getArea())
                    + ", периметр = " + String.format("%.2f", getPerimeter());
        }
    }

    static class Circle extends Shape {
        private double radius;
        public Circle(double radius) { this.radius = radius; }
        @Override public String getType() { return "Круг"; }
        @Override public double getArea() { return Math.PI * radius * radius; }
        @Override public double getPerimeter() { return 2 * Math.PI * radius; }
        @Override public String toString() { return super.toString() + ", радиус = " + radius; }
    }

    static class Rectangle extends Shape {
        protected double width, length;
        public Rectangle(double width, double length) { this.width = width; this.length = length; }
        @Override public String getType() { return "Прямоугольник"; }
        @Override public double getArea() { return width * length; }
        @Override public double getPerimeter() { return 2 * (width + length); }
        @Override public String toString() { return super.toString() + ", стороны = " + width + " x " + length; }
    }

    static class Square extends Rectangle {
        public Square(double side) { super(side, side); }
        @Override public String getType() { return "Квадрат"; }
        @Override public String toString() { return super.toString() + " (все стороны равны)"; }
    }

    static void task1() {
        Main.title("ПР4.1 Задание 1: Shape и наследование");
        Shape[] shapes = {new Shape(), new Circle(3), new Rectangle(2, 5), new Square(4)};
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i]);
        }
    }

    static class Phone {
        String number;
        String model;
        double weight;

        Phone() {
            this("не задан", "неизвестна");
        }

        Phone(String number, String model) {
            this.number = number;
            this.model = model;
        }

        Phone(String number, String model, double weight) {
            this(number, model);
            this.weight = weight;
        }

        void receiveCall(String name) {
            System.out.println("Звонит " + name);
        }

        void receiveCall(String name, String callerNumber) {
            System.out.println("Звонит " + name + " (" + callerNumber + ") на номер " + number);
        }

        String getNumber() {
            return number;
        }

        void sendMessage(String... numbers) {
            System.out.print("Сообщение с " + number + " отправлено на номера: ");
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i]);
                if (i < numbers.length - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }

    static void task2() {
        Main.title("ПР4.1 Задание 2: Phone");

        Phone p1 = new Phone("+7-900-111-22-33", "iPhone 15", 171);
        Phone p2 = new Phone("+7-911-444-55-66", "Samsung S24");
        Phone p3 = new Phone();
        Phone[] phones = {p1, p2, p3};

        for (int i = 0; i < phones.length; i++) {
            System.out.println("Телефон " + (i + 1) + ": номер = " + phones[i].number
                    + ", модель = " + phones[i].model + ", вес = " + phones[i].weight);
        }

        String[] callers = {"Мама", "Анна", "Дима"};
        for (int i = 0; i < phones.length; i++) {
            phones[i].receiveCall(callers[i]);
            System.out.println("getNumber(): " + phones[i].getNumber());
        }

        p1.receiveCall("Олег", "+7-999-000-11-22");

        p1.sendMessage("+7-901-000-00-01", "+7-902-000-00-02", "+7-903-000-00-03");
        p2.sendMessage("+7-904-000-00-04");
    }

    static class Person {
        String fullName;
        int age;

        Person() {
            fullName = "Неизвестный";
            age = 0;
        }

        Person(String fullName, int age) {
            this.fullName = fullName;
            this.age = age;
        }

        void move() {
            System.out.println(fullName + " идёт");
        }

        void talk() {
            System.out.println(fullName + " говорит");
        }
    }

    static void task3() {
        Main.title("ПР4.1 Задание 3: Person");
        Person p1 = new Person();
        Person p2 = new Person("Иванов Иван Иванович", 30);
        System.out.println(p1.fullName + ", возраст " + p1.age);
        p1.move(); p1.talk();
        System.out.println(p2.fullName + ", возраст " + p2.age);
        p2.move(); p2.talk();
    }

    static class Matrix {
        private double[][] data;
        private int rows;
        private int cols;

        public Matrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            data = new double[rows][cols];
        }

        public Matrix(double[][] values) {
            rows = values.length;
            cols = values[0].length;
            data = new double[rows][cols];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    data[i][j] = values[i][j];
        }

        public Matrix add(Matrix other) {
            if (rows != other.rows || cols != other.cols) {
                System.out.println("Ошибка: размеры матриц не совпадают");
                return null;
            }
            Matrix res = new Matrix(rows, cols);
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    res.data[i][j] = data[i][j] + other.data[i][j];
            return res;
        }

        public Matrix multiply(double k) {
            Matrix res = new Matrix(rows, cols);
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    res.data[i][j] = data[i][j] * k;
            return res;
        }

        public Matrix multiply(Matrix other) {
            if (cols != other.rows) {
                System.out.println("Ошибка: число столбцов первой матрицы != числу строк второй");
                return null;
            }
            Matrix res = new Matrix(rows, other.cols);
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < other.cols; j++) {
                    double sum = 0;
                    for (int k = 0; k < cols; k++)
                        sum += data[i][k] * other.data[k][j];
                    res.data[i][j] = sum;
                }
            return res;
        }

        public void print() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.printf("%8.2f", data[i][j]);
                }
                System.out.println();
            }
        }
    }

    static void task4() {
        Main.title("ПР4.1 Задание 4: Матрица");
        Matrix a = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        Matrix b = new Matrix(new double[][]{{6, 5, 4}, {3, 2, 1}});
        Matrix c = new Matrix(new double[][]{{1, 0}, {0, 1}, {2, 3}});
        System.out.println("A:"); a.print();
        System.out.println("B:"); b.print();
        System.out.println("A + B:"); a.add(b).print();
        System.out.println("A * 2.5:"); a.multiply(2.5).print();
        System.out.println("C:"); c.print();
        System.out.println("A * C:"); a.multiply(c).print();
    }

    static class Book {
        String title;
        String author;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }

    static class Reader {
        String fullName;
        int ticketNumber;
        String faculty;
        String birthDate;
        String phone;

        Reader(String fullName, int ticketNumber, String faculty, String birthDate, String phone) {
            this.fullName = fullName;
            this.ticketNumber = ticketNumber;
            this.faculty = faculty;
            this.birthDate = birthDate;
            this.phone = phone;
        }

        static String books(int n) {
            int n10 = n % 10, n100 = n % 100;
            if (n10 == 1 && n100 != 11) return n + " книгу";
            if (n10 >= 2 && n10 <= 4 && (n100 < 12 || n100 > 14)) return n + " книги";
            return n + " книг";
        }

        void takeBook(int count) {
            System.out.println(fullName + " взял " + books(count));
        }

        void takeBook(String... titles) {
            System.out.println(fullName + " взял книги: " + String.join(", ", titles));
        }

        void takeBook(Book... bookList) {
            System.out.println(fullName + " взял книги: " + titlesOf(bookList));
        }

        void returnBook(int count) {
            System.out.println(fullName + " вернул " + books(count));
        }

        void returnBook(String... titles) {
            System.out.println(fullName + " вернул книги: " + String.join(", ", titles));
        }

        void returnBook(Book... bookList) {
            System.out.println(fullName + " вернул книги: " + titlesOf(bookList));
        }

        private String titlesOf(Book[] bookList) {
            String s = "";
            for (int i = 0; i < bookList.length; i++) {
                s += bookList[i].title;
                if (i < bookList.length - 1) s += ", ";
            }
            return s;
        }

        void printInfo() {
            System.out.println(fullName + ", билет №" + ticketNumber + ", " + faculty
                    + ", д.р. " + birthDate + ", тел. " + phone);
        }
    }

    static void task5() {
        Main.title("ПР4.1 Задание 5: Читатели библиотеки");
        Reader[] readers = {
                new Reader("Петров В. В.", 1001, "Институт ИТ", "12.03.2004", "+7-900-123-45-67"),
                new Reader("Сидорова А. А.", 1002, "Экономический", "05.11.2005", "+7-911-765-43-21")
        };
        for (int i = 0; i < readers.length; i++) readers[i].printInfo();

        Reader petrov = readers[0];
        petrov.takeBook(3);
        petrov.takeBook("Приключения", "Словарь", "Энциклопедия");
        Book[] books = {
                new Book("Приключения", "Р. Стивенсон"),
                new Book("Словарь", "В. Даль"),
                new Book("Энциклопедия", "БРЭ")
        };
        petrov.takeBook(books);
        petrov.returnBook(books);
        petrov.returnBook("Приключения", "Словарь", "Энциклопедия");
        petrov.returnBook(3);
        readers[1].takeBook(1);
        readers[1].takeBook(5);
    }

    static class Employer {
        String firstName;
        String lastName;
        double income;

        Employer(String firstName, String lastName, double income) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.income = income;
        }

        double getIncome() {
            return income * 12;
        }
    }

    static class Manager extends Employer {
        double averageSum;

        Manager(String firstName, String lastName, double income, double averageSum) {
            super(firstName, lastName, income);
            this.averageSum = averageSum;
        }

        @Override
        double getIncome() {
            return super.getIncome() + averageSum * 12;
        }
    }

    static void task6() {
        Main.title("ПР4.1 Задание 6: Employer и Manager");

        Employer e = new Manager("Анна", "Смирнова", 90000, 25000);
        System.out.println("Employer-ссылка на Manager, доход за год: " + e.getIncome());

        Employer[] staff = {
                new Employer("Иван", "Петров", 60000),
                new Manager("Ольга", "Кузнецова", 80000, 20000),
                new Employer("Сергей", "Иванов", 55000),
                e
        };
        for (int i = 0; i < staff.length; i++) {
            String role = (staff[i] instanceof Manager) ? "менеджер" : "сотрудник";
            System.out.printf("%s %s (%s): доход за год = %.0f руб.%n",
                    staff[i].firstName, staff[i].lastName, role, staff[i].getIncome());
        }
    }

    static class Learner {
        String name;
        int age;

        Learner(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getInfo() {
            return name + ", " + age + " лет";
        }
    }

    static class Schoolboy extends Learner {
        int grade;

        Schoolboy(String name, int age, int grade) {
            super(name, age);
            this.grade = grade;
        }

        @Override
        String getInfo() {
            return "Школьник: " + super.getInfo() + ", " + grade + " класс";
        }
    }

    static class Student extends Learner {
        String university;
        int course;

        Student(String name, int age, String university, int course) {
            super(name, age);
            this.university = university;
            this.course = course;
        }

        @Override
        String getInfo() {
            return "Студент: " + super.getInfo() + ", " + university + ", " + course + " курс";
        }
    }

    static void task7() {
        Main.title("ПР4.1 Задание 7: Учащийся");
        Learner[] learners = {
                new Schoolboy("Миша", 12, 6),
                new Student("Лена", 20, "РТУ МИРЭА", 3),
                new Schoolboy("Катя", 16, 10),
                new Student("Артём", 19, "МГУ", 2),
                new Schoolboy("Петя", 8, 2)
        };
        System.out.println("Студенты:");
        for (int i = 0; i < learners.length; i++) {
            if (learners[i] instanceof Student) System.out.println("  " + learners[i].getInfo());
        }
        System.out.println("Школьники:");
        for (int i = 0; i < learners.length; i++) {
            if (learners[i] instanceof Schoolboy) System.out.println("  " + learners[i].getInfo());
        }
    }

    static void task8() {
        Main.title("ПР4.1 Задание 8: абстрактный Shape (реализация из ПР3)");
        Pr3.Shape[] shapes = {
                new Pr3.Circle(2.0, "green", true),
                new Pr3.Rectangle(3.0, 4.0, "blue", false),
                new Pr3.Square(5.0, "yellow", true)
        };
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i]);
            System.out.printf("  площадь = %.2f, периметр = %.2f%n",
                    shapes[i].getArea(), shapes[i].getPerimeter());
        }
    }

    static abstract class Furniture {
        protected String name;
        protected String material;
        protected double price;

        public Furniture(String name, String material, double price) {
            this.name = name;
            this.material = material;
            this.price = price;
        }

        public double getPrice() { return price; }

        public abstract String getType();

        public abstract String use();

        @Override
        public String toString() {
            return getType() + " \"" + name + "\" (" + material + ") — " + price + " руб.";
        }
    }

    static class Chair extends Furniture {
        private int legs;

        public Chair(String name, String material, double price, int legs) {
            super(name, material, price);
            this.legs = legs;
        }

        public String getType() { return "Стул"; }
        public String use() { return "на нём сидят (ножек: " + legs + ")"; }
    }

    static class Table extends Furniture {
        private int seats;

        public Table(String name, String material, double price, int seats) {
            super(name, material, price);
            this.seats = seats;
        }

        public String getType() { return "Стол"; }
        public String use() { return "за ним едят или работают (мест: " + seats + ")"; }
    }

    static class Sofa extends Furniture {
        private boolean folding;

        public Sofa(String name, String material, double price, boolean folding) {
            super(name, material, price);
            this.folding = folding;
        }

        public String getType() { return "Диван"; }
        public String use() { return folding ? "на нём отдыхают и спят (раскладной)" : "на нём отдыхают"; }
    }

    static class Wardrobe extends Furniture {
        private int doors;

        public Wardrobe(String name, String material, double price, int doors) {
            super(name, material, price);
            this.doors = doors;
        }

        public String getType() { return "Шкаф"; }
        public String use() { return "в нём хранят одежду (дверей: " + doors + ")"; }
    }

    static class FurnitureShop {
        private Furniture[] items = new Furniture[20];
        private int count = 0;

        public void add(Furniture f) {
            if (count < items.length) {
                items[count] = f;
                count++;
            }
        }

        public void showAll() {
            System.out.println("Ассортимент магазина:");
            for (int i = 0; i < count; i++) {
                System.out.println("  " + (i + 1) + ") " + items[i] + "; " + items[i].use());
            }
        }

        public void showCheaperThan(double maxPrice) {
            System.out.println("Дешевле " + maxPrice + " руб.:");
            for (int i = 0; i < count; i++) {
                if (items[i].getPrice() < maxPrice) System.out.println("  " + items[i]);
            }
        }

        public double totalPrice() {
            double sum = 0;
            for (int i = 0; i < count; i++) sum += items[i].getPrice();
            return sum;
        }
    }

    static void task9() {
        Main.title("ПР4.1 Задание 9: Магазин мебели");
        FurnitureShop shop = new FurnitureShop();
        shop.add(new Chair("Венский", "дерево", 4500, 4));
        shop.add(new Table("Обеденный", "дуб", 18000, 6));
        shop.add(new Sofa("Комфорт", "ткань", 42000, true));
        shop.add(new Wardrobe("Купе", "ЛДСП", 31000, 3));
        shop.add(new Chair("Барный", "металл", 6200, 3));
        shop.showAll();
        shop.showCheaperThan(10000);
        System.out.println("Общая стоимость товаров: " + shop.totalPrice() + " руб.");
    }

    static abstract class Transport {
        protected String name;
        protected double speed;
        protected double pricePerKm;
        protected double cargoPricePerKm;

        public Transport(String name, double speed, double pricePerKm, double cargoPricePerKm) {
            this.name = name;
            this.speed = speed;
            this.pricePerKm = pricePerKm;
            this.cargoPricePerKm = cargoPricePerKm;
        }

        public abstract String getType();

        public abstract double getTime(double distance);

        public double getPassengerCost(double distance, int passengers) {
            return distance * pricePerKm * passengers;
        }

        public double getCargoCost(double distance, double tons) {
            return distance * cargoPricePerKm * tons;
        }

        public void printTrip(double distance, int passengers, double tons) {
            System.out.printf("%s \"%s\": время %.1f ч, пассажиры (%d) — %.0f руб., груз (%.1f т) — %.0f руб.%n",
                    getType(), name, getTime(distance), passengers,
                    getPassengerCost(distance, passengers), tons, getCargoCost(distance, tons));
        }
    }

    static class Car extends Transport {
        public Car(String name) { super(name, 80, 4, 12); }
        public String getType() { return "Автомобиль"; }

        public double getTime(double distance) {
            double t = distance / speed;
            int stops = (int) (t / 4);
            return t + stops * 0.5;
        }
    }

    static class Airplane extends Transport {
        public Airplane(String name) { super(name, 800, 8, 40); }
        public String getType() { return "Самолёт"; }

        public double getTime(double distance) { return distance / speed + 2; }
    }

    static class Train extends Transport {
        public Train(String name) { super(name, 60, 2.5, 3); }
        public String getType() { return "Поезд"; }

        public double getTime(double distance) { return distance / speed + (int) (distance / 200) * (10.0 / 60); }
    }

    static class Ship extends Transport {
        public Ship(String name) { super(name, 30, 3, 1.5); }
        public String getType() { return "Корабль"; }
        public double getTime(double distance) { return distance / speed; }
    }

    static void task10() {
        Main.title("ПР4.1 Задание 10: Транспорт");
        double distance = 700;
        int passengers = 3;
        double tons = 2;
        System.out.println("Расстояние " + distance + " км, " + passengers + " пассажира, груз " + tons + " т:");
        Transport[] fleet = {
                new Car("Lada Vesta"),
                new Airplane("SSJ-100"),
                new Train("Сапсан"),
                new Ship("Волга")
        };
        for (int i = 0; i < fleet.length; i++) {
            fleet[i].printTrip(distance, passengers, tons);
        }
    }
}
