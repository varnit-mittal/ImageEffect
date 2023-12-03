#include<vector>
#include<math.h>
#include"Brightness.h"
using namespace std;


void applyBrightness(vector<vector<Pixel>> &imageVector, float amount)
{
    int m=imageVector.size();
    int n= imageVector[0].size();

    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
//            int a= (int)(amount);
            imageVector[i][j].r=(int)(pow(imageVector[i][j].r,amount/100));
            imageVector[i][j].b=(int)(pow(imageVector[i][j].b,amount/100));
            imageVector[i][j].g=(int)(pow(imageVector[i][j].g,amount/100));

            if(imageVector[i][j].r>255)
            {
                imageVector[i][j].r=255;
            }

            if(imageVector[i][j].g>255)
            {
                imageVector[i][j].g=255;
            }

            if(imageVector[i][j].b>255)
            {
                imageVector[i][j].b=255;
            }

            if(imageVector[i][j].r<10)
            {
                imageVector[i][j].r+=50;
            }

            if(imageVector[i][j].g<10)
            {
                imageVector[i][j].g+=50;
            }

            if(imageVector[i][j].b<10)
            {
                imageVector[i][j].b+=50;
            }
        }
    }

}
