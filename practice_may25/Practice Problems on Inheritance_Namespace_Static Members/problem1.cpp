#include<iostream>
#include<cstring>
using namespace std;

namespace infrastructure {
    class pool {
    int height, width, depth;
    char painted_color[10];
public:
    void set_properties( int h, int w, int d, char* pc ) {
    height = h; width = w, depth = d;
    strcpy(painted_color, pc);
    }
    void show() {
    cout << "Dimension: " << height << " x " << width << " x " << depth
     << " color: " << painted_color << endl;
    }
    };
}

namespace sports {
    class pool {
    char table_ingredient[20], table_color[20];
public:
    void set_properties( char* ti, char* tc ) {
    strcpy(table_ingredient, ti);
    strcpy(table_color, tc );
    }
    void show() {
    cout << "Table ingredient: " << table_ingredient << " Table color: " << table_color << endl;
    }
    };
}

int main() {
    infrastructure::pool pool1;
    pool1.set_properties(1, 2, 3, "Blue");
    pool1.show();
    sports::pool pool2;
    pool2.set_properties("Metal", "Blue" );
    pool2.show();

    return 0;
}
