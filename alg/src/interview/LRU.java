package interview;

import java.util.HashMap;

public class LRU<K,V> {
    int currentSize;
    int capcity;//总容量
    //存储所有节点
    HashMap<K,Node> nodes;
    //头连接
    Node head;
    //尾部连接
    Node tail;

    public LRU(int size) {
        currentSize = 0;
        this.capcity = size;
        nodes = new HashMap<K, Node>(size);
    }

    private static class Node<K,V> {
        K k;
        V v;
        Node next;

        Node pre;

        public Node(K k,V v) {
            this.k = k;
            this.v = v;
        }

        public K getK() {
            return k;
        }

        public Node setK(K k) {
            this.k = k;
            return this;
        }

        public V getV() {
            return v;
        }

        public Node setV(V v) {
            this.v = v;
            return this;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
        }

        public Node getPre() {
            return pre;
        }

        public Node setPre(Node pre) {
            this.pre = pre;
            return this;
        }
    }


    //
    public Node put(K k,V v) {
        Node node = nodes.get(k);
        //若不存在
        if(node == null) {
            if(nodes.size() >= capcity) {
                nodes.remove(tail.getK());
                removeLast();
            }
            node = new Node(k,v);
        } else {
            node.v = v;
        }
        //并将节点添加到头部
        moveToHead(node);
        nodes.put(k,node);
        return node;
    }

    /**
     *
     * head -> node1 -> node2
     *
     * @param node
     */
    private void moveToHead(Node node) {
        //若是新节点
        if(node.getNext() == null) {
            node.next = head;
            head.pre = node;
            head = node;
        } else {
            //旧节点且头节点
            if(node.getPre() == null) {
                //就是当前头节点不需要操作
                return;
            }
            //
            Node next = node.getNext();
            Node pre = node.getPre();
            pre.next = next;
            next.pre = pre;

            //
            node.next = head;
            head.pre = node;
            head = node;
            head.pre = null;
        }
    }


    /**
     * 移除最后一个节点
     */
    private void removeLast() {
        if (tail != null) {
            //复制一份最后节点的前一个节点引用。
            final Node pre = tail.pre;
            //将最后节点的前置节点引用置为NULL
            tail.pre = null; //help gc
            //将最后节点引用重新复制。
            tail = pre;
            if (tail == null) {
                head = null;
            } else {
                //将next置为NULL
                tail.next = null; //helpGC
            }
        }
    }



}
