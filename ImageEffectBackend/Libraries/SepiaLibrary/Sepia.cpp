#include<vector>
#include "Sepia.h"
using namespace std;

void applySepia(vector<vector<Pixel>> &imageVector)
{
    for (int i = 0; i < imageVector.size(); i++)
    {
        for (int j = 0; j < imageVector[i].size(); j++)
        {
            int r = imageVector[i][j].r;
            int g = imageVector[i][j].g;
            int b = imageVector[i][j].b;

            int newR = (r * .393) + (g * .769) + (b * .189);
            int newG = (r * .349) + (g * .686) + (b * .168);
            int newB = (r * .272) + (g * .534) + (b * .131);

            if (newR > 255)
            {
                newR = 255;
            }
            if (newG > 255)
            {
                newG = 255;
            }
            if (newB > 255)
            {
                newB = 255;
            }

            imageVector[i][j].r = newR;
            imageVector[i][j].g = newG;
            imageVector[i][j].b = newB;
        }
    }
}