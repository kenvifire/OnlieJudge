//
// Created by Hannah Zhang on 16/6/9.
//
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

#define SetBit(A,k)     ( A[(k/32)] |= (1 << (k%32)) )
#define TestBit(A,k)    ( A[(k/32)] & (1 << (k%32)) )

typedef  unsigned long long ULLONG;
int main() {
    ULLONG N ,S,P,Q;
    cin >> N >> S >> P >> Q;

    ULLONG size = static_cast<ULLONG>(pow(2, 31));

    int *bitset = new int[size / 32];
    memset(bitset, 0, sizeof(int) * (size / 32));

    ULLONG  acc = S % size, tmp;
    SetBit(bitset, acc);
    int count = 1;
    for (ULLONG i = 1; i < N; i++) {
        tmp = acc * P + Q ;
        acc = tmp % size;

        if(!TestBit(bitset, acc)) {
            SetBit(bitset, acc);
            count++;
        }
    }
//
    cout << count;
    delete[] bitset;
    return 0;
}


