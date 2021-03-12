#include<iostream>
#include<cstdlib>
using namespace std;

typedef struct v {
    int x, y, z;
} myVector;

class Vectors {
    int sizeV;
    myVector *f, *str;
public:
    Vectors( int sV ) {
        f = ( myVector* ) malloc( sV * sizeof( myVector ) );
        sizeV = sV;
        str = f;
    }

    ~Vectors() {
        free( f );
    }

    void print() {
        for ( int i = 0; i < sizeV; i++ )
            cout << ( f + i )->x << " "
                 << ( f + i )->y << " " << ( f + i )->z << endl;
    }

    void set( int index, int x, int y, int z ) {
        ( str + index )->x = x;
        ( str + index )->y = y;
        ( str + index )->z = z;
    }

    int* get( int index ) {
        int* res = ( int * ) malloc( 3 * sizeof( int ) );
        res[0] = ( f + index )->x;
        res[1] = ( f + index )->y;
        res[2] = ( f + index )->z;
        return res;
    }

    void add( int x, int y, int z ) {
        for ( int i = 0; i < sizeV; i++ ) {
            ( f + i )->x += x;
            ( f + i )->y += y;
            ( f + i )->z += z;
        }
    }

    int* add() {
        int* res = ( int* ) malloc( 3 * sizeof( int ) );
        res[0] = res[1] = res[2] = 0;

        for ( int i = 0; i < sizeV; i++ ) {
            res[0] += ( f + i )->x;
            res[1] += ( f + i )->y;;
            res[2] += ( f + i )->z;;
        }

        return res;
    }
};

int main() {
    Vectors v( 5 );
    v.set( 0, 0, 0, 0 );
    v.set( 1, 1, 0, 0 );
    v.set( 2, 0, 1, 0 );
    v.set( 3, 0, 0, 1 );
    v.set( 4, 1, 1, 0 );

    int *t = v.get( 1 );
    cout << "Vector t: " << t[0] << " " << t[1] << " " << t[2] << endl;

    cout << "Vectors: " << endl;
    v.print();

    v.add( 10, 10, 10 );

    cout << "Vectors after adding 10 in all axes: " << endl;
    v.print();

    t = v.add();
    cout << "t: " << t[0] << " " << t[1] << " " << t[2];

    free( t );

    return 0;
}
