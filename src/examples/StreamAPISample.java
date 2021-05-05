package examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPISample {
    public static void main(String[] args) {

        /* Способы создания стримов
            1. Классический: Создание стрима из коллекции collection.stream()
                    Collection<String> collection = Arrays.asList("a1", "a2", "a3");
                    Stream<String> streamFromCollection = collection.stream();
            2. Создание стрима из значений	Stream.of(значение1,… значениеN)
                    Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
            3. Создание стрима из массива	Arrays.stream(массив)
                    String[] array = {"a1","a2","a3"};
                    Stream<String> streamFromArrays = Arrays.stream(array);
            4. Создание стрима из файла (каждая строка в файле будет отдельным элементом в стриме)	Files.lines(путь_к_файлу)
                    Stream<String> streamFromFiles = Files.lines(Paths.get("file.txt"))
            5. Создание стрима из строки	«строка».chars()
                    IntStream streamFromString = "123".chars()
            6. С помощью Stream.builder	Stream.builder().add(...)....build()
                    Stream.builder().add("a1").add("a2").add("a3").build()
            7. Создание параллельного стрима	collection.parallelStream()
                    Stream<String> stream = collection.parallelStream();
            8. Создание бесконечных стрима с помощью Stream.iterate
                    Stream.iterate(начальное_условие, выражение_генерации)
                    Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1)
            9. Создание бесконечных стрима с помощью Stream.generate	Stream.generate(выражение_генерации)
                    Stream<String> streamFromGenerate = Stream.generate(() -> "a1")
         */

        /* описание конвейерных методов
            filter	    Отфильтровывает записи, возвращает только записи, соответствующие условию	collection.stream().filter(«a1»::equals).count()
            skip	    Позволяет пропустить N первых элементов	collection.stream().skip(collection.size() — 1).findFirst().orElse(«1»)
            distinct	Возвращает стрим без дубликатов (для метода equals)	collection.stream().distinct().collect(Collectors.toList())
            map	        Преобразует каждый элемент стрима	collection.stream().map((s) -> s + "_1").collect(Collectors.toList())
            peek	    Возвращает тот же стрим, но применяет функцию к каждому элементу стрима	collection.stream().map(String::toUpperCase).peek((e) -> System.out.print("," + e)).collect(Collectors.toList())
            limit	    Позволяет ограничить выборку определенным количеством первых элементов	collection.stream().limit(2).collect(Collectors.toList())
            sorted	    Позволяет сортировать значения либо в натуральном порядке, либо задавая Comparator	collection.stream().sorted().collect(Collectors.toList())
            mapToInt, mapToDouble, mapToLong	Аналог map, но возвращает числовой стрим (то есть стрим из числовых примитивов)	collection.stream().mapToInt((s) -> Integer.parseInt(s)).toArray()
            flatMap, flatMapToInt, flatMapToDouble, flatMapToLong	Похоже на map, но может создавать из одного элемента несколько	collection.stream().flatMap((p) -> Arrays.asList(p.split(",")).stream()).toArray(String[]::new)
        */

        /* описание терминальных методов
            findFirst   	Возвращает первый элемент из стрима (возвращает Optional)	collection.stream().findFirst().orElse(«1»)
            findAny	        Возвращает любой подходящий элемент из стрима (возвращает Optional)	collection.stream().findAny().orElse(«1»)
            collect	        Представление результатов в виде коллекций и других структур данных	collection.stream().filter((s) -> s.contains(«1»)).collect(Collectors.toList())
            count	        Возвращает количество элементов в стриме	collection.stream().filter(«a1»::equals).count()
            anyMatch    	Возвращает true, если условие выполняется хотя бы для одного элемента	collection.stream().anyMatch(«a1»::equals)
            noneMatch   	Возвращает true, если условие не выполняется ни для одного элемента	collection.stream().noneMatch(«a8»::equals)
            allMatch    	Возвращает true, если условие выполняется для всех элементов	collection.stream().allMatch((s) -> s.contains(«1»))
            min	            Возвращает минимальный элемент, в качестве условия использует компаратор	collection.stream().min(String::compareTo).get()
            max	            Возвращает максимальный элемент, в качестве условия использует компаратор	collection.stream().max(String::compareTo).get()
            forEach	        Применяет функцию к каждому объекту стрима, порядок при параллельном выполнении не гарантируется	set.stream().forEach((p) -> p.append("_1"));
            forEachOrdered	Применяет функцию к каждому объекту стрима, сохранение порядка элементов гарантирует	list.stream().forEachOrdered((p) -> p.append("_new"));
            toArray	        Возвращает массив значений стрима	collection.stream().map(String::toUpperCase).toArray(String[]::new);
            reduce	        Позволяет выполнять агрегатные функции на всей коллекцией и возвращать один результат	collection.stream().reduce((s1, s2) -> s1 + s2).orElse(0)
         */

        /* описание дополнительных методов у числовых стримов
            sum	        Возвращает сумму всех чисел	collection.stream().mapToInt((s) -> Integer.parseInt(s)).sum()
            average	    Возвращает среднее арифметическое всех чисел	collection.stream().mapToInt((s) -> Integer.parseInt(s)).average()
            mapToObj	Преобразует числовой стрим обратно в объектный	intStream.mapToObj((id) -> new Key(id)).toArray()
         */

        /* Несколько других полезных методов
            isParallel	Узнать является ли стрим параллельным
            parallel	Вернуть параллельный стрим, если стрим уже параллельный, то может вернуть самого себя
            sequential	Вернуть последовательный стрим, если стрим уже последовательный, то может вернуть самого себя
         */

        /**
         * Примеры использования filter, findFirst, findAny, skip, limit и count
         */
        // findFirst - возвращает первый Optional элемент из стрима
        // skip - пропускает N первых элементов (где N параметр метода)
        // collect преобразует stream в коллекцию или другую структуру данных
        
        List<String> list = Arrays.asList("a1", "a2", "a3", "a1");

        // Вернуть количество вхождений объекта «a1»
        list.stream().filter("a1"::equals).count();

        // Вернуть первый элемент коллекции или 0, если коллекция пуста
        list.stream().findFirst().orElse("0");

        // Вернуть последний элемент коллекции или «empty», если коллекция пуста
        list.stream().skip(list.size()-1).findAny().orElse("empty");

        // Найти элемент в коллекции равный «a3» или кинуть ошибку
        list.stream().filter("a3"::equals).findFirst().get();

        // Вернуть третий элемент коллекции по порядку
        list.stream().skip(2).findFirst().get();

        // Вернуть два элемента начиная со второго
        list.stream().skip(1).limit(2).toArray();

        // Выбрать все элементы по шаблону
        list.stream().filter((s) -> s.contains("1")).collect(Collectors.toList());
//----------------------------------------------------------------------------------------------------------------------
        /**
         * коллекция класс People (с полями name — имя, age — возраст, sex — пол)
         */
        List<People> peopleList = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Мила", 42, Sex.WOMAN),
                new People("Головач Лена", 69, Sex.WOMAN));

        // filter - возвращает stream, в котором есть только элементы, соответствующие условию фильтра
        // count - возвращает количество элементов в стриме
        // collect - преобразует stream в коллекцию или другую структуру данных
        // mapToInt - преобразовать объект в числовой стрим (стрим, содержащий числа)

        // Выбрать мужчин-военнообязанных (от 18 до 27 лет)
        peopleList.stream().filter((p) -> p.getAge() >= 18 && p.getAge() < 27 && p.getSex() == Sex.MAN).collect(Collectors.toList());

        // Найти средний возраст среди мужчин
        peopleList.stream().filter((p) -> p.getSex() == Sex.MAN).mapToInt(People::getAge).average().getAsDouble();

        // Найти кол-во потенциально работоспособных людей в выборке (т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)
        peopleList.stream().filter((p) -> p.getAge() >= 18).filter((p) -> (p.getSex() == Sex.WOMAN && p.getAge() < 55)
                || (p.getSex() == Sex.MAN && p.getAge() < 60)).count();


    }
}

class People {
    private String name;
    private int age;
    private Sex sex;

    public People(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}

enum Sex {
    MAN,
    WOMAN
}
