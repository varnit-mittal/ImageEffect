#include "HueSaturation.h"
#include<vector>
#include<algorithm>
#include<math.h>
#include<cmath>

using namespace std;


void applyHueSaturation(vector< vector<Pixel> > &image, float saturationValue, float hueValue) {

    int m=image.size();
    int n= image[0].size();

    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            float h = hueValue*3.6;
            float s= max(0.0,min(1.0,saturationValue/100.0));
            float l = (max({image[i][j].r,image[i][j].g,image[i][j].b}) + min({image[i][j].r,image[i][j].g,image[i][j].b}))/200.0;
            float c = (1 - abs(2 * l - 1)) * s;
            float x = c * (1 - abs(fmod(h / 60.0, 2) - 1));
            float m = (l - c )/ 2;

             double r1, g1, b1;

            if (h < 60) {
                r1 = c; g1 = x; b1 = 0;
            } else if (h < 120) {
                r1 = x; g1 = c; b1 = 0;
            } else if (h < 180) {
                r1 = 0; g1 = c; b1 = x;
            } else if (h < 240) {
                r1 = 0; g1 = x; b1 = c;
            } else if (h < 300) {
                r1 = x; g1 = 0; b1 = c;
            } else {
                r1 = c; g1 = 0; b1 = x;
            }

            image[i][j].r = (min(255,(int)(abs((r1 + m)) * 255)));
            image[i][j].g = (min(255,(int)(abs(g1 + m) * 255)));
            image[i][j].b = (min(255,(int)(abs(b1 + m) * 255)));
        }
    }
}