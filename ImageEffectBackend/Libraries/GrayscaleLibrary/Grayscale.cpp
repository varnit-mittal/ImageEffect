#include "../Pixel.h"
#include"Grayscale.h"
#include<vector>

using namespace std;

void applyGrayscale(vector<vector<Pixel>> &imageVector)
{
    int m=imageVector.size();
    int n= imageVector[0].size();

    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            int grayValue = (int)(0.299*imageVector[i][j].r + 0.587*imageVector[i][j].g + 0.114* imageVector[i][j].b);
            imageVector[i][j].r=grayValue;
            imageVector[i][j].g=grayValue;
            imageVector[i][j].b=grayValue;
        }
    }
}