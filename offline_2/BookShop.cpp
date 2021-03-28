/*******************************Offline 2****************************************/
/* Implement the functions of the class BookShop below as per the instructions  */
/* given inline the class definition. Make sure the output of the code in the   */
/* main function matches the given sample output. You may add/delete codes in   */
/* the main function during your testing. But before submission remove all your */
/* modifications from the main function and submit it as provided initially.    */
/********************************************************************************/

#include<iostream>
#include<cstring>
#include<cmath>
#include "Book.cpp"

using namespace std;

class BookShop {
    char name[100];
    Book* books; //List of books in the shop
    int size;  //maximum number of books the shop can keep
    int count; //tracks currently how many numbers in the shop
public:
    void setName( char* name );

    BookShop();

    BookShop( char* name, int size );

    BookShop( const BookShop& bs );

    ~BookShop();

    void addBook( Book b );

    void addBook( Book* ba, int count );

    Book getBookInfo( char* title );

    void updateBookPrice( int isbn, int price );

    void removeBook( int isbn );

    int totalPrice();

    void print();

    BookShop mergeShop( BookShop b );
};

void BookShop::setName( char* name ) {
    /*Set the name of the bookshop to the given name*/
    strcpy( this->name, name );
}

BookShop::BookShop() { //Default constructor
    /*Initialize with size 5 and name to empty string ""*/
    size = 5;
    books = new Book[size];
    strcpy( name, "" );
    count = 0;
}

BookShop::BookShop( char* name, int size ) { //Parameterized constructor
    /*Initialize with the given name and size*/
    this->size = size;
    books = new Book[this->size];
    strcpy( this->name, name );
    count = 0;
}

BookShop::BookShop( const BookShop& bs ) { //Copy constructor
    /*Write necessary code for the copy constructor*/
    this->size = bs.size;
    strcpy( this->name, bs.name );
    this->books = new Book[ this->size ];
    this->count = 0;
    addBook( bs.books, bs.count );
}

BookShop::~BookShop() { //Destructor
    /*Free memory as applicable*/
    delete [] this->books;
}

void BookShop::addBook( Book b ) {
    /*Add book b to the end of the list*/
    if ( this->count < this->size )
        this->books[count++] = b;
    else
        cout << "Maximum bookshop size reached already" << endl;
}

void BookShop::addBook( Book* ba, int count ) {
    /*Add the given array of books ba to the end of the list*/
    for ( int i = 0; i < count; i++ )
        addBook( ba[i] );
}

Book BookShop::getBookInfo( char* title ) {
    /*Return the **first** book that has the given title. Assume there is atleast one book in the list with the given title*/
    Book temp;

    for ( int i = 0; i < this->count; i++ ) {
        if ( !strcmp( title, this->books[i].getTitle() ) ) {
            temp = this->books[i];
            break;
        }
    }

    return temp;
}

void BookShop::updateBookPrice( int isbn, int price ) {
    /*Update the price of the book with given isbn to the given price*/
    for ( int i = 0; i < this->count; i++ ) {
        if ( isbn == this->books[i].getISBN() ) {
            this->books[i] =  this->books[i].generateNewEdition( isbn, price );
            break;
        }
    }
}

void BookShop::removeBook( int isbn ) {
    /*Remove the book with the given isbn from the list.
    After removing a book all the books below the removed book will be shifted up,
     i.e, there will be no hole in the list*/
    int toRemove = 0;

    for ( int i = 0; i < this->count; i++ )
        if ( isbn == this->books[i].getISBN() ) {
            toRemove = i;
            break;
        }

    for ( int i = toRemove; i < this->count - 1; i++ )
        this->books[i] = this->books[i + 1];

    count--;
}

int BookShop::totalPrice() {
    /*Return the sum of the prices of all the books in the list*/
    int tp = 0;

    for ( int i = 0; i < this->count; i++ )
        tp += this->books[i].getPrice();

    return tp;
}

void BookShop::print() {
    /*Print the bookshop's name followed by information of all the books in the bookshop*/
    cout << "Bookshop name: " << this->name << endl;

    for ( int i = 0; i < this->count; i++ )
        cout << "ISBN: " << this->books[i].getISBN() << ", Title: " << this->books[i].getTitle()
             << ", Price: " << this->books[i].getPrice() << endl;
}

BookShop BookShop::mergeShop( BookShop b ) {
    /* Return a new bookshop object that will contain all the books of this bookshop and the given bookshop b*/
    /* Use the title **MergedShop** of the new bookshop						        */
    BookShop res( "MergedShop", this->size + b.size );
    res.addBook( this->books, this->count );
    res.addBook( b.books, b.count );
    return res;
}
