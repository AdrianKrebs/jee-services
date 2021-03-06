package ch.adriankrebs.services.book.util;


import java.util.*;

/**
 * Created by Adrian on 9/23/2016.
 */
public class Generics {

    static class Sparrow extends Bird {
    }

    static class Bird {
    }

    public class SpecialSorter<K> {
    }

    public static void main(String[] args) {
        List<? extends Bird> birds = new ArrayList<>();
        // PECS 
        // birds.add(new Sparrow()); // DOES NOT COMPILE
        // birds.add(new Bird()); // DOES NOT COMPILE

        List<String> strings = new ArrayList<String>();
        strings.add("tweet");
        List<Object> objects = new ArrayList<Object>(strings);
        addSound(strings);
        //addSound(objects); --> cant add object to wildcarded list
        Collection<String> tester = new ArrayList<>();
        tester.remove("onetwo");


        PlaceHolder<String, String> ph1 = PlaceHolder.getDuplicateHolder("b"); //1
        PlaceHolder<?, ?> ph5 = new PlaceHolder(10, 10); //5

        //Map m = new HashMap<>();
        Map<Object, ? super Object> m = new LinkedHashMap<>();
        m.put("1", new ArrayList());    //1
      //  m.put("1", new FinalArrayList());    //1
        m.put(1, new Object());    //2
        m.put(1.0, "Hello");     //3
        System.out.println(m);


        List<?> list2 = new ArrayList<>(Arrays.asList("t2","t2"));


    }


    public static void addSound(List<String> list) {
        list.add("quack");
    }

    public static class PlaceHolder<K, V> { //1
        private K k;
        private V v;

        public PlaceHolder(K k, V v) { //2
            this.k = k;
            this.v = v;
        }

        public K getK() {
            return k;
        }

        public static <X> PlaceHolder<X, X> getDuplicateHolder(X x) { //3
            return new PlaceHolder<>(x, x); //4
        }
    }
}


class BoxDemo {

    public static <U> void addBox(U u,
                                  java.util.List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box : boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" +
                    boxContents.toString() + "]");
            counter++;
        }
    }

    public static <E extends CharSequence> List<? super E> doIt(List<E> nums) {
        return new ArrayList<E>();
    }

    public static void main(String[] args) {
        java.util.ArrayList<Box<Integer>> listOfIntegerBoxes =
                new java.util.ArrayList<>();

        List test = doIt(new ArrayList<>(Arrays.asList("test")));

        /*
        The generic method addBox defines one type parameter named U.
        Generally, a Java compiler can infer the type parameters of a generic method call. Consequently, in most cases, you do not have to specify them.
        Both methods work:
         */
        BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
        BoxDemo.outputBoxes(listOfIntegerBoxes);
    }

    private static class Box<T> {


        public <T> void set(T whatever) {

        }

        public T get() {


            return null;
        }

    }

}

