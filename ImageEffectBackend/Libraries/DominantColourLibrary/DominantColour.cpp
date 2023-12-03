#include<vector>
#include<map>
#include<math.h>
#include<algorithm>
#include "DominantColour.h"
#include "../Pixel.h"
using namespace std;
void applyDominantColour(vector<vector<Pixel>>& image)
{
       vector<int> ar(255<<16|255<<8|255, 0);
       for (int i = 0; i < image.size(); i++)
          for (int j = 0; j < image[i].size(); j++)
            ar[(image[i][j].r << 16) | (image[i][j].g << 8) | image[i][j].b]++;

       int mxColor = max_element(ar.begin(), ar.end()) - ar.begin();
       Pixel ans;
       ans.r = (mxColor >> 16) & 0xFF;
       ans.g = (mxColor >> 8) & 0xFF;
       ans.b = mxColor & 0xFF;
       for (int i = 0; i < image.size(); i++)
         for (int j = 0; j < image[i].size(); j++)
            image[i][j] = ans;

}