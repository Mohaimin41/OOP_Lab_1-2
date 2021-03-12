#include <iostream>
using namespace std;

#define SIZE 10

class stack
{
    char s[SIZE]; // holds the stack
    int top; // index of top of stack
public:
    void init()
    {
        top = 0;
    }

    // Push a character
    void push(char c)
    {
        if(top == SIZE)
        {
            cout<<"Stack is full"<<endl;
            return;
        }
        s[top++] = c;
    }

    // Pop a character
    char pop()
    {
        if(top == 0)
        {
            cout<<"Stack is empty"<<endl;
            return 0; // return null on empty stack
        }
        return s[--top];
    }

    int isEmpty()
    {
        return top == 0;
    }

};





int main(void)
{
	stack s1;

	s1.init();
	s1.push('h');
	s1.push('e');
	s1.push('m');


    while(!s1.isEmpty())
	{
	    cout<<s1.pop();
	}

	return 0;
}
