#include <iostream>
#include <cmath>
#include <cstdlib>
using namespace std;

class Point {
    // x and y coordinate
    int x, y;
public:
//Add necessary constructor(s) to initialize x and y
//Add your set and get functions for x and y

    Point( int a, int b ) {
        x = a;
        y = b;
    }
    Point() {
	x = 0;
	y = 0;
    }
    void set( int a, int b ) {
        x = a;
        y = b;
    }
    int* get() {
        int* res = ( int* ) malloc( 2 * sizeof( int ) ) ;
        *( res ) = x;
        *( res + 1 ) = y;
        return res;
    }
    void print() {
        cout << "Coordinate: " << x << ", " << y << endl;
    }
};

class Line {
    Point p1, p2;
public:
        Line( int a1, int b1, int a2, int b2 ) {
        p1.set( a1, b1 );
        p2.set( a2, b2 );
    }

     	void printLength() {
        int* P1 = p1.get(), *P2 = p2.get();
        double length = sqrt( ( *( P1 ) - * ( P2 ) ) * ( *( P1 ) - * ( P2 ) ) +
                              ( *( P1 + 1 ) - * ( P2 + 1 ) ) * ( *( P1 + 1 ) - * ( P2 + 1 ) ) );
        cout << "Length: " << length << endl;
	free( P1 );
	free( P2 );
    }
};

class Circle {
    Point p;
    int radius;
public:
// Add necessary constructor(s) to initialize p and radius
    Circle( int x, int y, int r ) {
        p.set( x, y );
        radius = r;
    }
    Circle( int x, int y ) {
        p.set( x, y );
    }
    Circle( int r ) {
        radius = r;
    }
    void update( int a, int b ) {
        int *center = p.get();
        p.set( *( center ) + a, *( center + 1 ) + b );
 	free( center );
    }
    void update( int r ) {
        radius += r;
    }
    void update( int a, int b, int r ) {
        int *center = p.get();
        p.set( *( center ) + a, *( center + 1 ) + b );
        radius += r;
	free( center );
    }

    void print() {
        cout << "Center ";
        p.print();
        cout << "Radius: " << radius << endl;
    }
};

int main() {
    Point p( 5, 5 );
    Circle c( 2, 3, 5 );
    cout << endl << "Point Display" << endl;
    p.print();
    cout << endl << "Circle Display" << endl;
    c.print();
    cout << endl;
    Line l( 0, 0, 4, 0 );
    cout << endl << "Line length display" << endl;
    l.printLength();
    cout << endl;

//First update
    cout << "First Update" << endl;
// call update function of Circle class to increase the centers x
//    coordinate by 5 and y coordinate by 5;
    c.update( 5, 5 );

    c.print();
    cout << endl;

//Second update
    cout << "Second Update" << endl;

// call update function of Circle class to increase the radius by 6;
    c.update( 6 );
    c.print();
    cout << endl;

//Third update
    cout << "Third Update" << endl;

// call update function of Circle class to increase the centers x
//    coordinate by 2 and y coordinate by 2 and the radius by 2;
    c.update( 2, 2, 2 );
    c.print();
    cout << endl;
    return 0;
}
