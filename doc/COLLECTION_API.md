# Collections API Lab Discussion
### Marcus Ortiz, Alexander Bildner, Edison Ooi, Leo Cao, Zijie Yang
### Team 7


## In your experience using these collections, are they hard or easy to use?
In our experiences, Java collections is generally an easy API to use

## In your experience using these collections, do you feel mistakes are easy to avoid?
Fairly easy to avoid mistakes when it comes to preserving the data you have, but accesses often throw different exceptions
or return null.


## What methods are common to all collections (except Maps)?
.add(), .remove(), .size(), addAll(), clear(), containsAll(), isEmpty(), removeAll(), retainAll(), iterator(),

## What methods are common to all Deques?
.add(e), contains(Object o), .peek(), .poll(), .pop(), .push()

## What is the purpose of each interface implemented by LinkedList?
* Serializable - this interface indicates that the implementing class can have its objects be streamed
into a buffer that can get stored in memory - either volatile or persistent.
* Cloneable - this interface indicates that the implementing class has the ability to create clones
of its object instances. In other words, it has the ability to create copies of objects that 
are distinct in memory. 
* Iterable<E> - this interface represents a collection of objects that is iterable, can get elements one by one without 
worrying about how it is structured internally
* Collection<E> - this interface indicates that implementations represent data structures that hold and rearrange objects
as well as obtain metadata about the objects
* Deque<E> - this interface indicates that the implementing class has support for the behavior of
a "double ended queue," as in an object which supports addition and removal of elements at both ends
* List<E> - this interface declares the behavior or a collection and stores a sequence of elements
* Queue<E> - this interface defines data structures that hold pre-processed objects. It contains some optional methods
for adding, looking at, or removing certain elements in the Collection.

## How many different implementations are there for a Set?
* HashSet
* TreeSet
* LinkedHashSet
* EnumSet
* CopyOnWriteArraySet


## What is the purpose of each superclass of PriorityQueue?

The Class heirarchy of PriorityQueu is:
java.lang.Object
        java.util.AbstractCollection<E>
            java.util.AbstractQueue<E>
                java.util.PriorityQueue<E>

Each superclass of PriorityQueue has its own purpose.

* java.lang.Object has the purpose of providing basic Object functionality. As the JavaDocs says,
"Class Object is the root of the class hierarchy. Every class has Object as a superclass.
All objects, including arrays, implement the methods of this class." This includes functionality like
clone, hashing, etc.
* java.util.AbstractCollection<E> has the purpose of providing an API and functionality for additional
features specific to Collections - addAll, clear, isEmpty, etc.
* java.util.AbstractQueue<E> has the purpose of providing an API and functionality for queues - like 
element and remove to get but not and get and remove the head of queue.

## What is the purpose of the collection utility classes?
The collections utility classes has polymorphic methods that operate on all the implementations of collection.

## API Characterics applied to Collection API

 * Easy to learn
   * Method names are intuitive and perform exactly what they say, on any type of Collection

 * Provides for extension
   * It means that a lot of classes can easily extend collection and adapt it for their needs.

 * Leads to readable code
   * Method names are concise and do exactly what they say

 * Hard to misuse
   * The methods do what they say they do, the documentation is fairly extensive, and the parameters are of type Collection
   usually, which has its own protections