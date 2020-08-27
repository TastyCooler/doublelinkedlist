class Main {
 public static void main( String[] args )
    {
        testDoublyLinkedList();
    }
        
    public static void testDoublyLinkedList()
    {
      /* DoublyLinkedList students = new DoublyLinkedList();
        students.add( new Student( "A", "Inf", 123433 ) );
        students.add( new Student( "B", "Inf", 123456 ) );
        students.add( new Student( "C", "Inf", 123457 ) );
        students.add( new Student( "D", "Inf", 123458 ) );
        students.add( new Student( "E", "Inf", 123459 ) );
        students.add( new Student( "F", "Inf", 123460 ) );
        students.showAll();
        students.addFirst( new Student( "X", "Inf", 123461 ) );
        students.showAll();
        
        System.out.println( students.get(0).toString() );
        System.out.println( students.get(2).toString() );
        System.out.println( students.get(6).toString() );
        System.out.println( students.removeFirst().toString() );
        //students.clear();
        students.showAll();
        System.out.println( students.getFirst().toString() );

        for ( int i = 0; i < students.size(); i++ )
        {
            if ( i != 0 )
            {
                System.out.print( students.get(i) );
            }
            System.out.println();
        } */
      //  System.out.println(students.getLast());
       // Object k = new Object();
       // System.out.println(students.contains(k));

       /* DoublyLinkedList numbers = new DoublyLinkedList();
        numbers.add( new Fraction( 2, 3 ) );
        numbers.add( new Fraction( 1, 7 ) );
        numbers.add( new Fraction( 3, 12 ) );
        numbers.add( new Fraction( 8 ) );
        numbers.add(new Fraction (2,3));
        numbers.showAll();
        System.out.println( numbers.removeFirst().toString() );
        numbers.showAll();
        System.out.println( numbers.getFirst().toString() ); */
         DoublyLinkedList d = new DoublyLinkedList();
        d.add(1);
        d.add(2);
        d.add(1);
        d.add(4);
        d.add(5);
        d.add(1);
        d.showAll();
        d.removeUnequalToFirst();
         d.showAll();
        System.out.println(d.size());
        
        Integer ref = 5;
        Integer ref2 = new Integer( 5 ) ;

        int i = ref;				
        int j = ref2.intValue();
        DoublyLinkedList integers = new DoublyLinkedList();
        integers.add( 4 );
        integers.add( 5 );
        integers.add( 6 );
        integers.add( 9 );
        integers.add( 5 );
        integers.showAll();
        //integers.a1(5);
        integers.a2(6);
        //integers.a3(7);
        integers.showAll();
        //System.out.println(integers.containsDouble());
       // Object c = 5;
        //integers.remove(c);
       // integers.showAll();
      //  DoublyLinkedList sub = integers.subList(1,4);
      //  sub.showAll();
        /* DoublyLinkedList list = new DoublyLinkedList();
        list.add( new Student( "A", "Inf", 123433 ) );
        list.add( new Fraction( 3, 7 ) );
        list.showAll();   */

    }
}