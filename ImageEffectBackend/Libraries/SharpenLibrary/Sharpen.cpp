#include<vector>
#include<cmath>
#include "Sharpen.h"
#include<algorithm>

using namespace std;

void applySharpen(vector<vector<Pixel>> &image, float value)
{
    const int kernel[3][3] = {
      {-1, -1, -1},
      {-1,  9, -1},
      {-1, -1, -1}
      };
      int height = image.size();
      int width = image[0].size();
      value=value/45.0;
      vector<vector<vector<int>>> newImage(height, vector<vector<int>>(width, vector<int>(3, 0)));

          for (int i = 1; i < height - 1; ++i) {
              for (int j = 1; j < width - 1; ++j) {
                  for (int k = 0; k < 3; ++k) {
                      int sum = 0;
                      for (int m = -1; m <= 1; ++m) {
                          for (int n = -1; n <= 1; ++n) {
                              if(k==0)
                              sum += image[i + m][j + n].r * kernel[m + 1][n + 1];
                              if(k==1)
                              sum += image[i + m][j + n].g * kernel[m + 1][n + 1];
                              if(k==2)
                               sum += image[i + m][j + n].b * kernel[m + 1][n + 1];
                          }
                      }
                      newImage[i][j][k]=sum;
                  }
              }
          }
    for(int i=0;i<height;i++)
    {
        for(int j=0;j<width;j++)
        {
            for(int k=0;k<3;k++)
            {
                if(k==0)
                {
                    int delta = newImage[i][j][k] - image[i][j].r;
//                      image[i][j].r=min(255,max(0,newImage[i][j][k]));
                    image[i][j].r= min(255, max(0, image[i][j].r + (int)(value* delta)));
//                    image[i][j].r=255;
                }
                else if(k==1)
                {
                    int delta = newImage[i][j][k] - image[i][j].g;
//                    image[i][j].g=min(255,max(0,newImage[i][j][k]));
                    image[i][j].g= min(255, max(0, image[i][j].g + (int)(value* delta)));
//                    image[i][j].g=255;
                }
                else if(k==2)
                {
                    int delta = newImage[i][j][k] - image[i][j].b;
//                    image[i][j].b=min(255,max(0,newImage[i][j][k]));
                    image[i][j].b= min(255, max(0, image[i][j].b + (int)(value* delta)));
//                    image[i][j].b= min(255, max(0, image[i][j].b + 1000*delta));
                }

            }
        }
    }

}