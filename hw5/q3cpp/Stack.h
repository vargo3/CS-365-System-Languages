//Jacob Vargo

#include <vector>
using namespace std;

template<class T, int size = 100>
class Stack{
	public:
		Stack(int maxsize = size);
		bool push(T value);
		T pop();
		bool isEmpty();
	protected:
		std::vector<T> vec;
};

#include "Stack.cpp"
