#include<iostream>
#include<cstring>
using namespace std;

class Vector
{
    char *name;
    int x,y,z;
public:
    Vector(char *n)
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
        x=0;
        y=0;
        z=0;
    }
    Vector(char *n, int a, int b, int c)
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
        x=a;
        y=b;
        z=c;
    }
    
    int setX(int a){x=a;}
    int setY(int b){y=b;}
    int setZ(int c){z=c;}

    void setName(char *n)
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
    }

    int getX(){return x;}
    int getY(){return y;}
    int getZ(){return z;}

    char *getName(){return name;}

    ~Vector()
    {
        delete []name;
    }
    
    void print();
    
    Vector operator ^( Vector& a ); 

    int operator ==( Vector& a );
	
    Vector operator *( int a );

    Vector operator *( Vector& a );
 
    void operator =( const Vector& a );

    friend Vector operator *( int a, Vector& b );
};

void Vector::print() {
    cout << name << ": " << x << "x";
    if ( y < 0 ) cout << y << "y";
    else cout << "+" << y << "y";
    if ( z < 0 ) cout << z << "z";
    else cout << "+" << z << "z";
    cout << endl;
}

Vector Vector::operator ^( Vector& a ) {
    Vector ans( "" );
    ans.x = y * a.z - z * a.y;
    ans.y = - x * a.z + z * a.x;
    ans.z = x * a.y - y * a.x;
    return ans;
}

int Vector::operator ==( Vector& a ) {
    return ( ( x == a.x ) && ( y == a.y ) && ( z == a.z ) );
}

Vector Vector::operator *( int a ) {
    Vector ans( "" );
    ans.x = x * a;
    ans.y = y * a;
    ans.z = z * a;
    return ans;
}

Vector Vector::operator *( Vector& a ) {
    Vector ans( "" );
    ans.x = x * a.x;
    ans.y = y * a.y;
    ans.z = z * a.z;
    return ans;
}

Vector operator *( int a, Vector& b ) {
    Vector ans( "" );
    ans.x = a * b.x;
    ans.y = a * b.y;
    ans.z = a * b.z;
    return ans;
}

void Vector::operator =( const Vector& a ) {
    x = a.x;
    y = a.y;
    z = a.z;
}

int main()
{
    Vector v1("v1", 1,2,3), v2("v2", 4, 5, -6), v3("Result1"),v4("Result2",-27,18,-3);

    v1.print();     ///Print the components of vector v1
    v2.print();     ///Print the components of vector v2

    v3=v1^v2;       ///Calculate the cross product of vector v1 and vector v2 (Consider ^ as cross product for this assignment)
    v3.print();     ///Print the modified components of vector v3 (Name: Result1)

    if(v3==v4)      ///Check for equality; if two vectors contain equal component values (x, y, z), then they are equal.
       cout<<"Vectors are equal"<<endl;
    else
       cout<<"Vectors are not equal"<<endl;

    v1= v1*2;       ///Multiply each component of vector v1 with the given value
    v1.print();     ///Print the modified components of vector v1

    v2=2*v2;        ///Multiply each component of vector v2 with the given value
    v2.print();     ///Print the modified components of vector v2

    v3=v1*v2;       ///Multiply each component of vector v1 with the corresponding component of vector v2.
    v3.print();     ///Print the modified components of vector v3 (Name: Result1)

    if(v3==v4)      ///Check for equality; if two vectors contain equal component values (x, y, z), then they are equal.
        cout<<"Vectors are equal"<<endl;
    else
        cout<<"Vectors are not equal"<<endl;

    return 0;
}
