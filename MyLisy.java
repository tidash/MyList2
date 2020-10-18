package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyList<T> implements Collection<T> {

    class Node<T> {
        private T value;
        private Node<T> node;

        public Node(T value) {
            this.value = value;
            this.node = null;
        }

        public boolean hasNext() {
            if(this.node != null) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return value.toString();
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNode() {
            return node;
        }

        public void setNode(Node<T> node) {
            this.node = node;
        }

    }
    private Node<T> root;
    private long counter;
    private Comparable comp;
    public MyList() {
        this.root = null;
        this.counter = 0;
    }

    public MyList(Comparable comp) {
        this.root = null;
        this.counter = 0;
        this.comp = comp;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return (this.root == null ? true : false);
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node<T> link = new Node<>(t);
        if(root == null) {
            this.root = link;
            this.counter++;
            return true;
        } else {
            end().setNode(link);
            this.counter++;
        }
        return false;
    }
    public Node<T> end() {
        if (this.root == null)
            return null;
        Node<T> iter = this.root;
        while (iter.hasNext()) {
            iter = iter.getNode();
        }
        return iter;
    }
    public String toString() {
        String result = "[";
        if (this.root == null)
            return null;
        else {
            Node<T> iter = this.root;
            while (iter.hasNext()) {
                result += iter.toString() + ", ";
                iter = iter.getNode();
            }
            result += iter.toString();
        }
        result += " ]";
        return result;
    }
    public Node<T> indexAt( int index) {
        if((index <= this.counter - 1) && (index >= 0)) {
            Node<T> iter = this.root;
            for(int i=0;i < index; ++i) {
                iter = iter.getNode();
            }
            return iter;
        }
        return null;
    }

    public void swap(int firstPos, int secondPos){

        if (firstPos > secondPos) {
            int tmp = firstPos;
            firstPos = secondPos;
            secondPos = tmp;
        }
        if (firstPos >= 0) {
            Node<T> pre = indexAt(firstPos - 1);
            Node<T> first = indexAt(firstPos);
            Node<T> post = indexAt(firstPos + 1);
            Node<T> prep = indexAt(secondPos - 1);
            Node<T> second = indexAt(secondPos);
            Node<T> postp = indexAt(secondPos + 1);

            if (pre != null) {
                pre.setNode(second);
            }
            else {
                this.root = second;
            }

            first.setNode(post);

            if (pre == first) {
                second.setNode(first);
            }
            else {
                second.setNode(post);
                pre.setNode(first);
            }
        }
    }

    public void sort() {
        int k = 0;
        Node<T> one;
        Node<T> two;
        boolean thatsAll = true;
        while (thatsAll) {
            for (int i = 1; i <= this.counter - 1; i++) {
                one = indexAt(i - 1);
                two = indexAt(i);
                if (comp.compare(one,two) == 1) {
                    swap(i - 1, i);
                    k++;
                }

            }
            if (k == 0)
                thatsAll = false;
            k = 0;

        }
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        return null;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return false;
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public Stream<T> stream() {
        return null;
    }

    @Override
    public Stream<T> parallelStream() {
        return null;
    }
}

interface Comparable {
    int compare(MyList.Node a, MyList.Node b);
}
