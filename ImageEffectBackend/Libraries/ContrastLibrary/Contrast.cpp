#include<vector>
#include<math.h>
#include<stdio.h>
#include "Contrast.h"
using namespace std;

void applyContrast(vector<vector<Pixel>> &imageVector, float amount)
{
        amount=259*(amount+255)/(255*(259-amount));
        for (int i = 0; i < imageVector.size(); i++)
        {
            for (int j = 0; j < imageVector[i].size(); j++)
            {
                imageVector[i][j].r = max((float)0,min((float)255,(imageVector[i][j].r - 128) * amount + 128));
                imageVector[i][j].g = max((float)0,min((float)255,(imageVector[i][j].g - 128) * amount + 128));
                imageVector[i][j].b = max((float)0,min((float)255,(imageVector[i][j].b - 128) * amount + 128));
            }
        }
}
