package ru.ssau.tk.shnurok.lab2.realizations;

import ru.ssau.tk.shnurok.lab2.coredefenitions.AbstractTabulatedFunction;
import ru.ssau.tk.shnurok.lab2.coredefenitions.MathFunction;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction {

    protected static class Node {
        public Node next=null;
        public Node prev=null;
        public double x;
        public double y;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }

    }
    private Node head = null;
    protected int count;

    private void addNode(double x, double y) {
        Node newNode = new Node(x, y);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
        count++;
    }

    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        for (int i = 0; i < xValues.length; ++i) {
            addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (xFrom > xTo) {
            double t = xFrom;
            xFrom = xTo;
            xTo = t;
        }
        if (xFrom == xTo) {
            for (int i = 0; i < count; i++) {
                addNode(xFrom, source.apply(xFrom));
            }
        }

    }
    private Node getNode(int index) {
        if (index > count / 2) {
            Node current = head.prev;
            for (int i = 0; i < count - index - 1; i++) {
                current = current.prev;
            }
            return current;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
    }


    @Override
    protected int floorIndexOfX(double x) {
        Node cur = head;
        int i = 0;
        do {
            if (cur.x >= x)
                return i == 0 ? 0 : i - 1;
            ++i;
            cur = cur.next;
        } while (cur != head);
        return count;

    }

    @Override
    protected double extrapolateLeft(double x) {
        if (count == 1)
            return head.y;
        return interpolate(x,head.x,head.next.x,head.y,head.next.y);

    }

    @Override
    protected double extrapolateRight(double x) {
        if (count == 1)
            return head.y;
        return interpolate(x, head.prev.prev.x, head.prev.x, head.prev.prev.y, head.prev.y);

    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        if (count == 1)
            return head.y;
        Node floorNode = getNode(floorIndex);
        return interpolate(x,floorNode.x,floorNode.next.x,floorNode.y,floorNode.next.y);

    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double getX(int index) {
        return getNode(index).x;
    }

    @Override
    public double getY(int index) {
        return getNode(index).y;
    }

    @Override
    public void setY(int index, double value) {
        getNode(index).y = value;
    }

    @Override
    public int indexOfX(double x) {
        Node current = head;
        for (int i = 0; i < count; i++) {
            if (current.x == x) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        Node current = head;
        for (int i = 0; i < count; i++) {
            if (current.y == y) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public double leftBound() {
        return head.x;
    }

    @Override
    public double rightBound() {
        return head.prev.x;
    }
}
