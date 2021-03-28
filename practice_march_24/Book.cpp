/************Topics of Demonstration********************/
/* => Dynamic Allocation of objects         		   */
/* => Constructor overloading		        		   */
/* => Copy constructor				        		   */
/* => Passing and returning objects from functions     */
/*******************************************************/

#include<iostream>
#include<cstring>
#include<cmath>
//#include"colormod.h"

using namespace std;

class Book{
	int isbn;
	char title[100];
	int price;
	public:
		//Setter functions
		void setISBN(int isbn){this->isbn=isbn;}
		void setTitle(char* title){strcpy(this->title,title);}
		void setPrice(int price){this->price=price;}

		//Getter functions
		int getISBN(){return isbn;}
		char* getTitle(){return title;}
		int getPrice(){return price;}
		
		//Constructor functions
		Book(){ //default constructor
			isbn=0;
			strcpy(title,"");
			price=0;
			cout<< "In the default constructor of the book: "<<isbn<<endl;
		}
		Book(int isbn, char* title, int price){//constructor with parameters
			this->isbn=isbn;
			strcpy(this->title,title);
			this->price=price;			
			cout<< "In the parameterized constructor of the book: "<<isbn<<endl;
		}
		
		//destructor function
		~Book(){ 
			cout<< "In the destructor of the book: "<<isbn<<endl; 
		}
			
		//Other functions
		void print(){
			if (isbn>0) cout << "ISBN: "<< isbn <<", Title: " << title <<", Edition: "<<price<<endl;
			else cout<< "Values not yet set\n";
		}
};

int main(){
	cout<<"\n+++++++++++Start++++++++\n";
	Book b1;
	b1.print();
	Book b2(101,"Teach yourself C++",230);
	b2.print();
	
	cout<<"\n+++++++++++End++++++++\n";
}
