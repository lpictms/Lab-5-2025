import functions.*;

public class Main {
    public static void main(String[] args) {

        FunctionPoint[] points1 = {new FunctionPoint(0.0, 1.5), new FunctionPoint(4.2, 7), new FunctionPoint(10, 13.46)};
        FunctionPoint[] points2 = {new FunctionPoint(0.0, 1.5), new FunctionPoint(4.2, 7), new FunctionPoint(10, 13.46)};
        FunctionPoint[] points3 = {new FunctionPoint(0.0, 1.5), new FunctionPoint(2, 7), new FunctionPoint(10, 13.46)};

        System.out.println("== Тестирование toString() ==");
        ArrayTabulatedFunction arrayFunc1 = new ArrayTabulatedFunction(points1);
        LinkedListTabulatedFunction linkedlistFunc1 = new LinkedListTabulatedFunction(points1);

        System.out.println("Array: " + arrayFunc1.toString());
        System.out.println("LinkedList: " + linkedlistFunc1.toString());

        System.out.println("\n== Тестирование equals() ==");
        ArrayTabulatedFunction arrayFunc2 = new ArrayTabulatedFunction(points2);
        ArrayTabulatedFunction arrayFunc3 = new ArrayTabulatedFunction(points3);
        LinkedListTabulatedFunction linkedlistFunc2 = new LinkedListTabulatedFunction(points2);
        LinkedListTabulatedFunction linkedlistFunc3 = new LinkedListTabulatedFunction(points3);

        System.out.println("array1 == array2: " + arrayFunc1.equals(arrayFunc2)); // true
        System.out.println("linkedlist1 == linkedlist2: " + linkedlistFunc1.equals(linkedlistFunc2)); // true
        System.out.println("array1 == linkedlist1: " + arrayFunc1.equals(linkedlistFunc1)); // true
        System.out.println("array1 == array3: " + arrayFunc1.equals(arrayFunc3)); // false

        System.out.println("\n== Тестирование hashCode() ==");
        System.out.println("array1 hashCode: " + arrayFunc1.hashCode());
        System.out.println("array2 hashCode: " + arrayFunc2.hashCode());
        System.out.println("array3 hashCode: " + arrayFunc3.hashCode());
        System.out.println("linkedlist1 hashCode: " + linkedlistFunc1.hashCode());
        System.out.println("linkedlist2 hashCode: " + linkedlistFunc2.hashCode());
        System.out.println("linkedlist3 hashCode: " + linkedlistFunc3.hashCode());

        System.out.println("\n== Проверка согласованности hashCode и equals ==");
        System.out.println("array1 hashCode == array2 hashCode: " + (arrayFunc1.hashCode() == arrayFunc2.hashCode()));
        System.out.println("linkedlist1 hashCode == linkedlist2 hashCode: " + (linkedlistFunc1.hashCode() == linkedlistFunc2.hashCode()));
        System.out.println("array1 hashCode == linkedlist1 hashCode: " + (arrayFunc1.hashCode() == linkedlistFunc1.hashCode()));

        System.out.println("\n== Проверка изменения hashCode() ==");
        int origHash = arrayFunc1.hashCode();
        arrayFunc1.setPointY(1, 7.00001); // незначительное изменение
        int newHash = arrayFunc1.hashCode();
        System.out.println("Изначальный: " + origHash);
        System.out.println("Измененный: " + newHash);

        System.out.println("\n== Тестирование clone() ==");
        ArrayTabulatedFunction arrayClone = (ArrayTabulatedFunction) arrayFunc1.clone();
        LinkedListTabulatedFunction linkedlistClone = (LinkedListTabulatedFunction) linkedlistFunc1.clone();

        System.out.println("Изначальный array: " + arrayFunc1.toString());
        System.out.println("Клон array: " + arrayClone.toString());
        System.out.println("Изначальный linkedlist: " + linkedlistFunc1.toString());
        System.out.println("Клон linkedlist : " + linkedlistClone.toString());

        System.out.println("\n== Проверка глубокого копирования ==");
        arrayFunc1.setPointY(0, 10); // изменяем оригинал
        linkedlistFunc1.setPointY(0, 10);  // изменяем оригинал

        System.out.println("Измененный array: " + arrayFunc1.toString());
        System.out.println("Клон array: " + arrayClone.toString());
        System.out.println("Измененный linkedlist: " + linkedlistFunc1.toString());
        System.out.println("Клон linkedlist : " + linkedlistClone.toString());

    }
}