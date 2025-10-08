#include <iostream>
using namespace std;

/**
 * Queue using Linked List
 * Time Complexity: O(1) for enqueue and dequeue
 * Space Complexity: O(n)
 */

class Node {
public:
    int data;
    Node* next;
    Node(int val) { data = val; next = nullptr; }
};

class Queue {
    Node *front, *rear;
public:
    Queue() { front = rear = nullptr; }

    bool isEmpty() { return front == nullptr; }

    void enqueue(int val) {
        Node* temp = new Node(val);
        if (rear == nullptr) {
            front = rear = temp;
            return;
        }
        rear->next = temp;
        rear = temp;
    }

    void dequeue() {
        if (isEmpty()) {
            cout << "Queue Underflow\n";
            return;
        }
        Node* temp = front;
        front = front->next;
        cout << "Dequeued: " << temp->data << endl;
        delete temp;
        if (front == nullptr) rear = nullptr;
    }

    void peek() {
        if (isEmpty()) cout << "Queue is empty\n";
        else cout << "Front element: " << front->data << endl;
    }
};

int main() {
    Queue q;
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.peek();
    q.dequeue();
    q.peek();
}
