#include <iostream>
#define SIZE 5
using namespace std;

/**
 * Circular Queue using Array
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 */

class CircularQueue {
    int arr[SIZE];
    int front, rear;
public:
    CircularQueue() { front = -1; rear = -1; }

    bool isFull() { return (front == 0 && rear == SIZE - 1) || (rear == (front - 1) % (SIZE - 1)); }

    bool isEmpty() { return (front == -1); }

    void enqueue(int x) {
        if (isFull()) {
            cout << "Queue Overflow\n";
            return;
        }
        if (front == -1) front = 0;
        rear = (rear + 1) % SIZE;
        arr[rear] = x;
    }

    void dequeue() {
        if (isEmpty()) {
            cout << "Queue Underflow\n";
            return;
        }
        cout << "Dequeued: " << arr[front] << endl;
        if (front == rear) front = rear = -1;
        else front = (front + 1) % SIZE;
    }

    void display() {
        if (isEmpty()) {
            cout << "Queue is empty\n";
            return;
        }
        cout << "Queue elements: ";
        int i = front;
        while (true) {
            cout << arr[i] << " ";
            if (i == rear) break;
            i = (i + 1) % SIZE;
        }
        cout << endl;
    }
};

int main() {
    CircularQueue q;
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.display();
    q.dequeue();
    q.display();
}
