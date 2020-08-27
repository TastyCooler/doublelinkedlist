public class DoublyLinkedList
{
    private Element first, last;
    private int size;

    public DoublyLinkedList()
    {
        first = last = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }

    public void add( Object content ) 
    {
        Element e = new Element( content );
        if ( isEmpty() ) 
        {
            first = last = e;
        }
        else 
        {
            last.connectAsSucc( e );
            last = e;
        }
        size++;
    }

    public void addFirst( Object content ) 
    {
        Element e = new Element( content );
        if ( isEmpty() ) 
        {
            first = last = e;
        }
        else 
        {
            first.connectAsPred( e );
            first = e;
        }
        size++;
    }

    public Object getFirst() 
    {
        if ( !isEmpty() )
        {
            return first.getContent();
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public Object get( int index ) 
    {
        if ( index >= 0 && index < size )
        {
            Element current = first;
            for ( int i = 0; i < index; i++ )
            {
                current = current.getSucc();
            }
            return current.getContent();
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public Object removeFirst()
    {
        if ( !isEmpty() ) 
        {
            Object result = first.getContent();
            if ( first.hasSucc() )
            {
                first = first.getSucc();
                first.disconnectPred();
            }
            else
            {
                first = last = null;
            }
            size--;
            return result;
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public void showAll()
    {
        Element current = first;
        while ( current != null )
        {
            System.out.print( current.getContent().toString() );
            if ( current != last )
            {
                System.out.print(", ");
            }
            current = current.getSucc();
        }
        System.out.println();
    }


/* 1 - Methode void clear()
Die Methode clear() soll alle Elemente aus der Liste entfernen. 
 */

public void clear(){

first = last = null;
size = 0;
  
}

/* 2 - Methode Object getLast()
Die Methode getLast() soll den Inhalt des letzten Elements der Liste zurückgeben. Falls die Liste keine Elemente
enthält, soll eine IllegalStateException geworfen werden. */

public Object getLast(){
  if(!isEmpty()){

    return last.getContent();
  } else{
    throw new IllegalStateException();
  }
}

/* 3 - Methode boolean contains( Object o )
Die Methode contains( Object o ) soll true zurückgeben, wenn der Inhalt o in den Elementen der Liste
vorkommt. Dabei soll die Gleichheit mit der Methode equals überprüft werden. */

public boolean contains(Object o){
  Element current  = first;

  while( current != null){
    if((o  == null && current.getContent() == null) || (o != null && o.equals(current.getContent()))){
      return true;
    }
    current = current.getSucc();
  }
return false;
}

/* 4 - Methode int count( Object o )
Die Methode count( Object o ) soll die Häufigkeit zurückgeben, mit der der Inhalt o in den Elementen der Liste
vorkommt. Dabei soll die Gleichheit mit der Methode equals überprüft werden.
*/

public int count(Object o){
  Element current = first;
  int count = 0;
  while(current != null){
    if( o == null && current.getContent() == null ||o != null && o.equals(current.getContent())){
      count++;
    }
    current = current.getSucc();
  }
  return count;
}

/* 5 - Methode boolean allEqual()
Die Methode allEqual() soll true zurückgeben, wenn alle Elemente gleiche Inhalte besitzen. Dabei soll die Gleichheit
mit der Methode equals überprüft werden. */

public boolean allEqual(){
 if(!isEmpty()){
   Object o = first.getContent();
   Element current = first.getSucc();
   while(current != null){
     if( (o == null && current.getContent() != null) || (o != null && !o.equals(current.getContent()))){
       return false;
     }
     current = current.getSucc();
   }
   return true;
 } else{
   return true;
 }
}

/* 6 - Methode boolean containsDouble()
Die Methode containsDouble() soll true zurückgeben, wenn mindestens zwei Elemente gleiche Inhalte besitzen.
Dabei soll die Gleichheit mit der Methode equals überprüft werden. */

 private boolean contains( Element start, Object o )
    {
        Element current = start;
        while ( current != null )
        {
            if ( ( o == null && current.getContent() == null )              // beruecksichtigt explizit null als Inhalt
            || ( o != null && o.equals( current.getContent() ) )
            )
            {
                return true;
            }
            current = current.getSucc();
        }
        return false;
    }

 public boolean containsDouble()
    {
        if ( !isEmpty() )
        {
            Element current = first;
            while ( current != null )
            {
                if ( contains( current.getSucc(), current.getContent() ) )
                {
                    return true;
                }
                else
                {
                    current = current.getSucc();
                }
            }
        }
        return false;
    }
/* 7 - Methode void insert( int n, Object o )
Die Methode insert( int n, Object o ) soll ein neues Element mit dem Inhalt o hinter dem Element am Index n
in die Liste einfügen. Hat die Liste weniger als n Elemente, so soll eine IndexOutOfBoundsException geworfen
werden. */

public void insert(int n, Object o){
  if ( n >= 0 && n < size ){
   Element pre = first;
for(int i = 0; i < n; i++){
  pre = pre.getSucc();
}

Element suc = pre.getSucc();
Element elm = new Element(o);
pre.connectAsSucc(elm);

if(suc == null){
  last = elm;
} else{
  suc.connectAsPred(elm);
}
size++;
}else{
  throw new IndexOutOfBoundsException();
}

}

/* 8 - Methode void toArray( Object[] arr )
Die Methode toArray( Object[] arr ) soll in das als Argument an den Parameter arr übergebene Feld die Inhalte
der ersten arr.length Elemente der Liste in der gleichen Reihenfolge eintragen. Besitzt die Liste weniger Elemente, so
sollen die verbleibenden Einträge des Feldes auf null verweisen. Die Inhalte der Ausgangsliste sollen nicht kopiert werden, so dass anschließend das Feld und die Liste auf die gleichen Objekte verweisen.*/

public void toArray(Object[] arr){
  Element current = first;

  for(int i = 0; i < arr.length; i++){
    if(i < size()){
    arr[i] = current.getContent();
    current = current.getSucc();
    } else{
      arr[i] = null;
    }
    
  }
}

/* 9 - Methode DoublyLinkedList flip()
Die Methode flip() soll eine Liste zurückgeben, in der die Inhalte der Liste in umgekehrter Reihenfolge auftreten. Die
Inhalte der Ausgangsliste sollen nicht kopiert werden, so dass beide Listen anschließend auf die gleichen Objekte verweisen. 
 */

public DoublyLinkedList flip(){
  DoublyLinkedList reverse = new DoublyLinkedList();
  Element current = last;
  while(current != null){
    reverse.add(current.getContent());
    current = current.getPred();
  }
  return reverse;
}

/* 10 - Methode void remove( int n )
Die Methode remove( int n ) soll das Element am Index n der Liste löschen, falls dieses existiert. Der Aufruf
remove(0) soll also das erste Element löschen, der Aufruf remove(1) das zweite Element usw. Beachten Sie die
Sonderfälle, dass das einzige, das erste oder das letzte Element gelöscht wird. Hat die Liste weniger als n+1 Elemente, so
soll eine IndexOutOfBoundsException geworfen werden.*/

public void remove(int n){
  if ( n >= 0 && n < size ){
   Element toRemove = first;

  for(int i = 0; i < n; i++){
  toRemove = toRemove.getSucc();
}
if(toRemove == first && toRemove == last){
  first = last = null;
} else if(toRemove == first){
  first = toRemove.getSucc();
  first.disconnectPred();
} else if(toRemove == last){
  last = last.getPred();
  last.disconnectSucc();
} else{
  toRemove.getPred().connectAsSucc(toRemove.getSucc());
}
size--;
} else{
  throw new IndexOutOfBoundsException();
}

}

/*11 - Methode void remove( Object o )
Die Methode remove( Object o ) soll alle Elemente aus der Liste löschen, die den Inhalt o besitzen. Dabei soll die
Gleichheit mit der Methode equals überprüft werden. Beachten Sie die Sonderfälle, dass das einzige, das erste oder das
letzte Element gelöscht wird. Tritt kein Element mit dem Inhalt o auf, soll nicht geschehen. */

public void remove(Object o){
  Element current = first;
  Element SuccCandidate;
  while(current != null){
    SuccCandidate = current.getSucc();
    if((o == null && current.getContent() == null) ||(o != null && o.equals(current.getContent()))){
      if(current == first && current == last){
        first = last = null;
      }
      if(current == first){
        first = first.getSucc();
        first.disconnectPred();
      } else if(current == last){
        last =  last.getPred();
        last.disconnectSucc();
      } else{
        current.getPred().connectAsSucc(current.getSucc());
      }
      size--;
    }
      current = SuccCandidate;
  }
}

/* 12 - Methode void concat( DoublyLinkedList dll )
Die Methode concat( DoublyLinkedList dll ) soll die als Parameter übergebene Liste an die aufrufende Liste
anhängen. Die übergebene Liste soll danach leer sein. Erzeugen Sie bei der Implementierung keine neuen Objekte der Klasse
Element*/

public void concat(DoublyLinkedList dll){
  if(dll != null && !dll.isEmpty()){
    if(isEmpty()){
      first = dll.first;
    } else{
      last.connectAsSucc(dll.first);
    }
    last = dll.last;
    size += dll.size;
    dll.clear();
  }
}

/* 13 - Konstruktor DoublyLinkedList( DoublyLinkedList dll )
Der Konstruktor DoublyLinkedList( DoublyLinkedList dll ) soll eine Liste erzeugen, die Kopien der Elemente der
Liste dll enthält. Die Inhalte der Elemente der Ausgangsliste sollen nicht kopiert werden, so dass beide Listen anschließend auf die gleichen Objekte verweisen.*/

public DoublyLinkedList(DoublyLinkedList dll){
  for(Element current = dll.first; current != null; current = current.getSucc()){
    add(current.getContent());
  }
}

/* 14 - Methode DoublyLinkedList subList( int from, int to )
Die Methode subList( int from, int to ) soll eine neue Liste mit den Inhalten zurückgeben, die in der Ausgangsliste vom Index from (inklusiv) bis zum Index to (exklusiv) liegen. Die Ausgangsliste soll unverändert bleiben. Die
Inhalte der Ausgangsliste sollen nicht kopiert werden, so dass beide Listen anschließend auf die gleichen Objekte verweisen.
Definieren die Indizes from und to einen ungültigen Bereich, so soll eine IndexOutOfBoundsException geworfen
werden.*/

public DoublyLinkedList subList(int from, int to){
  if ( from >= 0 && from < size && to >= 0 && to < size && from < to ){
    DoublyLinkedList newList = new DoublyLinkedList();

    Element a = first;
    for(int i = 0; i < from; i++){
      a = a.getSucc();
    }
    for(int i = 0; i < to; i++){
      newList.add(a.getContent());
      a = a.getSucc();
      newList.size++;
    }
    return newList;
  } else{
    throw new IndexOutOfBoundsException();
  }
}

/* 15 - Methode void removeAll( DoublyLinkedList dll )
Die Methode removeAll( DoublyLinkedList dll ) soll alle Elemente aus der Liste löschen, die einen Inhalt
besitzen, der in der Liste dll vorkommt. Dabei soll die Gleichheit mit der Methode equals überprüft werden. */

 public void removeAll( DoublyLinkedList dll ) 
    {
        Element current = dll.first;
        while ( current != null )
        {
            remove( current.getContent() );
            current = current.getSucc();
        }
    }
    
    /*16 - Methode void pack()
Die Methode pack soll Elemente in der Liste so löschen, dass von jeder Teilfolge von unmittelbar aufeinander folgenden
Elementen mit gleichen Inhalten jeweils nur genau ein Element erhalten bleibt.  */
    public void pack()
    {
        Element current = first;

        while ( current != last )
        {
            if ( ( current.getContent() == null && current.getSucc().getContent() == null )
                 || ( current.getContent() != null && current.getContent().equals( current.getSucc().getContent() ) ) )
            {
                current.connectAsSucc( current.getSucc().getSucc() );
                size--;
                if ( current.getSucc() == null )
                {
                    last = current;
                }
            }
            else
            {
                current = current.getSucc();
            }
        }
    }

/* Testat*/

public void a1(Object o){
  if(!isEmpty()){
    if(o.equals(last.getContent()) && o != null){
      last = last.getPred();
      last.disconnectSucc();
    }
  }
}

public void a2(Object o){
  Element current = first;
  

  while(current != null){
    if(o.equals(current.getContent())){
      last.setContent(o);
    }
    current = current.getSucc();
    
  }

}

public void a3(Object o){
  if(size >= 5){
    Element current = first;
    Element toAdd = new Element(o);
    for(int i = 0; i < 2; i++){
      current = current.getSucc();
    }
    Element tmp = current.getSucc();
    current.connectAsSucc(toAdd);
    toAdd.connectAsSucc(tmp);
    size++;


  }
}

public DoublyLinkedList extract(int n){
  if(size < n +1){
    return new DoublyLinkedList();

  }else{
    Element current = first;
    for(int i = 1; i < n; i++){
      current = current.getSucc();
    }
    
    Element t = current.getSucc();
    current.disconnectSucc();
     DoublyLinkedList d = new DoublyLinkedList();
    

     d.first = first;
     

    first = t; 
     return d; 

  }

  
}

public void removeUnequalToFirst(){
  if(!isEmpty() && first.getContent() != null){
    Element current = first.getSucc();

    while(current != last){
      if(!first.getContent().equals(current.getContent())){
      
      first.connectAsSucc(current.getSucc());
       
      current = current.getSucc();
      

      
      }
      else{
        first.connectAsPred(current);
        current = current.getSucc();
        
        
      }
    }
  }
}

}
