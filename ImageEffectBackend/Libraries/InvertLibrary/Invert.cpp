#include "Invert.h"
#include<vector>
#include<math.h>
#include "../Pixel.h"
using namespace std;

void applyInvert(vector<vector<Pixel>> &imageVector)
{
    int m = imageVector.size();
    int n = imageVector[0].size();
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            imageVector[i][j].r = 255 - imageVector[i][j].r;
            imageVector[i][j].g = 255 - imageVector[i][j].g;
            imageVector[i][j].b = 255 - imageVector[i][j].b;
        }
    }
}